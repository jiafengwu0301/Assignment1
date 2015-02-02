
/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/

package ca.ualberta.jiafeng1.activity;

import java.util.ArrayList;
import java.util.Collection;

import ca.ualberta.jiafeng1.list.Claim;
import ca.ualberta.jiafeng1.list.ListController;
import ca.ualberta.jiafeng1.mod_list.AddClaimActivity;
import ca.ualberta.jiafeng1.mod_list.EditClaimActivity;
import ca.ualberta.jiafeng1.mod_list.Listener;
import ca.ualberta.jiafeng1.mod_list.Position;

import com.example.assignment1.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//This code is modified by reference code from Student Picker
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
	//http://stackoverflow.com/questions/8430805/android-clicking-twice-the-back-button-to-exit-activity 01/31/2015
	private boolean doubleBackToExitPressedOnce = false;
	@Override
	public void onBackPressed(){
		if (doubleBackToExitPressedOnce) {
	        super.onBackPressed();
	        //startActivity(new Intent(MainActivity.this, MainActivity.class));
	        return;
	    }

	    this.doubleBackToExitPressedOnce = true;
	    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

	    new Handler().postDelayed(new Runnable() {

	        @Override
	        public void run() {
	            doubleBackToExitPressedOnce=false;                       
	        }
	    }, 2000);
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
