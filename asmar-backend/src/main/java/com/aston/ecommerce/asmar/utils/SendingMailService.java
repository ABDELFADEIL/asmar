package com.aston.ecommerce.asmar.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@Component
public class SendingMailService {


    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    public SimpleMailMessage template;

    @Value("${email.exp}")
    private String email;

    public void sendSimpleMessage(String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(email);
        mailSender.setPassword("beel123ok");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "This is the test email template for your email:\n%s\n");
        return message;
    }

    //  @Override
    public void sendMessageWithAttachment( String from, String to, String subject, String text, String pathToAttachment) {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            FileSystemResource file
                    = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }


    public void sendVerificationMail( String to, String text) {
        String subject = "Please verify your email";
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(email);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }

    public void sendingMail( String to, String text) {
        String subject = "Please verify your email";
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(email);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SendingMailService{" +
                "emailSender=" + emailSender +
                ", template=" + template +
                ", email='" + email + '\'' +
                '}';
    }
}
