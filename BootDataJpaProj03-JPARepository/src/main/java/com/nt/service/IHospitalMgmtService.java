package com.nt.service;

import java.util.List;

import com.nt.entity.Hospital;

public interface IHospitalMgmtService {
	public   String removeHospitalsByIdsInBatch(Iterable<Integer> ids);
	public  List<Hospital>  showHospitalsByExampleData(Hospital hospital, boolean ascOrder , String ...props);
	public   String   showHospitalById(int id);
	public   Hospital   getHospitalById(int id);
	
 }
