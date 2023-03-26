package one.digitalinovation;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;
    public ListaDuplamenteEncadeada(){
        primeiroNo = null;
        ultimoNo = null;
        this.tamanhoLista = 0;

    }
    public int size(){
        return tamanhoLista;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo noAuxiliar = primeiroNo;
        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }
    public T get(int index){
        return getNo(index).getConteudo();
    }
    public void add(T elemento){
//      novo nó é instanciado
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
//      define que o proximo nó é null
        novoNo.setNoProximo(null);
//      define que o no anterior recebe o valor do ultimo no adcionado a lista
//      se for o primeiro a ser adicionado seu valor será null e os proximos terao o valor do ultimo no adicionado
        novoNo.setNoPrevio(ultimoNo);
//      se for o primeiro for igual a null, quer dizer que a lista esta vazia e o novoNo será o primeiroNo
        if(primeiroNo == null){
//            logo o primeiro tera o proxima referincia de no como null
//            e a anterior como null, porque o estado incial do ultimoNo é null
            primeiroNo = novoNo;
//             null|conteudo|null
        }
        if(ultimoNo != null){
//            o segundo a ser adicionado caira nessa condição, porque o conteudo addicionado antes desse se tornou o
//            ultimo conteudo a ser adicionado
//            logo o proximo novoNo a ser addicionado vai ser o logo apos o ultimo adicionado
            ultimoNo.setNoProximo(novoNo);
        }
//        o novo no ja foi referenciado o ultimoNo addicionado como referencia e salvo
//        assim podesse atualizar o ultimoNo com o valor do conteudo adicionado na execução desse metodo
        ultimoNo = novoNo;
//        para manter o tamanho da lista atualizado somamos mais um toda vez que o metodo é executado
//        assim nao precisamos de laços de repetição para poder dimensionar tamaho de listas
//        o que se tornaria um problema em listas mais longas
        tamanhoLista++;
    }

    public void add(int index, T elemento){

        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);

        if(novoNo.getNoProximo() != null){
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if(index == 0) {
            primeiroNo = novoNo;
        }else{
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }

        ultimoNo = novoNo;
        tamanhoLista++;
    }
    public void remove(int index){
        if(index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if(primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        }else{
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if(noAuxiliar != ultimoNo){
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            }else{
                ultimoNo = noAuxiliar;
            }
        }
        tamanhoLista--;
    }

    @Override
    public String toString() {
        String strRetorno = "null";
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < size(); i++) {
            strRetorno += "<--- No{conteudo" + noAuxiliar.getConteudo() + "} --->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}


