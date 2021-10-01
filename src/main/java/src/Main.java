package src;

import java.util.*;

// git branch nazwa_galezi - utworzenie nowej galezi
// git checkout - przelaczenie sie na galaz
// git push --set-upstream origin szablon-projektu -> wypychanie galazki za pierwszym razem to taka komenda
public class Main {
    public static void main(String []args){
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

        for(int x = 0; x < trzeciaLista.size(); x++) {
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
    }
}
