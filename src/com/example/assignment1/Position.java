package com.example.assignment1;

public class Position {
	
	protected static int position;
	
	public Position(int position) {
		Position.position = position;
	}
	
	public static int getPosition() {
		return position;
	}

}
