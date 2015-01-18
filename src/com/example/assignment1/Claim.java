package com.example.assignment1;

public class Claim {
	protected String claimName;
	public Claim(String claimName) {
		// TODO Auto-generated constructor stub
		this .claimName = claimName;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this .claimName;
	}
	public String toString(){
		return getName();
	}
}
