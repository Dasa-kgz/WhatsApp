import java.util.List;

public class Profile {
    private int id;
    private String userName;
    private String phoneNumber;
    private String password;
    private String image;
    private String status;
    private List<Profile>contacts;
    private List<String>messages;

    public Profile(int id, String userName, String phoneNumber, String password, String image, String status, List<Profile> contacts, List<String> messages) {
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.image = image;
        this.status = status;
        this.contacts = contacts;
        this.messages = messages;
    }
    public Profile(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Profile> getContacts() {
        return contacts;
    }

    public void setContacts(List<Profile> contacts) {
        this.contacts = contacts;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", contacts=" + contacts +
                ", messages=" + messages +
                '}';
    }
}
