package one.digitalinovation;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> minhaListaCircular = new ListaCircular<>();

        minhaListaCircular.add("C0");
        System.out.println(minhaListaCircular);

        minhaListaCircular.remove(0);
        System.out.println(minhaListaCircular);

    }
}