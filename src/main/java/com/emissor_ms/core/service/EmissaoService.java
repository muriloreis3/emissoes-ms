package com.emissor_ms.core.service;

import com.emissor_ms.rest.dto.PropostaDTO;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface EmissaoService {
    public void enviarProposta(PropostaDTO proposta) throws TemplateException, MessagingException, IOException;
}
