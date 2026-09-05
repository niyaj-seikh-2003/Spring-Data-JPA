package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;
import com.nt.repository.IJobSeekerRepository;

@Service
public class JobSeekerMgmtImpl implements IJobSeekerMgmtService {

	@Autowired
	private IJobSeekerRepository jsRepo;
	@Override
	public String registerJObSeekAsGroup(List<JobSeeker> list) {
		System.out.println("JobSeekerMgmtImpl.registerJObSeekAsGroup()");
		Iterable<JobSeeker>savejs=jsRepo.saveAll(list);
		return list.size()+" job seeker are saved";
	}

	@Override
	public Iterable<JobSeeker> showAllJobSeekrs() {
		System.out.println("JobSeekerMgmtImpl.showAllJobSeekrs()");
		return jsRepo.findAll();
	}

	@Override
	public JobSeeker findJsById(int id) {
		System.out.println("JobSeekerMgmtImpl.findJsById()");
		Optional<JobSeeker>opt=jsRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalStateException("Invalid id");
	}

}
