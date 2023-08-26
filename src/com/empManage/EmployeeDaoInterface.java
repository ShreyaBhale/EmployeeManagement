package com.empManage;

public interface EmployeeDaoInterface {
	
	//create employee
	public void createEmployee(Employee emp);
	
	//show all
	public void showEmployee();
	
	//show based on id
	public void showEmployeeBasedonID(int id);
	
	//update
	public void updateEmployee(int id, String name);
	
	//delete
	public void deleteEmployee(int id);
}
