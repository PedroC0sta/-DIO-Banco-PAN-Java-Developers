package one.digitalinovation;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;


    public ArvoreBinaria(){
        this.raiz = null;
    }
    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }
    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if(atual == null){
            return novoNo;
        }else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        }else{
            atual.setNoDir(inserir(atual.getNoEsq(), novoNo));
        }
        return atual;
    }



//      Loop dentro de loop até que a condição de recursividade não seja mais satisfeita.
//      Assim o último nó segue o fluxo, printando o conteúdo do nó, tenta "caminhar" para a direita,
//    se não conseguir, o fluxo vai retornando para a raiz,
//    conforme os loops recursivos hierarquicamente são sendo satisfeitos, no caso de haver um nó direita,
//    "caminha-se" para direita e logo após segue o fluxo de ir resolvendo nós a esquerda
//    até o anterior a referência null.
    public void showInOrder(){
        System.out.println("\n Exibindo showInOrder");
        this.showInOrder(this.raiz);
    }
    public void showInOrder(BinNo atual){
        if(atual != null){
            showInOrder(atual.getNoEsq());
            System.out.println(atual.getConteudo());
            showInOrder(atual.getNoDir());
        }
    }
//      Mesmo esquema da anterios, showInOrder, porem ele printa o nó atual antes de ir caminhando.
//    printa depois vizita o próximo nó
    public void showPreOrder(){
        System.out.println("\n Exibindo PreOrder");
        showPreOrder(this.raiz);
    }
    private void showPreOrder(BinNo atual){
        System.out.println(atual.getConteudo());
        showInOrder(atual.getNoEsq());
        showInOrder(atual.getNoDir());
    }
// vizita até ultimo hierarquicamente e depois printa
    public void showPosOrder(){
        System.out.println("\n Exibindo PreOrder");
        showPreOrder(this.raiz);
    }
    private void showPosOrder(BinNo atual){
        showInOrder(atual.getNoEsq());
        showInOrder(atual.getNoDir());
        System.out.println(atual.getConteudo());
    }

    public void remove(T conteudo){
        try{
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho= null;
            BinNo<T> temp = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)){
                pai = atual;
                if(conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsq();
                }else {
                    atual = atual.getNoDir();
                }
            }
            if(atual == null) {
                System.out.println("Conteudo não encontrado Bloco try");
            }

            if (pai == null){
                if(atual.getNoDir() == null){
                    this.raiz = atual.getNoEsq();
                }else if (atual.getNoEsq() == null){
                    this.raiz = atual.getNoEsq();
                }else{
                    for(temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoEsq()
                    ) {
                        if(filho != atual.getNoEsq()){
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoEsq(raiz.getNoDir());
                    raiz = filho;
                }
            }else if (atual.getNoDir() == null){
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoEsq());
                }else {
                    pai.setNoDir(atual.getNoEsq());
                }
            }else if(atual.getNoEsq() == null){
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoDir());
                }else {
                    pai.setNoDir(atual.getNoDir());
                }
            }else {
                for (
                        temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoDir()
                ){
                    if(filho != atual.getNoEsq()){
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoEsq(atual.getNoEsq());
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(filho);
                }else{
                    pai.setNoDir(filho);
                }
                }
            }



        }catch (nullPointerException err){
            System.out.println("Conteudo não encontrado Bloco catch");
        }
    }

}
