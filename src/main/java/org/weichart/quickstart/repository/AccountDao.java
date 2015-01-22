package org.weichart.quickstart.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.weichart.quickstart.entity.Account;

public interface AccountDao extends PagingAndSortingRepository<Account, Long>,JpaSpecificationExecutor<Account> {

}
