package com.springservice.domain;

public class User {

String EmployeeID;
String Name;
String EmployeeCode;
String Address;
String deleteFlag;

public String getDeleteFlag() {
	return deleteFlag;
}
public void setDeleteFlag(String deleteFlag) {
	this.deleteFlag = deleteFlag;
}
public String getEmployeeID() {
	return EmployeeID;
}
public void setEmployeeID(String employeeID) {
	EmployeeID = employeeID;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmployeeCode() {
	return EmployeeCode;
}
public void setEmployeeCode(String employeeCode) {
	EmployeeCode = employeeCode;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
@Override
public String toString() {
	return "User [EmployeeID=" + EmployeeID + ", Name=" + Name
			+ ", EmployeeCode=" + EmployeeCode + ", Address=" + Address + "]";
}

		
}

