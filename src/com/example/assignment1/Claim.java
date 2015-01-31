package com.example.assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Claim implements Comparable<Claim>{
	
	private String denstation;
	private Date d_from = new Date();
	private Date d_to = new Date();
	private String des;
	SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
	
	
	public Claim(String den, String from, String to, String desp) {
		this.denstation = den;
		try {
			this.d_from = date.parse(from);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.d_to = date.parse(to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getDenstation(){
		return denstation;
	}
	
	public Date getDFrom(){
		return d_from;
	}
	
	public Date getDTo(){
		return d_to;
	}
	
	public String getDes(){
		return des;
	}
	
	public String toString() {
		return getDenstation();
	}
	
	// used to get the start date of the claim
	public Date fdateString() {
		return getDFrom();
	}
	
	// used to get the end date of the claim
	public Date tdateString() {
		return getDTo();
	}
	
	// used to get the details of the claim
	public String desString() {
		return getDes();
	}
	
	public String setDenstation(String denstation){
		this.denstation=denstation;
		return denstation;
	}
	
	public Date setDfrom(Date d_from){
		this.d_from=d_from;
		return d_from;
	}
	
	public Date setDTo(Date d_to){
		this.d_to=d_to;
		return d_to;
	}
	
	public String setDes(String des){
		this.des=des;
		return des;
	}

	public int compareTo(Claim another) {
		return getDFrom().compareTo(another.getDFrom());
	}
}
