package com.sunil.library.library.uiModel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errMessage;
	private String errCode;
    private Throwable errorDetails;
	
    private Date date;
}
