pragma solidity >=0.4.22 <0.6.0;
contract PatientRecord {
  
  string patient_record;
  
  function patientRecord(string memory data) public  {
      patient_record = data;
  }
  function getPatientRecord() public view returns (string memory) {
      return patient_record;
   }
}