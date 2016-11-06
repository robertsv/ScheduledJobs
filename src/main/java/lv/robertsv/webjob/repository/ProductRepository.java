package lv.robertsv.webjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lv.robertsv.webjob.domain.Job;

public interface ProductRepository extends JpaRepository<Job, Long>{
}