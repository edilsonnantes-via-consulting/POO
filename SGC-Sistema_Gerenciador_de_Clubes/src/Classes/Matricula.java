package Classes;

import java.util.Calendar;

public class Matricula{
	private int matriculaId;
	private Modalidade modalidade;
	private Calendar dataIni;
	private Calendar dataFim;

	//Método contrutor
	public Matricula(Modalidade modalidade){
		this.modalidade = modalidade;
		this.dataIni = Calendar.getInstance();
	}

	//gets
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

	//sets
	public void setDataFim(){
		this.dataFim = Calendar.getInstance();
	}


	//Método que faz a pesuisa de matriculas pelo ID
	public static Matricula pesquisar(int id, Matricula matriculas[]){
	    int i;
		for (i = 0; i < matriculas.length; i++){
		    if(id == matriculas[i].getMatriculaId()){
				break;
		    }
	    }
		if(id == matriculas[i].getMatriculaId()){
			return matriculas[i];
		}
		else{
			return null;
		}

	}
	
	//Método toString
	public String toString(){
        	String aux = "";
        	aux += "\nID: " + this.matriculaId;
		aux += "\nData de inicio: " + this.dataIni;
		aux += "\nData de termino: " + this.dataFim;
        	return aux;
	}
}
