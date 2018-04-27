package org.hassen.services;

import org.hassen.dao.AccountDao;
import org.hassen.entities.Account;

public interface AccountService {

    public Iterable<Account> findAll();
    public Account find(Long id);
    public void save(Account account);
    public void delete(Account account);


}
