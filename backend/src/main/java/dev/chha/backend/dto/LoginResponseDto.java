package dev.chha.backend.dto;

public class LoginResponseDto {

    private UserDto user;

    private String jwt;

    public LoginResponseDto() {
    }

    public LoginResponseDto(UserDto user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    
}
