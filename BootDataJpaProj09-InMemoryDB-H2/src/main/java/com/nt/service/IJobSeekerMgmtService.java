package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeeker;

public interface IJobSeekerMgmtService {
	public String registerJObSeekAsGroup(List<JobSeeker>list);
	public Iterable<JobSeeker>showAllJobSeekrs();
	public JobSeeker findJsById(int id);
}
