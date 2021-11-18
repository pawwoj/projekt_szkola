package service;

import model.Lesson;
import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StudentService {
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

    public Map<Long, Student> getStudentMap() {
        return studentMap;
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
        Student studentTemp = new Student((firstFreeIndex + offSet), firstName, lastName, true, new ArrayList<>());
        return studentTemp;
    }

    private void addStudentIndexToStudentListInLesson(String lessonName, Student student, LessonService lessonService) {
        lessonService.getLessonMap().entrySet().stream()
                .filter(lessonEntry -> lessonEntry.getValue().getLessonName().equals(lessonName))
                .forEach(lessonEntry -> lessonEntry.getValue().getStudentList().add(student));
    }

    public void addLessonThatStudentIsAttending(LessonService lessonService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student index to add lessons");
        String index = scanner.nextLine();
        Long keyIndex = Long.valueOf(index);
        if (studentMap.containsKey(keyIndex) && studentMap.get(keyIndex).getIsActive()) {
            while (true) {
                System.out.println("Enter the index of lesson the student attends:  [0 = end]");
                String indexL = scanner.nextLine();
                Long keyIndexL = Long.valueOf(indexL);
                if (indexL.equals("0")) {
                    break;
                }
                studentMap.get(keyIndex).getLessonList().add((lessonService.getLesson(keyIndexL)));
            }
        }
    }

    public List<Lesson> getLessonListFromFIleStudent(String listInString) {
        List<Lesson> lessonList = new ArrayList<>();

        String[] splittedArray = listInString.split(" ");
        int i = 0;
        int dataForOneLesson = 4;
        while (i < splittedArray.length && splittedArray.length >= dataForOneLesson) {
            Long index = Long.valueOf(splittedArray[i++]);
            String lessonName = splittedArray[i++];
            Boolean isActive = Boolean.parseBoolean(splittedArray[i++]);
            String classroom = splittedArray[i++];
            if (classroom.endsWith(",")) {
                classroom = classroom.substring(0, classroom.length() - 1);
            }
            if (isActive) {
                lessonList.add(new Lesson(index, lessonName, isActive, Lesson.CLASSROOM.valueOf(classroom)));
            }
        }
        return lessonList;
    }

    public void saveObjectMapToFile(LessonService lessonService) {
        updateLessonListForStudent(lessonService);
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
        for (Student student : studentMap.values()) {
            try {
                writer.write(student.getIndex() + " "
                        + student.getFirstName() + " "
                        + student.getLastName() + " "
                        + student.getIsActive() + " "
                        + student.lessonListWithoutStudentToString()
                        + System.lineSeparator());
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
                if (i > 1) {
                    studentMap.put(keyIndex,
                            new Student(
                                    keyIndex,
                                    splittedArray[1],
                                    splittedArray[2],
                                    Boolean.parseBoolean(splittedArray[3]),
                                    getLessonListFromFIleStudent(line.subSequence(line.indexOf('[') + 1, line.indexOf(']')).toString())));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void putModelToMap() {
        Student student = returnStudentGeneratedFromConsole();
        studentMap.put((getFirstFreeIndex() + offSet), student);
    }

    public void printModelsValueFromMap(LessonService lessonService) {
        updateLessonListForStudent(lessonService);
        studentMap.entrySet().stream()
                .filter(student -> student.getValue().getIsActive().equals(true))
                .forEach(student -> System.out.println(student.getValue().toStringWithoutIndex() + " "
                        + student.getValue().stringFromLessonListOfLessonName()));
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object index which you wanna remove");
        while (true) {
            String indexString = scanner.nextLine();
            Long keyIndex = Long.valueOf(indexString);
            if (studentMap.containsKey(keyIndex) && studentMap.get(keyIndex).getIsActive()) {
                studentMap.get(keyIndex).setIsActive(false);
                break;
            } else {
                System.out.println("There is no object with that index.\n Try again: ");
            }
        }
    }

    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object index which you wanna edit");
        while (true) {
            String indexString = scanner.nextLine();
            Long keyIndex = Long.valueOf(indexString);
            if (studentMap.containsKey(keyIndex) && studentMap.get(keyIndex).getIsActive()) {
                System.out.println("Enter student first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter student last name:");
                String lastName = scanner.nextLine();
                studentMap.get(keyIndex).setFirstName(firstName);
                studentMap.get(keyIndex).setLastName(lastName);
                break;
            } else {
                System.out.println("There is no object with that index.\n Try again: ");
            }
        }
    }

    public void updateLessonListForStudent(LessonService lessonService) {
        for (Map.Entry<Long, Student> entry : studentMap.entrySet()) {
            for (Lesson lesson : entry.getValue().getLessonList()) {
                entry.getValue().getLessonList().stream()
                        .filter(lesson1 -> lesson1.getIndex().equals(lesson.getIndex()))
                        .findFirst().get()
                        .setIsActive(lessonService.getLessonMap().get(Long.valueOf(lesson.getIndex())).getIsActive());
            }
        }
    }
}