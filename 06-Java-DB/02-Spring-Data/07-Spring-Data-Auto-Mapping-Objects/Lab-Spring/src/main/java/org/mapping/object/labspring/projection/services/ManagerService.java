package org.mapping.object.labspring.projection.services;

import org.mapping.object.labspring.projection.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {

    List<EmployeeDTO> findAllManagers();
}
