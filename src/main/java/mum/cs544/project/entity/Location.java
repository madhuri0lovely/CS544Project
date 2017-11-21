package mum.cs544.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=1, max=50)
	private String building;
	
	@NotNull
	@Size(min=1, max=50)
	private String room;
	
	public Location() { }
	public Location(String building, String room) {
		super();
		this.building = building;
		this.room = room;
	}

	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Building=" + building + ", Room=" + room;
	}
	
}
