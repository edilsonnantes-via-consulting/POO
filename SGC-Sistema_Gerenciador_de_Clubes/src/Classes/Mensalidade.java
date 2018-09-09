package Classes;

import java.util.Calendar;

public class Mensalidade{
    private int mensalidadeId;
    private Calendar dataEmissao;
    private float valor;
    private Calendar dataPagamento;

    //Método construtor
    public Mensalidade(float valor){
        this.dataEmissao=Calendar.getInstance();
        this.valor = valor;
    }

    //Método toString
    public String toString(){
        String aux = "";
        aux += "ID: " + this.mensalidadeId;
        aux += "\nValor:" + this.valor;
        aux += "\nEmissao:" + this.dataEmissao.get(Calendar.DAY_OF_MONTH);
        aux += "/" + (this.dataEmissao.get(Calendar.MONTH)+1);
        aux += "/" + this.dataEmissao.get(Calendar.YEAR);

        return aux;
    }

    //Métodos sets

    /*mensalidadeId não possui set, pois é definido conforme o cadastramento */
    
    public void setDataEmissao(){
        this.dataEmissao = Calendar.getInstance();
    }

    public void setValor(float valor){
        this.valor = valor;
    }

	public void setDataPagamento(){
		this.dataPagamento=Calendar.getInstance();
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
