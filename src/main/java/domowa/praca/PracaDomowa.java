package domowa.praca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PracaDomowa {
    List<Integer> listaIntegerow = new ArrayList<>();
    List<String> listaStringow = new ArrayList<>();
    List<Double> listaDouble = new ArrayList<>();

    public PracaDomowa() {
        listaIntegerow.add(5);
        listaIntegerow.add(2);
        listaIntegerow.add(8);
        listaIntegerow.add(1);
        listaIntegerow.add(32);

        listaDouble.addAll(Arrays.asList(5.2, 6.8, 1.1, 2.2, 3.3));
    }

    public void z1ForEachZListaIntegerI() {
        listaIntegerow.forEach((integer -> System.out.println(integer)));
    }

    public int z2ZwracaSumeLiczbZListyIntegerow() {
        int suma = 0;
        for (Integer i : listaIntegerow) {
            suma += i;
        }
        return suma;
    }

    public List<Integer> z3ZwracaListeElementowwiekszychOd3() {
        List<Integer> listaElementowWiekszOd3 = new ArrayList<>();
        for (Integer i : listaIntegerow) {
            if (i > 3) {
                listaElementowWiekszOd3.add(i);
            }
        }
        return listaElementowWiekszOd3;
    }

    public void z4ListaStringowBezTomka() {
        listaStringow.addAll(Arrays.asList("Tomek", "Ania", "Tomek", "Krzys", "Grzes", "Tomek"));
        listaStringow.removeIf(imie -> (imie.equals("Tomek")));
        System.out.println(listaStringow);
    }

    public List<String> z5ZwracaListeNajdlozszychImion() {
        List<String> listaNajdluzszychImion = new ArrayList<>();
        int max = 0;

        for (String imie : listaStringow) {
            if (imie.length() > max)
                max = imie.length();
        }

        for (String imieMax : listaStringow) {
            if (imieMax.length() == max)
                listaNajdluzszychImion.add(imieMax);
        }

        return listaNajdluzszychImion;
    }

    public boolean z6SprawdzaCzyPodaneImieZnajdujeSieWKolekcji(String imie) {
        return listaStringow.contains(imie);
    }

    public void z7WypisujeListeDoubleWKolejnosciRosnacej() {
        Collections.sort(listaDouble);
        System.out.println(listaDouble);
    }

    public List<Integer> z8ZwracaListePosortowanychLosowychLiczb() {
        List<Integer> listaLosowychLiczb = new ArrayList<>();
        int random28 = ThreadLocalRandom.current().nextInt(2, 9);
        System.out.println("Ilość liczb do wylosowania: \n" + random28);
        for (int i = 0; i < random28; i++) {
            listaLosowychLiczb.add(ThreadLocalRandom.current().nextInt(1, 11));
        }
        System.out.println("Wylosowane: \n" + listaLosowychLiczb);
        Collections.reverse(listaLosowychLiczb);
        System.out.println("Odwrócone: \n" + listaLosowychLiczb);

        return listaLosowychLiczb;
    }

    public List<Integer> z9ZwracaPodanaListeZElementamiWiekszymiOdDanegoInt(List<Integer> listaPodana, int wartoscWyjsciowa) {
        listaPodana.removeIf(integer -> (integer <= wartoscWyjsciowa));
        return listaPodana;
    }

    public List<Integer> z10ZwracaIndeksyZListyDlaPodanegoImienia(List<String> listaImion, String szukaneImie) {
        List<Integer> listaZIndeksamiSzukanegoImienia = new ArrayList<>();

        for (int i = 0; i < listaImion.size(); i++) {
            if (listaImion.get(i).equals(szukaneImie)) {
                listaZIndeksamiSzukanegoImienia.add(i);
            }
        }
        return listaZIndeksamiSzukanegoImienia;
    }
}