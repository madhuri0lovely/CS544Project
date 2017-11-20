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
	private String name;
	
	public Location() { }
	public Location(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
}
