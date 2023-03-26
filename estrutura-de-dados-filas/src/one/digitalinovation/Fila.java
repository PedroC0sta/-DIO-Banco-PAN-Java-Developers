package com.digitalInovation;

public class Fila {
    private No refNoEntradaFila;
    public Fila(){
        this.refNoEntradaFila = null;
    }
    public void enqueue(Object object){
        No novoNo = new No(object)
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public Object first() {
         if(!this.isEmpty()){
             No primeiroNo = refNoEntradaFila;
             while (true){
                 if(primeiroNo.getRefNo() != null){
                     primeiroNo = primeiroNo.getRefNo();
                 }else{
                     break;
                 }
             }
             return primeiroNo.getObject();
         }
         return null;
    }

    public Object dequeue() {
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();

                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return primeiroNo.getObject;
        }
        return null;
    }
    
    public Object last(){
        return refNoEntradaFila.getObject();
    }
    private boolean isEmpty(){
        return refNoEntradaFila == null? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while(true){
                stringRetorno += "[No{Objeto=" + noAuxiliar.getObject() + "}] --->";
                if(noAuxiliar.getRefNo() != null){
                    noAuxiliar = noAuxiliar.getRefNo();
                }else{
                    stringRetorno += "null";
                    break;
                }
            }
        }else{
            stringRetorno = "null";
        }
        return stringRetorno;
    }
}
