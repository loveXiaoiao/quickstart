package org.weichart.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.weichart.quickstart.entity.Circle;

public interface CircleDao extends JpaSpecificationExecutor<Circle>,
		PagingAndSortingRepository<Circle, Long> {
	
	Circle findByname(String name);

}
