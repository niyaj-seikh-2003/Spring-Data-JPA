package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee_Date_Time;

public interface EmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time,Integer> 
{
	@Query(nativeQuery = true,value = "SELECT YEAR(CURRENT_TIMESTAMP)-YEAR(DOB)FROM EMP_DATE_TIME WHERE DESG=:job")
	public List<Integer> getEmployeeAgeByDesg(String job);
	
	@Query(value = "SELECT (DATEDIFF(CURDATE(), dob) / 365.25) " +
            "FROM EMP_DATE_TIME WHERE eno = :id",
    nativeQuery = true)
public float calculateAgeByPid(int id);
	
}
