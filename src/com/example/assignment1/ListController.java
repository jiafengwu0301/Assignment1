package com.example.assignment1;

public class ListController {
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
	
	private static ExpenseList expenseList = null;
	
	static public ExpenseList getExpenseList() {
		if (expenseList == null) {
			expenseList = new ExpenseList();
		}
		
		return expenseList;
	}

	public Expense chooseExpense() throws EmptyExpenseListException {
		return getExpenseList().chooseExpense();
	}

	public void addExpense(Expense item) {
		getExpenseList().addExpense(item);
	}

	public void edittedExpense() {
		getExpenseList().editExpense();
	}
	
}
