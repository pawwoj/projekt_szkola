package service;

import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentService implements Service {
    Map<Long, Student> studentMap = new LinkedHashMap<>();
    String fileName = "student.txt";
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

    public Student returnStudentGeneratedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter student last name:");
        String lastName = scanner.nextLine();
        setFirstFreeIndex(firstFreeIndex + 1);
        return new Student((firstFreeIndex + offSet), firstName, lastName, true);
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
        for (Object student : studentMap.values()) {
            try {
                writer.write(student.toString() + System.lineSeparator());
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
                    studentMap.put(keyIndex, new Student(keyIndex, splittedArray[1], splittedArray[2], Boolean.parseBoolean(splittedArray[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putModelToMap() {
        Student student = returnStudentGeneratedFromConsole();
        studentMap.put((getFirstFreeIndex() + offSet), student);
    }

    @Override
    public void printModelsValueFromMap() {
        studentMap.entrySet().stream()
                .filter(student -> student.getValue().getIsActive().equals(true))
                .forEach(student -> System.out.println(student.getValue().toStringWithoutIndex()));
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object index which you wanna remove");
        while (true) {
            String index = scanner.nextLine();
            Long aLong = Long.valueOf(index);
            if (studentMap.containsKey(aLong) && studentMap.get(aLong).getIsActive()) {
                studentMap.replace(aLong, new Student(aLong, studentMap.get(aLong).getFirstName(), studentMap.get(aLong).getLastName(), false));
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
            String index = scanner.nextLine();
            Long aLong = Long.valueOf(index);
            if (studentMap.containsKey(aLong) && studentMap.get(aLong).getIsActive()) {
                System.out.println("Enter student first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter student last name:");
                String lastName = scanner.nextLine();
                studentMap.replace(aLong, new Student(aLong, firstName, lastName, true));
                break;
            } else {
                System.out.println("There is no object with that index.\n Try again: ");
            }
        }
    }
}