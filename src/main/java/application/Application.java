package application;

import model.Lesson;
import model.Student;
import model.Teacher;
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
                    "| [1] Add Student | [2] Print all Students |\n" +
                            "| [3] Add Teacher | [4] Print all Teachers |\n" +
                            "| [5] Add Lesson  | [6] Print all Lessons  |\n" +
                            "| [7] Exit");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                Student student = studentService.returnStudentGeneratedFromConsole();
                studentService.putModelToMap((long) studentService.getStudentMap().size() + 1,
                        new Student(student.getFirstName(), student.getLastName(),
                                (long) studentService.getStudentMap().size() + 1));
            } else if (option.equals("2")) {
                studentService.printModelsValueFromMap();
            } else if (option.equals("3")) {
                Teacher teacher = teacherService.returnTeacherGeneratedFromConsoleWithoutIndex();
                teacherService.putModelToMap((long) teacherService.getTeacherMap().size() + 1,
                        new Teacher(teacher.getFirstName(), teacher.getLastName(),
                                (long) teacherService.getTeacherMap().size() + 1));
            } else if (option.equals("4")) {
                teacherService.printModelsValueFromMap();
            } else if (option.equals("5")) {
                Lesson lesson = lessonService.returnLessonGeneratedFromConsole();
                lessonService.putModelToMap((long) lessonService.getLessonMap().size() + 1,
                        new Lesson(lesson.getLessonName(),
                                (long) lessonService.getLessonMap().size() + 1));
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
