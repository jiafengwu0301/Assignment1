/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/

package com.example.assignment1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

//This code is modified by reference code from Student Picker
public class ExpenseList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2450981085621593182L;
	protected ArrayList<Expense> ExpenseList;
	protected ArrayList<Listener> listeners;

	public ExpenseList(){	
		ExpenseList = new ArrayList<Expense>();
		listeners = new ArrayList<Listener>();
	}
	
	public Collection<Expense> getExpense() {
		return ExpenseList;
	}

	public void addExpense(Expense testExpense) {		
		ExpenseList.add(testExpense);
		notifyListeners();
	}

	public void deleteExpense(Expense testExpense) {		
		ExpenseList.remove(testExpense);	
		notifyListeners();
	}
	
	public void editExpense() {
		notifyListeners();
	}

	public int size(){	
		return ExpenseList.size();		
	}

	public boolean contains(Expense testExpense) {
		return ExpenseList.contains(testExpense);
	}
	
	public Expense chooseExpense() throws EmptyListException {
		int size = ExpenseList.size();
		if (size <= 0) {
			throw new EmptyListException();
		}
		int index = 0;
		return ExpenseList.get(index);
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
