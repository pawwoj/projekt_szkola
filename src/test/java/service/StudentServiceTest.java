package service;

import model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class StudentServiceTest {

    @Test
    @DisplayName("Add student test, map not empty")
    void whenAddStudentMapShouldNotBeEmpty() {
        // Given
        StudentService studentService = new StudentService();
        Student testStudent = new Student("Jan", "Kowalski", 1L);
        Long index = 1L;
        // When
        studentService.putModelToMap(index, testStudent);
        // Then
        assertThat(studentService.getStudentMap()).isNotEmpty();
    }

    @Test
    @DisplayName("Add student test, map not null")
    void whenAddStudentMapShouldNotNull() {
        StudentService studentService = new StudentService();
        Student testStudent = new Student("Jan", "Kowalski", 1L);
        Long index = 1L;
        studentService.putModelToMap(index, testStudent);
        assertThat(studentService.getStudentMap()).isNotNull();
    }

    @Test
    @DisplayName("Add student test, map contain only 1 element")
    void whenAddStudentMapContain1Element() {
        StudentService studentService = new StudentService();
        Student testStudent = new Student("Jan", "Kowalski", 1L);
        Long index = 1L;
        studentService.putModelToMap(index, testStudent);
        assertThat(studentService.getStudentMap()).hasSize(1);
    }

    @Test
    @DisplayName("Add student test, map contain student key")
    void whenAddStudentMapContainHisKey() {
        StudentService studentService = new StudentService();
        Student testStudent = new Student("Jan", "Kowalski", 1L);
        Long index = 1L;
        studentService.putModelToMap(index, testStudent);
        assertThat(studentService.getStudentMap()).containsKey(1L);
    }

    @Test
    @DisplayName("Add student test, map contain student value")
    void whenAddStudentMapContainHisValue() {
        StudentService studentService = new StudentService();
        Student testStudent = new Student("Jan", "Kowalski", 1L);
        Long index = 1L;
        studentService.putModelToMap(index, testStudent);
        assertThat(studentService.getStudentMap()).containsValue(testStudent);
    }

    @Test
    @DisplayName("Map contain only added student")
    void whenAddStudentMapContainsOnlyHim() {
        StudentService studentService = new StudentService();
        Student testStudent = new Student("Jan", "Kowalski", 1L);
        Long index = 1L;
        studentService.putModelToMap(index, testStudent);
        assertThat(studentService.getStudentMap()).containsOnly(entry(index, testStudent));
    }

    @Test
    @DisplayName("Save map to file, file has contetnt")
    void shouldSaveMapToFile() {
        StudentService studentService = new StudentService();
        //Is OK to use many method in one test?
        Long index = 1L;
        Student testStudent = new Student("Jan", "Kowalski", index);
        studentService.setFileName("tested.txt");
        studentService.putModelToMap(index, testStudent);
        File temp = new File("tested.txt");
        studentService.saveObjectMapToFile();
        assertThat(temp).hasContent("Jan Kowalski");
    }
// Nie działa .. ?
//    @Test
//    @DisplayName("Load file to map, map has contetnt")
//    void shouldLoadDataFromFileToModel() {
//        StudentService studentService = new StudentService();
//
//        // cant test only load test without save before
//        Long index = 1L;
//        Student testStudent = new Student("Jan", "Kowalski", 1L);
//        studentService.setFileName("tested.txt");
//        studentService.loadToMapObjectFromFile();
//       // studentService.putModelToMap(index, testStudent);
//        System.out.println("test");
//        assertThat(studentService.getStudentMap()).containsValue(testStudent);
//    }

}