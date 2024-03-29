package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Worker> workers;
    private Repository<Vehicle> vehicles;

    int countTools = 0;

    public ControllerImpl() {
        this.workers = new WorkerRepository();
        this.vehicles = new VehicleRepository();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;

        if (type.equals("FirstShift")) {
            worker = new FirstShift(workerName);
        } else if (type.equals("SecondShift")) {
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }

        workers.add(worker);
        return String.format(ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);

        vehicles.add(vehicle);
        return String.format(SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker currentWorker = workers.findByName(workerName);

        if (null == currentWorker) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Tool tool = new ToolImpl(power);
        currentWorker.addTool(tool);

        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Vehicle currentVehicle = vehicles.findByName(vehicleName);

        List<Worker> workersWithNeededStrength = workers.getWorkers()
                .stream()
                .filter(worker -> worker.getStrength() > 70)
                .collect(Collectors.toList());

        if (workersWithNeededStrength.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }

        while (!workersWithNeededStrength.isEmpty()) {
            workersWithNeededStrength.forEach(Worker::working);
            currentVehicle.making();
            countTools++;
        }

        return String.format(VEHICLE_DONE + " " + COUNT_BROKEN_INSTRUMENTS, vehicleName, "done", countTools);
    }

    @Override
    public String statistics() {
        return String.format("");
    }
}
