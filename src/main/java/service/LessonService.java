package service;

import model.Lesson;
import org.apache.commons.lang3.EnumUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LessonService {
    private final Map<Long, Lesson> lessonMap = new LinkedHashMap<>();
    private final int offSet = -1;
    private String fileName = "lesson.txt";
    private Long firstFreeIndex = 1L;


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

    public Map<Long, Lesson> getLessonMap() {
        return lessonMap;
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public Lesson returnLessonGeneratedFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lesson name:");
        String lessonName = scanner.nextLine();
        System.out.println("Enter classroom name:");
        String classroom = scanner.nextLine();
        while (EnumUtils.getEnumIgnoreCase(Lesson.CLASSROOM.class, classroom) == null) {
            System.out.println("Enter correct classroom name");
            classroom = scanner.nextLine();
        }
        setFirstFreeIndex(firstFreeIndex + 1);
        return new Lesson((firstFreeIndex + offSet), lessonName, true, EnumUtils.getEnumIgnoreCase(Lesson.CLASSROOM.class, classroom), new ArrayList<>());
    }

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
        for (Lesson lesson : lessonMap.values()) {
            try {
                writer.write(lesson.toStringWithoutList() + System.lineSeparator());
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
                if (i > 1)
                    lessonMap.put(keyIndex, new Lesson(keyIndex, splittedArray[1], Boolean.parseBoolean(splittedArray[2]), Lesson.CLASSROOM.valueOf(splittedArray[3]), new ArrayList()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void putModelToMap() {
        Lesson lesson = returnLessonGeneratedFromConsole();
        lessonMap.put((getFirstFreeIndex() + offSet), lesson);
    }

    public void printModelsValueFromMap(StudentService studentService) {
        addStudentToStudentListInLesson(studentService);
        lessonMap.entrySet().stream()
                .filter(lessonEntry -> lessonEntry.getValue().getIsActive().equals(true))
                .forEach(lessonEntry -> System.out.println(lessonEntry.getValue().toStringWithoutIndex() + " "
                        + lessonEntry.getValue().stringFromListOfStudentFirstAndLastName()));
    }

    public Lesson getLessonFromMap(Long index) {
        return lessonMap.get(index);
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter object index which you wanna remove");
        while (true) {
            String indexString = scanner.nextLine();
            Long keyIndex = Long.valueOf(indexString);
            if (lessonMap.containsKey(keyIndex) && lessonMap.get(keyIndex).getIsActive()) {
                lessonMap.get(keyIndex).setIsActive(false);
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
            if (lessonMap.containsKey(keyIndex) && lessonMap.get(keyIndex).getIsActive()) {
                System.out.println("Enter lesson name:");
                String lessonName = scanner.nextLine();
                lessonMap.get(keyIndex).setLessonName(lessonName);
                System.out.println("Enter classroom name:");
                String classroom = scanner.nextLine();
                while (EnumUtils.getEnumIgnoreCase(Lesson.CLASSROOM.class, classroom) == null) {
                    System.out.println("Enter correct classroom name");
                    classroom = scanner.nextLine();
                    lessonMap.get(keyIndex).setClassroom(EnumUtils.getEnumIgnoreCase(Lesson.CLASSROOM.class, classroom));
                }
                break;
            } else {
                System.out.println("There is no object with that index.\n Try again: ");
            }
        }
    }

    public Lesson getLesson(Long lessonIndex) {
        return lessonMap.get(lessonIndex);
    }

    public void addStudentToStudentListInLesson(StudentService studentService) {

        studentService.getStudentMap().entrySet().stream().filter(longStudentEntry -> longStudentEntry.getValue().getIsActive().equals(true))
                .forEach(longStudentEntry -> longStudentEntry.getValue().getLessonList()
                        .forEach(lesson -> lessonMap.get(lesson.getIndex()).getStudentList().clear()));

        studentService.getStudentMap().entrySet().stream().filter(longStudentEntry -> longStudentEntry.getValue().getIsActive().equals(true))
                .forEach(longStudentEntry -> longStudentEntry.getValue().getLessonList()
                        .forEach(lesson -> lessonMap.get(lesson.getIndex()).getStudentList().add(longStudentEntry.getValue())));
    }
}