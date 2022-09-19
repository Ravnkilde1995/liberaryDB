import java.util.Date;

public class Member {

    String firstName;
    String lastName;
    Date joinedDate;
    int activeStatus;
    static String user_name;
    String password;

    public Member(String firstName, String lastName, Date joinedDate, int activeStatus, String user_name, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinedDate = joinedDate;
        this.activeStatus = activeStatus;
        this.user_name = user_name;
        this.password = password;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public static String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
