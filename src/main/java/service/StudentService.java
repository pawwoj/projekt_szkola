package service;

import model.Student;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    List<Student> studentList = new ArrayList<>();
    Map<String, Student> studentMap = new HashMap<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public String toStringList() {
        return studentList.toString();
    }

    public void printStudentList() {
        System.out.println(studentList);
    }

    public void printStudentMap() {
        System.out.println(studentMap);
    }

    public String toStringMap() {
        return studentMap.toString();
    }

    public Student returnGeneratedStudentFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter student last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter student index number:");
        String indexNumber;
        boolean indexNumberIsCorrect;

        do {
            indexNumber = scanner.nextLine();
            try {
                int intValue = Integer.parseInt(indexNumber);
                indexNumberIsCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Index number isn't correct. Type correct Index Number for: " + firstName + " " + lastName + " :");
                indexNumberIsCorrect = false;
            }
        } while (!indexNumberIsCorrect);

        return new Student(firstName, lastName, indexNumber);
    }

    public void addStudentToList(String firstName, String lastName, String indexNumber) {
        Student student = new Student(firstName, lastName, indexNumber);
        studentList.add(student);
    }

    public void addStudentToMap(String studentID, Student student) {
        studentMap.put(studentID, student);
    }

    public void addStudentToList(Student student) {
        studentList.add(student);
    }

    public void addStudentToList() {
        String yesNo;
        do {
            studentList.add(returnGeneratedStudentFromConsole());
            System.out.println("Do you wanna add another student? y / n");
            Scanner scanner = new Scanner(System.in);
            yesNo = scanner.nextLine();
        } while (yesNo.equals("y"));
    }

    public Student studentGeneratorFromStringLine(String line) {
        String firstName;
        String lastName;
        String indexNumber;
        int firstSpace = line.indexOf(' ');
        int secondSpace = line.indexOf(' ', firstSpace + 1);
        firstName = line.substring(0, firstSpace);
        lastName = line.substring(firstSpace + 1, secondSpace);
        indexNumber = line.substring(secondSpace + 1);
        return new Student(firstName, lastName, indexNumber);
    }

    public void addStudentToListFromTxtFile(List<Student> studentList, String filePath) throws IOException {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            {
                String lineFromTxtFile;
                while ((lineFromTxtFile = fileReader.readLine()) != null) {
                    studentList.add(studentGeneratorFromStringLine(lineFromTxtFile));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }

    public void saveListToFile(List<Student> listOfStudent, String filePath) throws IOException {
        StringBuilder listToWrite = new StringBuilder();
        listOfStudent.forEach(student -> listToWrite.append(student.toString() + "\n"));
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(listToWrite.toString());
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    public List<Student> returnStudentListFilteredByName(List<Student> studentList, String studentName) {
        List<Student> filtredList =
                studentList.stream()
                        .filter(student -> student.getFirstName().equals(studentName))
                        .collect(Collectors.toList());
        return filtredList;
    }
}


