package lv.robertsv.webjob.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lv.robertsv.webjob.domain.Job;

@Repository
public class JobDaoMem implements JobDao {
	
	private List<Job> STORAGE = new ArrayList<>();
	
    @Autowired
    private DozerBeanMapper mapper;
    
    @PostConstruct
    public void init() {
	}

	public List<Job> getAll() {
		return STORAGE;
	}
	
	public void add(Job job) {
		STORAGE.add(job);
		
	}

	public void remove(long jobId) {
		STORAGE.stream().filter(o -> o.getId().equals(jobId)).forEach(o -> STORAGE.remove(o));
	}

}
