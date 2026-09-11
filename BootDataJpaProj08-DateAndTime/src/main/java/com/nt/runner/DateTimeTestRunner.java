package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_Date_Time;
import com.nt.service.IEmployeeMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService  service;
	@Override
	public void run(String... args) throws Exception {
		try {
			Employee_Date_Time emp=new Employee_Date_Time("raja","clerk",
					LocalDateTime.of(1990, 10,20,11,34),
					LocalTime.of(17, 45),
					LocalDate.of(2020, 10, 30));

			String result=service.saveEmployee(emp);
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			service.getAllEmployees().forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			service.showEmployeeAgeByDesg("clerk").forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Person Age is::"+service.getAgeByPid(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
