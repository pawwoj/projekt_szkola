package service;

import model.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TeacherService implements Service {

    Map<Long, Teacher> teacherMap = new LinkedHashMap<>();
    String fileName = "teacher.txt";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Teacher returnTeacherGeneratedFromConsoleWithoutIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter teacher first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter teacher last name:");
        String lastName = scanner.nextLine();

        return new Teacher(firstName, lastName);
    }

    public Map<Long, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void saveObjectMapToFile() {
        FileWriter writer = null;

        try {
            writer = new FileWriter(getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object teacher : teacherMap.values()) {
            try {
                writer.write(teacher.toString() + System.lineSeparator());
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
        File file = new File(getFileName());

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(",");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split(" ");
                teacherMap.put((long) teacherMap.size() + 1, new Teacher(splittedArray[0], splittedArray[1], (long) teacherMap.size() + 1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putModelToMap(Long index, Object model) {
        teacherMap.put(index, (Teacher) model);
    }

    @Override
    public void printModelsValueFromMap() {
        teacherMap.forEach((index, teacher) -> System.out.println(teacher));
    }
}
