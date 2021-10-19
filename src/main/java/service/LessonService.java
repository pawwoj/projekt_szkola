package service;

import model.Lesson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LessonService implements Operation {

    Map<Long, Lesson> lessonMap = new LinkedHashMap<>();
    String fileName = "lesson.txt";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Lesson returnLessonGeneratedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lesson name:");
        String lessonName = scanner.nextLine();

        return new Lesson(lessonName);
    }

    @Override
    public void saveObjectMapToFile() {
        FileWriter writer = null;

        try {
            writer = new FileWriter(getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object lesson : lessonMap.values()) {
            try {
                writer.write(lesson.toString() + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadToMapObjectFromFile() {
        File file = new File(getFileName());

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(",");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split(" ");
                lessonMap.put((long) lessonMap.size() + 1, new Lesson(splittedArray[0], (long) lessonMap.size() + 1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map getLessonMap() {
        return lessonMap;
    }

    @Override
    public void putModelToMap(Long number, Object model) {
        lessonMap.put(number, (Lesson) model);
    }

    @Override
    public void printModelsValueFromMap() {
        lessonMap.forEach((aLong, lesson) -> System.out.println(lesson));
    }
}
