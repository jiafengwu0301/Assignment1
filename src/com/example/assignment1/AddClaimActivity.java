/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/

package com.example.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;


//This code is modified by reference code from Student Picker

public class AddClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claim);
		getActionBar().setTitle("Add Claim");

		
		Button add_claim = (Button) findViewById(R.id.Add_Button);
		add_claim.setOnClickListener(new View.OnClickListener()
		{

			public void onClick(View v){
				
				Toast.makeText(AddClaimActivity.this, "Add a claim", Toast.LENGTH_SHORT).show();
				ListController controller = new ListController();
				EditText den = (EditText) findViewById(R.id.Destination_editText);
				EditText fdate = (EditText) findViewById(R.id.From_editText);
				EditText tdate = (EditText) findViewById(R.id.To_editText);
				EditText des = (EditText) findViewById(R.id.Descriptions_editText);
				Spinner status = (Spinner) findViewById(R.id.st_spinner);
				String st = status.getSelectedItem().toString();
				controller.addClaim(new Claim(den.getText().toString(), fdate.getText().toString(), 
						tdate.getText().toString(), des.getText().toString(), st));	
				finish();
			}
		});
		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
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
	
	
//	public void addItem(View v){
//		Toast.makeText(this, "Add A Expenses", Toast.LENGTH_SHORT).show();
//		Intent intent = new Intent(AddClaimActivity .this, List_Expense_Activity.class);
//		startActivity(intent);
//	}
//	
	public void Cancel(View v){
		Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(AddClaimActivity .this, MainActivity.class);
		startActivity(intent);
	}
}
