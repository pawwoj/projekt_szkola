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
    Long firstFreeIndex = 1L;
    int offSet = -1;

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

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
                if (isNumeric(line)) {
                    setFirstFreeIndex(Long.valueOf(line));
                }
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
        return new Teacher((firstFreeIndex + offSet), firstName, lastName, true);
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
    public void loadToMapObjectFromFile() {

        loadAndSetFirstFreeIndexFromFile();

        File file = new File(getFileName());

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(",");
            int i = 0;
            Long keyIndex = 1L;
            while (fileScanner.hasNextLine()) {
                i++;
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split(" ");
                if (isNumeric(splittedArray[0])) {
                    keyIndex = Long.valueOf(splittedArray[0]);
                }
                if (i > 1)
                    teacherMap.put(keyIndex, new Teacher(keyIndex, splittedArray[1], splittedArray[2], Boolean.parseBoolean(splittedArray[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putModelToMap() {
        Teacher teacher = returnTeacherGeneratedFromConsole();
        teacherMap.put((getFirstFreeIndex() + offSet), teacher);
    }

    @Override
    public void printModelsValueFromMap() {
        teacherMap.entrySet().stream()
                .filter(teacherEntry -> teacherEntry.getValue().getIsActive().equals(true))
                .forEach(teacherEntry -> System.out.println(teacherEntry.getValue().toStringWithoutIndex()));
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object index which you wanna remove");
        while (true) {
            String indexString = scanner.nextLine();
            Long keyIndex = Long.valueOf(indexString);
            if (teacherMap.containsKey(keyIndex) && teacherMap.get(keyIndex).getIsActive()) {
                teacherMap.replace(keyIndex, new Teacher(keyIndex, teacherMap.get(keyIndex).getFirstName(), teacherMap.get(keyIndex).getLastName(), false));
                break;
            } else {
                System.out.println("There is no object with that index.\n Try again: ");
            }
        }
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object index which you wanna edit");
        while (true) {
            String indexString = scanner.nextLine();
            Long keyIndex = Long.valueOf(indexString);
            if (teacherMap.containsKey(keyIndex) && teacherMap.get(keyIndex).getIsActive()) {
                System.out.println("Enter teacher first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter teacher last name:");
                String lastName = scanner.nextLine();
                teacherMap.replace(keyIndex, new Teacher(keyIndex, firstName, lastName, true));
                break;
            } else {
                System.out.println("There is no object with that index.\n Try again: ");
            }
        }
    }
}