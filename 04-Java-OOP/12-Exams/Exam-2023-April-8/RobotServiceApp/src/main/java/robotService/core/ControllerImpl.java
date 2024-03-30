package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;

        if (type.equals("MainService")) {
            service = new MainService(name);
        } else if (type.equals("SecondaryService")) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }

        services.add(service);

        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;

        if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        } else if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Service currentService = services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .findFirst()
                .get();

        Supplement currentSupplement = supplements.findFirst(supplementType);

        if (null == currentSupplement) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        currentService.addSupplement(currentSupplement);
        supplements.removeSupplement(currentSupplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;

        if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
        } else if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        Service currentService = services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .findFirst()
                .get();

        if (robotType.equals("MaleRobot") && currentService.getClass().getSimpleName().equals("MainService")) {
            currentService.addRobot(robot);
        } else if (robotType.equals("FemaleRobot") && currentService.getClass().getSimpleName().equals("SecondaryService")) {
            currentService.addRobot(robot);
        } else {
            return UNSUITABLE_SERVICE;
        }

        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service currentService = services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .findFirst()
                .get();

        currentService.getRobots().forEach(Robot::eating);
        long fedRobots = currentService.getRobots().size();

        return String.format(FEEDING_ROBOT, fedRobots);
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service currentService = services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .findFirst()
                .get();

        double robotsPrice = currentService
                .getRobots().stream()
                .mapToDouble(Robot::getPrice)
                .sum();

        double supplementsPrice = currentService
                .getSupplements().stream()
                .mapToDouble(Supplement::getPrice)
                .sum();

        double totalPrice = robotsPrice + supplementsPrice;

        return String.format(VALUE_SERVICE, serviceName, totalPrice);
    }

    @Override
    public String getStatistics() {
        return services.stream()
                .map(Service::getStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
