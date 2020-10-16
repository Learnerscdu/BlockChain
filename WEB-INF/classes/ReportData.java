package com;
import java.util.ArrayList;
public class ReportData{

	static ArrayList<Reports> list;

public static void setReport(ArrayList<Reports> l){
	list = l;
}

public static ArrayList<Reports> getReport() {
	return list;
}

}