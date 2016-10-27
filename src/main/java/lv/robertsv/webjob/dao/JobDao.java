package lv.robertsv.webjob.dao;

import java.util.List;

import lv.robertsv.webjob.domain.Job;

public interface JobDao {
	
	List<Job> getAll();
	
	Job add(Job job);

	void remove(long jobId);

}
