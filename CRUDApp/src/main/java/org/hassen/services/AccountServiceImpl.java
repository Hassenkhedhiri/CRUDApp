package org.hassen.services;

import org.hassen.dao.AccountDao;
import org.hassen.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Iterable<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account find(Long id) {
        return (Account) accountDao.findOne(id);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Account account) {
        accountDao.delete(account);
    }
}
