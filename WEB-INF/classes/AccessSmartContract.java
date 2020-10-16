package com;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.protocol.core.RemoteCall;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
public class AccessSmartContract {
    public static Web3j web3j;
	public static Credentials credentials;
	public static String address;
public static void setup() {
	try{
		if(web3j == null){
			web3j = Web3j.build(new HttpService());
			credentials = WalletUtils.loadCredentials("blockchain","C:/ETH/data-private/keystore/UTC--2020-01-22T04-33-13.998428700Z--b6ecc4bfac92a1d5fc1aad218bcb7dd6814c90a9");
            TransactionReceipt transferReceipt = Transfer.sendFunds(web3j, credentials,"0xb6ecc4bfac92a1d5fc1aad218bcb7dd6814c90a9", BigDecimal.valueOf(100), Convert.Unit.ETHER).sendAsync().get();
			BufferedReader br = new BufferedReader(new FileReader(Path.getPath()));
			address = br.readLine();
			address = address.trim();
			br.close();
			System.out.println("Transaction complete : "+ transferReceipt.getTransactionHash()+" "+address);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}
public static String getDoctor(){
	String result = "none";
	try{
		setup();
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String doctor = ul.getDoctor().send();
		String arr[] = doctor.split("#");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			String ar[] = arr[i].split(",");
			sb.append(ar[0]+" ");
		}
		result = sb.toString().trim();
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}

public static String getPatients(){
	String result = "none";
	try{
		StringBuilder sb = new StringBuilder();
		setup();
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String data = ul.getPatientRecord().send();
		String arr[] = data.split("#");
		for(int i=0;i<arr.length;i++){
			String ar[] = arr[i].split(",");
			sb.append(ar[0]+"#");
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length()-1);
		}
		result = sb.toString().trim();

	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}

public static String login(String user,String pass,String type){
	String result = "none";
	try{
		setup();
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		if(type.equals("Data Owner")){
			String patient = ul.getPatients().send();
			System.out.println(patient);
			String arr[] = patient.split("#");
			for(int i=0;i<arr.length;i++){
				String ar[] = arr[i].split(",");
				if(ar[0].equals(user) && ar[1].equals(pass)){
					result = ar[2];
					break;
				}
			}
		}
		if(type.equals("Physician")){
			String doctor = ul.getDoctor().send();
			String arr[] = doctor.split("#");
			for(int i=0;i<arr.length;i++){
				String ar[] = arr[i].split(",");
				if(ar[0].equals(user) && ar[1].equals(pass)){
					result = ar[2];
					break;
				}
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}
public static String getPrescription(String user){
	String result = "none";
	try{
		StringBuilder sb = new StringBuilder();
		setup();
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String data = ul.getPrescription().send();
		String arr[] = data.split("#");
		for(int i=0;i<arr.length;i++){
			String ar[] = arr[i].split(",");
			if(ar[1].equals(user)){
				sb.append(arr[i]+"#");
			}
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length()-1);
		}
		result = sb.toString().trim();

	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}

public static String addPrescription(String doctor,String patient,String prescription){
	String result = "none";
	try{
		setup();
		StringBuilder sb = new StringBuilder();
		System.out.println("Address "+address);
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String data = ul.getPatientRecord().send();
		String arr[] = data.split("#");
		for(int i=0;i<arr.length;i++){
			String ar[] = arr[i].split(",");
			if(ar[0].equals(patient) && ar[3].equals("pending")){
				sb.append(ar[0]+","+ar[1]+","+ar[3]+","+prescription+"#");
			} else {
				sb.append(arr[i]+"#");
			}
		}
		if(sb.length() > 0)
			sb.deleteCharAt(sb.length()-1);
		ul.patientRecord(sb.toString().trim()).send();
		result = "success";
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}

public static String createRecord(String user,String pass,String type,String contact,String email,String patient_address){
	String result = "none";
	try{
		setup();
		System.out.println("Address "+address);
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		if(type.equals("Data Owner")){
			String patient = ul.getPatients().send();
			if(patient.length() > 0)
				patient = patient+"#"+user+","+pass+","+type+","+contact+","+email+","+patient_address;
			else
				patient = user+","+pass+","+type+","+contact+","+email+","+patient_address;
			ul.createPatient(patient).send();
		}
		if(type.equals("Physician")){
			String doctor = ul.getDoctor().send();
			if(doctor.length() > 0)
				doctor = doctor+"#"+user+","+pass+","+type+","+contact+","+email+","+patient_address;
			else
				doctor = user+","+pass+","+type+","+contact+","+email+","+patient_address;
			ul.createDoctor(doctor).send();
		}
		result = "success";
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}


public static String access(String user,String access,String problem,String status){
	String result = "none";
	try{
		setup();
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String data = ul.getPatientRecord().send();
		if(data.length() > 0){
			data = data+"#"+user+","+access+","+problem+","+status;
		}else{
			data = user+","+access+","+problem+","+status;
		}
		ul.patientRecord(data).send();
		result = "success";
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}
public static String getAccess(String user){
	String result = "none";
	try{
		StringBuilder sb = new StringBuilder();
		setup();
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String data = ul.getPatientRecord().send();
		String arr[] = data.split("#");
		for(int i=0;i<arr.length;i++){
			String ar[] = arr[i].split(",");
			String temp[] = ar[1].split("\\s+");
			for(int j=0;j<temp.length;j++){
				if(temp[j].equals(user)){
					sb.append(arr[i]+"#");
				}
			}
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length()-1);
		}
		result = sb.toString().trim();

	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}


public static String ownerAccess(String user){
	String result = "none";
	try{
		StringBuilder sb = new StringBuilder();
		setup();
        UserList ul = UserList.load(address, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String data = ul.getPatientRecord().send();
		String arr[] = data.split("#");
		for(int i=0;i<arr.length;i++){
			String ar[] = arr[i].split(",");
			if(ar[0].equals(user)){
				sb.append(arr[i]+"#");
			}
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length()-1);
		}
		result = sb.toString().trim();

	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}
}