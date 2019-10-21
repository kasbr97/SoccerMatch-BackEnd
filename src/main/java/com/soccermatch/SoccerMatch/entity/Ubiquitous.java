package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="Ubiquitous")
public class Ubiquitous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(4)")
    private int id;
    @Column(name="name",nullable=false)
    private String name;
    @Column(name="longitude",nullable=false)
    private double longitude;
    @Column(name="latitude",nullable=false)
    private double latitude;
    @OneToMany(mappedBy = "ubiquitous",cascade = CascadeType.ALL)
    private List<People> people;
	@OneToMany(mappedBy = "ubiquitous",cascade = CascadeType.ALL)
    private List<Places> places;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
