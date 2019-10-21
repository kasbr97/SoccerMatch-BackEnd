package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Membership")
public class Memberships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(4)")
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_team",nullable = false)
    private  Teams teams;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_person",nullable = false)
    private  People person;
    
    @Column(name="member_since",nullable = false)
    private LocalDateTime member_since;
    
    @Column(name="member_until",nullable = false)
    private LocalDateTime member_until;
    @Column(name="role",nullable = false)
    private boolean role;
    @OneToMany(mappedBy = "memberships",cascade = CascadeType.ALL)
    private List<Rents> rents;
    @OneToMany(mappedBy = "memberships",cascade = CascadeType.ALL)
    private List<Payments> payments;
    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }

    public LocalDateTime getMember_since() {
        return member_since;
    }

    public void setMember_since(LocalDateTime member_since) {
        this.member_since = member_since;
    }

    public LocalDateTime getMember_until() {
        return member_until;
    }

    public void setMember_until(LocalDateTime member_until) {
        this.member_until = member_until;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
