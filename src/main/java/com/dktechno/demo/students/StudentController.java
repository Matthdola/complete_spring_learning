package com.dktechno.demo.students;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("students")
    public StudentResponseDTO saveStudent(@RequestBody StudentDto dto) {
        return this.studentService.saveStudent(dto);
    }


    @GetMapping("students")
    public List<StudentResponseDTO> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("students/{student-id}")
    public StudentResponseDTO findStudentById(@PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("students/search/{student-name}")
    public List<StudentResponseDTO> findStudentsByName(@PathVariable("student-name") String name) {
        return studentService.findStudentsByName(name);
    }

    @DeleteMapping("students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id) {
        studentService.deleteById(id);
    }
}
