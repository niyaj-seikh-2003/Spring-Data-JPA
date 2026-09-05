package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICallerTuneMgmtService;
@Component
public class VersioningAndTimeStampingTest implements CommandLineRunner {

	@Autowired
	private ICallerTuneMgmtService serivce;
	@Override
	public void run(String... args) throws Exception 
	{
		/*
		 * try { CallerTuneInfo info=new CallerTuneInfo("OO antaca mama","pushpa");
		 * System.out.println(serivce.saveCallerTuneInfo(info));
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */
		
		try {
			System.out.println(serivce.updateTuneInfoById(1, "jhume jo pathan", "patha"));
			System.out.println(serivce.showCallerTuneDetailsById(1));
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(serivce.updateTuneInfoById(1, "Natu Natu", "RRR"));
			System.out.println(serivce.showCallerTuneDetailsById(1));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
