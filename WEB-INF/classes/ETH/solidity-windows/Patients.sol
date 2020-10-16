pragma solidity >=0.4.22 <0.6.0;
contract UserList {
  string patient_data;
  string doctor_data;
  string patient_record;
  string prescription;
  function createPatient(string memory data) public  {
      patient_data = data;
  }
  function getPatients() public view returns (string memory) {
      return patient_data;
   }
   function createDoctor(string memory data) public  {
      doctor_data = data;
  }
  function getDoctor() public view returns (string memory) {
      return doctor_data;
   }
   function patientRecord(string memory data) public  {
      patient_record = data;
  }
  function getPatientRecord() public view returns (string memory) {
      return patient_record;
   }

   function addPrescription(string memory data) public  {
      prescription = data;
  }
  function getPrescription() public view returns (string memory) {
      return prescription;
   }
}