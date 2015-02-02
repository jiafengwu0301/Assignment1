/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/
package ca.ualberta.jiafeng1.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import ca.ualberta.jiafeng1.mod_list.Listener;


//This code is modified by reference code from Student Picker
public class ClaimList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -272342298747450793L;
	protected ArrayList<Claim> claimList = null;
	protected ArrayList<Listener> listeners;

	public ClaimList(){	
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}
	
	public Collection<Claim> getClaim() {
		return claimList;
	}
	
	public void addClaim(Claim testClaim) {		
		claimList.add(testClaim);
		notifyListeners();
	}
	
	public void notifyListeners() {
		for (Listener listener: listeners) {
			listener.update();
		}
	}

	public void deleteClaim(Claim testClaim) {		
		claimList.remove(testClaim);	
		notifyListeners();
	}
	
	public void removeClaim(Claim testClaim) {
		claimList.remove(testClaim);
		notifyListeners();
	}
	
	public void editClaim() {
		notifyListeners();
	}
	
	public Claim chooseClaim() throws EmptyListException {
		int size = claimList.size();
		if (size <= 0) {
			throw new EmptyListException();
		}
		int index = 0;
		return claimList.get(index);
	}

	public int size(){	
		return claimList.size();		
	}

	public boolean contains(Claim testClaim) {
		return claimList.contains(testClaim);
	}
	
	public void addListener(Listener l) {
		listeners.add(l);
	}
	
	public void removeListener (Listener l) {
		listeners.remove(l);
	}
}

