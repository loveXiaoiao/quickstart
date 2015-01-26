package org.weichart.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.weichart.quickstart.entity.AccountRoleHistory;

public interface AccountRoleHistoryDao extends
		PagingAndSortingRepository<AccountRoleHistory, Long>, JpaSpecificationExecutor<AccountRoleHistory> {

}
