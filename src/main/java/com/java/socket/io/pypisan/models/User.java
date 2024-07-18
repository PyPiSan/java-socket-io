package com.java.socket.io.pypisan.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String userName;
    private LocalDateTime joinedOn;
    private LocalDateTime updatedAt;
    private String emailId;
    private String profileUrl;



    public User() {
    }

    public User(UUID id, String userName, LocalDateTime joinedOn, LocalDateTime updatedAt, String emailId, String profileUrl) {
        this.id = id;
        this.userName = userName;
        this.joinedOn = joinedOn;
        this.updatedAt = updatedAt;
        this.emailId = emailId;
        this.profileUrl = profileUrl;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public User userName(String userName) {
        setUserName(userName);
        return this;
    }

    public User joinedOn(LocalDateTime joinedOn) {
        setJoinedOn(joinedOn);
        return this;
    }

    public User updatedAt(LocalDateTime updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    public User emailId(String emailId) {
        setEmailId(emailId);
        return this;
    }

    public User profileUrl(String profileUrl) {
        setProfileUrl(profileUrl);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(joinedOn, user.joinedOn) && Objects.equals(updatedAt, user.updatedAt) && Objects.equals(emailId, user.emailId) && Objects.equals(profileUrl, user.profileUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, joinedOn, updatedAt, emailId, profileUrl);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", joinedOn='" + getJoinedOn() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", emailId='" + getEmailId() + "'" +
            ", profileUrl='" + getProfileUrl() + "'" +
            "}";
    }
    
    
}
