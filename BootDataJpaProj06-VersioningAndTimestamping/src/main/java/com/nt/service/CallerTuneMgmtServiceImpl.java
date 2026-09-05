package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTuneInfo;
import com.nt.repository.ICalleTuneInfoRepository;

@Service("callerTuneService")
public class CallerTuneMgmtServiceImpl implements ICallerTuneMgmtService {

	@Autowired
	private ICalleTuneInfoRepository callerTuneRepo;
	
	
	@Override
	public String saveCallerTuneInfo(CallerTuneInfo info) {
		Integer idval=callerTuneRepo.save(info).getTuneId();
		
		return "CallerTune is saved with id value::"+idval;
	}


	@Override
	public String updateTuneInfoById(Integer id, String tuneName, String movieName) {
		Optional<CallerTuneInfo>opt=callerTuneRepo.findById(id);
		if(opt.isPresent()) {
			CallerTuneInfo info=opt.get();
			info.setTuneName(tuneName);
			info.setMovieName(movieName);
			CallerTuneInfo tune=callerTuneRepo.save(info);
			return "Object is updated for "+tune.getUpdatedCount()+" times....lastly modified on:"
					+tune.getLastlyUpdatedOn()+" created on :: "+tune.getServiceOptedOn();
		}else
			
		return "CallereTuneService is not found";
	}


	@Override
	public CallerTuneInfo showCallerTuneDetailsById(Integer id) {
		return callerTuneRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Caller tune not found"));
	}

}
