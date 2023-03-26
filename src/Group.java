import java.util.List;

public class Group {
    private int id;
    private String groupName;
    private List<Profile>profiles;
    private List<String>message;

    public int getId() {
        return id;
    }

    public Group(int id, String groupName, List<Profile> profiles, List<String> message) {
        this.id = id;
        this.groupName = groupName;
        this.profiles = profiles;
        this.message = message;
    }

    public Group() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", profiles=" + profiles +
                ", message=" + message +
                '}';
    }
}
