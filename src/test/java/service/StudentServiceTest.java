package service;

import model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class StudentServiceTest {

/*
    @Test
    @DisplayName("Add student to map - map not empty")
    void whenAddStudentMapShouldNotBeEmpty() {
        // Given
        StudentService studentService = new StudentService();
        String data = "Franek\r\nKimono\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        studentService.putModelToMap();
        // Then
        assertThat(studentService.getStudentMap()).isNotEmpty();
    }

    @Test
    @DisplayName("Add student to map - map not null")
    void whenAddStudentMapShouldNotNull() {
        // Given
        StudentService studentService = new StudentService();
        String data = "Franek\r\nKimono\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        studentService.putModelToMap();
        // Then
        assertThat(studentService.getStudentMap()).isNotNull();
    }

    @Test
    @DisplayName("Add 2 students to map, map contain 2 elements")
    void whenAddStudentMapContain1Element() {
        // Given
        StudentService studentService = new StudentService();
        String data = "Franek\r\nKimono\r\n";
        String data2 = "Jan\r\nMatejko\r\n";
        // When
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        studentService.putModelToMap();
        // When
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        studentService.putModelToMap();
        // Then
        assertThat(studentService.getStudentMap()).hasSize(2);
    }

    @Test
    @DisplayName("Add 2 students to map, map key auto increment")
    void whenAddStudentMapContainHisKey() {
        // Given
        StudentService studentService = new StudentService();
        String data = "Franek\r\nKimono\r\n";
        String data2 = "Jan\r\nMatejko\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        studentService.putModelToMap();
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        // When
        studentService.putModelToMap();
        // Then
        assertThat(studentService.studentMap).containsKey(2L);
        assertThat(studentService.getFirstFreeIndex()).isEqualTo(3L);
    }

    @Test
    @DisplayName("Add student to map, map contain student data in value")
    void whenAddStudentMapContainHisDataAsValue() {
        // Given
        StudentService studentService = new StudentService();
        Student studentTest = new Student(1L, "Jan", "Matejko");
        String data = "Jan\r\nMatejko\r\n";
        // When
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        studentService.putModelToMap();
        // Then
        assertThat(studentService.getStudentMap().get(1L).toString()).isEqualTo(studentTest.toString());
    }

    @Test
    @DisplayName("Edit student first and last name")
    void shouldEditStudentFirstNameAndLastName() {
        // Given
        StudentService studentService = new StudentService();
        studentService.getStudentMap().put(5L, new Student(5L, "Kamil", "Norwid"));
        String data = "5\r\nFranek\r\nKimono\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        studentService.edit();
        // Then
        assertThat(studentService.getStudentMap().get(5L).toString()).isEqualTo("5 Franek Kimono");
        assertThat(studentService.getStudentMap().get(5L).toString()).isNotEqualTo("5 Kamil Norwid");
    }

    @Test
    @DisplayName("Remove one and only student from map - map is empty")
    void shouldRemoveStudentFromMap() {
        // Given
        StudentService studentService = new StudentService();
        studentService.getStudentMap().put(5L, new Student(5L, "Kamil", "Norwid"));
        studentService.getStudentMap().put(6L, new Student(6L, "Ola", "Zola"));
        String data = "5\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        studentService.remove();
        // Then
        assertThat(studentService.getStudentMap()).hasSize(1);
    }

    @Test
    @DisplayName("Remove one and only student from map - map is empty")
    void shouldRemoveOneAndOnlyStudentFromMap() {
        // Given
        StudentService studentService = new StudentService();
        studentService.getStudentMap().put(5L, new Student(5L, "Kamil", "Norwid"));
        String data = "5\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        studentService.remove();
        // Then
        assertThat(studentService.getStudentMap()).isEmpty();
    }

    @Test
    @DisplayName("Save map to file, file has contetnt")
    void shouldSaveMapToFile() throws IOException {
        // Given
        StudentService studentService = new StudentService();
        Student testStudent = new Student(1L, "Jan", "Kowalski");
        studentService.setFileName("tested.txt");
        studentService.getStudentMap().put(1L, testStudent);
        Path fileName = Path.of("tested.txt");
        String studentString = "1 Jan Kowalski";
        // When
        studentService.saveObjectMapToFile();
        String actual = Files.readString(fileName);
        //Then
        assertThat(actual).containsSequence(studentString);
    }

    @Test
    @DisplayName("Load map from file, map has contetnt")
    void shouldLoadMapFromFile() throws IOException {
        // Given
        StudentService studentService = new StudentService();
        studentService.setFileName("tested.txt");
        Path fileName = Path.of("tested.txt");
        String content  = "1 Franek Kimono\n2 Adam Asnyk\n3 Maria Konopnicka";
        Files.writeString(fileName, content);
        // When
        studentService.loadToMapObjectFromFile();
        //Then
        assertThat(studentService.getStudentMap().get(3L).toString()).isEqualTo("3 Maria Konopnicka");
    }

*/

}