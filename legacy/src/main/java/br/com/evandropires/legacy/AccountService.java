package br.com.evandropires.legacy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountService {

    @PersistenceContext
    private EntityManager entityManager;

    public Account find(Integer id) {
        return entityManager.find(Account.class, id);
    }


}
