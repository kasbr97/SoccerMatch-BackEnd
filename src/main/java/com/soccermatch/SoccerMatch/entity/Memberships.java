package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;
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
    @Temporal(TemporalType.DATE)
    @Column(name="member_since",nullable = false)
    private Date member_since;
    @Temporal(TemporalType.DATE)
    @Column(name="member_until",nullable = false)
    private Date member_until;
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

    public Date getMember_since() {
        return member_since;
    }

    public void setMember_since(Date member_since) {
        this.member_since = member_since;
    }

    public Date getMember_until() {
        return member_until;
    }

    public void setMember_until(Date member_until) {
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
