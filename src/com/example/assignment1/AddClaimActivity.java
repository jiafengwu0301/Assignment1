package com.example.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AddClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claim);
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
	
	public void addExpense(MenuItem menu){
		Toast.makeText(this, "Add Expenses", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(AddClaimActivity .this, AddExpenseActivity.class);
		startActivity(intent);
	}
	
	public void addItem(View v){
		Toast.makeText(this, "Add A Expenses", Toast.LENGTH_SHORT).show();
		
	}
	
	public void Cancel(View v){
		Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(AddClaimActivity .this, MainActivity.class);
		startActivity(intent);
	}
	
}
