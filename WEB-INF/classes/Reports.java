package com;
import java.io.Serializable;
import java.util.Date;
public class Reports implements Serializable{
	String patient;
	Date date;
	String reportname;
	byte data[];
public void setPatient(String patient){
	this.patient = patient;
}
public String getPatient(){
	return patient;
}
public void setDate(Date date){
	this.date = date;
}
public Date getDate(){
	return date;
}
public void setReportname(String reportname){
	this.reportname = reportname;
}
public String getReportname(){
	return reportname;
}
public void setData(byte data[]){
	this.data = data;
}
public byte[] getData(){
	return data;
}
}