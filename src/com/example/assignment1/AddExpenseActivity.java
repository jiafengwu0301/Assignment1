
/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/
package com.example.assignment1;


import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//This code is modified by reference code from Student Picker

public class AddExpenseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_expense);
		
		Button addButton = (Button) findViewById(R.id.Expense_add_button);
		addButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(AddExpenseActivity.this, "Add a Expense!", Toast.LENGTH_SHORT).show();
				int claimpos = Position.getPosition();
				Collection<Claim> claim = ListController.getClaimList().getClaim();
				ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
				ListController controller = claimlist.get(claimpos).getController();
				
				EditText name = (EditText) findViewById(R.id.expense_name_editText);
				Spinner category = (Spinner) findViewById(R.id.for_items_spinner);
				String cate = category.getSelectedItem().toString();
				EditText when = (EditText) findViewById(R.id.When_editText);
				EditText cost = (EditText) findViewById(R.id.HowMuch_editText);
				float fcost = 0;
				if (cost.getText().toString().matches("")) {

				} else {
					fcost = Float.valueOf(cost.getText().toString());
				}
				Spinner curr = (Spinner) findViewById(R.id.Currency_spinner);
				String currency = curr.getSelectedItem().toString();
				EditText des = (EditText) findViewById(R.id.Description_editText);
				controller.addExpense(new Expense(name.getText().toString(), cate, when.getText().toString(), 
						fcost,currency,des.getText().toString()));		
				
				finish();
				
			}
			
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_expense, menu);
		return true;
	}
	
	public void CancelExpenseItem(View v){
		Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(AddExpenseActivity .this, List_Expense_Activity.class);
		startActivity(intent);
	}
	

}
