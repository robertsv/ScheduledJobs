package lv.robertsv.webjob.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import lv.robertsv.webjob.domain.Job;

@Repository
public class JobDaoMem implements JobDao {
	
    private List<Job> STORAGE = new ArrayList<>();

	public List<Job> getAll() {
		return STORAGE;
	}
	
	public Job  add(Job job) {
		STORAGE.add(job);
		Random r = new Random();
		job.setId(r.nextLong());
		return job;
	}

	public void remove(long jobId) {
		STORAGE.stream().filter(o -> o.getId().equals(jobId)).forEach(o -> STORAGE.remove(o));
	}

}
