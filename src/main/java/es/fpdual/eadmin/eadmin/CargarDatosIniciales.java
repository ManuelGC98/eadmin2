package es.fpdual.eadmin.eadmin;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

@Component
public class CargarDatosIniciales implements ApplicationRunner {

	private final RepositorioDocumento repositorioDocumento;

	private static final Date fecha = new Date();

	@Autowired
	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento,
			RepositorioExpediente repositorioExpediente) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Documento doc1 = new Documento(1, "documento1", fecha, fecha, true, EstadoDocumento.ACTIVO);
		Documento doc2 = new Documento(2, "documento2", fecha, fecha, false, EstadoDocumento.ACTIVO);
		Documento doc3 = new Documento(3, "documento3", fecha, fecha, true, EstadoDocumento.ACTIVO);
		Documento doc4 = new Documento(4, "documento4", fecha, fecha, true, EstadoDocumento.ACTIVO);
		Documento doc5 = new Documento(5, "documento5", fecha, fecha, true, EstadoDocumento.ACTIVO);

		Documento doc2Modificado = new Documento(2, "documento2", fecha, fecha, true, EstadoDocumento.ACTIVO);
		Documento doc4Modificado = new Documento(4, "documento4", fecha, fecha, false, EstadoDocumento.ACTIVO);

		repositorioDocumento.altaDocumento(doc1);
		repositorioDocumento.altaDocumento(doc2);
		repositorioDocumento.altaDocumento(doc3);
		repositorioDocumento.altaDocumento(doc4);
		repositorioDocumento.altaDocumento(doc5);
		repositorioDocumento.obtenerTodosLosDocumentos();

		repositorioDocumento.modificarDocumento(doc2Modificado, doc2.getCodigo());
		repositorioDocumento.modificarDocumento(doc4Modificado, doc4.getCodigo());
		repositorioDocumento.obtenerTodosLosDocumentos();

		repositorioDocumento.eliminarDocumento(5);
		repositorioDocumento.obtenerTodosLosDocumentos();
	}
}
