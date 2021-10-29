package service;

import model.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TeacherService implements Service {
    Map<Long, Teacher> teacherMap = new LinkedHashMap<>();
    String fileName = "teacher.txt";
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

    public Teacher returnTeacherGeneratedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter teacher first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter teacher last name:");
        String lastName = scanner.nextLine();
        setFirstFreeIndex(firstFreeIndex + 1);
        return new Teacher((firstFreeIndex - 1), firstName, lastName);
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
                    teacherMap.put(keyIndex, new Teacher(keyIndex, splittedArray[1], splittedArray[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putModelToMap (){
        Teacher teacher = returnTeacherGeneratedFromConsole();
        teacherMap.put((getFirstFreeIndex() - 1), teacher);
    }

    @Override
    public void printModelsValueFromMap() {
        teacherMap.forEach((index, teacher) -> System.out.println(teacher.toStringWithoutIndex()));
    }
}
