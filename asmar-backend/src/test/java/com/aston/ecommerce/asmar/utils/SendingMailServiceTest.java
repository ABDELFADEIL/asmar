package com.aston.ecommerce.asmar.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SendingMailService.class})
@ExtendWith(SpringExtension.class)
class SendingMailServiceTest {
    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private SendingMailService sendingMailService;

    @MockBean
    private SimpleMailMessage simpleMailMessage;

    @Test
    void testSendSimpleMessage() throws MailException {
        doNothing().when(this.javaMailSender).send((SimpleMailMessage) any());
        this.sendingMailService.sendSimpleMessage("jane.doe@example.org", "alice.liddell@example.org",
                "Hello from the Dreaming Spires", "Text");
        verify(this.javaMailSender).send((SimpleMailMessage) any());
    }

    @Test
    void testGetJavaMailSender() {
        assertEquals("dadeil.dev1@gmail.com",
                ((JavaMailSenderImpl) this.sendingMailService.getJavaMailSender()).getUsername());
        assertTrue(((JavaMailSenderImpl) this.sendingMailService.getJavaMailSender())
                .getDefaultFileTypeMap() instanceof org.springframework.mail.javamail.ConfigurableMimeFileTypeMap);
        assertEquals(4, ((JavaMailSenderImpl) this.sendingMailService.getJavaMailSender()).getJavaMailProperties().size());
        assertEquals("beel123ok", ((JavaMailSenderImpl) this.sendingMailService.getJavaMailSender()).getPassword());
        assertEquals("smtp.gmail.com", ((JavaMailSenderImpl) this.sendingMailService.getJavaMailSender()).getHost());
        assertEquals(587, ((JavaMailSenderImpl) this.sendingMailService.getJavaMailSender()).getPort());
    }

    @Test
    void testTemplateSimpleMessage() {
        assertEquals("This is the test email template for your email:\n%s\n",
                this.sendingMailService.templateSimpleMessage().getText());
    }

    @Test
    void testSendMessageWithAttachment() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.sendingMailService.sendMessageWithAttachment("jane.doe@example.org", "alice.liddell@example.org",
                "Hello from the Dreaming Spires", "Text", "Path To Attachment");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    @Test
    void testSendMessageWithAttachment2() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.sendingMailService.sendMessageWithAttachment("", "alice.liddell@example.org", "Hello from the Dreaming Spires",
                "Text", "Path To Attachment");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    @Test
    void testSendMessageWithAttachment3() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.sendingMailService.sendMessageWithAttachment("jane.doe@example.org", "", "Hello from the Dreaming Spires",
                "Text", "Path To Attachment");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    @Test
    void testSendVerificationMail() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.sendingMailService.sendVerificationMail("alice.liddell@example.org", "Text");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    @Test
    void testSendVerificationMail2() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.sendingMailService.sendVerificationMail("Please verify your email", "Text");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    @Test
    void testSendingMail() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.sendingMailService.sendingMail("alice.liddell@example.org", "Text");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }

    @Test
    void testSendingMail2() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.sendingMailService.sendingMail("Please verify your email", "Text");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }
}

