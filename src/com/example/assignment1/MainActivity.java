package com.example.assignment1;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setTitle("Travel Expense Tracker");
		ListView listView = (ListView) findViewById(R.id.Expense_View);
        Collection<Claim> claims = ListController.getClaimList().getClaim();
        
        final ArrayList<Claim> list = new ArrayList<Claim>(claims);
        final ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, 
        		android.R.layout.simple_list_item_1, list);
        listView.setAdapter(claimAdapter);

        ListController.getClaimList().addListener(new Listener() {
        	public void update() {
        		list.clear();
        		Collection<Claim> claims = ListController.getClaimList().getClaim();
        		list.addAll(claims);
        		claimAdapter.notifyDataSetChanged();
        	}
        });
        
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
				AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
				adb.setMessage("Edit/Delete "+list.get(position).toString()+"?");
				adb.setCancelable(true);
				adb.setPositiveButton("Delete", new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						AlertDialog.Builder adb2 = new AlertDialog.Builder(MainActivity.this);
						adb2.setMessage("Delete "+list.get(position).toString()+"?");
						adb2.setCancelable(true);
						final int finalPosition = position;
						adb2.setPositiveButton("Yes", new OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								Claim claim = list.get(finalPosition);
								ListController.getClaimList().deleteClaim(claim);
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
						Intent intent = new Intent(MainActivity.this, EditClaimActivity.class);
						new Position(position);
				    	startActivity(intent);
					}
				});
				adb.setNegativeButton("Cancel", new OnClickListener() {
					public void onClick (DialogInterface dialog, int which) {
						Intent intent = new Intent(MainActivity.this, MainActivity.class);
						new Position(position);
				    	startActivity(intent);
					}
				});
				adb.show();
				return false;
				}
			});
        listView.setOnItemClickListener(new OnItemClickListener() {
        	@Override
			public void onItemClick(AdapterView<?> adapterView, View view,int position, long id) {
				Intent intent = new Intent(MainActivity.this, List_Expense_Activity.class);
				startActivity(intent);
			}
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addClaim(MenuItem menu){
		Toast.makeText(this, "Add Claim", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity .this, AddClaimActivity.class);
		startActivity(intent);
	}
	
}
