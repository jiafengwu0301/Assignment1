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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditClaimActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super .onCreate(savedInstanceState);
		setContentView(R.layout.edit_claim);
		getActionBar().setTitle("Edit Claim");

		Collection<Claim> claim = ListController.getClaimList().getClaim();
		ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
		int claimpos = Position.getPosition();
		EditText den = (EditText) findViewById(R.id.edit_Destination_textView);
		EditText fdate = (EditText) findViewById(R.id.from_edit_editText);
		EditText tdate = (EditText) findViewById(R.id.to_edit_editText);
		EditText des = (EditText) findViewById(R.id.edit_Description);
		Spinner status = (Spinner) findViewById(R.id.ed_st_spinner);
		status.setSelection(getIndex(status, claimlist.get(claimpos).statusString()));
		
		
		den.setText(claimlist.get(claimpos).toString());
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
		fdate.setText(date.format(claimlist.get(claimpos).fdateString()));
		tdate.setText(date.format(claimlist.get(claimpos).tdateString()));
		des.setText(claimlist.get(claimpos).desString());
		
		Button editbutton = (Button) findViewById(R.id.edit_button);
		editbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(EditClaimActivity.this, "Update a claim", Toast.LENGTH_SHORT).show();
				EditText den = (EditText) findViewById(R.id.edit_Destination_textView);
				EditText fdate = (EditText) findViewById(R.id.from_edit_editText);
				EditText tdate = (EditText) findViewById(R.id.to_edit_editText);
				EditText des = (EditText) findViewById(R.id.edit_Description);
				Spinner status = (Spinner) findViewById(R.id.ed_st_spinner);
				String st = status.getSelectedItem().toString();
				
				Collection<Claim> claim = ListController.getClaimList().getClaim();
				ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
				int claimpos = Position.getPosition();
				claimlist.get(claimpos).setDenstation(den.getText().toString());
				
				SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
				try {
					claimlist.get(claimpos).setDfrom(date.parse(fdate.getText().toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					claimlist.get(claimpos).setDTo(date.parse(tdate.getText().toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				claimlist.get(claimpos).setDes(des.getText().toString());
				claimlist.get(claimpos).setStatus(st);
				ListController controller = new ListController();
				controller.editClaim();
				finish();

			}
			
		});
	}
	
	public void editCancel(View v){
		Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(EditClaimActivity .this, MainActivity.class);
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


