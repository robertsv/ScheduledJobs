package lv.robertsv.webjob.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lv.robertsv.webjob.domain.Job;
import lv.robertsv.webjob.repository.ProductRepository;
import lv.robertsv.webjob.service.ScheduleManager;

@RestController
@RequestMapping("/job")
public class JobRestSrv {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ScheduleManager schedulerManager;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Job> getJobs() {
		return productRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addJob(@RequestBody Job job) {
		job = productRepository.save(job);
		schedulerManager.addToSchedule(job);
		// TODO (RV): fix it
		return "{\"OK\"}";
	}
	
	@RequestMapping(value = "/delete/{jobId}", method = RequestMethod.POST)
	public String removeJob(@PathVariable("jobId") Long jobId) {
		schedulerManager.removeFromSchedule(jobId);
		productRepository.delete(jobId);
		// TODO (RV): fix it
		return "{\"OK\"}";
	}
	
}