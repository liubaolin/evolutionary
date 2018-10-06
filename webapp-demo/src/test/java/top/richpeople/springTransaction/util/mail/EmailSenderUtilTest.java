package top.richpeople.springTransaction.util.mail;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

public class EmailSenderUtilTest {

    ApplicationContext ctx = null;


    @Before
    public void setUp() {
        System.out.println("setUp");
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public void tearDown() {
        System.out.println("tearDown");
        ctx = null;
    }

    /**
     * 发送一封简单的邮件
     */
    @Test
    public void testSendMail() {
        EmailSenderUtil emailService = (EmailSenderUtil) ctx.getBean("emailSenderUtil");
        emailService.sendRichEmail("xxx@gmail.com", "hello workd");
    }


    /**
     * 发送带附件的邮件
     */
    @Test
    public void testSendMultipartEmail() {
        EmailSenderUtil emailService = (EmailSenderUtil) ctx.getBean("emailSenderUtil");
        FileSystemResource fileSystemResource = new FileSystemResource("/home/richey/图片/tree.jpg");

        EmailSummaryInfo emailSummaryInfo = new EmailSummaryInfo();
        emailSummaryInfo.setTo("xxx.xxx@gmail.com");
        emailSummaryInfo.setSubject("a velocity email");

        Map<String, InputStreamSource> attachmentMap = new HashMap<String, InputStreamSource>();
        attachmentMap.put("tree.jpg", fileSystemResource);
        emailService.sendAttachmentEmail(emailSummaryInfo,
                "这是一封带附件的邮件",
                attachmentMap);
    }


    /**
     * 测试发送富文本邮件
     */
    @Test
    public void testSendRichTextEmail() {
        EmailSenderUtil emailService = (EmailSenderUtil) ctx.getBean("emailSenderUtil");
        FileSystemResource resource = new FileSystemResource("/home/richey/图片/tree.jpg");
        String htmlText = "<html>\n" +
                "<body>\n" +
                "    <img src='cid:treeLogo'>\n" +
                "    <h4>这是邮件logo</h4>\n" +
                "    <i>黑夜给了我黑色的眼睛</i>\n" +
                "</body>\n" +
                "</html>";
        Map<String, Resource> cidResourceMap = new HashMap<>();
        cidResourceMap.put("treeLogo", resource);

        EmailSummaryInfo emailSummaryInfo = new EmailSummaryInfo();
        emailSummaryInfo.setTo("xx.xxx@gmail.com");
        emailSummaryInfo.setSubject("a velocity email");
        try {
            emailService.sendRichEmail(emailSummaryInfo, htmlText, cidResourceMap);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testSendEmailByVelocity() {
        EmailSenderUtil emailService = (EmailSenderUtil) ctx.getBean("emailSenderUtil");
        FileSystemResource resource = new FileSystemResource("/home/richey/图片/tree.jpg");
        Map<String, Resource> cidResourceMap = new HashMap<>();
        cidResourceMap.put("treeLogo", resource);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("logoTitle", "这是图片Logo");
        model.put("content", "这是邮件的内容");

        EmailSummaryInfo emailSummaryInfo = new EmailSummaryInfo();
        emailSummaryInfo.setTo("xx.xxx@gmail.com");
        emailSummaryInfo.setSubject("a velocity email");

        try {
            emailService.sendVelocityEmail(emailSummaryInfo,
                    model, "/emailTemplate/DemoEmailTemplate.vm",
                    cidResourceMap);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSendAttachmentVelocityEmail() {
        EmailSenderUtil emailService = (EmailSenderUtil) ctx.getBean("emailSenderUtil");

        EmailSummaryInfo emailSummaryInfo = new EmailSummaryInfo();
        emailSummaryInfo.setTo("xx.xx@gmail.com");
        emailSummaryInfo.setSubject("a velocity email");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("logoTitle", "这是图片Logo");
        model.put("content", "这是邮件的内容");

        FileSystemResource resource = new FileSystemResource("/home/richey/图片/tree.jpg");
        Map<String, Resource> cidResourceMap = new HashMap<>();
        cidResourceMap.put("treeLogo", resource);

        FileSystemResource fileSystemResource = new FileSystemResource("/home/richey/图片/tree.jpg");

        Map<String, InputStreamSource> attachmentMap = new HashMap<String, InputStreamSource>();
        attachmentMap.put("tree.jpg", fileSystemResource);

        try {
            emailService.sendAttachmentVelocityEmail(emailSummaryInfo,model,cidResourceMap,attachmentMap);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
