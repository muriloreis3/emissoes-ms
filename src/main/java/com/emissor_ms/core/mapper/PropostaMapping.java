package com.emissor_ms.core.mapper;

import com.emissor_ms.core.entity.PropostaEntity;
import com.emissor_ms.rest.dto.PropostaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PropostaMapping {
    PropostaEntity dtoToEntity(PropostaDTO proposta);
}
