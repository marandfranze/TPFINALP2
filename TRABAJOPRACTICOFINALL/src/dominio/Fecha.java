package dominio;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Fecha {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		  sb.append(" dia : " + dia  );
		  sb.append(", mes :" + mes);
		  sb.append(", anio :" + anio);
		  return "{"+sb+"}";
	}

	Integer dia;
	Integer mes;
	Integer anio;

	public Fecha(Integer dia, Integer mes, Integer anio)  {
		if( (dia>0 && dia<32) && (mes>0 && mes<13) && (anio>1920 && anio<2200) ) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		}
		else {
			throw new RuntimeException("Ingrese una fecha valida");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Fecha))
			return false;
		Fecha other = (Fecha) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		return true;
	}

	public String obtenerFecha() {
		StringBuilder str = new StringBuilder();
		str.append(dia);
		str.append("/");
		str.append(mes);
		str.append("/");
		str.append(anio);

		return str.toString();
	}

	public static Fecha hoy()  {
		LocalDate fechaAux = LocalDate.now();
		return new Fecha(fechaAux.getDayOfMonth(), fechaAux.getMonthValue(), fechaAux.getYear());
	}
	
	// lo que hace esto es el this que es la fecha inicial
	// le resta a la fecha alta que es fecha, en breve entonces vas a hacer
	// fechaInicial >= fechaAlta
	public boolean esMayorIgual(Fecha fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder fechaInicialStr = new StringBuilder();
		fechaInicialStr.append(this.anio);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.mes);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.dia);

		StringBuilder fechaFinalStr = new StringBuilder();
		fechaFinalStr.append(fecha.anio);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.mes);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.dia);
		Date fechaInicial = new Date();
		Date fechaFinal = new Date();

		try {
			fechaInicial = dateFormat.parse(fechaInicialStr.toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fechaFinal = dateFormat.parse(fechaFinalStr.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
		if (dias >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @descripcion this seria tu fecha inicial entonces los dias es fechaFinal -
	 * fechaInicial= diferencia
	 */
	public int obtenerDias(Fecha fecha)  {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder fechaInicialStr = new StringBuilder();
		fechaInicialStr.append(this.anio);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.mes);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.dia);

		StringBuilder fechaFinalStr = new StringBuilder();
		fechaFinalStr.append(fecha.anio);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.mes);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.dia);
		Date fechaInicial = new Date();
		Date fechaFinal = new Date();

		try {
			fechaInicial = dateFormat.parse(fechaInicialStr.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fechaFinal = dateFormat.parse(fechaFinalStr.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
		return dias;
	}
	
	public boolean esMenorIgual(Fecha fecha)  {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  StringBuilder fechaInicialStr = new StringBuilder();
		  fechaInicialStr.append(this.anio);
		  fechaInicialStr.append("-");
		  fechaInicialStr.append(this.mes);
		  fechaInicialStr.append("-");
		  fechaInicialStr.append(this.dia);

		  StringBuilder fechaFinalStr = new StringBuilder();
		  fechaFinalStr.append(fecha.anio);
		  fechaFinalStr.append("-");
		  fechaFinalStr.append(fecha.mes);
		  fechaFinalStr.append("-");
		  fechaFinalStr.append(fecha.dia);
		  Date fechaInicial = new Date();
		  Date fechaFinal = new Date();

		  try {
			fechaInicial = dateFormat.parse(fechaInicialStr.toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			fechaFinal = dateFormat.parse(fechaFinalStr.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
		  if (dias <= 0) {
		   return true;
		  } else {
		   return false;
		  }
		 }

	public static void main(String[] args)  {
	//	Fecha nueva = new Fecha(10, 02, 2020);
		//Fecha nueva2 = new Fecha(10,02,2019);

	/*	if (nueva.getClass().getSimpleName().equals("Fecha")) {
			System.out.println(nueva.getClass().getSimpleName());
		}*/
	//	System.out.println(nueva2.obtenerDias(nueva));
		/*System.out.println(nueva.esMenorIgual(nueva2));
		System.out.println(nueva.esMayorIgual(nueva2));
*/
	}
}
