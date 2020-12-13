package dominio;

public class Atencion {
	protected double importe;
	protected Fecha fecha;
	protected Boolean pagado;

	public Atencion(double importe, Fecha fecha)  {

		Fecha topeInicio = new Fecha(1, 1, 2000);
		Fecha topeFin = new Fecha(1, 1, 2100);

		//try {
			Validaciones.validarPrecio(importe,100000.0, "El importe debe ser mayor o igual a 0 y menor a 100000");
	/*	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {*/
			Validaciones.validarFecha(fecha, topeInicio, topeFin, "Ingrese una fecha valida");
	/*	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		this.importe = importe;
		this.fecha = fecha;
		pagado = false;
	}

	public double obtenerImporte() {
		return importe;
	}

	public Fecha obtenerFecha() {
		return fecha;
	}
	
	public void agregarImporte(double importe)  {
		//try {
			Validaciones.validarPrecio(importe, 100000.0, "El importe debe estar entre 0 y 100000");
		/*} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.importe = importe;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		  sb.append(" atencion :  importe  " + importe  );
		  sb.append(", fecha :" + fecha);
		  sb.append(", pagado :" + pagado);
		  return "{"+sb+"}";
	}

	public Boolean pagar() {
		return pagado = true;
	}
}
