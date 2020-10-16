pragma solidity >=0.4.22 <0.6.0;
contract HelloWorld {
   uint256 counter = 5;
   
   function add() public {  //increases counter by 1
       counter++;
   }
 
   function subtract() public { //decreases counter by 1
       counter--;
   }
   
   function getCounter() public view returns (uint256) {
       return counter;
   } 

}