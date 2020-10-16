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
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
public class deploy {
    private static final Logger log = LoggerFactory.getLogger(deploy.class);

    public static void main(String[] args) throws Exception {
        new deploy().run();
    }

    private void run() throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        Web3j web3j = Web3j.build(new HttpService());
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "blockchain",
                        "C:/ETH/data-private/keystore/UTC--2020-01-22T04-33-13.998428700Z--b6ecc4bfac92a1d5fc1aad218bcb7dd6814c90a9");
        log.info("Credentials loaded");
        log.info("Sending Ether ..");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                "0xb6ecc4bfac92a1d5fc1aad218bcb7dd6814c90a9",  // you can put any address here
                BigDecimal.valueOf(100), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .sendAsync().get();
        System.out.println("Transaction complete : "
                + transferReceipt.getTransactionHash());


        // Now lets deploy a smart contract
        System.out.println("Deploying smart contract");
        UserList contract = UserList.deploy(web3j, credentials,ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();

        String contractAddress = contract.getContractAddress();
        System.out.println("Smart contract deployed to address " + contractAddress);
		contract.createPatient("1,a,a.mmd@gmail.com").send();
		FileWriter fw = new FileWriter("address.txt");
		fw.write(contractAddress);
		fw.close();
		BufferedReader br = new BufferedReader(new FileReader("address.txt"));
		contractAddress = br.readLine();
		br.close();
        UserList greeter = UserList.load(contractAddress, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String patient = greeter.getPatients().send();
		String doctor = greeter.getDoctor().send();
		String records = greeter.getPatientRecord().send();
		if(patient.length() > 0){
			patient = patient+"#"+"2,b,b@gmail.com";
		} else {
			patient = "1,a,a@gmail.com";
		}
		greeter.createPatient(patient).send();
		patient = greeter.getPatients().send();
		System.out.println("Initial value of counter in Smart contract: " + patient+" "+doctor+" "+records);
        
	}
}