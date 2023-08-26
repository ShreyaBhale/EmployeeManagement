package com.empManage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String name;
		int empid;
		// TODO Auto-generated method stub
		EmployeeDaoInterface e = new EmployeeDaoImp();
		System.out.println("Welcome to Employee Management");
		
		do {
			System.out.println("1. Add Employee \n2. Show all Employees \n3. Show Employee based on id \n4. Update the employee \n5. Delete the employee");
			
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter id:  ");
				int id = sc.nextInt();
				
				System.out.println("Enter user name: ");
				name = sc.next();
				
				System.out.println("Enter salary");
				double salary = sc.nextDouble();
				
				System.out.println("Enter age: ");
				int age = sc.nextInt();
				
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				
				e.createEmployee(emp);
				break;
				
			case 2:
				e.showEmployee();
				break;
				
			case 3:
				System.out.println("Enter id:");
				empid = sc.nextInt();
				e.showEmployeeBasedonID(empid);
				break;
				
			case 4:
				System.out.println("Enter id:");
				empid = sc.nextInt();
				name = sc.next();
				e.updateEmployee(empid, name);
				break;
				
			case 5:
				System.out.println("Enter id:");
				empid = sc.nextInt();
				e.deleteEmployee(empid);
				break;
				
			case 6:
				System.out.println("thnks");
				System.exit(0);
			default:
				System.out.println("Enter valid choice");
				break;
			}
		}while(true);
	}

}
