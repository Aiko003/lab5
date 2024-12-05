// Student.java
public class Student {
    private String lastName;
    private String firstName;
    private String login;

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = lastName; // Логин по умолчанию - фамилия
    }


    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Логин='" + login;
    }
}
