import java.util.*;

public class ProfileServiceImpl implements ProfileService {
    private List<Profile>profiles=new ArrayList<>();
    private static int id;
    private static int groupID;

    @Override
    public Profile installWhatsApp() {
       Profile profile=new Profile();
       profile.setId(++id);
       try{
           System.out.println("Атынды жаз:");
           String phoneNumber=new Scanner(System.in).nextLine();
           if (phoneNumber.isBlank()){
               throw new MyExceptions("Номер бош болбошу керек!");
           }
           boolean isSamePhoneNumber=true;
           if (!profiles.isEmpty()){
               for (Profile p: profiles){
                   if (!p.getPhoneNumber().equals(phoneNumber)){
                       profile.setPhoneNumber(phoneNumber);
                       isSamePhoneNumber=false;
                   }else {
                       isSamePhoneNumber=true;
                   }
               }
               if (isSamePhoneNumber){
                   throw new MyExceptions("WhatsApp is already installed on this number");
               }
           }else {
               profile.setPhoneNumber(phoneNumber);
           }
           System.out.println("Enter user name: ");
           String userName=new Scanner(System.in).nextLine();
           boolean isSameUserName=false;
           if (!profiles.isEmpty()){
               for (Profile p:profiles){
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
                           throw new MyExceptions("пароль 7 символдон аз болбошу керек!");
                       }else {
                           profile.setPassword(password);
                           profiles.add(profile);
                           System.out.println("Вы успешно зарегистрировались");
                           return profile;
                       }
                   }
                   else {
                       isSameUserName=true;
                   }
               }
           }else {
               profile.setUserName(userName);
               profile.setImage("DEFAULT IMAGE");
               profile.setStatus(String.valueOf(Status.HELLO_I_USE_WHATSAPP));
               profile.setContacts(new ArrayList<>());
               profile.setMessages(new ArrayList<>());
               System.out.println("Enter password");
               String password=new Scanner(System.in).nextLine();
               if (password.length()<7){
                   throw new MyExceptions("Password lendth can't be less than 7 symbols");
               }else {
                   profile.setPassword(password);
                   profiles.add(profile);
                   System.out.println("You sucsesfully installed Whatsapp");
                   return profile;
               }
           }
           if (isSameUserName){
               throw new MyExceptions("User Name is duplicate!");
           }
       }catch (MyExceptions e){
           System.out.println(e.getMessage());
       }
       return null;
    }//todo установка готова



    @Override
    public Profile goToProfile() {
        Profile profile1;
        try {
            System.out.println("Enter user name:");
            String userName=new Scanner(System.in).nextLine();
            System.out.println("Enter password: ");
            String password=new Scanner(System.in).nextLine();
            boolean isTrue=true;
            if (!profiles.isEmpty()){
                for (Profile profile:profiles){
                    if (profile.getUserName().equals(userName)&&profile.getPassword().equals(password)){
                        isTrue=false;
                        return profile;
                    }else {
                        isTrue=true;
                    }
                }
                if (isTrue){
                    throw new MyExceptions("Profile user name or password is wrong");
                }
            }else {
                throw new MyExceptions("Profile is empty!");
            }
        }catch (MyExceptions e){
            System.out.println(e.getMessage());
        }

        return null;
    }//todo profile ready

    @Override//todo статус готов
    public List<Status> getAllWhatsApp() {return new ArrayList<>(Arrays.asList(Status.values()));}

    @Override
    public String changWhatsappStatus() {
    Profile profile1;
    try{
        System.out.println("Enter user name:");
        String userName=new Scanner(System.in).nextLine();
        System.out.println("Enter password: ");
        String password=new Scanner(System.in).nextLine();
        boolean isTrue=true;
        if (!profiles.isEmpty()){
            for (Profile profile: profiles){
                if (profile.getUserName().equals(userName)&&profile.getPassword().equals(password)){
                    profile1=profile;
                    System.out.println("your status: "+profile1.getStatus());
                    System.out.println("Choose one of the statues: ");
                    System.out.println("""
                            1-> AT_WORK,
                            2-> TO_THE_CINEMA,
                            3-> BUSY,
                            4-> HELLO_I_USE_WHATSAPP;""");
                    int number=new Scanner(System.in).nextInt();
                    if (number==1){
                        profile1.setStatus(String.valueOf(Status.AT_WORK));
                        isTrue=false;
                        return "Your status successfully canged! \n"+profile1;
                    }else if (number==2){
                        profile1.setStatus(String.valueOf(Status.TO_THE_CINEMA));
                        isTrue=false;
                        return profile1+"\n Your status successfully canged!";
                    }else if (number==3){
                        profile1.setStatus(String.valueOf(Status.BUSY));
                        isTrue=false;
                        return "Your status successfully canged! \n"+profile1;

                    }else if (number==4){
                        profile1.setStatus(String.valueOf(Status.HELLO_I_USE_WHATSAPP));
                        isTrue=false;
                        return "Your status successfully canged! \n"+profile1;
                    }else {
                        isTrue=false;
                        throw new MyExceptions("Wrong number!");
                    }
                }else {
                    isTrue=true;
                }
            }
            if (isTrue){
                throw new MyExceptions("Profile user name or paswword is wrong!");
            }
        }else {
            throw new MyExceptions("Profile is empty!");
        }

        }catch (MyExceptions e){
        System.out.println(e.getMessage());
    }

        return null;
    }//todo status is ready

    @Override
    public String addContact() {
    Profile pp;
    try{
        System.out.println("Enter user name: ");
        String userName=new Scanner(System.in).nextLine();
        System.out.println("Enter password: ");
        String password=new Scanner(System.in).nextLine();
        boolean isFounded=true;
        boolean isSaved=true;
        boolean isAccauntFound=true;
        if (!profiles.isEmpty()){
            for (Profile profile:profiles){
                if (profile.getUserName().equals(userName)&&profile.getPassword().equals(password)){
                    isAccauntFound=true;
                    pp=profile;
                    System.out.println("Enter contact whatsapp number: ");
                    String phoneNmber=new Scanner(System.in).nextLine();
                    if (!profiles.isEmpty()){
                        for (Profile p:profiles){
                            if (p.getPhoneNumber().equals(phoneNmber)&&!p.equals(pp)){
                                isFounded=true;
                                if (!pp.getContacts().contains(p)){
                                    isSaved=false;
                                    pp.getContacts().add(p);
                                    p.getContacts().add(pp);
                                    return "Contact seccesfully added to your contacts!";
                                }else {
                                    isSaved=true;
                                }
                            }else {
                                isFounded=false;
                            }
                        }
                        if (!isFounded){
                            throw new MyExceptions("This number is not install whatsapp!");
                        }
                        if (isSaved){
                            throw new MyExceptions("This number is already saved in your contacts!");

                        }
                    }
                }else {
                    isAccauntFound=false;
                }
            }
            if (!isAccauntFound){
                throw new MyExceptions("Profile user name or password is wrong!");
            }
        }else {
            throw new MyExceptions("Profiles is empty!");

        }
    }catch (MyExceptions e){
        System.out.println(e.getMessage());
    }

        return null;
    }// todo addcontact ready!

    @Override
    public String changeProfilePhoto() {
    Profile profile1;
    try{
        System.out.println("Enter user name: ");
        String userName=new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password=new Scanner(System.in).nextLine();
        boolean isTrue=true;
        if (!profiles.isEmpty()){
            for (Profile profile:profiles){
                if (profile.getUserName().equals(userName)&&profile.getPassword().equals(password)){
                    isTrue=false;
                    profile1=profile;
                    System.out.println("Put new photo link: ");
                    String link=new Scanner(System.in).nextLine();
                    profile1.setImage(link);
                    System.out.println("Set photo");
                }
            }
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return null;
    }

    @Override
    public String sendMessage() {
    Profile profile1;
    try {
        System.out.println("Enter user name: ");
        String userName=new Scanner(System.in).nextLine();
        System.out.println("Enter password: ");
        String password=new Scanner(System.in).nextLine();
        boolean isTrue=true;
        if (!profiles.isEmpty()){
            for (Profile profile: profiles){
                if (profile.getUserName().equals(userName)&&profile.getPassword().equals(password)){
                    profile1=profile;
                    if (!profile1.getContacts().isEmpty()){
                        System.out.println("Your contact: ");
                        for (Profile p:profile1.getContacts()){
                            System.out.println(p.getUserName());
                        }
                        boolean isFounded=true;
                        System.out.println("Choose one of the them: ");
                        String choise=new Scanner(System.in).nextLine();
                    }
                }
            }
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return null;
    }

    @Override
    public void deleteWhatsApp() {
   profiles.clear();

    }//todo готов
}

