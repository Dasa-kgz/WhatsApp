package service.impl;

import enums.Status;
import service.ProfileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfileServiceImpl implements ProfileService {
    private List<Profile>profiles=new ArrayList<>();
    private static int id;
    private static int groupID;
    @Override
    public Profile installWhatsApp() {
        Profile profile=new Profile();
        profile.setId(++id);
        try{
            System.out.println("Enter phone number: ");
            String phoneNumber=new Scanner(System.in).nextLine();
            if (phoneNumber.isBlank()){
                throw new MyExceptions("Phone number can't be empty");
            }
            boolean isSamePhoneNumber=true;
            if (!profiles.isEmpty()){
                for (Profile p:profiles){
                    if (!p.getPhoneNumber().equals(phoneNumber)){
                        profile.setPhoneNumber(phoneNumber);
                        isSamePhoneNumber=false;
                    }else {
                        isSamePhoneNumber=true;
                    }
                }
                if (isSamePhoneNumber){
                    throw new MyExceptions("Whatsapp is already installed on this number!")
                }
            }else {
                profile.setPhoneNumber(phoneNumber);
            }
            System.out.println("Enter user name: ");
            String userName=new Scanner(System.in).nextLine();
            boolean isSameUserName=false;
            if (!profiles.isEmpty()){
                for (Profile p: profiles){
                    if (!p.getUserName().equals(userName)){
                        profile.setUserName(userName);
                        profile.setImage("DEFAULT IMAGE");
                        profile.setStatus(String.valueOf(Status.HELLO_I_USE_WHATSAPP));
                        profile.setContacts(new ArrayList<>());
                        profile.setMessages(new ArrayList<>());
                        System.out.println("Enter password");
                        String password=new Scanner(System.in).nextLine();
                        isSameUserName=false;
                        if (password.length()<7){
                            throw new MyExceptions("7 символдон аз жазылбасын");
                        }else {
                            profile.setPassword(password);
                            profile.add(profiles);
                            System.out.println("You succesfully installed WhatsApp!");
                            return profile;
                        }
                    }else {
                        isSameUserName=true;
                    }
                }

            }else {
                profile.setUserName(userName);
                profile.setImage("DEFAULT IMAGE");
                profile.setStatus(String.valueOf(Status.HELLO_I_USE_WHATSAPP));
                profile.setContacts(new ArrayList<>());
                profile.setMessages(new ArrayList<>());
            }
        } catch (MyExceptions e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Profile goToProfile() {
        return null;
    }

    @Override
    public List<Status> getAllWhatsAppStatus() {
        return null;
    }

    @Override
    public String changeWhatsAppStatus() {
        return null;
    }

    @Override
    public String addContact() {
        for (Profile profile:profiles){
            profile.add
        }
        return null;
    }

    @Override
    public String changeProfilePhoto() {
        return null;
    }

    @Override
    public String sendMessage() {
        Profile profile1;
        try{
            System.out.println("Enter user name: ");
            String userName=new Scanner(System.in).nextLine();
            System.out.println("Enter password");
            String password=new Scanner(System.in).nextLine();
            boolean isTrue=true;
            if (profiles.isEmpty())
        }
    }

    @Override
    public void deleteWhatsApp() {

    }
}
