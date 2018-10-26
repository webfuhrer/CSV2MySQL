import java.util.ArrayList;

public class ClasePpal {

	public static void main(String[] args) {
SuperContaminacion lista=AccesoFichero.devolverContaminaciones();
AccesoBD.insertarContaminaciones(lista);		
	}

}
