
public class Contaminacion {
private String provincia, municipio, estacion, magnitud, punto_muestreo, ano, mes, dia;
private String[] datos;
public String getProvincia() {
	return provincia;
}
public String getMunicipio() {
	return municipio;
}
public String getEstacion() {
	return estacion;
}
public String getMagnitud() {
	return magnitud;
}
public String getPunto_muestreo() {
	return punto_muestreo;
}
public String getAno() {
	return ano;
}
public String getMes() {
	return mes;
}
public String getDia() {
	return dia;
}
public String[] getDatos() {
	return datos;
}
public Contaminacion(String provincia, String municipio, String estacion, String magnitud, String punto_muestreo,
		String ano, String mes, String dia, String[] datos) {
	super();
	this.provincia = provincia;
	this.municipio = municipio;
	this.estacion = estacion;
	this.magnitud = magnitud;
	this.punto_muestreo = punto_muestreo;
	this.ano = ano;
	this.mes = mes;
	this.dia = dia;
	this.datos = datos;
}

}
