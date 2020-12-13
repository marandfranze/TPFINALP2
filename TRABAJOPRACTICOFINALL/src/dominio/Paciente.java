package dominio;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public abstract class Paciente {
	protected int nroHistoriaClinica;
	protected Fecha nacimiento;
	protected String nombre;
	protected double saldo;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Paciente))
			return false;
		Paciente other = (Paciente) obj;
		if (nacimiento == null) {
			if (other.nacimiento != null)
				return false;
		} else if (!nacimiento.equals(other.nacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nroHistoriaClinica != other.nroHistoriaClinica)
			return false;
		return true;
	}

	public Paciente(String nombre, Integer nroHistoriaClinica, Fecha nacimiento)  {
		try {
			Validaciones.validarNumeroPositivo(nroHistoriaClinica);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Validaciones.validarLenghtString(nombre, 50, "Ingrese un nombre de paciente entre 0 y 50");
		
		this.nroHistoriaClinica = nroHistoriaClinica;
		this.nacimiento = nacimiento;
		this.nombre = nombre;
		this.saldo = 0.0;

	}

	public Integer obtenerNroHistoriaClinica() {
		return nroHistoriaClinica;
	}

	public Fecha obtenerFechaNacimiento() {
		return nacimiento;
	}

	public Integer obtenerEdad()  {
		return nacimiento.obtenerDias(Fecha.hoy()) / 365;
	}

	public double obtenerSaldo() {
		return saldo;
	}
	
	protected void modficarSaldo(double saldo)  {
		try {
			Validaciones.validarPrecio(saldo, 1000000.0, "El saldo debe estar entre 0 y 1000000");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.saldo=saldo;
	}

	public abstract void pagarSaldo() ;

	
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			  sb.append(" nombre :" + nombre );
			  sb.append(", nroHistoriaClinica :" + nroHistoriaClinica);
			  return "{"+sb+"}";
			
	
	}

	
}
