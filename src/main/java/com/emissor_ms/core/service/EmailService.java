package com.emissor_ms.core.service;

import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.Map;

public interface EmailService {
    void sendMessageUsingFreemarkerTemplate(String to, String subject, String template, Map<String, Object> templateModel)
        throws IOException, TemplateException, MessagingException;
}
