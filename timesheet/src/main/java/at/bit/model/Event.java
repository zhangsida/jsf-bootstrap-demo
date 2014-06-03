package at.bit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalTime;

@Entity
@Table(name="event_tbl")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;


	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_time")
	private Date endTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void withStartDateTime(DateTime startDTTime) {
		setStartTime(startDTTime.toDate());
	}

	public void withEndDateTime(DateTime endDTTime) {
		setEndTime(endDTTime.toDate());
	}

	public DateTime startDateTime() {
		return new DateTime(getStartTime());
	}
	
	public DateTime endDateTime() {
		return new DateTime(getEndTime());
	}

	public LocalTime getStartDateTime() {
		return new DateTime(getStartTime()).toLocalTime();
	}
	
	public LocalTime getEndDateTime() {
		return new DateTime(getEndTime()).toLocalTime();
	}

	public long durationHours() {
		return new Duration(new DateTime(getStartTime()), new DateTime(getEndTime())).getStandardHours();
	}

	public long durationMinutes() {
		return new Duration(new DateTime(getStartTime()), new DateTime(getEndTime())).getStandardMinutes();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=").append(id).append(", name=").append(name)
				.append(", startTime=").append(startTime).append(", endTime=")
				.append(endTime).append("]");
		return builder.toString();
	}

}
