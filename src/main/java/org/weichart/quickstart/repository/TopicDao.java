package org.weichart.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.weichart.quickstart.entity.Topic;

public interface TopicDao extends JpaSpecificationExecutor<Topic>,
		PagingAndSortingRepository<Topic, Long> {

}
