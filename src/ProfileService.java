import java.util.List;

public interface ProfileService {
    Profile installWhatsApp();

    Profile goToProfile();

    List<Status> getAllWhatsApp();

    String changWhatsappStatus();

    String addContact();

    String changeProfilePhoto();

    String sendMessage();

    void deleteWhatsApp();
}
