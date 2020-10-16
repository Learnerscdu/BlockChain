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
public class test {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        new test().run();
    }

    private void run() throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        Web3j web3j = Web3j.build(new HttpService());
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "kaleem",
                        "C:/ETH/data-private/keystore/UTC--2019-02-19T11-28-28.439083600Z--5eff9771abebc594013cf160c49b1ddd4bf578ae");
        log.info("Credentials loaded");
        log.info("Sending Ether ..");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                "0x5eff9771abebc594013cf160c49b1ddd4bf578ae",  // you can put any address here
                BigDecimal.valueOf(100), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .sendAsync().get();
        System.out.println("Transaction complete : "
                + transferReceipt.getTransactionHash());


       
        System.out.println("Deploying smart contract");
        UserList contract = UserList.deploy(web3j, credentials,ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();

        //String contractAddress = contract.getContractAddress();
        //System.out.println("Smart contract deployed to address " + contractAddress);
		//contract.createPatient("1,kaleem,kaleem.mmd@gmail.com").send();

       /* UserList greeter = UserList.load("0x451af2482318dc85a2184a660ea39cdf4fef11e5", web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String patient = greeter.getPatients().send();
		String doctor = greeter.getDoctor().send();
		String records = greeter.getPatientRecord().send();
		if(patient.length() > 0){
			patient = patient+"#"+"2,raheem,raheem.mmd@gmail.com";
		} else {
			patient = "1,kaleem,kaleem.mmd@gmail.com";
		}
		greeter.createPatient(patient).send();
		patient = greeter.getPatients().send();
		System.out.println("Initial value of counter in Smart contract: " + patient+" "+doctor+" "+records);
        */
	}
}