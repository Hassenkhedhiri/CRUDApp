package org.hassen.dao;

import org.hassen.entities.Account;
import org.springframework.data.repository.CrudRepository;


public interface AccountDao extends CrudRepository <Account,Long> {




}
