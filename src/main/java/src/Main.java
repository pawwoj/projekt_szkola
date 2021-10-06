package src;

import domowa.praca.PracaDomowa;

import java.util.*;

// git branch nazwa_galezi - utworzenie nowej galezi
// git checkout - przelaczenie sie na galaz
// git push --set-upstream origin szablon-projektu -> wypychanie galazki za pierwszym razem to taka komenda
public class Main {
    public static void main(String[] args) {
        List<Integer> pierwszaLista = new ArrayList<>();
        pierwszaLista.add(1);
        pierwszaLista.add(3);
        pierwszaLista.add(5);

        System.out.println(pierwszaLista);
        System.out.println(Collections.max(pierwszaLista));

        for (Integer x : pierwszaLista) {
            System.out.println(x);
        }

        pierwszaLista.remove(1);
        System.out.println(pierwszaLista);

        // kolekejca niegeneryczna - moze przechowywac rozne typy
        List drugaLista = new ArrayList();
        drugaLista.add("Kot");
        drugaLista.add(1);
        drugaLista.add(1.0);
        System.out.println(drugaLista);

        /*
        ArrayList - przechwouje elementy w dynamicznej tablicy (nie musisz podawac jej rozmiaru)
        dane w pamieci znajduja sie obok siebie
        -> ZAD01. Jaka jest roznica miedzy stos a sterta?
         */
        List<String> trzeciaLista = new ArrayList<>();
        trzeciaLista.add("ALa");
        trzeciaLista.add("ma");
        trzeciaLista.add("kota");

        trzeciaLista.addAll(Arrays.asList("ale", "ma", "tez", "adhd"));
        System.out.println(trzeciaLista);

        System.out.println("Rozmiar kolekcji: " + trzeciaLista.size());

        String ala = trzeciaLista.get(0);
        System.out.println(ala);

        for (int x = 0; x < trzeciaLista.size(); x++) {
            System.out.print(trzeciaLista.get(x) + " ");
        }

        Iterator<String> iterowanie = trzeciaLista.iterator();
        while (iterowanie.hasNext()) {
            System.out.print(iterowanie.next() + " ");
        }
        System.out.println();
        System.out.println("Czy Ala znajduje sie w kolekcji? " + trzeciaLista.contains("ALa"));
        System.out.println();

        List<String> czwartaKolekcja = new ArrayList<>();
        System.out.println("Czy kolekcja pusta? " + czwartaKolekcja.isEmpty());


        System.out.println("\n---------- Praca Domowa ----------\n");
        PracaDomowa pracaDomowa = new PracaDomowa();

        System.out.println("Zadanie 1: Zadeklaruj ArrayListe intow, dodaj do niej 5 roznych liczb metoda add, wyswietl cala liste\n" +
                "petla for each: ");
        pracaDomowa.z1ForEachZListaIntegerI();
        System.out.println("Zadanie 2: Stworz metode ktora zwroci sume liczb z ArrayListy z 1 zadania:\n"
                + pracaDomowa.z2ZwracaSumeLiczbZListyIntegerow());
        System.out.println("Zadanie 3: Stworz metode ktora zwroci liste elementow wiekszych od 3:\n"
                + pracaDomowa.z3ZwracaListeElementowwiekszychOd3());
        System.out.println("Zadanie 4: Zadeklaruj Liste Stringow, dodaj do niej kolekcje imion Tomek Ania Tomek Krzys Grzes\n" +
                "Tomek metoda addAll, nastepnie usun wszystkich Tomkow z tej list:");
        pracaDomowa.z4ListaStringowBezTomka();
        System.out.println("Zadanie 5: Napisz metode do zadania 4, ktora zwroci najdluzsze imie:\n"
                + pracaDomowa.z5ZwracaListeNajdlozszychImion());
        System.out.println("Zadanie 6: Napisz metode do zadani 4 ktora sprawdza czy podane imie znajduje sie w kolekcje (Ania):\n"
                + pracaDomowa.z6SprawdzaCzyPodaneImieZnajdujeSieWKolekcji("Ania"));
        System.out.println("Zadanie 7: Zadeklaruj liste zmiennych typu double, dodaj do listy 5 liczb rzeczywiste i wypisz je\n"
                + "w kolejnosci rosnacej:");
        pracaDomowa.z7WypisujeListeDoubleWKolejnosciRosnacej();
        System.out.println("Zadanie 8: Napisz metode ktora uzupelnia losowa iloscia (od 2-8) liczb losowych z przedziaku 1-10,\n" +
                "wrzucmy te liczby do nowej listy posortujmy ja odwrotnie i zwracamy ta liste:");
        pracaDomowa.z8ZwracaListePosortowanychLosowychLiczb();
        List<Integer> listaDoZadania9 = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 7, 5, 3));
        System.out.println("Zadanie 9: Napisz metode ktora jako parametr przyjmuje liste intow oraz inta i zwraca liste intow\n" +
                "ktore sa wieksze niz podany jako parametr int: (1,2,4,6,7,5,3) - (5) \n"
                + pracaDomowa.z9ZwracaPodanaListeZElementamiWiekszymiOdDanegoInt(listaDoZadania9, 5));
        List<String> listaDoZadania10 = new ArrayList<>(Arrays.asList("Monika", "Adam", "Ola", "Kamil", "Ola", "Marta", "Ola"));
        System.out.println("Zadanie 10: Napisz metode ktora przyjmuje liste Stringow i zwraca listę (intow) indeksow wszystkich\n" +
                "elementow na liscie, ktore sa takie same jak parametr metody np dla Listy Ania Krzys Ania\n" +
                "Piotr Tomek Ania i imienia Ania output: to 0,2,5: " + listaDoZadania10 + "- Ola \n"
                + pracaDomowa.z10ZwracaIndeksyZListyDlaPodanegoImienia(listaDoZadania10, "Ola"));
    }
}
