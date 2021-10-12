package collection;

import model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class StudentStorageTest {
    Student student1;
    Student student2;
    Student student3;
    private StudentStorage studentStorage;

    @BeforeEach
    public void setUp() {
        studentStorage = new StudentStorage();
        student1 = new Student("Jan", "Kowalski", "123456789");
        student2 = new Student("Anna", "Nowak", "987654321");
        student3 = new Student("Marta", "Gala", "5463645");
    }

    @Test
    void printStudentListTest() {
        studentStorage.studentList.add(student1);
        studentStorage.studentList.add(student2);
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        studentStorage.printStudentList();
        Assertions.assertEquals("[Jan Kowalski 123456789, Anna Nowak 987654321]\r\n", newConsole.toString());
    }

    @Test
    void addStudentToListTest() {
        studentStorage.addStudentToList(student3);
        Assertions.assertEquals("[Marta Gala 5463645]", studentStorage.toStringList());
    }

    @Test
    void addStudentToMapTest() {
        String idStudent1 = "1";
        String idStudent2 = "2";
        String idStudent3 = "3";
        studentStorage.addStudentToMap(idStudent1, student1);
        studentStorage.addStudentToMap(idStudent2, student2);
        studentStorage.addStudentToMap(idStudent3, student3);
        Assertions.assertTrue(studentStorage.studentMap.containsValue(student2));
    }

    @Test
    void shouldSayStudentMapIsNotEmpty() {
        String idStudent1 = "1";
        studentStorage.addStudentToMap(idStudent1, student1);
        Assertions.assertFalse(studentStorage.studentMap.isEmpty());
    }
}