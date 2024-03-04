package com.shounoop.springboot.service;

import com.shounoop.springboot.entity.Department;
import com.shounoop.springboot.error.DepartmentNotFoundException;
import com.shounoop.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if (department.getDepartmentName() != null && !department.getDepartmentName().equalsIgnoreCase("")) {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (department.getDepartmentCode() != null && !department.getDepartmentCode().equalsIgnoreCase("")) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if (department.getDepartmentAddress() != null && !department.getDepartmentAddress().equalsIgnoreCase("")) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
