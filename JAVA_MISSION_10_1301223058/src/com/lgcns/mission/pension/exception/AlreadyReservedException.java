package com.lgcns.mission.pension.exception;

@SuppressWarnings("serial")
public class AlreadyReservedException extends Exception{
	
	public AlreadyReservedException() {
		super("[Error] Kamar sudah dipesan.");
	}

}
