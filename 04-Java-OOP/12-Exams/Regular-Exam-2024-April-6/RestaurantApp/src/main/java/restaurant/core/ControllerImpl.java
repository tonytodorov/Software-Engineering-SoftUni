package restaurant.core;

import restaurant.common.ConstantMessages;
import restaurant.common.ExceptionMessages;
import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.orders.TakenOrders;
import restaurant.models.orders.TakenOrdersImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.Working;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.Repository;
import restaurant.repositories.WaiterRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Client> clientRepository;
    private Repository<Waiter> waiterRepository;
    private int countClients;

    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;

        if (type.equals("FullTimeWaiter")) {
            waiter = new FullTimeWaiter(waiterName);
        } else if (type.equals("HalfTimeWaiter")) {
            waiter = new HalfTimeWaiter(waiterName);
        } else {
            throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }

        waiterRepository.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);

        Arrays.stream(orders)
                .forEach(order -> client.getClientOrders().add(order));

        clientRepository.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiterRepository.byName(waiterName);

        if (null == waiter) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }

        waiterRepository.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = clientRepository.byName(clientName);

        if (null == client) {
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }

        clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (waiterRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }

        Client client = clientRepository.byName(clientName);

        Working working = new WorkingImpl();
        working.takingOrders(client, waiterRepository.getCollection());

        countClients++;

        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_CLIENTS_COUNT, countClients));
        sb.append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS);

        waiterRepository.getCollection().forEach(waiter -> {
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_WAITER_NAME, waiter.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency()));
            sb.append(System.lineSeparator());

            if (waiter.takenOrders().getOrdersList().isEmpty()) {
                sb.append(String.format(FINAL_WAITER_ORDERS, "None"));
            } else {
                String orders = String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList());
                sb.append(String.format(FINAL_WAITER_ORDERS, orders));
            }

        });

        return sb.toString().trim();
    }
}
