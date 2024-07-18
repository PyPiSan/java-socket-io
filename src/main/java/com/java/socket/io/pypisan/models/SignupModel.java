package com.java.socket.io.pypisan.models;
import java.util.Objects;

public class SignupModel {
    
    private String userName;
    private String password;
    private String emailId;

    public SignupModel() {
    }

    public SignupModel(String userName, String password, String emailId) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public SignupModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public SignupModel password(String password) {
        setPassword(password);
        return this;
    }

    public SignupModel emailId(String emailId) {
        setEmailId(emailId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SignupModel)) {
            return false;
        }
        SignupModel signupModel = (SignupModel) o;
        return Objects.equals(userName, signupModel.userName) && Objects.equals(password, signupModel.password) && Objects.equals(emailId, signupModel.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, emailId);
    }

    @Override
    public String toString() {
        return "{" +
            " userName='" + getUserName() + "'" +
            ", password='" + getPassword() + "'" +
            ", emailId='" + getEmailId() + "'" +
            "}";
    }
    
}
