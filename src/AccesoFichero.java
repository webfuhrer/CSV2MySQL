import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoFichero {

	public static SuperContaminacion devolverContaminaciones() {
		FileReader fr;
		SuperContaminacion sc=null;
		try {
			fr = new FileReader("D:\\LuisSanz\\contaminacion\\horario.csv");
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();//Esta línea tiene los nombres 
			//de los campos
			String[] nombres_campos=linea.split(";");
			linea=br.readLine();
			ArrayList<Contaminacion> lista_contaminacion=new ArrayList();
			while(linea!=null)
			{
				String[] datos=linea.split(";");
				String provincia=datos[0];
				String municipio=datos[1];
				String estacion=datos[2];
				String magnitud=datos[3];
				String punto_muestreo=datos[4];
				String ano=datos[5];
				String mes=datos[6];
				String dia=datos[7];
				String[] datos_contaminacion=obtenerDatosNumericos(datos);
				Contaminacion c=new Contaminacion(provincia, 
						municipio, 
						estacion, 
						magnitud,
						punto_muestreo, 
						ano, 
						mes, 
						dia, 
						datos_contaminacion);
				lista_contaminacion.add(c);
				linea=br.readLine();
			}
			// SuperContaminacion(ArrayList<Contaminacion> lista_contaminacion, String[] nombres_campos) 
			 sc=new SuperContaminacion(lista_contaminacion, nombres_campos);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
		
	}

	private static String[] obtenerDatosNumericos(String[] datos) {
		String[] lista_numeros=new String[datos.length-8];
		for (int i=8; i<datos.length; i++)
		{
			lista_numeros[i-8]=datos[i];
		}
		return lista_numeros;
	}

}
