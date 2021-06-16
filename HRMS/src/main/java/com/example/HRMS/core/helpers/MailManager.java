package com.example.HRMS.core.helpers;

public class MailManager implements MailService{

    @Override
    public void send(String mail) {
        System.out.println("Mail gonderildi(degistirilecek)" + mail);
    }
}
