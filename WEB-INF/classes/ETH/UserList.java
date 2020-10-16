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
    private static final String BINARY = "608060405234801561001057600080fd5b50610556806100206000396000f3fe608060405234801561001057600080fd5b506004361061007e577c0100000000000000000000000000000000000000000000000000000000600035046303d77988811461008357806312ad1c371461012b5780632383c44e146101a85780633062dcf61461024e5780633aaa5920146102565780638352a5861461025e575b600080fd5b6101296004803603602081101561009957600080fd5b8101906020810181356401000000008111156100b457600080fd5b8201836020820111156100c657600080fd5b803590602001918460018302840111640100000000831117156100e857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610304945050505050565b005b61013361031b565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561016d578181015183820152602001610155565b50505050905090810190601f16801561019a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610129600480360360208110156101be57600080fd5b8101906020810181356401000000008111156101d957600080fd5b8201836020820111156101eb57600080fd5b8035906020019184600183028401116401000000008311171561020d57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506103b2945050505050565b6101336103c5565b610133610423565b6101296004803603602081101561027457600080fd5b81019060208101813564010000000081111561028f57600080fd5b8201836020820111156102a157600080fd5b803590602001918460018302840111640100000000831117156102c357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610483945050505050565b8051610317906002906020840190610492565b5050565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156103a75780601f1061037c576101008083540402835291602001916103a7565b820191906000526020600020905b81548152906001019060200180831161038a57829003601f168201915b505050505090505b90565b8051610317906000906020840190610492565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156103a75780601f1061037c576101008083540402835291602001916103a7565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156103a75780601f1061037c576101008083540402835291602001916103a7565b80516103179060019060208401905b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106104d357805160ff1916838001178555610500565b82800160010185558215610500579182015b828111156105005782518255916020019190600101906104e5565b5061050c929150610510565b5090565b6103af91905b8082111561050c576000815560010161051656fea165627a7a723058204169a042b7a4e8a3cb03a1b972e5ef0928cf12ec6512894aff6945eb7c69797a0029";

    public static final String FUNC_PATIENTRECORD = "patientRecord";

    public static final String FUNC_GETPATIENTS = "getPatients";

    public static final String FUNC_CREATEPATIENT = "createPatient";

    public static final String FUNC_GETPATIENTRECORD = "getPatientRecord";

    public static final String FUNC_GETDOCTOR = "getDoctor";

    public static final String FUNC_CREATEDOCTOR = "createDoctor";

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

    public RemoteCall<TransactionReceipt> createDoctor(String data) {
        final Function function = new Function(
                FUNC_CREATEDOCTOR, 
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
