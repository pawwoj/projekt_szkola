package service;

import model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class StudentServiceTest {
    Student student1;
    Student student2;
    Student student3;
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        studentService = new StudentService();
        student1 = new Student("Jan", "Kowalski", "123456789");
        student2 = new Student("Anna", "Nowak", "987654321");
        student3 = new Student("Marta", "Gala", "5463645");
    }

    @Test
    void printStudentListTest() {
        studentService.studentList.add(student1);
        studentService.studentList.add(student2);
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        studentService.printStudentList();
        Assertions.assertEquals("[Jan Kowalski 123456789, Anna Nowak 987654321]\r\n", newConsole.toString());
    }

    @Test
    void addStudentToListTest() {
        studentService.addStudentToList(student3);
        Assertions.assertEquals("[Marta Gala 5463645]", studentService.toStringList());
    }

    @Test
    void addStudentToMapTest() {
        String idStudent1 = "1";
        String idStudent2 = "2";
        String idStudent3 = "3";
        studentService.addStudentToMap(idStudent1, student1);
        studentService.addStudentToMap(idStudent2, student2);
        studentService.addStudentToMap(idStudent3, student3);
        Assertions.assertTrue(studentService.studentMap.containsValue(student2));
    }

    @Test
    void shouldSayStudentMapIsNotEmpty() {
        String idStudent1 = "1";
        studentService.addStudentToMap(idStudent1, student1);
        Assertions.assertFalse(studentService.studentMap.isEmpty());
    }
}