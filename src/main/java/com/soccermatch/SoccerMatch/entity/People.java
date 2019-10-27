package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Person")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(4)")
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="dni",nullable=true)
    private int dni;
    @Column(name="phone_number",nullable=true)
    private String phoneNumber;
    @Column(name="email",nullable=false)
    private String email;
	@Column(name="username",nullable=true)
    private String username;
    @Column(name="password",nullable=false)
    private String password;
    @Column(name="partner",nullable=true)
    private boolean partner;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Memberships> memberships;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_ubiquitous",nullable = false)
    private Ubiquitous ubiquitous;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

	public Ubiquitous getUbiquitous() {
		return ubiquitous;
	}

	public void setUbiquitous(Ubiquitous ubiquitous) {
		this.ubiquitous = ubiquitous;
	}

}
