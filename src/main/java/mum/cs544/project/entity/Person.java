package mum.cs544.project.entity;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@SecondaryTables(
	@SecondaryTable(
		name="user", pkJoinColumns={
			@PrimaryKeyJoinColumn(name="person_id", referencedColumnName="id")
		}
	)
)
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=2, max=40)
	private String firstName;
	
	@Size(min=2, max=40)
	private String lastName;
	
	@Transient
	private String fullName;
	
	@NotNull
	@Email
	private String email;
	
	@Column(table="user")
	@Size(min=6, max=50)
	private String username;
	
	@Column(table="user")
	@Size(min=6, max=250)
	private String password;
	
	@ManyToMany
	private List<Role> roles;
	
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL)
	private List<Appointment> appointments;
	
	public Person() { }
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public String getFullName() {
		fullName = firstName + " " + lastName;
		return fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public List<Role> getRoles() {
		return (List<Role>)Collections.unmodifiableList(roles);
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
}
