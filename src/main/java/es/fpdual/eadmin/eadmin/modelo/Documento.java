package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Documento extends ElementoBaseAdministracionElectronica {

	private final EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion, publico);

		this.estado = estado;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Documento con código " + codigo;
	}

	public String getDatos() {
		return "Documento con código" + this.getCodigo() + " Nombre:  " + this.getNombre() + " FechaCracion: "
				+ this.getFechaCreacion() + " FechaUltimaActualizacion: " + this.getFechaUltimaActualizacion()
				+ " Publico: " + this.getPublico() + ".";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ElementoBaseAdministracionElectronica) {
			EqualsBuilder equalsBuilder = new EqualsBuilder();
			
			return true;
		}
		return false;
	}
}
