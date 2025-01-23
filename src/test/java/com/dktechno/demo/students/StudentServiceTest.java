package com.dktechno.demo.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// @ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    // Which service we want to test
    @InjectMocks
    private StudentService studentService;

    // Declare dependencies
    @Mock
    StudentRepository repository;
    @Mock
    StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_successfully_save_a_student() {
        // Given
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "john@email.com",
                1
        );

        Student student = new Student(
                "John",
                "Doe",
                "john@email.com",
                20
        );

        Student savedStudent = new Student(
                "John",
                "Doe",
                "john@email.com",
                20
        );
        savedStudent.setId(1);

        // Mock the calls
        Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);
        Mockito.when(repository.save(student)).thenReturn(savedStudent);
        Mockito.when(studentMapper.toStudentResponseDTO(savedStudent)).thenReturn(new StudentResponseDTO(
                "John",
                "Doe",
                "john@email.com"));

        // When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstname(), responseDTO.firstname());
        assertEquals(dto.lastname(), responseDTO.lastname());
        assertEquals(dto.email(), responseDTO.email());

        Mockito.verify(studentMapper, Mockito.times(1)).toStudent(dto);
        Mockito.verify(repository, Mockito.times(1)).save(student);
        Mockito.verify(studentMapper, Mockito.times(1)).toStudentResponseDTO(savedStudent);
    }

    @Test
    void should_return_all_students() {
        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "John",
                "Doe",
                "john@email.com",
                20
        ));

        // Mock the calls
        Mockito.when(repository.findAll()).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponseDTO(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "john@email.com")
                );

        // When
        List<StudentResponseDTO> responseDtos = studentService.findAllStudent();

        // Then
        assertEquals(students.size(), responseDtos.size());

        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void should_return_student_by_id() {
        // Given
        Integer studentId = 1;
        Student student = new Student(
                "John",
                "Doe",
                "john@email.com",
                20
        );

        // Mock the calls
        Mockito.when(repository.findById(studentId)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.toStudentResponseDTO(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "john@email.com")
                );

        // When
        StudentResponseDTO dto = studentService.findStudentById(studentId);

        // Then
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());

        Mockito.verify(repository, Mockito.times(1)).findById(studentId);
    }

    @Test
    void should_return_a_students_by_name() {
        // Given
        String studentName = "John";
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "John",
                "Doe",
                "john@email.com",
                20
        ));

        // Mock the calls
        Mockito.when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponseDTO(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "john@email.com")
                );

        // When
        var responseDtos = studentService.findStudentsByName(studentName);

        // Then
        assertEquals(students.size(), responseDtos.size());

        Mockito.verify(repository, Mockito.times(1)).findAllByFirstnameContaining(studentName);
    }

    @Test
    void should_delete_a_student_by_id() {
        // Given
        Integer studentId = 1;

        // Mock the calls

        // When
        studentService.deleteById(studentId);

        // Then

        Mockito.verify(repository, Mockito.times(1)).deleteById(studentId);
    }
}