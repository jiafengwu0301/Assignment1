/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/

package ca.ualberta.jiafeng1.list;


//This code is modified by reference code from Student Picker
public class ListController {
	private static ClaimList claimList = null;
	
	private static ExpenseList expenseList = null;
	
	
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
	
	public Claim chooseClaim() throws EmptyListException{
		return getClaimList().chooseClaim();
	}
	

	
	static public ExpenseList getExpenseList() {
		if (expenseList == null) {
			expenseList = new ExpenseList();
		}
		
		return expenseList;
	}

	public void addExpense(Expense expense) {
		getExpenseList().addExpense(expense);
	}

	public void editExpense() {
		getExpenseList().editExpense();
	}
	
	public Expense chooseExpense() throws EmptyListException {
		return getExpenseList().chooseExpense();
	}
	
}
