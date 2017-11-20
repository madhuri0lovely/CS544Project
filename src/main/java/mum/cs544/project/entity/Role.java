package mum.cs544.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=10, max=30)
	private String name;
	
	public Role() { }
	public Role(String name) {
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
