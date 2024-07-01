package com.emissor_ms.core.service.impl;

import com.emissor_ms.core.mapper.PropostaMapping;
import com.emissor_ms.core.repository.PropostaRepository;
import com.emissor_ms.core.service.PropostaService;
import com.emissor_ms.rest.dto.PropostaDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class PropostaServiceImpl implements PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private PropostaMapping propostaMapping;

    @Override
    public void gravarProposta(PropostaDTO proposta) {
        propostaRepository.save(propostaMapping.dtoToEntity(proposta));
    }
}
