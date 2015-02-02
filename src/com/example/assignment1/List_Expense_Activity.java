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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

//This code is modified by reference code from Student Picker

public class List_Expense_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_expense);
		getActionBar().setTitle("List of Expenses");
		
		ListView listView = (ListView) findViewById(R.id.expense_listView);
        
		int setposition = Position.getPosition();
        Collection<Claim> claim = ListController.getClaimList().getClaim();
		ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);

        final ArrayList<Expense> expense = claimlist.get(setposition).getItemArray();
        final ArrayAdapter<Expense> expenseAdapter = new ArrayAdapter<Expense>(this, 
        		android.R.layout.simple_list_item_1, expense);
        listView.setAdapter(expenseAdapter);
        
        
        ListController.getExpenseList().addListener(new Listener() {
        	public void update() {
        		expense.clear();
        		Collection<Expense> items = ListController.getExpenseList().getExpense();
        		expense.addAll(items);
        		expenseAdapter.notifyDataSetChanged();
        	}
        });
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
				AlertDialog.Builder adb = new AlertDialog.Builder(List_Expense_Activity.this);
				adb.setMessage("Edit/Delete "+expense.get(position).toString()+"?");
				adb.setCancelable(true);
				adb.setPositiveButton("Delete", new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						AlertDialog.Builder adb2 = new AlertDialog.Builder(List_Expense_Activity.this);
						adb2.setMessage("Delete "+expense.get(position).toString()+"?");
						adb2.setCancelable(true);
						final int finalPosition = position;
						adb2.setPositiveButton("Yes", new OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								Expense Expense = expense.get(finalPosition);
								ListController.getExpenseList().deleteExpense(Expense);
							}
						});
						adb2.setNegativeButton("No", new OnClickListener() {
							public void onClick (DialogInterface dialog, int which) {
							}
						});
						adb2.show();
					}
				});
				adb.setNeutralButton("Edit", new OnClickListener() {
					public void onClick (DialogInterface dialog, int which) {
						Intent intent = new Intent(List_Expense_Activity.this, EditExpenseActivity.class);
						new Position(position);
				    	startActivity(intent);
					}
				});
				adb.setNegativeButton("Cancel", new OnClickListener() {
					public void onClick (DialogInterface dialog, int which) {
						Intent intent = new Intent(List_Expense_Activity.this, List_Expense_Activity.class);
						new Position(position);
				    	startActivity(intent);
					}
				});
				adb.show();
				return false;
			}
		});
	}

	@Override
	public void onBackPressed(){
	    super.onBackPressed(); 
	    startActivity(new Intent(List_Expense_Activity.this, MainActivity.class));
	    finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_expense, menu);
		return true;
	}
	
	public void addExpense(MenuItem menu){
		Toast.makeText(this, "Add A Expenses", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(List_Expense_Activity .this,AddExpenseActivity.class);
		startActivity(intent);
	}
	
	public void email(MenuItem menu){
		Toast.makeText(this, "Email Claim", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(List_Expense_Activity .this,EmailClaim.class);
		startActivity(intent);
	}
	
	public void summary(View v){
		Toast.makeText(this, "Show Summary", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(List_Expense_Activity .this,ClaimSummary.class);
		startActivity(intent);
	}

}
