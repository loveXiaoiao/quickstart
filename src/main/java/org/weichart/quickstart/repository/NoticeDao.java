package org.weichart.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.weichart.quickstart.entity.Notice;

public interface NoticeDao extends PagingAndSortingRepository<Notice, Long>,
		JpaSpecificationExecutor<Notice> {

}
