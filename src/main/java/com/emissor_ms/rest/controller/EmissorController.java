package com.emissor_ms.rest.controller;

import com.emissor_ms.core.service.EmissaoService;
import com.emissor_ms.rest.dto.PropostaDTO;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/emissor")
public class EmissorController {
    @Autowired
    private EmissaoService emissaoService;

    @PostMapping("/emitirCartao")
    @ResponseStatus(HttpStatus.CREATED)
    public void emitirCartao(@RequestBody PropostaDTO proposta) {
        try {
            emissaoService.enviarProposta(proposta);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
