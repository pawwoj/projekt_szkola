package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

    @Test
    @DisplayName("File student.txt exist")
    void shouldSayStudentTXTFileExist() {
        // Given
        File tested = new File("student.txt");
        // When
        // Then
        assertThat(tested).exists();
    }
    @Test
    @DisplayName("File student.txt count si...")
    void shouldSayStudentTXTisNotEmpty() {
        // Given
        // When
        // Then

    }
}
