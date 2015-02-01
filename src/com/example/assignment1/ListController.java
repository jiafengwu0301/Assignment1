package com.example.assignment1;

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

	public Expense chooseExpense() throws EmptyListException {
		return getExpenseList().chooseExpense();
	}

	public void addExpense(Expense item) {
		getExpenseList().addExpense(item);
	}

	public void editExpense() {
		getExpenseList().editExpense();
	}
	
}
