import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProfileServiceImpl profileService=new ProfileServiceImpl();
        while (true){
            try{
                System.out.println("""
                        1-> Install Whatsapp
                        2-> Go to profile
                        3-> Get all whatsapp status
                        4-> Change profile photo
                        5-> Change whatsapp status
                        6-> Add contact
                        7-> Send message
                        8-> Delete whatsapp
                        """);
                int command=new Scanner(System.in).nextInt();
                switch (command){
                    case 1-> System.out.println(profileService.installWhatsApp());
                    case 2-> System.out.println(profileService.goToProfile());
                    case 3-> System.out.println(profileService.getAllWhatsApp());
                    case 4-> System.out.println(profileService.changeProfilePhoto());
                    case 5-> System.out.println(profileService.changWhatsappStatus());
                    case 6-> System.out.println(profileService.addContact());
                    case 7-> System.out.println(profileService.sendMessage());
                    case 8-> profileService.deleteWhatsApp();
                }
            }catch (InputMismatchException e){
                System.out.println("Write only numbers");
            }
        }
    }
}