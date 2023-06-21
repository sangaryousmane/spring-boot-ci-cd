package com.example.demo.entity.department.controller;

import com.example.demo.entity.department.DepartmentRepository;
import com.example.demo.entity.department.entity.Department;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@Log4j2
public class DepartmentController {


    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("")
    ResponseEntity<Iterable<Department>> departments() {
        Iterable<Department> departments = departmentRepository.findAll();
        log.info("{}", departments);
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/sort")
    public ResponseEntity<Iterable<Department>>
    sortName(@RequestParam(defaultValue = "0", name = "pageNumber") int pageNumber,
             @RequestParam(defaultValue = "5", name = "pageSize", required = false) int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Department> department = departmentRepository.findAll(pageable);

        if (department.isEmpty()){
            log.error("Sorry buddy! the page is empty {}", department);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(department.getContent());
    }

    @PostMapping("/saveDepartment")
    ResponseEntity<Map<String, Boolean>> save(@RequestBody Department department) {
        Map<String, Boolean> isSaved = new HashMap<>();
        boolean isExist = departmentRepository.existsById(department.getDepartment_id());

        if (isExist) {
            log.error("Sorry! the user already exist");
        } else {
            departmentRepository.save(department);
            isExist = true;
            isSaved.put("Status", isExist);
        }
        return new ResponseEntity<>(isSaved, HttpStatus.OK);
    }

    @PatchMapping("/partialUpdate/{department_id}/{department_name}")
    ResponseEntity<Department> partialUpdate(@PathVariable("department_id") Long department_id, @PathVariable("department_name") String department_name) {
        Department department1 = departmentRepository.findById(department_id).get();
        department1.setDepartment_name(department_name);
        departmentRepository.save(department1);
        return ResponseEntity.ok(department1);
    }

}
