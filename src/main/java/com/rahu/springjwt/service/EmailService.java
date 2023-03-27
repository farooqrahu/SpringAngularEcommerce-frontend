//package com.rahu.springjwt.service;
//
//import com.rahu.springjwt.dto.MailDto;
//import com.rahu.springjwt.exception.InvalidEmailException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//
//@Service
//public class EmailService {
//
////    @Autowired
////    private JavaMailSender emailSender;
//
////    @Autowired
////    private SpringTemplateEngine templateEngine;
//
//    @Value("${email.to}")
//    private String fromEmail;
//
//
//    /**
//     * the following method is used to send email
//     *
//     * @param mail
//     * @param templatePath
//     */
//    public void sendEmail(MailDto mail, String templatePath)  {
//        try {
//            MimeMessage message = emailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                    StandardCharsets.UTF_8.name());
//            Context context = new Context();
//            context.setVariables(mail.getModel());
//            String html = templateEngine.process(templatePath, context);
//
//            helper.setFrom(fromEmail);
//            helper.setTo(mail.getTo());
//            helper.setText(html, true);
//            helper.setSubject(mail.getSubject());
//
//            emailSender.send(message);
//        } catch (Exception e) {
//            throw new InvalidEmailException(201, e.getCause().getMessage());
//        }
//    }
//
//    /**
//     * @param mail
//     * @param html
//     * @param file
//     */
//    public void sendEmailWithAttachment(MailDto mail, String html, File file, String fileName) {
//        try {
//            MimeMessage message = emailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                    StandardCharsets.UTF_8.name());
//            Context context = new Context();
//            context.setVariables(mail.getModel());
//
//            helper.setFrom(fromEmail);
//            helper.setTo(mail.getTo());
//            helper.setText(html, true);
//            helper.setSubject(mail.getSubject());
//            helper.addAttachment(fileName, file);
//
//            emailSender.send(message);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * @param mail
//     * @param html
//     */
//    public void sendEmailWithPlainStringMessage(MailDto mail, String html) {
//        try {
//            MimeMessage message = emailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                    StandardCharsets.UTF_8.name());
//            Context context = new Context();
//            context.setVariables(mail.getModel());
//
//            helper.setFrom(fromEmail);
//            helper.setTo(mail.getTo());
//            helper.setText(html, true);
//            helper.setSubject(mail.getSubject());
//
//            emailSender.send(message);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}
