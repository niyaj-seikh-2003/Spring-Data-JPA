package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Component
public class H2InMemoryDBRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			JobSeeker js1=new JobSeeker();
			js1.setJsName("Niyaj");js1.setJsAddrs("hyd");
			js1.setQlfy("Bsc");js1.setExpectedSalary(70000.0);
			
			JobSeeker js2=new JobSeeker();
			js2.setJsName("Padma");js2.setJsAddrs("odi");
			js2.setQlfy("MSc");js2.setExpectedSalary(75000.0);
			
			JobSeeker js11=new JobSeeker();
			js11.setJsName("Hemant");js11.setJsAddrs("blr");
			js11.setQlfy("B tech");js11.setExpectedSalary(80000.0);
			
			
			String msg=service.registerJObSeekAsGroup(List.of(js1,js2,js11));
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("====================================================");
		service.showAllJobSeekrs().forEach(System.out::println);

		System.out.println("====================================================");
		System.out.println("1 id job seeker details::"+service.findJsById(1));
	}

}
