package com.example.assignment1;

import java.util.ArrayList;


public class ClaimList {
	
	ArrayList<Claim> claimList;
	
	public ClaimList(){
		claimList = new ArrayList<Claim>();
	}
	
	public ArrayList<Claim> getArrayClaim() {
		return claimList;
	}
	
	public void addClaim(Claim testClaim){
		this.claimList.add(testClaim);
	}
	
	public void removeClaim(Claim testClaim){
		claimList.remove(testClaim);
	}
}