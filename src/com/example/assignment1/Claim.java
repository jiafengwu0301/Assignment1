package com.example.assignment1;

public class Claim {
	
	private String denstation;
	private String d_from;
	private String d_to;
	private String des;
	
	public String getDenstation(){
		return denstation;
	}
	
	public String getDFrom(){
		return d_from;
	}
	
	public String getDTo(){
		return d_to;
	}
	
	public String getDes(){
		return des;
	}
	
	public void setDenstation(String denstation){
		this.denstation=denstation;
	}
	
	public void setDfrom(String d_from){
		this.d_from=d_from;
	}
	
	public void setDTo(String d_to){
		this.d_to=d_to;
	}
	
	public void setDes(String des){
		this.des=des;
	}
}
