package service;

import model.Lesson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LessonServiceTest {

    @Test
    @DisplayName("Add lesson test, map not empty")
    void whenAddLessonMapShouldNotBeEmpty() {
        // Given
        LessonService lessonService = new LessonService();
        Lesson testLesson = new Lesson("Lesson1", 1L);
        Long index = 1L;
        // When
        lessonService.putModelToMap(index, testLesson);
        // Then
        assertThat(lessonService.getLessonMap()).isNotEmpty();
    }

    @Test
    @DisplayName("Add lesson test, map not null")
    void whenAddLessonMapShouldNotNull() {
        LessonService lessonService = new LessonService();
        Lesson testLesson = new Lesson("Lesson1", 1L);
        Long index = 1L;
        lessonService.putModelToMap(index, testLesson);
        assertThat(lessonService.getLessonMap()).isNotNull();
    }

    @Test
    @DisplayName("Add lesson test, map contain only 1 element")
    void whenAddLessonMapContain1Element() {
        LessonService lessonService = new LessonService();
        Lesson testLesson = new Lesson("Lesson1", 1L);
        Long index = 1L;
        lessonService.putModelToMap(index, testLesson);
        assertThat(lessonService.getLessonMap()).hasSize(1);
    }

    @Test
    @DisplayName("Add lesson test, map contain lesson key")
    void whenAddLessonMapContainHisKey() {
        LessonService lessonService = new LessonService();
        Lesson testLesson = new Lesson("Lesson1", 1L);
        Long index = 1L;
        lessonService.putModelToMap(index, testLesson);
        assertThat(lessonService.getLessonMap()).containsKey(1L);
    }

    @Test
    @DisplayName("Add lesson test, map contain lesson value")
    void whenAddLessonMapContainHisValue() {
        LessonService lessonService = new LessonService();
        Lesson testLesson = new Lesson("Lesson1", 1L);
        Long index = 1L;
        lessonService.putModelToMap(index, testLesson);
        assertThat(lessonService.getLessonMap()).containsValue(testLesson);
    }

    @Test
    @DisplayName("Map contain only added lesson")
    void whenAddLessonMapContainsOnlyHim() {
        LessonService lessonService = new LessonService();
        Lesson testLesson = new Lesson("Lesson1", 1L);
        Long index = 1L;
        lessonService.putModelToMap(index, testLesson);
        assertThat(lessonService.getLessonMap()).containsOnly(entry(index, testLesson));
    }

    @Test
    @DisplayName("Save map to file, file has contetnt")
    void shouldSaveMapToFile() {
        LessonService lessonService = new LessonService();
        //Is OK to use many method in one test?
        Long index = 1L;
        Lesson testLesson = new Lesson("Lesson1", index);
        lessonService.setFileName("tested.txt");
        lessonService.putModelToMap(index, testLesson);
        File temp = new File("tested.txt");
        lessonService.saveObjectMapToFile();
        assertThat(temp).hasContent("Lesson1");
    }

}