package com.example.assignment1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class List_Expense_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_expense);
		getActionBar().setTitle("List of Expenses");
		
		ListView listView = (ListView) findViewById(R.id.expense_listView);
        Collection<Expense> Expenses = ListController.getExpenseList().getExpense();
        
        final ArrayList<Expense> list = new ArrayList<Expense>(Expenses);
        Collections.sort(list);
        final ArrayAdapter<Expense> ExpenseAdapter = new ArrayAdapter<Expense>(this, 
        		android.R.layout.simple_list_item_1, list);
        listView.setAdapter(ExpenseAdapter);

        ListController.getExpenseList().addListener(new Listener() {
        	public void update() {
        		list.clear();
        		Collection<Expense> Expenses = ListController.getExpenseList().getExpense();
        		list.addAll(Expenses);
        		Collections.sort(list);
        		ExpenseAdapter.notifyDataSetChanged();
        	}
        });
        
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
				AlertDialog.Builder adb = new AlertDialog.Builder(List_Expense_Activity.this);
				adb.setMessage("Edit/Delete "+list.get(position).toString()+"?");
				adb.setCancelable(true);
				adb.setPositiveButton("Delete", new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						AlertDialog.Builder adb2 = new AlertDialog.Builder(List_Expense_Activity.this);
						adb2.setMessage("Delete "+list.get(position).toString()+"?");
						adb2.setCancelable(true);
						final int finalPosition = position;
						adb2.setPositiveButton("Yes", new OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								Expense Expense = list.get(finalPosition);
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
//				adb.setNeutralButton("Edit", new OnClickListener() {
//					public void onClick (DialogInterface dialog, int which) {
//						Intent intent = new Intent(List_Expense_Activity.this, EditExpenseActivity.class);
//						new ExpensePosition(position);
//				    	startActivity(intent);
//					}
//				});
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
//        listView.setOnItemClickListener(new OnItemClickListener() {
//        	@Override
//			public void onItemClick(AdapterView<?> adapterView, View view,int position, long id) {
//				Intent intent = new Intent(MainActivity.this, List_Expense_Activity.class);
//				startActivity(intent);
//			}
//        });
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

}
