package one.digitalinovation;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> minhhaLista = new ListaEncadeada<>();
        minhhaLista.add("teste1");
        minhhaLista.add("teste2");
        minhhaLista.add("teste3");
        minhhaLista.add("teste4");

        System.out.println(minhhaLista.get(0));
        System.out.println(minhhaLista.get(1));
        System.out.println(minhhaLista.get(2));
        System.out.println(minhhaLista.get(3));


        System.out.println(minhhaLista);

        System.out.println(minhhaLista.remove(2));

        System.out.println(minhhaLista);
    }
}