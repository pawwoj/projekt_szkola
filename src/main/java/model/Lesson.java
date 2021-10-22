package model;

public class Lesson {

    String lessonName;
    Long lessonIndex;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }

    public Lesson(String lessonName, Long lessonIndex) {
        this.lessonName = lessonName;
        this.lessonIndex = lessonIndex;
    }

    public String getLessonName() {
        return lessonName;
    }

    public Long getLessonIndex() {
        return lessonIndex;
    }

    @Override
    public String toString() {
        return this.lessonName;
    }
}
