package service;

import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentService implements Service {

    Map<Long, Student> studentMap = new LinkedHashMap<>();
    String fileName = "student.txt";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public Student returnStudentGeneratedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter student last name:");
        String lastName = scanner.nextLine();

        return new Student(firstName, lastName);
    }

    @Override
    public void saveObjectMapToFile() {
        FileWriter writer = null;

        try {
            writer = new FileWriter(getFileName());
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
        File file = new File(getFileName());

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter(",");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split(" ");
                studentMap.put((long) studentMap.size() + 1, new Student(splittedArray[0], splittedArray[1], (long) studentMap.size() + 1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putModelToMap(Long index, Object model) {
        studentMap.put(index, (Student) model);
    }

    @Override
    public void printModelsValueFromMap() {
        studentMap.forEach((index, teacher) -> System.out.println(teacher));
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student index which you wanna remove");
        while(true){
            String index = scanner.nextLine();
            Long aLong = Long.valueOf(index);
            if (studentMap.containsKey(aLong)){
                studentMap.remove(aLong);
                break;
            }
            else {
                System.out.println("There is no student with that index.\n Try again: ");
            }
        }
    }
}


