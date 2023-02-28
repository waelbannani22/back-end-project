package com.stage.backend.entity;

import jakarta.persistence.*;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "password_reset_token")
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = Pharmacien.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Pharmacien user;

    public void setId(Long id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(Pharmacien user) {
        this.user = user;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Pharmacien getUser() {
        return user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    private Date expiryDate;

    public PasswordResetToken() {
        super();
    }

    public PasswordResetToken(String token, Pharmacien user) {
        super();
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    // Getters and setters omitted for brevity

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}

