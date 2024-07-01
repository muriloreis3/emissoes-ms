package com.emissor_ms.core.service.impl;

import com.emissor_ms.core.service.EmailService;
import com.emissor_ms.core.service.EmissaoService;
import com.emissor_ms.core.service.PropostaService;
import com.emissor_ms.rest.dto.CartaoRequestDTO;
import com.emissor_ms.rest.dto.CartaoResponseDTO;
import com.emissor_ms.rest.dto.PropostaDTO;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmissaoServiceImpl implements EmissaoService {

    @Value("${email.banco}")
    private String emailBanco;

    @Autowired
    private PropostaService propostaService;

    @Autowired
    private EmailService emailService;

    @Override
    public void enviarProposta(PropostaDTO proposta) throws TemplateException, MessagingException, IOException {
        propostaService.gravarProposta(proposta);
        enviarCartao(proposta);
    }

    private void enviarCartao(PropostaDTO proposta) throws TemplateException, MessagingException, IOException {
        enviarEmailCartao(emitirCartao(
                CartaoRequestDTO.builder()
                        .conta(proposta.getConta())
                        .limite(proposta.getLimite())
                        .build()
        ));
    }

    private CartaoResponseDTO emitirCartao(CartaoRequestDTO proposta) {
        String uri = "http://localhost:8080/cartoes";
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForEntity(uri, proposta, CartaoResponseDTO.class).getBody();
    }

    private void enviarEmailCartao(CartaoResponseDTO dadosCartao) throws TemplateException, MessagingException, IOException {
        String emailBanco = "";
        Map<String, Object> infoCartao = new HashMap<>();
        infoCartao.put("nomeCliente", dadosCartao.getNomeCliente());
        infoCartao.put("numero", dadosCartao.getNumero());
        infoCartao.put("emissao", dadosCartao.getEmissao());
        infoCartao.put("vencimento", dadosCartao.getVencimento());
        infoCartao.put("cvv", dadosCartao.getCvv());

        emailService.sendMessageUsingFreemarkerTemplate(emailBanco, dadosCartao.getEmailCliente(), "emailCartao.ftl", infoCartao);
    }
}
