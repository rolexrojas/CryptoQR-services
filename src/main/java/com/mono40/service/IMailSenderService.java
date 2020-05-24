package com.mono40.service;

import com.mono40.domain.Account;
import com.mono40.util.PasswordStorage;
//import freemarker.template.TemplateException;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yinfante on 2/21/18.
 */
public interface IMailSenderService {
   /* @Async
    void sendEmail(String to, String content, String subject, boolean isHtml);

    @Async
    void sendEmailFromTemplate(Map model, String to, String template, String titleKey) throws IOException, TemplateException;

    *//*@Async
    void sendWelcomeEmail(Account account) throws IOException, TemplateException;
*//*
    @Async
    void sendBlockUserEmail(Account account, String otp) throws PasswordStorage.CannotPerformOperationException, IOException, TemplateException;

*//*
    @Async
    void sendForgotPasswordEmail(Account account, String otp) throws PasswordStorage.CannotPerformOperationException, IOException, TemplateException;

    @Async
    void sendConfirmationEmailCode(String email, String code) throws IOException, TemplateException;
*//*
*//*

    @Async
    void sendPaymentNotification(String firstName, String lastName, String amount,
                                 String currency, String accountNumber, String merchantDescription,
                                 String transactionDate, String sessionId, String recipient) throws IOException, TemplateException;
*//*
*/
}
