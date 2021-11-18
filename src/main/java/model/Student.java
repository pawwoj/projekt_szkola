package model;

import lombok.*;

import java.util.List;

@Setter
@Getter

@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    @NonNull
    private final Long index;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Boolean isActive;

    private List<Lesson> lessonList;

    public String toStringWithoutIndex() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return this.index + " " + this.firstName + " " + this.lastName + " " + this.isActive + " " + this.lessonList;
    }

    public String toStringWithoutList() {
        return this.index + " " + this.firstName + " " + this.lastName + " " + this.isActive;
    }

    public String stringFromLessonListOfLessonName() {
        String listOfLessonToNameAndClassroom = "- attends on: ";
        StringBuilder sB = new StringBuilder(listOfLessonToNameAndClassroom);
        lessonList.stream().filter(lesson -> lesson.getIsActive().equals(true))
                .forEach(lesson -> sB.append(lesson.toStringLessonNameAndClassroom() + ", "));
        return listOfLessonToNameAndClassroom = sB.toString();
    }

    public String lessonListWithoutStudentToString() {
        String listToString = "[";
        StringBuilder sB = new StringBuilder(listToString);
        lessonList.stream().filter(lesson -> lesson.getIsActive().equals(true))
                .forEach(lesson -> sB.append(lesson.toStringWithoutList() + ", "));
        if (sB.length() > 5) {
            sB.delete(sB.length() - 2, sB.length());
        }
        sB.append("]");
        return listToString = sB.toString();
    }
}