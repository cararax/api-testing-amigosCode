package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void itShoudCheckIfStudentExistsByEmail() {
        //given
        String email = "jamila@gmail.com";
        Student student = new Student(
                "jamila",
                email,
                Gender.FEMALE
        );
        underTest.save(student);

        //when
        Boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isTrue();

    }
}