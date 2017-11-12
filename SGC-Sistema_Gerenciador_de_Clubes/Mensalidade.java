import java.util.Calendar;

public class Mensalidade{
    private int mensalidadeId;
    private Calendar dataEmissao;
    private float valor;
    private Calendar dataPagamento;

    teste

    //Método construtor
    public Mensalidade(Calendar dataEmissao, float valor, Calendar dataPagamento){
        this.mensalidadeId = Utilitario.MENSALIDADE_ID++;
        this.dataEmissao= dataEmissao;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

    //Método toString
    public String toString(){
        String aux = "";
        aux += "ID: " + this.mensalidadeId;
        aux += "\nValor:" + this.valor;
        aux += "\nEmissao:" + this.dataEmissao;
        aux += "\nPagamento: " + this.dataPagamento;

        return aux;
    }

    //Métodos sets

    /*mensalidadeId não possue set, pois é definido conforme o cadastramento */
    
    public void setDataEmissao(Calendar dataEmissao){
        this.dataEmissao = dataEmissao;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public void setDataPagamento(Calendar dataPagamento){
        this.dataPagamento = dataPagamento;
    }

    //Métodos gets
    public int getMensalidadeId(){
        return this.mensalidadeId;
    }

    public Calendar getDataEmissao(){
        return this.dataEmissao;
    }

    public float getValor(){
        return this.valor;
    }

    public Calendar getDataPagamento(){
        return this.dataPagamento;
    }
}