package com.example.assignment1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class Claim implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8510597131317856369L;
	
	private String denstation;
	private Date d_from = new Date();
	private Date d_to = new Date();
	private String des;
	private String status;
	SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
	
	protected ArrayList<Expense> ExpenseList;
	ListController controller;
	ExpenseList list;
	
	
	public Claim(String den, String from, String to, String desp, String st) {
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
		this.des=desp;
		this.status = st;
		
		this.ExpenseList = new ArrayList<Expense>();
		this.controller  = new ListController();
		this.list = new ExpenseList();
	}
	
	public ArrayList<Expense> getItemArray() {
		return this.ExpenseList;
	}
	
	public ArrayList<Expense> toArrayList() {
		return getItemArray();
	}
	
	public ListController getController() {
		return this.controller;
	}
	
	public ExpenseList getlist() {
		return this.list;
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
	
	public String getStatus(){
		return status;
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
	
	public String statusString(){
		return getStatus();
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
	
	public String setStatus(String st){
		this.status = st;
		return st;
	}

	public int compareTo(Claim another) {
		return getDFrom().compareTo(another.getDFrom());
	}
}
