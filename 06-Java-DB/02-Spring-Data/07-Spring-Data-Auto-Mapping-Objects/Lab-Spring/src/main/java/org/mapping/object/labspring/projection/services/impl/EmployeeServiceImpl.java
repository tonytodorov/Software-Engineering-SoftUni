package org.mapping.object.labspring.projection.services.impl;

import org.mapping.object.labspring.projection.dto.EmployeeDTO;
import org.mapping.object.labspring.projection.entities.Employee;
import org.mapping.object.labspring.projection.repositories.EmployeeRepository;
import org.mapping.object.labspring.projection.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDTO> findEmployeeBornBefore(int bornBefore) {
        LocalDate before = LocalDate.of(bornBefore, 1, 1);

        List<Employee> employees = employeeRepository
                .findByBirthdayBeforeOrderBySalaryDesc(before);

        return employees
                .stream()
                .map(e -> mapper.map(e, EmployeeDTO.class))
                .toList();
    }

    @Override
    public List<EmployeeDTO> findAllWithManager() {
        List<Employee> result = employeeRepository.findByManagerIsNotNull();

        return result
                .stream()
                .map(e -> mapper.map(e, EmployeeDTO.class))
                .toList();
    }
}
