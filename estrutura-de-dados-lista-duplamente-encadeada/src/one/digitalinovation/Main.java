package one.digitalinovation;

import olne.digitatalinovation.ListaDuplamenteEncadeada;

import java.lang.management.MonitorInfo;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> minhaLista = new ListaDuplamenteEncadeada<>();

        minhaLista.add("c1");
        minhaLista.add("c2");
        minhaLista.add("c3");
        minhaLista.add("c4");
        minhaLista.add("c5");

        System.out.println(minhaLista);
        minhaLista.add(5, "c99");
        System.out.println(minhaLista);

        minhaLista.remove(2);
        System.out.println(minhaLista);
    }
}