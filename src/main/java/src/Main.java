package src;

import collection.StudentStorage;
import model.Student;

import java.io.IOException;

/*
 1. Wyrzuc kod z poprzednich zajec calkowicie do klasy PracaDomowa
 */
// git branch nazwa_galezi - utworzenie nowej galezi
// git checkout - przelaczenie sie na galaz
// git push --set-upstream origin szablon-projektu -> wypychanie galazki za pierwszym razem to taka komenda
// git add -u -> DODAJE DO COMMITA TYLKO EDYTOWANE PLIKI

/*
Zadanie ->
W nowym pakiecie (wymysl dobra nazwe)
Stworz klase ktora bedzie przechowywac w dowolnej kolekcji studentow, ktorych dodajesz w main
Niech ta klasa posiada dwie metody, jedna do dodawania studentow, druga do wyspisywania studentow
*** -> napisz do tych dwoch metod po jednym podstawowym tescie
 */
public class Main {
    public static void main(String[] args) throws IOException {

        StudentStorage studentStorage = new StudentStorage();
        String savePath = "src\\main\\resources\\save.txt";
        String filtrPath = "src\\main\\resources\\filtr.txt";
        String loadPath = "src\\main\\resources\\load.txt";
        String nameToFiltr = "Alicja";

        Student studentZ = new Student("Tomek", "Dorsz", "345345");

        studentStorage.addStudentToList(studentZ);
        studentStorage.addStudentToList("Alicja", "Nazwisko1", "242424");
        studentStorage.addStudentToList("Marcin", "Nazwisko2", "6543654");
        studentStorage.addStudentToList("Alicja", "Nazwisko9", "6546");
        studentStorage.printStudentList();

        studentStorage.saveListToFile(studentStorage.getStudentList(), savePath);

        studentStorage.addStudentToListFromTxtFile(studentStorage.getStudentList(), loadPath);
        studentStorage.printStudentList();

        studentStorage.saveListToFile(studentStorage.returnStudentListFilteredByName(studentStorage.getStudentList(), nameToFiltr), filtrPath);

        studentStorage.addStudentToMap("1", new Student("Jan", "Frik", "1231"));
        studentStorage.addStudentToMap("2", new Student("Aleksandra", "Riki", "65456"));
        studentStorage.printStudentMap();

    }
}
