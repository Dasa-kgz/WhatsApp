package service;

import enums.Status;

import java.util.List;

public interface ProfileService {
    Profile installWhatsApp();
    Profile goToProfile();
    List<Status> getAllWhatsAppStatus();
    String changeWhatsAppStatus();
    String addContact();
    String changeProfilePhoto();
    String sendMessage();
    void deleteWhatsApp();



}
