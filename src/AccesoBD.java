import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoBD {
	static String usuario="root";
	static String password="";
	static String url="jdbc:mysql://localhost:3306/basedatos";
	public static void insertarContaminaciones(SuperContaminacion lista) {
		crearTabla(lista.getNombres_campos());
		insertarDatos(lista.getLista_contaminacion());
		
	}

	private static void insertarDatos(ArrayList<Contaminacion> lista_contaminacion) {
		
		for (Contaminacion contaminacion : lista_contaminacion) {
			String query_insert=obtenerInsert(contaminacion);
			try {
				Connection c=DriverManager.getConnection(url, usuario, password);
			Statement stmt=c.createStatement();
			stmt.executeUpdate(query_insert);
			stmt.close();
			c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static String obtenerInsert(Contaminacion contaminacion) {
		String insert="INSERT INTO tabla_contaminacion VALUES(";
		insert+="'"+contaminacion.getProvincia()+"', ";
		insert+="'"+contaminacion.getMunicipio()+"', ";
		insert+="'"+contaminacion.getEstacion()+"', ";
		insert+="'"+contaminacion.getMagnitud()+"', ";
		insert+="'"+contaminacion.getPunto_muestreo()+"', ";
		insert+="'"+contaminacion.getAno()+"', ";
		insert+="'"+contaminacion.getMes()+"', ";
		insert+="'"+contaminacion.getDia()+"', ";
		for(int i=0; i<contaminacion.getDatos().length;i++ )
		{
			insert+="'"+contaminacion.getDatos()[i]+"',";
		}
		insert=insert.substring(0,insert.length()-1);
		insert+=")";
		return insert;
	}

	private static void crearTabla(String[] nombres_campos) {
		String creacion_tabla="CREATE TABLE IF NOT EXISTS tabla_contaminacion";
		creacion_tabla+="(";
		for (int i=0; i<nombres_campos.length; i++)
		{
			creacion_tabla+=nombres_campos[i]+" varchar(16),";
		}
		creacion_tabla=creacion_tabla.substring(0, creacion_tabla.length()-1);
		creacion_tabla+=");";	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, usuario, password);
			Statement stmt=c.createStatement();
			stmt.executeUpdate(creacion_tabla);
			stmt.close();
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
