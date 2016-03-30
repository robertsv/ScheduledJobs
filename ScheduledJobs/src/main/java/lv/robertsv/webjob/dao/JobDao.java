package lv.robertsv.webjob.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.speedment.Manager;
import com.speedment.Speedment;

import lv.robertsv.speedment.test.TestApplication;
import lv.robertsv.speedment.test.webjobs.public_.scheduled_job.ScheduledJob;
import lv.robertsv.webjob.domain.Job;

@Repository
public class JobDao {
	
    private Manager<ScheduledJob> manager;
    
    @Autowired
    private DozerBeanMapper mapper;
    
    @PostConstruct
    public void init() {
    	Speedment speedment = new TestApplication().withPassword("postgres").build();
        manager = speedment.managerOf(ScheduledJob.class);
	}

	public List<Job> getAll() {
		List<ScheduledJob> scheduledJobs =  manager.stream().collect(Collectors.toList());
		
		System.out.println(mapper);
		// TODO (RV): use dozer to convert
		return null;
	}

	public void add(Job job) {
		ScheduledJob scheduledJob = manager.newInstance()
	    .setEnabled(1)
	    .setId(777L)
	    .setPath(job.getPath())
	    .setSchedule(job.getSchedule())
	    .setStatus("Scheduled")
	    .persist();
		
	}

	public void remove(long jobId) {
		manager.stream().filter(j -> j.getId().equals(jobId)).forEach(j -> j.remove());
	}

}
