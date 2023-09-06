package org.jsp.student.helper;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	String message;
	int status;
	T data;
}
