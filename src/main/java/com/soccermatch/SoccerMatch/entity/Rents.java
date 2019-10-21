package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Rent")
public class Rents {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(4)")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_membership",nullable = false)
    private Memberships memberships;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_field",nullable = false)
    private Fields fields;
    
    @Column(name="discount_percentage",nullable = false)
    private float discountPercentage;
    
	@Column(name="total_price",nullable = false)
    private float totalPrice;
	
    
    @Column(name="rented_at",nullable = false)
    private LocalDateTime rentedAt;
    
    @Column(name="duration",nullable = false)
    private int duration;
    
    @OneToMany(mappedBy = "rents",cascade = CascadeType.ALL)
    private List<Payments> payments;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public Memberships getMemberships() {
        return memberships;
    }

    public void setMemberships(Memberships memberships) {
        this.memberships = memberships;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(LocalDateTime rentedAt) {
        this.rentedAt = rentedAt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
