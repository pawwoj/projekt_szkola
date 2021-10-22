package service;

import model.Lesson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LessonService implements Service {
    Map<Long, Lesson> lessonMap = new LinkedHashMap<>();
    String fileName = "lesson.txt";
    Long firstFreeIndex;

    public Long getFirstFreeIndex() {
        return firstFreeIndex;
    }

    public void setFirstFreeIndex(Long firstFreeIndex) {
        this.firstFreeIndex = firstFreeIndex;
    }

    public String getFileName() {
        return fileName;
    }

    public void loadAndSetFirstFreeIndexFromFile() {
        File file = new File(getFileName());

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(",");
            try {
                String line = fileScanner.nextLine();
                setFirstFreeIndex(Long.valueOf(line));
            } catch (NoSuchElementException e) {
                setFirstFreeIndex(1L);
                System.out.println("Empty Map - first free index = 1");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Lesson returnLessonGeneratedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lesson name:");
        String lessonName = scanner.nextLine();
        setFirstFreeIndex(firstFreeIndex + 1);
        return new Lesson((firstFreeIndex - 1), lessonName);
    }

    @Override
    public void saveObjectMapToFile() {
        FileWriter writer = null;

        try {
            writer = new FileWriter(getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(getFirstFreeIndex() + System.lineSeparator());
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
    public void remove() {
    }

    @Override
    public void loadToMapObjectFromFile() {

        loadAndSetFirstFreeIndexFromFile();

        File file = new File(getFileName());

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(",");
            int i = 0;
            while (fileScanner.hasNextLine()) {
                i++;
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split(" ");
                Long keyIndex = Long.valueOf(splittedArray[0]);
                if (i > 1)
                    lessonMap.put(keyIndex, new Lesson(keyIndex, splittedArray[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putModelToMap() {
        Lesson lesson = returnLessonGeneratedFromConsole();
        lessonMap.put((getFirstFreeIndex() - 1), lesson);
    }

    @Override
    public void printModelsValueFromMap() {
        lessonMap.forEach((index, lesson) -> System.out.println(lesson.toStringWithoutIndex()));
    }
}
