package com.cg.jpastart.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int trip_id;
	String fromCity;
	String toCity;
	@Embedded
	SeatInfo info;

	public int getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public SeatInfo getInfo() {
		return info;
	}

	public void setInfo(SeatInfo info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Trip [trip_id=" + trip_id + ", fromCity=" + fromCity
				+ ", toCity=" + toCity + ", info=" + info + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + trip_id;
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
		Trip other = (Trip) obj;
		if (trip_id != other.trip_id)
			return false;
		return true;
	}

}
