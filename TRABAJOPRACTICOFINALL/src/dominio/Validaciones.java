package dominio;

public class Validaciones {
	
	public static void validarLenghtString(String texto,Integer tope, String mensaje)   {
		if(!(texto.length()>0 && texto.length()<tope)) {
			throw new RuntimeException(mensaje);
		}
	}
	
	public static void validarPrecio(Double precio,Double tope,String mensaje)  {
		if(!(precio>=0.0 && precio<tope)) {
			throw new RuntimeException(mensaje);
		}
	}
	
	public static void validarPorcentaje(Double porcentaje,String mensaje) {
		if(!(porcentaje>0 && porcentaje<100)) {
			throw new RuntimeException(mensaje);
		}
	}
	
	public static void validarFecha(Fecha fecha,Fecha topeInicio,Fecha topeFin,String mensaje) {
		//if(!(fecha.esMayorIgual(topeInicio) && topeFin.esMenorIgual(fecha))) 
		if(!(topeInicio.esMayorIgual(fecha) && (topeFin.esMenorIgual(fecha))))
		{
			throw new RuntimeException(mensaje);
		}
	}
	
	public static void validarNumeroPositivo(Integer numero) {
		if(!(numero>0)) {
			throw new RuntimeException("El numero debe ser mayor a 0");
		}
	}
	

}
