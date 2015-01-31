package com.example.assignment1;


public class ClaimListController {
	private static ClaimList claimList = null;
	static public ClaimList getClaimList(){
		if (claimList == null){
			claimList = new ClaimList();
		}
		return claimList;
	}
	

	
	public void addClaim(Claim claim){
		getClaimList().addClaim(claim);
	}
	
	public void editClaim(){
		getClaimList().editClaim();
	}
	
	public Claim chooseClaim() throws EmptyClaimListException{
		return getClaimList().chooseClaim();
	}
	
}
