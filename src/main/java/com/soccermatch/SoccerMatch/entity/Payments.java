package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;

@Entity
@Table(name="Payment")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_membership",nullable = false)
    private Memberships memberships;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_rent",nullable = false)
    private Rents rents;
    
    @Column(name="share",nullable = false)
    private float share;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rents getRents() {
        return rents;
    }

    public void setRents(Rents rents) {
        this.rents = rents;
    }

    public float getShare() {
        return share;
    }

    public void setShare(float share) {
        this.share = share;
    }
    public Memberships getMembership() {
		return memberships;
	}

	public void setMembership(Memberships memberships) {
		this.memberships = memberships;
	}

}
