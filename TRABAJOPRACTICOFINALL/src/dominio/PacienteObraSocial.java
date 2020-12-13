package dominio;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacienteObraSocial extends Paciente {
	private String obraSocial;
	private double descuento;
	private LinkedList<Internacion> internaciones;

	public PacienteObraSocial(String nombre, Integer nroHistoriaClinica, Fecha nacimiento, String obraSocial,
			double descuento)  {
		super(nombre, nroHistoriaClinica, nacimiento);
		
		Validaciones.validarLenghtString(obraSocial, 50, "La obra social debe estar entre 0 y 50 caracteres");
		try {
			Validaciones.validarPorcentaje(descuento, "El descuento debe estar entre 0 y 100 %");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.obraSocial = obraSocial;
		this.descuento = descuento;
		internaciones = new LinkedList<Internacion>();
	}

	public String obtenerObraSocial() {
		return this.obraSocial;
	}

	// o(n)
	private boolean contieneFechaIngreso(Fecha fechaIngreso) {
		boolean alguno = false;
		for (Internacion internacion : internaciones) {
			alguno = alguno || (internacion.fecha.equals(fechaIngreso));
		}
		return alguno;
	}

	// o(1)
	public boolean hayInternacionActiva() {
		if(internaciones.isEmpty()) {
			return false;
		}
		return internaciones.getLast().obtenerFechaAlta() == null;
	}

	public boolean agregarInternacion(String area, Fecha fechaIngreso, double importe, Integer nroHabitacion)  {
			if (!contieneFechaIngreso(fechaIngreso) && !hayInternacionActiva()) {
				area=area.toUpperCase();
				if (area.equals("CARDIOLOGIA") || area.equals("GENERAL") || area.equals("PEDIATRIA")) {
					Internacion internacion = new Internacion(importe, fechaIngreso, obraSocial, area, descuento,
							nroHabitacion);
					internaciones.addLast(internacion);
					return true;
				}
			}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		  sb.append(" obraSocial :" + obraSocial );
		  sb.append(" descuento :" + descuento );
		  sb.append(" internaciones :" + internaciones );
		  return "{"+sb+"}";
		
}


	public int darAlta(Fecha fechaAlta)  {
		if (!internaciones.isEmpty()) {
			Internacion ultimaInternacion = internaciones.getLast();
			if (hayInternacionActiva() && ultimaInternacion.obtenerFechaIngreso().esMayorIgual(fechaAlta)) {
				try {
					ultimaInternacion.agregarFechaAlta(fechaAlta);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// (porcentaje * fechaIngreso *costo diario)
				double costoAlta = descuento * ultimaInternacion.obtenerFechaIngreso().obtenerDias(fechaAlta)
						* ultimaInternacion.obtenerImporte();
				ultimaInternacion.agregarImporte(costoAlta);
				modficarSaldo(saldo + costoAlta);
			}
		}
		throw new RuntimeException("no se puede dar el alta");
	}

	public void pagarSaldo()  {
		if (!internaciones.isEmpty()) {
			for (Internacion internacion : internaciones) {
				if (internacion.obtenerFechaAlta() != null)
					internacion.pagar();
			}
			modficarSaldo(0.0);
		}
		else {
			throw new RuntimeException("No hay atenciones para pagar");
		}
	}

	// al pagar hay que dar el alta

}
