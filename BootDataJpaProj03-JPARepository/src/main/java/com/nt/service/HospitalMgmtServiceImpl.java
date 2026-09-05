package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Hospital;
import com.nt.repository.IHospitalRepository;

@Service
public class HospitalMgmtServiceImpl implements IHospitalMgmtService {
	@Autowired
	private   IHospitalRepository   hsRepo;

	@Override
	public String removeHospitalsByIdsInBatch(Iterable<Integer> ids) {
		//load  the objects
		List<Hospital>   list=hsRepo.findAllById(ids);
		if(list.size()!=0) {
		  //delete the records In batch
		   hsRepo.deleteAllByIdInBatch(ids);
		   return  list.size()+" no.of  hospitals are deleted";
		}
		else{
			 return  "no hospitals found for deletion";
		}
	}

	@Override
	public List<Hospital> showHospitalsByExampleData(Hospital hospital, boolean ascOrder, String... props) {
		//create Sort object
		Sort  sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);
		//create Example object
		Example<Hospital>  example=Example.of(hospital);
		//use repo
		List<Hospital>  list=hsRepo.findAll(example,sort);
		return list;
	}
	
	@Override
	public String showHospitalById(int id) {
		//Load object
		Optional<Hospital>  opt=hsRepo.findById(id);
		if(opt.isPresent()) {
			  return  id+"  Hospital info ::"+opt.get();
		}
		return id+"  Hospital is not found";
	}
	
	@Override
	public Hospital getHospitalById(int id) {
		//use repo
		Hospital  proxy=hsRepo.getReferenceById(id);
		return proxy;
	}

}//class

