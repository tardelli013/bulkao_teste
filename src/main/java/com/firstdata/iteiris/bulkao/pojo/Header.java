package com.firstdata.iteiris.bulkao.pojo;

import com.zandero.ffpojo.decorator.InternalDateDecorator;
import com.zandero.ffpojo.metadata.positional.annotation.PositionalField;
import com.zandero.ffpojo.metadata.positional.annotation.PositionalRecord;

import java.util.Date;

@PositionalRecord
public class Header {

	private Long controlNumber;
	private Date processDate;
	
	@PositionalField(initialPosition = 1, finalPosition = 10)
	public Long getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(Long controlNumber) {
		this.controlNumber = controlNumber;
	}
	// must use a String setter or a FieldDecorator
	public void setControlNumber(String controlNumber) {
		this.controlNumber = Long.valueOf(controlNumber);
	}
	
	@PositionalField(initialPosition = 11, finalPosition = 20, decorator = InternalDateDecorator.class)
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
}
