package com.example.assignment1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Expense implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8408038633806370834L;
	
	
	protected String name;
	protected String item;
	protected Date when = new Date();
	protected float cost;
	protected String curr;
	protected String des;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
	
	public Expense(String na, String it, String wh, float fl ,
			String cu, String de) {
		this.name = na;
		this.item = it;
		try {
			this.when = date.parse(wh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cost = fl;
		this.des = de;
		this.curr = cu;
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

	public float getCost(){
		return cost;
	}
	
	public String getCurr(){
		return curr;
	}
	
	public String getDescription(){
		return des;
	}
	
	public String toString() {
		return getName();
	}

	public String toItem() {
		return getItem();
	}

	public Date toWhen() {
		return getWhen();
	}
	
	public float toCost(){
		return getCost();
	}
	
	public String toCurr(){
		return getCurr();
	}

	public String toDescription() {
		return getDescription();
	}
	
	public String setName(String name){
		this.name=name;
		return name;
	}
	
	public String setItem(String cate){
		this.item=cate;
		return cate;
	}
	
	public Date setWhen(Date when){
		this.when=when;
		return when;
	}
	
	public float setCost(float cost){
		this.cost = cost;
		return cost;
	}
	
	public String setCurr(String curr){
		this.curr = curr;
		return curr;
	}
	
	public String setDescription(String des){
		this.des = des;
		return des;
	}
}
