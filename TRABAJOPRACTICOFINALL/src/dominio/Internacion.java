package dominio;

import java.text.ParseException;

public class Internacion extends Atencion {
	private String obraSocial;
	private String area;
	private Double descuento;
	private Integer nroHabitacion;
	private Fecha fechaAlta;

	public Internacion(Double importe, Fecha fecha, String obraSocial, String area, Double descuento,
			Integer nroHabitacion)  {

		super(importe, fecha);

		Validaciones.validarLenghtString(obraSocial, 50, "El la obra social debe ser mayor a 0 y menor a 50");
		Validaciones.validarLenghtString(area, 50, "El area debe ser mayor a 0 y menor a 50");
		Validaciones.validarPorcentaje(descuento, "El descuento debe estar entre 0 y 100");
		Validaciones.validarNumeroPositivo(nroHabitacion);

		this.obraSocial = obraSocial;
		this.area = area;
		this.descuento = descuento;
		this.nroHabitacion = nroHabitacion;
		this.fechaAlta = null;
	}

	public Fecha obtenerFechaAlta() {
		return fechaAlta;
	}

	public Fecha obtenerFechaIngreso() {
		return fecha;
	}

	public void agregarFechaAlta(Fecha fechaAlta) throws ParseException, Exception {
		if (fecha.esMayorIgual(fechaAlta)) {
			this.fechaAlta = fechaAlta;
		} else {
			throw new Exception("La fecha de alta debe ser mayor a la fecha de ingreso");
		}
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		  sb.append(" internacion,  obraSocial : " + obraSocial  );
		  sb.append(", area :" + area);
		  sb.append(", nroHabitacion :" + nroHabitacion);
		  sb.append(", fechaAlta :" + fechaAlta);
		  return "{"+sb+"}";
	}

	public double obtenerImporte() {
		return importe;
	}

}
