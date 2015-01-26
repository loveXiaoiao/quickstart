package org.weichart.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.weichart.quickstart.entity.PraiseHistory;

public interface PraiseHistoryDao extends JpaSpecificationExecutor<PraiseHistory>,
		PagingAndSortingRepository<PraiseHistory, Long> {

}
