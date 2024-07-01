package com.emissor_ms.core.service.impl;

import com.emissor_ms.core.service.EmailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private FreeMarkerConfigurer freemarkerConfigurer;

    private void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        emailSender.send(message);
    }

    @Override
    public void sendMessageUsingFreemarkerTemplate(String to, String subject, String template, Map<String, Object> templateModel)
        throws IOException, TemplateException, MessagingException {

        Template freemarkerTemplate = freemarkerConfigurer.getConfiguration().getTemplate(template);

        String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, templateModel);

        sendHtmlMessage(to, subject, htmlBody);
    }
}
