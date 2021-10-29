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
                    """
                            | [1] Add Student | [2] Print all Students | [3] Remove student
                            | [4] Add Teacher | [5] Print all Teachers | [6] Remove teacher
                            | [7] Add Lesson  | [8] Print all Lessons  | [9] Remove lesson
                            | [0] Exit""");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                studentService.putModelToMap();
            } else if (option.equals("2")) {
                studentService.printModelsValueFromMap();
            } else if (option.equals("3")) {
                studentService.remove();
            } else if (option.equals("4")) {
                teacherService.putModelToMap();
            } else if (option.equals("5")) {
                teacherService.printModelsValueFromMap();
            } else if (option.equals("6")) {
                teacherService.remove();
            } else if (option.equals("7")) {
                lessonService.putModelToMap();
            } else if (option.equals("8")) {
                lessonService.printModelsValueFromMap();
            } else if (option.equals("9")) {
                lessonService.remove();
            } else if (option.equals("0")) {
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
