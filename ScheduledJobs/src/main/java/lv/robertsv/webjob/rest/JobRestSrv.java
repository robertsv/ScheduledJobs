package lv.robertsv.webjob.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lv.robertsv.webjob.dao.JobDao;
import lv.robertsv.webjob.domain.Job;
import lv.robertsv.webjob.service.ScheduleManager;

@RestController
@RequestMapping("/job")
public class JobRestSrv {
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private ScheduleManager schedulerManager;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Job> getJobs() {
		return jobDao.getAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addJob(@RequestBody Job job) {
		jobDao.add(job);
		schedulerManager.addToSchedule(job);
		// TODO (RV): fix it
		return "{\"OK\"}";
	}
}