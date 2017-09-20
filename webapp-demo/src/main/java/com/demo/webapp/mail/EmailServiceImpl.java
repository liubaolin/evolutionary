package com.demo.webapp.mail;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * DESCRIPTION: 邮件发送的服务类
 *
 * @author richey
 */
@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    /**
     * 发一封简单的邮件
s     * @param to
     * @param text 文本格式的邮件内容
     */
    public void sendRichEmail(String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(javaMailSender.getUsername());
        message.setTo(to);
        message.setSubject("a simple mail");
        message.setText(text);       //设置信息文本
        javaMailSender.send(message);
    }

    /**
     * 发送带附件的邮件
     * @param text   文本格式的邮件内容
     */
    public void sendAttachmentEmail(EmailSummaryInfo emailSummaryInfo, String text, Map<String,InputStreamSource> attachementMap) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true 表明这个信息是multipart类型的
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(javaMailSender.getUsername());
            helper.setTo(emailSummaryInfo.getTo());
            helper.setSubject(emailSummaryInfo.getSubject());
            helper.setText(text);
            for (Map.Entry<String, InputStreamSource> entry : attachementMap.entrySet()) {
                helper.addAttachment(entry.getKey(),entry.getValue());
            }
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送富文本邮件
     * @param htmlText  HTML格式的邮件内容
     * @param cidResourceMap cid和Resource 对应 html模板中的嵌入式信息的key和Resource （可为空）
     */
    public void sendRichEmail(EmailSummaryInfo emailSummaryInfo, String htmlText, Map<String,Resource> cidResourceMap) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        //true 表明这个信息是multipart类型的
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(javaMailSender.getUsername());
        helper.setTo(emailSummaryInfo.getTo());
        helper.setSubject(emailSummaryInfo.getSubject());
        //将文本信息设置为HTML
        helper.setText(htmlText,true);
        for (Map.Entry<String, Resource> entry : cidResourceMap.entrySet()) {
            helper.addInline(entry.getKey(), entry.getValue());
        }
        javaMailSender.send(message);
    }


    /**
     * 发送带附件的富文本邮件
     * @param emailSummaryInfo
     * @param htmlText
     * @param cidResourceMap
     * @param attachementMap
     * @throws MessagingException
     */
    public void sendRichAttachmentEmail(EmailSummaryInfo emailSummaryInfo,
                                        String htmlText,
                                        Map<String, Resource> cidResourceMap,
                                        Map<String, InputStreamSource> attachementMap) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        //true 表明这个信息是multipart类型的
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(javaMailSender.getUsername());
        helper.setTo(emailSummaryInfo.getTo());
        helper.setSubject(emailSummaryInfo.getSubject());
        //将文本信息设置为HTML
        helper.setText(htmlText,true);
        for (Map.Entry<String, Resource> entry : cidResourceMap.entrySet()) {
            helper.addInline(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, InputStreamSource> entry : attachementMap.entrySet()) {
            helper.addAttachment(entry.getKey(),entry.getValue());
        }
        javaMailSender.send(message);
    }

    /**
     * 根据Velocity模板发送邮件
     * @param templateModel  velocity模板中的key对应的值
     * @param cidResourceMap   cid和Resource 对应 html模板中的嵌入式信息的key和Resource
     * @throws MessagingException
     */
    public void sendVelocityEmail(EmailSummaryInfo emailSummaryInfo,
                                  Map<String, Object> templateModel,
                                  String templatePath,
                                  Map<String,Resource> cidResourceMap ) throws MessagingException {
        String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templatePath,"utf-8", templateModel);
        sendRichEmail(emailSummaryInfo, emailText,cidResourceMap);
    }


    /**
     * 根据Velocity模板发送带附件的邮件
     * @param emailSummaryInfo
     * @param templateModel
     * @param cidResourceMap
     * @param attachementMap
     */
    public void sendAttachmentVelocityEmail(EmailSummaryInfo emailSummaryInfo,
                                  Map<String, Object> templateModel,
                                  Map<String, Resource> cidResourceMap,
                                  Map<String,InputStreamSource> attachementMap) throws MessagingException {
        String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/emailTemplate/DemoEmailTemplate.vm","utf-8", templateModel);
        sendRichAttachmentEmail(emailSummaryInfo, emailText, cidResourceMap, attachementMap);
    }

}
