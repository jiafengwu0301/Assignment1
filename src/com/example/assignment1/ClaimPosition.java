package com.example.assignment1;

public class ClaimPosition {
	
	protected static int position;
	
	public ClaimPosition(int position) {
		ClaimPosition.position = position;
	}
	
	public static int getPosition() {
		return position;
	}

}
