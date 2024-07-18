package com.java.socket.io.pypisan.models;
import java.time.LocalDateTime;
import java.util.Objects;

public class SignupModel {
    
    private String userName;
    private String password;
    private LocalDateTime joinedOn;
    private LocalDateTime updatedAt;
    private String emailId;
    private String profileUrl;
    

    public SignupModel() {
    }

    public SignupModel(String userName, String password, LocalDateTime joinedOn, LocalDateTime updatedAt, String emailId, String profileUrl) {
        this.userName = userName;
        this.password = password;
        this.joinedOn = joinedOn;
        this.updatedAt = updatedAt;
        this.emailId = emailId;
        this.profileUrl = profileUrl;
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

    public LocalDateTime getJoinedOn() {
        return this.joinedOn;
    }

    public void setJoinedOn(LocalDateTime joinedOn) {
        this.joinedOn = joinedOn;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public SignupModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public SignupModel password(String password) {
        setPassword(password);
        return this;
    }

    public SignupModel joinedOn(LocalDateTime joinedOn) {
        setJoinedOn(joinedOn);
        return this;
    }

    public SignupModel updatedAt(LocalDateTime updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    public SignupModel emailId(String emailId) {
        setEmailId(emailId);
        return this;
    }

    public SignupModel profileUrl(String profileUrl) {
        setProfileUrl(profileUrl);
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
        return Objects.equals(userName, signupModel.userName) && Objects.equals(password, signupModel.password) && Objects.equals(joinedOn, signupModel.joinedOn) && Objects.equals(updatedAt, signupModel.updatedAt) && Objects.equals(emailId, signupModel.emailId) && Objects.equals(profileUrl, signupModel.profileUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, joinedOn, updatedAt, emailId, profileUrl);
    }

    @Override
    public String toString() {
        return "{" +
            " userName='" + getUserName() + "'" +
            ", password='" + getPassword() + "'" +
            ", joinedOn='" + getJoinedOn() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", emailId='" + getEmailId() + "'" +
            ", profileUrl='" + getProfileUrl() + "'" +
            "}";
    }

}
