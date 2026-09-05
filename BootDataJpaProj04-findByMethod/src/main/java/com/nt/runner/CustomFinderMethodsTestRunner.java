package com.nt.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Hospital;
import com.nt.repository.IHospitalRepository;

@Component
public class CustomFinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private  IHospitalRepository hsRepo;

	@Override
	public void run(String... args) throws Exception {
		//invoke the b.method
		/*try {
			List<Hospital>  list=hsRepo.findByLocationEquals("hyd");
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		/*	try {
				List<Hospital>  list=hsRepo.readByLocationIs("hyd");
				list.forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			hsRepo.getByLocation("hyd").forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			hsRepo.queryBySizeBetween(100, 700).forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		try {
			/*		hsRepo.findByNameStartingWith("L").forEach(System.out::println);
					System.out.println("--------------");
					hsRepo.findByNameEndingWith("S").forEach(System.out::println);
					System.out.println("--------------");
					hsRepo.findByNameContaining("I").forEach(System.out::println);
			*/
			/*    hsRepo.findByNameLike("L%").forEach(System.out::println);	
			    System.out.println("---------------");
			    hsRepo.findByNameLike("%S").forEach(System.out::println);	
			    System.out.println("---------------");
			    hsRepo.findByNameLike("%I%").forEach(System.out::println);	
			*/
			
			  //hsRepo.findByNameLikeOrderByNameDesc("%I%").forEach(System.out::println);
			
			 //hsRepo.getBySizeBetweenAndLocationIn(300, 700, List.of("hyd","delhi")).forEach(System.out::println);
			
			//  hsRepo.findByLocationOrNameIn("hyd", "JIMS","LIMS").forEach(System.out::println);
			  
			/*  Optional<Hospital> opt=hsRepo.findByName("JIMSS");
			  if(opt.isEmpty())
				  System.out.println("Record not found");
			  else {
				  Hospital hs=opt.get();
				  System.out.println("Hospitale details are ::"+hs);
			  }*/
			
			long count=hsRepo.countByLocation("hyd");
			System.out.println("Records count::"+count);
			System.out.println("----------------------");
			boolean flag=hsRepo.existsByName("JIMS");
			System.out.println("JIMS Hospital available ?"+flag);
			
			
			long count1=hsRepo.deleteByNameIn("JIMS","JIMS1");
			System.out.println("no.of records that are deleted::"+count1);
			
			  
			  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
				
	}

}
