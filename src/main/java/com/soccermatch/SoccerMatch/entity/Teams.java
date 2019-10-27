package com.soccermatch.SoccerMatch.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Team")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(4)")
    private int id;
    @Column(name="name",nullable=false)
    private String name;
    @Column(name="description",nullable=false)
    private String description;
    @OneToMany(mappedBy = "teams",cascade = CascadeType.ALL)
    private List<Memberships> memberships;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
