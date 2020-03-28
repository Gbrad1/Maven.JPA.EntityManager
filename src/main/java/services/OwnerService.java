package services;

import entities.Owner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class OwnerService {

    @PersistenceContext
    private final EntityManager em;

    public OwnerService() {
        this.em = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
    }

    public Owner findById(Long id) {

    }

}
