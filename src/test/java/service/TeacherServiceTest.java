package service;

import model.Teacher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class TeacherServiceTest {
//
//    @Test
//    @DisplayName("Add teacher test, map not empty")
//    void whenAddTeacherMapShouldNotBeEmpty() {
//        // Given
//        TeacherService teacherService = new TeacherService();
//        Teacher testTeacher = new Teacher("Jan", "Kowalski", 1L);
//        Long index = 1L;
//        // When
//        teacherService.putModelToMap(index, testTeacher);
//        // Then
//        assertThat(teacherService.getTeacherMap()).isNotEmpty();
//    }
//
//    @Test
//    @DisplayName("Add teacher test, map not null")
//    void whenAddTeacherMapShouldNotNull() {
//        TeacherService teacherService = new TeacherService();
//        Teacher testTeacher = new Teacher("Jan", "Kowalski", 1L);
//        Long index = 1L;
//        teacherService.putModelToMap(index, testTeacher);
//        assertThat(teacherService.getTeacherMap()).isNotNull();
//    }
//
//    @Test
//    @DisplayName("Add teacher test, map contain only 1 element")
//    void whenAddTeacherMapContain1Element() {
//        TeacherService teacherService = new TeacherService();
//        Teacher testTeacher = new Teacher("Jan", "Kowalski", 1L);
//        Long index = 1L;
//        teacherService.putModelToMap(index, testTeacher);
//        assertThat(teacherService.getTeacherMap()).hasSize(1);
//    }
//
//    @Test
//    @DisplayName("Add teacher test, map contain teacher key")
//    void whenAddTeacherMapContainHisKey() {
//        TeacherService teacherService = new TeacherService();
//        Teacher testTeacher = new Teacher("Jan", "Kowalski", 1L);
//        Long index = 1L;
//        teacherService.putModelToMap(index, testTeacher);
//        assertThat(teacherService.getTeacherMap()).containsKey(1L);
//    }
//
//    @Test
//    @DisplayName("Add teacher test, map contain teacher value")
//    void whenAddTeacherMapContainHisValue() {
//        TeacherService teacherService = new TeacherService();
//        Teacher testTeacher = new Teacher("Jan", "Kowalski", 1L);
//        Long index = 1L;
//        teacherService.putModelToMap(index, testTeacher);
//        assertThat(teacherService.getTeacherMap()).containsValue(testTeacher);
//    }
//
//    @Test
//    @DisplayName("Map contain only added teacher")
//    void whenAddTeacherMapContainsOnlyHim() {
//        TeacherService teacherService = new TeacherService();
//        Teacher testTeacher = new Teacher("Jan", "Kowalski", 1L);
//        Long index = 1L;
//        teacherService.putModelToMap(index, testTeacher);
//        assertThat(teacherService.getTeacherMap()).containsOnly(entry(index, testTeacher));
//    }
//
//    @Test
//    @DisplayName("Save map to file, file has contetnt")
//    void shouldSaveMapToFile() {
//        TeacherService teacherService = new TeacherService();
//        //Is OK to use many method in one test?
//        Long index = 1L;
//        Teacher testTeacher = new Teacher("Jan", "Kowalski", index);
//        teacherService.setFileName("tested.txt");
//        teacherService.putModelToMap(index, testTeacher);
//        File temp = new File("tested.txt");
//        teacherService.saveObjectMapToFile();
//        assertThat(temp).hasContent("Jan Kowalski");
//    }

}