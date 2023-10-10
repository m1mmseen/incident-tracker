package dev.chha.backend.dto;

public class RegisterDto {

    private String username;

    private String password;

    private String firstname;

    private String lastname;

    public RegisterDto() {
    }

    public RegisterDto(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Registration for:" +
                "user='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }
    
}
