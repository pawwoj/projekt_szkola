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
    private final String lessonName;
    @NonNull
    private Boolean isActive;

    private List<Student> studentList;

    public String toStringWithoutIndex() {
        return this.lessonName;
    }

    @Override
    public String toString() {
        return this.index + " " + this.lessonName + " " + this.isActive;
    }
}