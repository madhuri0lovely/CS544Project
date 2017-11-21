package mum.cs544.project.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Session {
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Future
	private Date date;
	
	@Temporal(TemporalType.TIME)
	private Date time;
	
	@Min(value=15)
	private int duration;
	
	@Min(value=1)
	@Max(value=5)
	private int capacity;
	
	@Valid
	@NotNull
	@OneToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	@Valid
	@NotNull
	@OneToOne
	@JoinColumn(name="counselor_id")
	private Person counselor;
	
	@OneToMany(mappedBy="session", cascade=CascadeType.ALL)
	private List<Appointment> attendees;
	
	public Session() { }
	public Session(Date date, Date time, int duration, int capacity, Location location, Person counselor) {
		super();
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.capacity = capacity;
		this.location = location;
		this.counselor = counselor;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Person getCounselor() {
		return counselor;
	}
	public void setCounselor(Person counselor) {
		this.counselor = counselor;
	}
	public Long getId() {
		return id;
	}
	
	public String getInfo() {
		return this.date.toString() + " " + this.time.toString() + " at " + this.location.toString();
	}
}
