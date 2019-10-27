package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Fee")
public class Fees implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_fees",columnDefinition = "SMALLINT(4)")
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_fields",nullable = false)
    private Fields fields;
    @Column(name = "price",nullable = false)
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}
    
}
