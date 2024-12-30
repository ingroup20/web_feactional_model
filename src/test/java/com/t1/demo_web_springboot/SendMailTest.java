package com.t1.demo_web_springboot;

import com.t1.demo_web_springboot.mail.JavaMailService;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class SendMailTest {

    @Autowired
    JavaMailService javaMailService;//真實寄出

    @Test
    public void sendMailTest_orderSendFrom() {
        String sendTo = "chuckwang@gateweb.com.tw";
        String sendFrom = "chuckwang@gateweb.com.tw";
//        javaMailService = mock(JavaMailService.class);//模擬寄出
//        verify(javaMailService, times(1)).sendMail(sendTo, sendFrom, "orderSendFrom");
        assertDoesNotThrow(() -> {
            javaMailService.sendMail(sendTo, sendFrom, "orderSendFrom");
        });
        assertThrows(RuntimeException.class,() -> { //改拋出RuntimeException
            javaMailService.sendMail(sendTo,"@", "orderSendFrom-goto default");//此封不會寄出，地址錯誤
        });

    }

    @Test
    public void sendMailTest_defaultSendFrom() {
        String sendTo = "chuckwang@gateweb.com.tw";
//        javaMailService = mock(JavaMailService.class); //模擬寄出
//        verify(javaMailService, times(1)).sendMail(sendTo,"defaultSendFrom");
        assertDoesNotThrow(() -> {
            javaMailService.sendMail(sendTo, "defaultSendFrom");
        });
        assertThrows(RuntimeException.class,() -> {
            javaMailService.sendMail("@", "defaultSendFrom");//此封不會寄出，地址錯誤
        });

        try {
            Thread.sleep(5000); // 暫停 5 秒，等待郵件發送完成
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
