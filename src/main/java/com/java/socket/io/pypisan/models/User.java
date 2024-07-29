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

    @Column(name="user_name")
    private String userName;

    @Column(name="joined_on")
    private LocalDateTime joinedOn;

    @Column(name="updated_on")
    private LocalDateTime updatedAt;

    @Column(name="email")
    private String emailId;

    @Column(name="profile_url")
    private String profileUrl;

    @Column(name="key")
    private String password;


    public User() {
    }

    public User(UUID id, String userName, LocalDateTime joinedOn, LocalDateTime updatedAt, String emailId, String profileUrl, String password) {
        this.id = id;
        this.userName = userName;
        this.joinedOn = joinedOn;
        this.updatedAt = updatedAt;
        this.emailId = emailId;
        this.profileUrl = profileUrl;
        this.password = password;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, joinedOn, updatedAt, emailId, profileUrl, password);
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
            ", password='" + getPassword() + "'" +
            "}";
    }
    
    
}
