import java.io.*;
import java.util.Calendar;

public class Leitura{

	//funcoes de leitura que já passam o que vai ser impresso na tela
	public static String lerString(String label){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(isr);
		String aux = "";
		System.out.print(label); 
		try{
			aux = buf.readLine();
		}catch(IOException erro){
			System.out.println("Deu erro...");
		}
		
		return aux;
	}

	public static int lerInt(String label){
		int valor=0;
		try{
			valor = Integer.parseInt(lerString(label));
		}catch(Exception erro){
			System.out.println("Valor digitado invalido,tente novamente");
			lerInt();
		}
		return valor;
	}

	public static float lerFloat(String label){
		try{
			return Float.parseFloat(lerString(label));
		}catch(Exception erro){
			System.out.println("Valor digitado invalido, tente novamente");
			lerFloat("");
		}

		return 0;
	}

	public static double lerDouble(String label){
		return Double.parseDouble(lerString(label));
	}

	public static Calendar lerData(String label){
		String dataString = lerString(label);
		Calendar d = Calendar.getInstance();
		try{
			d.set(Calendar.DAY_OF_MONTH,Integer.parseInt(dataString.substring(0,2)));
			d.set(Calendar.MONTH,Integer.parseInt(dataString.substring(3,5))-1); /*Os meses na classe Calendar são numerados de 
																			 	   0(Janeiro) até 11(dezembro)*/
																				   
			d.set(Calendar.YEAR,Integer.parseInt(dataString.substring(6,10)));
		}
		catch(Exception erro){
			System.out.println("Data invalida");
			lerData("");
		}
		
		return d;		
	}

	//funcoes polimorficas quando é solicitado uma funcao sem label
	public static String lerString(){
		return lerString("");
	}

	public static int lerInt(){
		return lerInt("");
	}

	public static float lerFloat(){
		return lerFloat("");
	}


	public static Calendar lerData(){
		return lerData("");
	}
}