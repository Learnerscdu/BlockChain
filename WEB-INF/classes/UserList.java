package com;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class UserList extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5061069f806100206000396000f3fe608060405234801561001057600080fd5b50600436106100a5576000357c0100000000000000000000000000000000000000000000000000000000900480633aaa5920116100785780633aaa59201461027d5780634c3b9086146102855780638352a5861461028d578063dbaf5de214610333576100a5565b806303d77988146100aa57806312ad1c37146101525780632383c44e146101cf5780633062dcf614610275575b600080fd5b610150600480360360208110156100c057600080fd5b8101906020810181356401000000008111156100db57600080fd5b8201836020820111156100ed57600080fd5b8035906020019184600183028401116401000000008311171561010f57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506103d9945050505050565b005b61015a6103f0565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561019457818101518382015260200161017c565b50505050905090810190601f1680156101c15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610150600480360360208110156101e557600080fd5b81019060208101813564010000000081111561020057600080fd5b82018360208201111561021257600080fd5b8035906020019184600183028401116401000000008311171561023457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610487945050505050565b61015a61049a565b61015a6104f8565b61015a610558565b610150600480360360208110156102a357600080fd5b8101906020810181356401000000008111156102be57600080fd5b8201836020820111156102d057600080fd5b803590602001918460018302840111640100000000831117156102f257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506105b9945050505050565b6101506004803603602081101561034957600080fd5b81019060208101813564010000000081111561036457600080fd5b82018360208201111561037657600080fd5b8035906020019184600183028401116401000000008311171561039857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506105cc945050505050565b80516103ec9060029060208401906105db565b5050565b60008054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281526060939092909183018282801561047c5780601f106104515761010080835404028352916020019161047c565b820191906000526020600020905b81548152906001019060200180831161045f57829003601f168201915b505050505090505b90565b80516103ec9060009060208401906105db565b60028054604080516020601f600019610100600187161502019094168590049384018190048102820181019092528281526060939092909183018282801561047c5780601f106104515761010080835404028352916020019161047c565b60018054604080516020601f6002600019610100878916150201909516949094049384018190048102820181019092528281526060939092909183018282801561047c5780601f106104515761010080835404028352916020019161047c565b60038054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281526060939092909183018282801561047c5780601f106104515761010080835404028352916020019161047c565b80516103ec9060019060208401906105db565b80516103ec9060039060208401905b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061061c57805160ff1916838001178555610649565b82800160010185558215610649579182015b8281111561064957825182559160200191906001019061062e565b50610655929150610659565b5090565b61048491905b80821115610655576000815560010161065f56fea165627a7a72305820493e9cd6f194f2c7b43503468ee18692dc9b7f484b69c3ccab1a49b2f2cdd3400029";

    public static final String FUNC_PATIENTRECORD = "patientRecord";

    public static final String FUNC_GETPATIENTS = "getPatients";

    public static final String FUNC_CREATEPATIENT = "createPatient";

    public static final String FUNC_GETPATIENTRECORD = "getPatientRecord";

    public static final String FUNC_GETDOCTOR = "getDoctor";

    public static final String FUNC_GETPRESCRIPTION = "getPrescription";

    public static final String FUNC_CREATEDOCTOR = "createDoctor";

    public static final String FUNC_ADDPRESCRIPTION = "addPrescription";

    protected UserList(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UserList(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> patientRecord(String data) {
        final Function function = new Function(
                FUNC_PATIENTRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getPatients() {
        final Function function = new Function(FUNC_GETPATIENTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createPatient(String data) {
        final Function function = new Function(
                FUNC_CREATEPATIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getPatientRecord() {
        final Function function = new Function(FUNC_GETPATIENTRECORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getDoctor() {
        final Function function = new Function(FUNC_GETDOCTOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getPrescription() {
        final Function function = new Function(FUNC_GETPRESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createDoctor(String data) {
        final Function function = new Function(
                FUNC_CREATEDOCTOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addPrescription(String data) {
        final Function function = new Function(
                FUNC_ADDPRESCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<UserList> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UserList.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<UserList> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UserList.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static UserList load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserList(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static UserList load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserList(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
