package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working {

    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Collection<String> clientOrders = client.getClientOrders();

        waiters.forEach(waiter -> {

            while (waiter.canWork() && clientOrders.iterator().hasNext()) {
                waiter.work();
                String order = clientOrders.iterator().next();
                waiter.takenOrders().getOrdersList().add(order);
                clientOrders.remove(order);
            }
        });
    }
}
