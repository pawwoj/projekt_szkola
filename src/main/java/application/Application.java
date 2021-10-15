package application;

import model.Student;
import service.StudentService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    public void run() {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        File file = new File("data.txt");

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(",");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split(" ");
                studentService.addStudentToList(new Student(splittedArray[0], splittedArray[1], splittedArray[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("1 Dodaj studenta // 2 Wyswietl studentow // 3 Wyjdź z programu");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                studentService.addStudentToList();
            } else if (option.equals("2")) {
                studentService.printStudentList();
            } else if (option.equals("3")) {
                break;
            } else {
                System.out.println("Wpisano złą komendę");
            }
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            FileWriter writer = null;

            try {
                writer = new FileWriter("data.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Student student : studentService.getStudentList()) {
                try {
                    writer.write(student.toString() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}
