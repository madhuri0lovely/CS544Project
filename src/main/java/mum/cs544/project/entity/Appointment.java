package mum.cs544.project.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Valid
	@ManyToOne
	@JoinColumn(name="session_id")
	private Session session;
	
	@NotNull
	@Valid
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	
	@NotNull
	@Valid
	@ManyToOne
	@JoinColumn(name="creator_id")
	private Person creator;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	private int reminder = 0;
	
	public Appointment() { }
	public Appointment(Session session, Person person, Person creator, Date createdDate) {
		super();
		this.session = session;
		this.person = person;
		this.creator = creator;
		this.createdDate = createdDate;
	}
	
	@PrePersist
	void preInsert() {
	   if (this.createdDate == null)
	       this.createdDate = new Date();
	}
	
	public Person getCreator() {
		return creator;
	}
	public void setCreator(Person creator) {
		this.creator = creator;
	}
	public int getReminder() {
		return reminder;
	}
	public void setReminder(int reminder) {
		this.reminder = reminder;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getId() {
		return id;
	}
}
