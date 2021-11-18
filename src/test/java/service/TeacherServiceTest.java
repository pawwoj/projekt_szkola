package service;

import model.Student;
import model.Teacher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class TeacherServiceTest {
/*
    @Test
    @DisplayName("Add teacher to map - map not empty")
    void whenAddTeacherMapShouldNotBeEmpty() {
        // Given
        TeacherService teacherService = new TeacherService();
        String data = "Franek\r\nKimono\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        teacherService.putModelToMap();
        // Then
        assertThat(teacherService.getTeacherMap()).isNotEmpty();
    }

    @Test
    @DisplayName("Add teacher to map - map not null")
    void whenAddTeacherMapShouldNotNull() {
        // Given
        TeacherService teacherService = new TeacherService();
        String data = "Franek\r\nKimono\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        teacherService.putModelToMap();
        // Then
        assertThat(teacherService.getTeacherMap()).isNotNull();
    }

    @Test
    @DisplayName("Add 2 teachers to map, map contain 2 elements")
    void whenAddTeacherMapContain1Element() {
        // Given
        TeacherService teacherService = new TeacherService();
        String data = "Franek\r\nKimono\r\n";
        String data2 = "Jan\r\nMatejko\r\n";
        // When
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        teacherService.putModelToMap();
        // When
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        teacherService.putModelToMap();
        // Then
        assertThat(teacherService.getTeacherMap()).hasSize(2);
    }

    @Test
    @DisplayName("Add 2 teachers to map, map key auto increment")
    void whenAddTeacherMapContainHisKey() {
        // Given
        TeacherService teacherService = new TeacherService();
        String data = "Franek\r\nKimono\r\n";
        String data2 = "Jan\r\nMatejko\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        teacherService.putModelToMap();
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        // When
        teacherService.putModelToMap();
        // Then
        assertThat(teacherService.teacherMap).containsKey(2L);
        assertThat(teacherService.getFirstFreeIndex()).isEqualTo(3L);
    }

    @Test
    @DisplayName("Add teacher to map, map contain teacher data in value")
    void whenAddTeacherMapContainHisDataAsValue() {
        // Given
        TeacherService teacherService = new TeacherService();
        Teacher teacherTest = new Teacher(1L, "Jan", "Matejko");
        String data = "Jan\r\nMatejko\r\n";
        // When
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        teacherService.putModelToMap();
        // Then
        assertThat(teacherService.getTeacherMap().get(1L).toString()).isEqualTo(teacherTest.toString());
    }

    @Test
    @DisplayName("Edit teacher first and last name")
    void shouldEditTeacherFirstNameAndLastName() {
        // Given
        TeacherService teacherService = new TeacherService();
        teacherService.getTeacherMap().put(5L, new Teacher(5L, "Kamil", "Norwid"));
        String data = "5\r\nFranek\r\nKimono\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        teacherService.edit();
        // Then
        assertThat(teacherService.getTeacherMap().get(5L).toString()).isEqualTo("5 Franek Kimono");
        assertThat(teacherService.getTeacherMap().get(5L).toString()).isNotEqualTo("5 Kamil Norwid");
    }

    @Test
    @DisplayName("Remove one and only teacher from map - map is empty")
    void shouldRemoveTeacherFromMap() {
        // Given
        TeacherService teacherService = new TeacherService();
        teacherService.getTeacherMap().put(5L, new Teacher(5L, "Kamil", "Norwid"));
        String data = "5\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        teacherService.remove();
        // Then
        assertThat(teacherService.getTeacherMap()).isEmpty();
    }

    @Test
    @DisplayName("Remove one and only teacher from map - map is empty")
    void shouldRemoveOneAndOnlyTeacherFromMap() {
        // Given
        TeacherService teacherService = new TeacherService();
        teacherService.getTeacherMap().put(5L, new Teacher(5L, "Kamil", "Norwid"));
        String data = "5\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        teacherService.remove();
        // Then
        assertThat(teacherService.getTeacherMap()).isEmpty();
    }

    @Test
    @DisplayName("Save map to file, file has contetnt")
    void shouldSaveMapToFile() throws IOException {
        // Given
        TeacherService teacherService = new TeacherService();
        Teacher testTeacher = new Teacher(1L, "Jan", "Kowalski");
        teacherService.setFileName("tested.txt");
        teacherService.getTeacherMap().put(1L, testTeacher);
        Path fileName = Path.of("tested.txt");
        String teacherString = "1 Jan Kowalski";
        // When
        teacherService.saveObjectMapToFile();
        String actual = Files.readString(fileName);
        //Then
        assertThat(actual).containsSequence(teacherString);
    }

    @Test
    @DisplayName("Load map from file, map has contetnt")
    void shouldLoadMapFromFile() throws IOException {
        // Given
        TeacherService teacherService = new TeacherService();
        teacherService.setFileName("tested.txt");
        Path fileName = Path.of("tested.txt");
        String content  = "1 Franek Kimono\n2 Adam Asnyk\n3 Maria Konopnicka";
        Files.writeString(fileName, content);
        // When
        teacherService.loadToMapObjectFromFile();
        //Then
        assertThat(teacherService.getTeacherMap().get(3L).toString()).isEqualTo("3 Maria Konopnicka");
    }
    */
}