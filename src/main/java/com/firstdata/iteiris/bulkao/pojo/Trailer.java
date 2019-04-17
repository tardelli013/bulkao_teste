package com.firstdata.iteiris.bulkao.pojo;


import com.zandero.ffpojo.metadata.positional.annotation.PositionalField;
import com.zandero.ffpojo.metadata.positional.annotation.PositionalRecord;

@PositionalRecord
public class Trailer {

	private Integer recordsCount;
	
	@PositionalField(initialPosition = 1, finalPosition = 4)
	public Integer getRecordsCount() {
		return recordsCount;
	}
	public void setRecordsCount(Integer recordsCount) {
		this.recordsCount = recordsCount;
	}
	// must use a String setter or a FieldDecorator
	public void setRecordsCount(String recordsCount) {
		this.recordsCount = Integer.valueOf(recordsCount);
	}
}
