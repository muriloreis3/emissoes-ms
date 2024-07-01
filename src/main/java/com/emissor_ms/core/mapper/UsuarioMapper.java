package com.emissor_ms.core.mapper;

import com.emissor_ms.core.entity.UsuarioEntity;
import com.emissor_ms.rest.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    UsuarioEntity dtoToEntity(UsuarioDTO input);
}
