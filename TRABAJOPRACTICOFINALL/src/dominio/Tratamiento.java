package dominio;

public class Tratamiento {
	
	private String nombreTratamiento;
	private boolean Pagado;
	private Medico medico;
	
	public Tratamiento(String nombreTratamiento, Medico medico) {
		this.nombreTratamiento= nombreTratamiento;
		this.medico = medico;
		Pagado = false;
	}

	public boolean isPagado() {
		return Pagado;
	}

	public void setPagado(boolean pagado) {
		Pagado = pagado;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		  sb.append(" nombreTratamiento :" + nombreTratamiento );
		  sb.append(" Pagado :" + Pagado );
		  sb.append(" medico :" + medico );
		  return "{"+sb+"}";
		
}


}
