package org.mapping.object.labspring.projection.services.impl;

import org.mapping.object.labspring.projection.dto.EmployeeDTO;
import org.mapping.object.labspring.projection.entities.Employee;
import org.mapping.object.labspring.projection.repositories.EmployeeRepository;
import org.mapping.object.labspring.projection.services.ManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    @Autowired
    public ManagerServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDTO> findAllManagers() {
        List<Employee> result = employeeRepository.findManagers();

        return result
                .stream()
                .map(e -> mapper.map(e, EmployeeDTO.class))
                .toList();
    }
}
