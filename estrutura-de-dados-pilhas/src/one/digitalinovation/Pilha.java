package one.digitalinovation;

public class Pilha {
    private No refNoEntradaPilha;

    public Pilha(){
        this.refNoEntradaPilha = null;
    }

    @Override
    public String toString() {
        String stringRetorno = "___________________\n";
        stringRetorno += "     Pilha\n";
        stringRetorno += "___________________\n";

        No noAuxiliar = refNoEntradaPilha;

        while(true){
            if(noAuxiliar != null){
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() +"}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            }else{
                break;
            }
        }
        stringRetorno += "================\n";
        return stringRetorno;
    }

    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    public boolean isEmpty(){
        return refNoEntradaPilha == null? true : false;
    }

    public No pop(){
        if(!this.isEmpty()){
            No noPopped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return  noPopped;
        }
        return null;
    }
    public No top(){
        return refNoEntradaPilha;
    }


}
