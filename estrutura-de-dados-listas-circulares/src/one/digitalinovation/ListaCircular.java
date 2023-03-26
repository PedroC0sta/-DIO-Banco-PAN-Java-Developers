package one.digitalinovation;

public class ListaCircular<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private int tamnahoLista;
    public  ListaCircular(){
        this.cauda = null;
        this.cabeca = null;
        this.tamnahoLista = 0;
    }
    public Boolean isEmpty(){
        return this.tamnahoLista == 0? true : false;
    }

    public int size(){
        return this.tamnahoLista;
    }

    private No<T> getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia");
        if(index == 0 )
            return cauda;
        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < index; i++)
            noAuxiliar = noAuxiliar.getNoProximo();

        return noAuxiliar;
    }
    public T get(int index){
        return getNo(index).getConteudo();
    }

    public void remove(int index){
        if(index >= size())
            throw new IndexOutOfBoundsException("O índice maior que o tamanho da lista");
        No<T> noAuxiliar = this.cauda;
        if(index == 0) {
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        }else if(index == 1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else {
            for (int i = 0; i < index-1; i++) {
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.tamnahoLista--;
    }
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.isEmpty()){
            this.cauda = novoNo;
            this.cabeca = this.cauda;
            this.cabeca.setNoProximo(this.cauda);
        }else{
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        tamnahoLista ++;
    }
    @Override
    public String toString(){
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for(int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() +"}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += size() != 0 ? "(Retorna ao início)" : "[]";
        return strRetorno;

    }

}

