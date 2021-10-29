package model;

public class Lesson {
    String lessonName;
    Long index;

    public Lesson(Long lessonIndex, String lessonName) {
        this.lessonName = lessonName;
        this.index = lessonIndex;
    }

    public String toStringWithoutIndex(){
        return this.lessonName;
    }

    @Override
    public String toString() {
        return this.index + " " + this.lessonName;
    }
}
