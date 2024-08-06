package com.lgcns.mission.pension.exception;

@SuppressWarnings("serial")
public class AlreadyCheckoutException extends Exception{
	
	public AlreadyCheckoutException() {
		super("[Error] Check out sudah dilakukan.");
	}
}
