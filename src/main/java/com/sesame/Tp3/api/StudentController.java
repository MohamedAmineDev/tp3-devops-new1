package com.sesame.Tp3.api;

import com.sesame.Tp3.model.Student;
import com.sesame.Tp3.repository.StudenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudenRepository studenRepository;

    @PostMapping("/register-student")
    public boolean saveStudent(@RequestBody Student student) {
        if (student == null) {
            return false;
        }
        studenRepository.saveAndFlush(student);
        return true;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studenRepository.findAll();
    }

    @DeleteMapping("/delete-student")
    public boolean deleteStudent(UUID uuid) {
        if (uuid == null) {
            return false;
        }
        Student student = studenRepository.findById(uuid).orElse(null);
        if (student == null) {
            return false;
        }
        studenRepository.delete(student);
        studenRepository.flush();
        return true;
    }
}
