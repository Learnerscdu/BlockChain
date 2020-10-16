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

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        new Application().run();
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


        // Now lets deploy a smart contract
        /*System.out.println("Deploying smart contract");
        HelloWorld contract = HelloWorld.deploy(web3j, credentials,ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();

        String contractAddress = contract.getContractAddress();
        System.out.println("Smart contract deployed to address " + contractAddress);

        System.out.println("Initial value of counter in Smart contract: " + contract.getCounter().send());
        System.out.println("Incrementing counter in Smart contract");
        contract.add().send();
        System.out.println("Value of counter in Smart contract after increment : " + contract.getCounter().send());
        System.out.println("Decrementing counter in Smart contract");
        contract.subtract().send();*/
        //System.out.println("Final value of counter in Smart contract : " + contract.getCounter().send());
		HelloWorld greeter = HelloWorld.load("0x62f41a1140187d7de21e282c1a7d251f6c85a28b", web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		greeter.add().send();
		System.out.println("Initial value of counter in Smart contract: " + greeter.getCounter().send());
        
	}
}