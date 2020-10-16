package com;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.parity.methods.response.ParityExportAccount;
import org.web3j.protocol.parity.methods.response.ParityTracesResponse;
import org.web3j.protocol.parity.methods.response.Trace;

import java.util.List;

public class Web3JClient {
    private static Web3jService service = new HttpService("http://127.0.0.1:8545"); // put fullnode url here
    private static Web3j web3j = Web3j.build(service);
    private static Parity parity = Parity.build(service);

    public static List<Trace> getCallActionsInBlock(long blockNum) throws Exception {
        DefaultBlockParameterNumber number = new DefaultBlockParameterNumber(blockNum);
        Request<?, ParityTracesResponse> request = parity.traceBlock(number);
        ParityTracesResponse response = request.send();
        return response.getTraces();
    }

    public static List<Trace> getCallAction(String hash) throws Exception {
        Request<?, ParityTracesResponse> request = parity.traceTransaction(hash);
        ParityTracesResponse response = request.send();
        return response.getTraces();
    }

    public static WalletFile exportAccount(String address, String password) throws Exception {
        Request<?, ParityExportAccount> request = parity.parityExportAccount(address, password);
        ParityExportAccount response = request.send();
        return response.getWallet();
    }

    public static void main(String[] args) throws Exception {
		System.out.println(exportAccount("0x11d0e518e08758714826bd6f3096661aa560d6ed","kaleem"));
// test function here
    }
}