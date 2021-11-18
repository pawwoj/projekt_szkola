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
                            | [1] Add Student | [2]  Print all Students | [3]  Remove student | [4]  Edit student | [5]  Add lesson to student  |
                            | [6] Add Teacher | [7]  Print all Teachers | [8]  Remove teacher | [9]  Edit teacher | [10] Add student to teacher |
                            | [11] Add Lesson | [12] Print all Lessons  | [13] Remove lesson  | [14] Edit lesson  |
                            | [0] Exit""");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                studentService.putModelToMap();
            } else if (option.equals("2")) {
                studentService.printModelsValueFromMap(lessonService);
            } else if (option.equals("3")) {
                studentService.remove();
            } else if (option.equals("4")) {
                studentService.edit();
            } else if (option.equals("5")) {
                studentService.addLessonThatStudentIsAttending(lessonService);
            } else if (option.equals("6")) {
                teacherService.putModelToMap();
            } else if (option.equals("7")) {
                teacherService.printModelsValueFromMap();
            } else if (option.equals("8")) {
                teacherService.remove();
            } else if (option.equals("9")) {
                teacherService.edit();
            } else if (option.equals("10")) {
                //   teacherService.addStudentForTeacher(studentService);
            } else if (option.equals("11")) {
                lessonService.putModelToMap();
            } else if (option.equals("12")) {
                lessonService.printModelsValueFromMap(studentService);
            } else if (option.equals("13")) {
                lessonService.remove();
            } else if (option.equals("14")) {
                lessonService.edit();
            } else if (option.equals("0")) {
                break;
            } else {
                System.out.println("Wrong command");
            }
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            teacherService.saveObjectMapToFile();
            studentService.saveObjectMapToFile(lessonService);
            lessonService.saveObjectMapToFile();
        }));
    }
}