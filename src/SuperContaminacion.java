import java.util.ArrayList;

public class SuperContaminacion {
private ArrayList<Contaminacion> lista_contaminacion=new ArrayList();
private String[] nombres_campos;
public ArrayList<Contaminacion> getLista_contaminacion() {
	return lista_contaminacion;
}
public String[] getNombres_campos() {
	return nombres_campos;
}
public SuperContaminacion(ArrayList<Contaminacion> lista_contaminacion, String[] nombres_campos) {
	super();
	this.lista_contaminacion = lista_contaminacion;
	this.nombres_campos = nombres_campos;
}


}
