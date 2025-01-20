package com.dktechno.demo.students;

import com.dktechno.demo.schools.School;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "T_STUDENT")
public class Student {
    @Id
    @GeneratedValue()
    private Integer id;

    //@Column(name = "c_fname", length = 50)
    private String firstname;
    @Column
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column
    private int age;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;
}
