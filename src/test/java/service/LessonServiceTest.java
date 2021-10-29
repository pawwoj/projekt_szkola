package service;

import model.Lesson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class LessonServiceTest {

    @Test
    @DisplayName("Add lesson to map - map not empty")
    void whenAddLessonMapShouldNotBeEmpty() {
        // Given
        LessonService lessonService = new LessonService();
        String data = "Mathematic\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        lessonService.putModelToMap();
        // Then
        assertThat(lessonService.getLessonMap()).isNotEmpty();
    }

    @Test
    @DisplayName("Add lesson to map - map not null")
    void whenAddLessonMapShouldNotNull() {
        // Given
        LessonService lessonService = new LessonService();
        String data = "Mathematic\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        lessonService.putModelToMap();
        // Then
        assertThat(lessonService.getLessonMap()).isNotNull();
    }

    @Test
    @DisplayName("Add 2 lessons to map, map contain 2 elements")
    void whenAddLessonMapContain1Element() {
        // Given
        LessonService lessonService = new LessonService();
        String data = "Mathematic\r\n";
        String data2 = "Biology\r\n";
        // When
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        lessonService.putModelToMap();
        // When
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        lessonService.putModelToMap();
        // Then
        assertThat(lessonService.getLessonMap()).hasSize(2);
    }

    @Test
    @DisplayName("Add 2 lessons to map, map key auto increment")
    void whenAddLessonMapContainHisKey() {
        // Given
        LessonService lessonService = new LessonService();
        String data = "Mathematic\r\n";
        String data2 = "Biology\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        lessonService.putModelToMap();
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        // When
        lessonService.putModelToMap();
        // Then
        assertThat(lessonService.lessonMap).containsKey(2L);
    }

    @Test
    @DisplayName("Add lesson to map, map contain lesson data in value")
    void whenAddLessonMapContainHisDataAsValue() {
        // Given
        LessonService lessonService = new LessonService();
        Lesson lessonTest = new Lesson(1L, "Mathematic");
        String data = "Mathematic\r\n";
        // When
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        lessonService.putModelToMap();
        // Then
        assertThat(lessonService.getLessonMap().get(1L).toString()).isEqualTo(lessonTest.toString());
    }

    @Test
    @DisplayName("Edit lesson first and last name")
    void shouldEditLessonFirstNameAndLastName() {
        // Given
        LessonService lessonService = new LessonService();
        lessonService.getLessonMap().put(5L, new Lesson(5L, "Mathematic"));
        String data = "5\r\nBiology\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        lessonService.edit();
        // Then
        assertThat(lessonService.getLessonMap().get(5L).toString()).isEqualTo("5 Biology");
        assertThat(lessonService.getLessonMap().get(5L).toString()).isNotEqualTo("5 Match");
    }

    @Test
    @DisplayName("Remove one and only lesson from map - map is empty")
    void shouldRemoveLessonFromMap() {
        // Given
        LessonService lessonService = new LessonService();
        lessonService.getLessonMap().put(5L, new Lesson(5L, "Mathematic"));
        String data = "5\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        lessonService.remove();
        // Then
        assertThat(lessonService.getLessonMap()).isEmpty();
    }

    @Test
    @DisplayName("Remove one and only lesson from map - map is empty")
    void shouldRemoveOneAndOnlyLessonFromMap() {
        // Given
        LessonService lessonService = new LessonService();
        lessonService.getLessonMap().put(5L, new Lesson(5L, "Mathematic"));
        String data = "5\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        // When
        lessonService.remove();
        // Then
        assertThat(lessonService.getLessonMap()).isEmpty();
    }

    @Test
    @DisplayName("Save map to file, file has contetnt")
    void shouldSaveMapToFile() throws IOException {
        // Given
        LessonService lessonService = new LessonService();
        Lesson testLesson = new Lesson(1L, "Mathematic");
        lessonService.setFileName("tested.txt");
        lessonService.getLessonMap().put(1L, testLesson);
        Path fileName = Path.of("tested.txt");
        String lessonString = "1 Mathematic";
        // When
        lessonService.saveObjectMapToFile();
        String actual = Files.readString(fileName);
        //Then
        assertThat(actual).containsSequence(lessonString);
    }

    @Test
    @DisplayName("Load map from file, map has contetnt")
    void shouldLoadMapFromFile() throws IOException {
        // Given
        LessonService lessonService = new LessonService();
        lessonService.setFileName("tested.txt");
        Path fileName = Path.of("tested.txt");
        String content = "1 Mathematic\n2 Biology\n3 Music";
        Files.writeString(fileName, content);
        // When
        lessonService.loadToMapObjectFromFile();
        //Then
        assertThat(lessonService.getLessonMap().get(3L).toString()).isEqualTo("3 Music");
    }

}