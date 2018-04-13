package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	private Documento documento;
	private Documento documentoModificado;

	@Before
	public void inicializarCadaTest() {
		documento = new Documento(1, "Documento 1", new Date(), new Date(), true, EstadoDocumento.ACTIVO);
		documentoModificado = new Documento(1, "Documento Modificado", new Date(), new Date(), true,
				EstadoDocumento.ACTIVO);
	}

	@Autowired
	private DocumentoMapper mapper;

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		final int resultado = this.mapper.insertarDocumento(this.documento);
		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaModificarUnDocumento() throws Exception {
		this.mapper.insertarDocumento(this.documento);
		final int resultado = this.mapper.modificarDocumento(this.documentoModificado, this.documento.getCodigo());
		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaBorrarUnDocumento() throws Exception {
		this.mapper.insertarDocumento(this.documento);
		final int resultado = this.mapper.borrarDocumento(this.documento.getCodigo());
		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaConsultarUnDocumento() throws Exception {
		this.mapper.insertarDocumento(this.documento);
		final int resultado = this.mapper.consultarDocumento(this.documento);
		assertThat(resultado, is(1));
	}
}
