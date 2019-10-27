package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Field")
public class Fields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(4)")
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="description",nullable = false)
    private String description;
    @Column(name="type",nullable = false)
    private String type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_places",nullable = false)
    private Places places;
    @OneToMany(mappedBy = "fields",cascade = CascadeType.ALL)
    private List<Rents> rents;
    public String getName() {
        return name;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Places getPlaces() {
        return places;
    }

    public void setPlaces(Places places) {
        this.places = places;
    }

}
