package org.xml.processing.exercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.xml.processing.exercises.service.*;

@Component
public class Runner implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public Runner(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!this.supplierService.isImported()) {
            this.supplierService.seedSuppliers();
        }

        if (!this.partService.isImported()) {
            this.partService.seedParts();
        }

        if (!this.carService.isImported()) {
           this.carService.seedCars();
        }

        if (!this.customerService.isImported()) {
            this.customerService.seedCustomers();
        }

        if (!this.customerService.isImported()) {
            this.customerService.seedCustomers();
        }

        if (!this.saleService.isImported()) {
            this.saleService.seedSales();
        }

//        this.customerService.exportOrderedCustomers();
//        this.carService.exportToyotaCars();
//        this.carService.exportCarsAndParts();
        this.saleService.exportSales();
    }
}
