package com.dktechno.demo.students;

import com.dktechno.demo.schools.School;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", exp.getMessage());
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("John", "Doe", "johndoe@email.com", 1);
        Student student = mapper.toStudent(dto);
        assertEquals(student.getFirstname(), dto.firstname());
        assertEquals(student.getLastname(), dto.lastname());
        assertEquals(student.getEmail(), dto.email());
        assertNotNull(student.getSchool());
        assertEquals(student.getSchool().getId(), dto.schoolId());
    }

    @Test
    public void toStudentResponseDTO() {
        // Given
        Student student = new Student("Jane", "Smith", "johndoe@gmail.com", 20);

        // When
        StudentResponseDTO dto = mapper.toStudentResponseDTO(student);

        // Assert
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
    }
}