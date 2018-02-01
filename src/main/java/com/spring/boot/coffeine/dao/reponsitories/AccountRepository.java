package com.spring.boot.coffeine.dao.reponsitories;

import com.spring.boot.coffeine.dao.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hainguyen on 5/29/17.
 */
@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account,String> {
}
