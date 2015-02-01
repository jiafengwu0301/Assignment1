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

public class AddExpenseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_expense);
		
		Button addButton = (Button) findViewById(R.id.Expense_add_button);
		addButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Test text "Added claim!"
				Toast.makeText(AddExpenseActivity.this, "Add a Expense!", Toast.LENGTH_SHORT).show();
				int setposition = Position.getPosition();
				Collection<Claim> claims = ListController.getClaimList().getClaim();
				ArrayList<Claim> alist = new ArrayList<Claim>(claims);
				ListController controller = alist.get(setposition).getController();
				
				// extract our name of the claim from the edit text and add it to our claim list
				EditText name = (EditText) findViewById(R.id.expense_name_editText);
				Spinner category = (Spinner) findViewById(R.id.for_items_spinner);
				String cate = category.getSelectedItem().toString();
				EditText when = (EditText) findViewById(R.id.When_editText);
				EditText cost = (EditText) findViewById(R.id.HowMuch_editText);
				float fcost = 0;
				if (cost.getText().toString().matches("")) {
					// do nothing 
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
