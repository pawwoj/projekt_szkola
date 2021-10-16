package src;

import application.Application;
import service.StudentService;

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


        Application app = new Application();
        app.run();



        // Wczytaj z klawiatury imie, nazwisko, nr albumu
        // dodaj studenta do kolekcji
        // wyswietl calosc


/*        String savePath = "src\\main\\resources\\save.txt";
        String filtrPath = "src\\main\\resources\\filtr.txt";
        String loadPath = "src\\main\\resources\\load.txt";
        String nameToFiltr = "Alicja";

        Student studentZ = new Student("Tomek", "Dorsz", "345345");

        studentService.addStudentToList(studentZ);
        studentService.addStudentToList("Alicja", "Nazwisko1", "242424");
        studentService.addStudentToList("Marcin", "Nazwisko2", "6543654");
        studentService.addStudentToList("Alicja", "Nazwisko9", "6546");
        studentService.printStudentList();

        studentService.saveListToFile(studentService.getStudentList(), savePath);

        studentService.addStudentToListFromTxtFile(studentService.getStudentList(), loadPath);
        studentService.printStudentList();

        studentService.saveListToFile(studentService.returnStudentListFilteredByName(studentService.getStudentList(), nameToFiltr), filtrPath);

        studentService.addStudentToMap("1", new Student("Jan", "Frik", "1231"));
        studentService.addStudentToMap("2", new Student("Aleksandra", "Riki", "65456"));
        studentService.printStudentMap();*/
    }
}
