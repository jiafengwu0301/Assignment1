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
	
	// We only enter this class when the user wants to update his/her claim
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super .onCreate(savedInstanceState);
		// set up our layout to be edit_claim
		setContentView(R.layout.edit_claim);
		getActionBar().setTitle("Edit Claim");

		Collection<Claim> claim = ListController.getClaimList().getClaim();
		ArrayList<Claim> list = new ArrayList<Claim>(claim);
		int setposition = Position.getPosition();
		EditText den = (EditText) findViewById(R.id.edit_Destination_textView);
		EditText fdate = (EditText) findViewById(R.id.from_edit_editText);
		EditText tdate = (EditText) findViewById(R.id.to_edit_editText);
		EditText des = (EditText) findViewById(R.id.edit_Description);
		Spinner status = (Spinner) findViewById(R.id.ed_st_spinner);
		status.setSelection(getIndex(status, list.get(setposition).statusString()));
		
		
		den.setText(list.get(setposition).toString());
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
		fdate.setText(date.format(list.get(setposition).fdateString()));
		tdate.setText(date.format(list.get(setposition).tdateString()));
		des.setText(list.get(setposition).desString());
		
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
				
				Collection<Claim> claims = ListController.getClaimList().getClaim();
				ArrayList<Claim> list = new ArrayList<Claim>(claims);
				int setposition = Position.getPosition();
				((Claim) list.get(setposition)).setDenstation(den.getText().toString());
				
				SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
				try {
					((Claim) list.get(setposition)).setDfrom(date.parse(fdate.getText().toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					((Claim) list.get(setposition)).setDTo(date.parse(tdate.getText().toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				((Claim) list.get(setposition)).setDes(des.getText().toString());
				list.get(setposition).setStatus(st);
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


