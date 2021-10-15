package application;

import service.StudentService;

import java.util.Scanner;

public class Application {

    public void run() {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 Dodaj studenta // 2 Wyjdź z programu");
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
    }
}
