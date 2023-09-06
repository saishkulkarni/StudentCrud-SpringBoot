package org.jsp.student.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShouldNotRepeatExecption extends RuntimeException {
	String message = "Data Should Not Repeat";
}
