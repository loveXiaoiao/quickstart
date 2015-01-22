package org.weichart.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.weichart.quickstart.entity.CircleRole;

public interface CircleRoleDao extends JpaSpecificationExecutor<CircleRole>,
		PagingAndSortingRepository<CircleRole, Long> {

}
