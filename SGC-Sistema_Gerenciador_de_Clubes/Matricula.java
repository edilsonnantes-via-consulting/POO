import java.util.Calendar;

public class Matricula{
	private int matriculaId;
	private Modalidade modalidade;
	private Calendar dataIni;
	private Calendar dataFim;



	public Matricula(Modalidade modalidade){
		this.matriculaId = Utilitario.MATRICULA_ID++;
		this.modalidade = modalidade;
		this.dataIni = Calendar.getInstance();
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


	public void setDataFim(Calendar dataFim){
		this.dataFim = dataFim;
	}
	
	public static Matricula pesquisar(int id, Matricula matriculas[]){
	    int i;
		for (i = 0; i < matriculas.length; i++){
		    if(id == matriculas[i+1].getMatriculaId()){
				break;
		    }
	    }
		if(id == matriculas[i+1].getMatriculaId()){
			return matriculas[i+1];
		}
		else{
			return null;
		}

	}
	

	public String toString(){
        String aux = "";
        aux += "\nID: " + this.matriculaId;
		aux += "\nData de inicio: " + this.dataIni;
		aux += "\nData de termino: " + this.dataFim;
        return aux;
	}
}
