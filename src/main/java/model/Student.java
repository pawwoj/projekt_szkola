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
    private final String firstName;
    @NonNull
    private final String lastName;
    @NonNull
    private final Boolean isActive;

    private List<Lesson> lessonList;

    public String toStringWithoutIndex() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return this.index + " " + this.firstName + " " + this.lastName + " " + this.isActive;
    }
}