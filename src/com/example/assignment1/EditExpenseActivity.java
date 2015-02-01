package com.example.assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditExpenseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_expense);
		getActionBar().setTitle("Edit Expense");
		
        int claimpos = Position.getPosition();
        int expensepos = Position.getPosition();
        
        Collection<Claim> claim = ListController.getClaimList().getClaim();
		ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
		
		claimlist.get(claimpos).getController();
		Collection<Expense> item = ListController.getExpenseList().getExpense();
		ArrayList<Expense> expense = new ArrayList<Expense>(item);

		EditText name = (EditText) findViewById(R.id.name_edit);
		Spinner category = (Spinner)findViewById(R.id.cat_spinner);
		EditText when = (EditText) findViewById(R.id.exp_date_edit);
		EditText cost = (EditText) findViewById(R.id.exp_cost_edit);
		EditText des = (EditText) findViewById(R.id.exp_des_edit);
		Spinner currency = (Spinner)findViewById(R.id.exp_curr_spinner);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
		
		name.setText(expense.get(expensepos).toString());
		category.setSelection(getIndex(category, expense.get(expensepos).toItem()));
		when.setText(date.format(expense.get(expensepos).toWhen()));
		cost.setText(Float.toString(expense.get(expensepos).toCost()));
		des.setText(expense.get(expensepos).toDescription());	
		currency.setSelection(getIndex(currency, expense.get(expensepos).toCurr()));

		Button editButton = (Button) findViewById(R.id.edit_edit_but);
		editButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(EditExpenseActivity.this, "Updated Item!", Toast.LENGTH_SHORT).show();
				
				// call our EditTexts and spinners for the new user values 
				EditText name = (EditText) findViewById(R.id.name_edit);
				EditText when = (EditText) findViewById(R.id.exp_date_edit);
				EditText cost = (EditText) findViewById(R.id.exp_cost_edit);
				EditText des = (EditText) findViewById(R.id.exp_des_edit);
				Spinner category = (Spinner)findViewById(R.id.cat_spinner);
				Spinner currency = (Spinner)findViewById(R.id.exp_curr_spinner);
				String cate = category.getSelectedItem().toString();
				String curr = currency.getSelectedItem().toString();
				float fcost = 0;
				if (cost.getText().toString().matches("")) {
					// do nothing 
				} else {
					fcost = Float.valueOf(cost.getText().toString());
				}

				int expensepos = Position.getPosition();
				int claimpos = Position.getPosition();
				
				Collection<Claim> claim = ListController.getClaimList().getClaim();
				ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
				ArrayList<Expense> expense = claimlist.get(claimpos).getItemArray();
				
				((Expense) expense.get(expensepos)).setName(name.getText().toString());
				expense.get(expensepos).setItem(cate);
				SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
				try {
					((Expense) expense.get(expensepos)).setWhen(date.parse(when.getText().toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				((Expense) expense.get(expensepos)).setDescription(des.getText().toString());
				expense.get(expensepos).setCost(fcost);
				expense.get(expensepos).setCurr(curr);
				
					
				ListController controller = new ListController();
				controller.editExpense();
				
				// now we want to update our total currency expense as well
//				Collection<TotalCurrency> total = TotalCurrencyController.getTotalCurrencyList().getTotalCurrency();
//				ArrayList<TotalCurrency> clist = new ArrayList<TotalCurrency>(total);
//				
//				clist.get(expensepos).modifyCost(cost);
//				clist.get(expensepos).modifyCurrency(curr);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds item to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_expense, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void editCancel1(View v){
		Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(EditExpenseActivity .this, List_Expense_Activity.class);
		startActivity(intent);
	}
	
	private int getIndex(Spinner spinner, String str) {
		
		int index = 0;
		
		for (int i=0;i<spinner.getCount();i++) {
			if (spinner.getItemAtPosition(i).equals(str)) {
				index = i;
			}
		}
		return index;
	}
}
