package com.example.demo.user.controller;
import com.example.demo.entity.Student;
import com.example.demo.entity.ums.User;
import com.example.demo.user.utils.UserService;
import com.example.demo.user.utils.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> userList() {
        List<User> allUsers = userService.findAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> responseEntity() {
        List<Student> students = userService.findALlStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public Student students(@PathVariable("id") Long id) {
        return userService.findALlStudents()
                .stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: " + id + "not found."));
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok(userService.saveStudent(student));
    }
}
