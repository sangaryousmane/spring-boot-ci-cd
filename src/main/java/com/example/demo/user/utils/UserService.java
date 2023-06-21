package com.example.demo.user.utils;
import com.example.demo.entity.Student;
import com.example.demo.user.repository.StudentRepository;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.entity.ums.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<Student> findALlStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
