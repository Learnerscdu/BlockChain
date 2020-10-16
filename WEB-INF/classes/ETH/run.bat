geth var _greeting = "Hello World!"
pause
geth --datadir /root/datadir/ --networkid 1234 --port 30303 --rpcport 8545 --rpc --rpcapi eth,web3,personal,net --rpcaddr 0.0.0.0 console
admin.nodeInfo.enode



https://ethereum.stackexchange.com/questions/566/how-to-write-my-first-solidity-hello-world-smart-contract
https://ethereum.org/greeter

personal.unlockAccount(eth.accounts[0], 'erum', 0)

address = 0x5945ac16205b4425901a388650d0a94f90d29873

"alloc": {
    "0xb671ec8eca17d38a25126e5dc803d8fe692b5ffb" :
    { "balance": "20000000000" } 
}

geth --dev console
personal.newAccount()
eth.getBalance(eth.accounts[0])
miner.start()
 geth attach
 copy and paste test1.js
 greeter.greet();

 greeter.kill.sendTransaction({from:eth.accounts[0]})

 interact from java
 https://medium.com/coinmonks/how-to-interact-with-smart-contract-using-java-f5b1ce7324e7


 geth --datadir ~/.ethereum_private init ~/dev/genesis.json

geth --cache 512 --ipcpath C:/geth.ipc --networkid 12345 --datadir c:/ethereum_private console 

enode://4b87f525476e6ee444c1a4eae38e8f32fe81ce4f96ae77e0b1dc736a8e6f15acee8f22bd7aae079d3b4ba3e46e870fc4281821003e8818f6caf2adf7211628d8@192.168.22.5:30303"


geth --datadir "C:\ETH\data-private" init "C:\ETH\configs\genesis.json"
geth --networkid 13 --port 60303 --rpc --lightkdf --cache 16 --datadir "C:\ETH\data-private" console
personal.newAccount()
0xb6ecc4bfac92a1d5fc1aad218bcb7dd6814c90a9
personal
admin.nodeInfo.enode
admin.addPeer("enode://39b6231792b186843a368e208a525c9dc79266686cce0d3012cab28db6a5de3b7f57c2d6d026bb44511a7b90c503745f31b1b75b3c4d00539308ca95e764c898@192.168.22.5:60303")
exit

geth --identity nodeSOL --nodiscover --networkid 13 --port 60303 --maxpeers 3 --lightkdf --cache 16  --syncmode "fast" --rpc --rpccorsdomain "*" --datadir "C:\ETH\data-private" --minerthreads 1  --mine
geth --identity nodeSOL --nodiscover --networkid 13 --port 30303 --maxpeers 10 --lightkdf --cache 16  --syncmode "fast" --rpc --rpccorsdomain "*" --datadir "C:\ETH\data-private" --etherbase "0xb6ecc4bfac92a1d5fc1aad218bcb7dd6814c90a9" --minerthreads 1  --mine
after running above command

open another console as administrator
and tyype below command
geth --ipcpath geth.ipc --datadir "C:\ETH\data-private" attach ipc:\\.\pipe\geth.ipc
then type below command
loadScript("test1.js");
type below if authenticaton needed
personal.unlockAccount(eth.accounts[0], 'offenburg', 0)
greeter.greet()
https://medium.com/@solangegueiros/https-medium-com-solangegueiros-setting-up-ethereum-private-network-on-windows-a72ec59f2198

to compile sol file
C:\Users\user\Desktop\phase1\ETH\solidity-windows>solc greeter.sol --bin --abi --optimize -o out
to generate java class
C:\Users\user\Desktop\phase1\ETH\web3j-3.5.0\web3j-3.5.0\bin>web3j solidity generate out/Greeter.bin out/Greeter.abi -o out -p com.Greeter


url for java code to deplay and get
https://blog.jayway.com/2017/08/23/interacting-with-ethereum-smart-contracts-from-android/