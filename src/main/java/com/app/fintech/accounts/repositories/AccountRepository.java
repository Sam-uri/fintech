package com.app.fintech.accounts.repositories;

import com.app.fintech.accounts.entities.Account;
import com.app.fintech.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
