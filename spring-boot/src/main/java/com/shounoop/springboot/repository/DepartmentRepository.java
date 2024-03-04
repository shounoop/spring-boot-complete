package com.shounoop.springboot.repository;

import com.shounoop.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
