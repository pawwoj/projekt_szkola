package application;

import service.LessonService;
import service.StudentService;
import service.TeacherService;

import java.util.Scanner;

public class Application {

    public void run() {
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        LessonService lessonService = new LessonService();
        Scanner scanner = new Scanner(System.in);
        teacherService.loadToMapObjectFromFile();
        studentService.loadToMapObjectFromFile();
        lessonService.loadToMapObjectFromFile();

        while (true) {
            System.out.println(
                    "| [1] Add Student | [2] Print all Students | [8] Remove student\n" +
                            "| [3] Add Teacher | [4] Print all Teachers |\n" +
                            "| [5] Add Lesson  | [6] Print all Lessons  |\n" +
                            "| [7] Exit");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                studentService.putModelToMap();
            } else if (option.equals("2")) {
                studentService.printModelsValueFromMap();
            } else if (option.equals("8")) {
                studentService.remove();
            } else if (option.equals("3")) {
                teacherService.putModelToMap();
            } else if (option.equals("4")) {
                teacherService.printModelsValueFromMap();
            } else if (option.equals("5")) {
                lessonService.putModelToMap();
            } else if (option.equals("6")) {
                lessonService.printModelsValueFromMap();
            } else if (option.equals("7")) {
                break;
            } else {
                System.out.println("Wrong command");
            }
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            teacherService.saveObjectMapToFile();
            studentService.saveObjectMapToFile();
            lessonService.saveObjectMapToFile();
        }));
    }
}
