import java.util.Calendar;

public class Matricula{
	private int matriculaId;
	private Modalidade modalidade;
	private Calendar dataIni;
	private Calendar dataFim;



	public Matricula(){

	}


	public int getMatriculaId(){
        return matriculaId;
	}

	public Calendar getDataIni(){
        return dataIni;
	}

	public Calendar getDataFim(){
        return dataFim;
	}

	public Modalidade getModalidade(){
        return modalidade;
	}


	public void setDataIni(){

	}

	public String toString(){
        String aux = "";
        aux += "\nID: " + this.matriculaId;

        return aux;
	}
}
