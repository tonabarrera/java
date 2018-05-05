package com.tona.login.entity;

import javax.persistence.*;

@Entity
public class Login {
    @Id
    private String correo;

    @Column
    private String passwordsalt;

    @Column
    private String passwordhash;

    @OneToOne(cascade = CascadeType.ALL)
    private Personal personal;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
