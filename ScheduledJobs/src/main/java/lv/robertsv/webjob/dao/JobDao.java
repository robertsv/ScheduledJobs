package lv.robertsv.webjob.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lv.robertsv.webjob.domain.Job;

@Repository
public class JobDao {

	// TODO (RV): add impl
	private static List<Job> JOBS = new ArrayList();

	public List<Job> getAll() {
		return JOBS;
	}

	public void add(Job job) {
		JOBS.add(job);
	}

	public void remove(long jobId) {
		JOBS = JOBS.stream().filter(j -> j.getId() != jobId).collect(Collectors.toList());
	}

}
