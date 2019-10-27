package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Place")
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(4)")
    private int id;
    @Column(name="name",nullable=false)
    private String name;
    @Column(name="description",nullable=false)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_ubiquitous",nullable = false)
    private Ubiquitous ubiquitous;
    @OneToMany(mappedBy = "places",cascade = CascadeType.ALL)
    private List<Fields> fields;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Ubiquitous getUbiquitous() {
		return ubiquitous;
	}

	public void setUbiquitous(Ubiquitous ubiquitous) {
		this.ubiquitous = ubiquitous;
	}


}
