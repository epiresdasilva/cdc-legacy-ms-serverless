package br.com.evandropires.legacy;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MovementService {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private AccountService accountService;

    public Movement find(Integer id) {
        return entityManager.find(Movement.class, id);
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public Movement save(Movement movement) {
        var account = accountService.find(movement.getAccount().getId());
        movement.setAccount(account);
        entityManager.persist(movement);
        return movement;
    }

}
