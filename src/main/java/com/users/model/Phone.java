package com.users.model;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;

@Entity
@JsonIgnoreProperties(value = { "Id" })
public class Phone implements Serializable {

	private static final long serialVersionUID = -4554700962912848953L;
	@Id
	@JsonIgnore
	private UUID Id;
	private String number;
	private String citycode;
	private String countrycode;
	
	public Phone() {
		
	}
		
	public Phone(UUID id, String number, String citycode, String countrycode) {
		super();
		Id = id;
		this.number = number;
		this.citycode = citycode;
		this.countrycode = countrycode;
	}

	@JsonIgnore
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Phone other = (Phone) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phone [Id=" + Id + ", number=" + number + ", citycode=" + citycode + ", countrycode=" + countrycode
				+ "]";
	}
	
}
