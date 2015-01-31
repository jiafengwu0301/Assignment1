package com.example.assignment1;

import java.util.ArrayList;
import java.util.Collection;

public class ExpenseList {
	protected ArrayList<Expense> ExpenseList = null;
	protected ArrayList<Listener> listeners;

	public ExpenseList(){	
		// create a new Expense list 
		ExpenseList = new ArrayList<Expense>();
		listeners = new ArrayList<Listener>();
	}
	
	public Collection<Expense> getExpense() {
		// return the collection of our Expenses
		return ExpenseList;
	}

	// add a Expense to our list of Expenses
	public void addExpense(Expense testExpense) {		
		ExpenseList.add(testExpense);
		notifyListeners();
	}

	// delete a Expense from the Expense list
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
	
	public Expense chooseExpense() throws EmptyExpenseListException {
		int size = ExpenseList.size();
		if (size <= 0) {
			throw new EmptyExpenseListException();
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
