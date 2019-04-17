package com.firstdata.iteiris.bulkao.pojo;

import com.zandero.ffpojo.decorator.InternalDateDecorator;
import com.zandero.ffpojo.metadata.positional.annotation.PositionalField;
import com.zandero.ffpojo.metadata.positional.annotation.PositionalRecord;
import com.zandero.ffpojo.metadata.positional.annotation.extra.LongPositionalField;

import java.util.Date;

@PositionalRecord(ignorePositionNotFound=true)
public class Customer {

	@LongPositionalField(initialPosition = 1, finalPosition = 5)
	private Long id;
	private String name;
	private String email;
	private Date birthDate;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@PositionalField(initialPosition = 6, finalPosition = 25)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@PositionalField(initialPosition = 26, finalPosition = 55)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@PositionalField(initialPosition = 56, finalPosition = 65, decorator = InternalDateDecorator.class)
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
