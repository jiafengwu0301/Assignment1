package com.example.assignment1;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimList {
	
	protected ArrayList<Claim> claimList = null;
	protected ArrayList<Listener> listeners;

	public ClaimList(){	
		// create a new claim list 
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}
	
	public Collection<Claim> getClaim() {
		// return the collection of our claims
		return claimList;
	}

	// add a claim to our list of claims
	public void addClaim(Claim testClaim) {		
		claimList.add(testClaim);
		notifyListeners();
	}

	// delete a claim from the claim list
	public void deleteClaim(Claim testClaim) {		
		claimList.remove(testClaim);	
		notifyListeners();
	}
	
	public void editClaim() {
		notifyListeners();
	}

	public int size(){	
		return claimList.size();		
	}

	public boolean contains(Claim testClaim) {
		return claimList.contains(testClaim);
	}
	
	public Claim chooseClaim() throws EmptyListException {
		int size = claimList.size();
		if (size <= 0) {
			throw new EmptyListException();
		}
		int index = 0;
		return claimList.get(index);
	}
	
	public void notifyListeners() {
		for (Listener listener: listeners) {
			listener.update();
		}
	}
	
	public void addListener(Listener l) {
		listeners.add(l);
	}
	
	public void removeListener (Listener l) {
		listeners.remove(l);
	}
}

