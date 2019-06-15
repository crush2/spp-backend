package com.example.spp_backend.service;

public interface MailService {
    void sendEmail(String to, String subject, String content);
}
