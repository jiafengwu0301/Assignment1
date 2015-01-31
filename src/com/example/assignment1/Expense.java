package com.example.assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Expense implements Comparable<Expense>{
	private String name;
	private String item;
	private Date when = new Date();
	private String des;
	private float cost;
	private String curr;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
	
	
	public Expense(String name, String item, String when, float cost, String currency,String des) {
		this.name = name;
		this.item = item;
		try {
			this.when = date.parse(when);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cost=cost;
		this.curr=currency;
		this.des = des;
	}
	
	public String getName(){
		return name;
	}
	
	public String getItem(){
		return item;
	}
	
	public Date getWhen(){
		return when;
	}
	
	public String getDescription(){
		return des;
	}
	public float getCost(){
		return cost;
	}
	
	public String getCurr(){
		return curr;
	}
	
	public String toName() {
		return getName();
	}

	public String toItem() {
		return getItem();
	}

	public Date toWhen() {
		return getWhen();
	}
	
	public String toDescription() {
		return getDescription();
	}
	
	public float toCost(){
		return getCost();
	}
	
	public String toCurr(){
		return getCurr();
	}
	
	public String setName(String name){
		this.name=name;
		return name;
	}
	
	public Date setWhen(Date when){
		this.when=when;
		return when;
	}

	public String setDescription(String des){
		this.des = des;
		return des;
	}
	
	public float setCost(float cost){
		this.cost = cost;
		return cost;
	}
	
	public String setCurr(String curr){
		this.curr = curr;
		return curr;
	}

	public int compareTo(Expense another) {
		return getWhen().compareTo(another.getWhen());
	}
}
