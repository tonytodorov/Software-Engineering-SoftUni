package org.mapping.object.labspring;

import org.mapping.object.labspring.projection.services.EmployeeService;
import org.mapping.object.labspring.projection.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final ManagerService managerService;

    @Autowired
    public Main(EmployeeService employeeService, ManagerService managerService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int bornBefore = Integer.parseInt(scanner.nextLine());

//        employeeService.findEmployeeBornBefore(bornBefore)
//                .forEach(System.out::println);
//
//        employeeService.findAllWithManager()
//                .forEach(System.out::println);

        managerService.findAllManagers()
                .forEach(System.out::println);
    }
}
