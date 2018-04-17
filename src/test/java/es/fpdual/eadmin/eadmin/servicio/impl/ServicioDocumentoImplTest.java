package es.fpdual.eadmin.eadmin.servicio.impl;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

public class ServicioDocumentoImplTest {

	private ServicioDocumentoImpl servicioDocumento;

	private static final Documento DOCUMENTO = mock(Documento.class);

	private final RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);

	@Before
	public void inicializarEnCadaTest() {

		this.servicioDocumento = spy(new ServicioDocumentoImpl(repositorioDocumento));
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {

		final Documento documentoModificado = mock(Documento.class);

		doReturn(documentoModificado).when(this.servicioDocumento).obtenerDocumentoConFechaCreacionCorrecta(DOCUMENTO);

		this.servicioDocumento.altaDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).altaDocumento(documentoModificado);

	}

	@Test
	public void deberiaModificarDocumento() {

		final Documento documentoModificado = mock(Documento.class);

		doReturn(documentoModificado).when(this.servicioDocumento)
				.obtenerDocumentoConFechaUltimaActualizacionCorrecta(DOCUMENTO);

		this.servicioDocumento.modificarDocumento(DOCUMENTO, documentoModificado);

		verify(this.repositorioDocumento).modificarDocumento(documentoModificado, DOCUMENTO.getCodigo());

	}

	@Test
	public void deberiaEliminarDocumento() {

		when(DOCUMENTO.getCodigo()).thenReturn(1);

		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());

		verify(this.repositorioDocumento).eliminarDocumento(1);
	}

}
