package model;

import lombok.*;

import java.util.List;

@Setter
@Getter

@AllArgsConstructor
@RequiredArgsConstructor

public class Lesson {

    @NonNull
    private final Long index;
    @NonNull
    private String lessonName;
    @NonNull
    private Boolean isActive;
    @NonNull
    private CLASSROOM classroom;
    private List<Student> studentList;

    public String toStringWithoutIndex() {
        return this.lessonName + " " + classroom;
    }

    @Override
    public String toString() {
        return this.index + " " + this.lessonName + " " + this.isActive + " " + this.classroom + " " + this.studentList;
    }

    public String toStringWithoutList() {
        return this.index + " " + this.lessonName + " " + this.isActive + " " + this.classroom;
    }

    public String toStringLessonNameAndClassroom() {
        return this.lessonName + " in " + this.classroom;
    }

    public String stringFromListOfStudentFirstAndLastName() {
        String listOfStudentFirstAndLastName = "|| Student list: ";
        StringBuilder sB = new StringBuilder(listOfStudentFirstAndLastName);
        studentList.stream().filter(student -> student.getIsActive().equals(true))
                .forEach(student -> sB.append(student.toStringWithoutIndex() + ", "));
        return listOfStudentFirstAndLastName = sB.toString();
    }

    public enum CLASSROOM {
        NATURE,
        LAB,
        TECHNICAL,
        MUSIC
    }
}