/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/

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
					
				} else {
					fcost = Float.valueOf(cost.getText().toString());
				}

				int expensepos = Position.getPosition();
				int claimpos = Position.getPosition();
				
				Collection<Claim> claim = ListController.getClaimList().getClaim();
				ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
				ArrayList<Expense> expense = claimlist.get(claimpos).getItemArray();
				
				expense.get(expensepos).setName(name.getText().toString());
				expense.get(expensepos).setItem(cate);
				SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
				try {
					expense.get(expensepos).setWhen(date.parse(when.getText().toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				expense.get(expensepos).setDescription(des.getText().toString());
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
	
	//http://stackoverflow.com/questions/2390102/how-to-set-selected-item-of-spinner-by-value-not-by-position 01/02/2015
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
