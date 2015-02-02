/*
Expense Tracker: record the expense Copyright (C) 2015 Jiafeng Wu jiafeng1@ualberta.ca

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see http://www.gnu.org/licenses/.
*/
package ca.ualberta.jiafeng1.list;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

//This code is modified by reference code from Student Picker
public class Claim implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8510597131317856369L;
	
	protected String denstation;
	protected Date d_from = new Date();
	protected Date d_to = new Date();
	protected String des;
	protected String status;
	SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
	
	protected ArrayList<Expense> ExpenseList;
	ListController controller;
	ExpenseList expenselist;
	
	
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
		this.expenselist = new ExpenseList();
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
		return this.expenselist;
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
	
	public Date fdateString() {
		return getDFrom();
	}
	
	public Date tdateString() {
		return getDTo();
	}
	
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
