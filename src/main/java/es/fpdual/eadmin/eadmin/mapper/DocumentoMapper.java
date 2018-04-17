package es.fpdual.eadmin.eadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {

	int insertarDocumento(@Param("documento") Documento documento);

	int modificarDocumento(@Param("documento") Documento documento, @Param("codigo") Integer codigo);

	int borrarDocumento(@Param("codigo") Integer codigo);

	List<Documento> consultarDocumento(@Param("codigo") Integer codigo);

	List<Documento> consultarTodosLosDocumento();
}
