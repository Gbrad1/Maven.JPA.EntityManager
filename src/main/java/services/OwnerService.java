package services;

import entities.Owner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class OwnerService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");

    public OwnerService() {}

    //The below method is used to create an entityManager. Whenever we need one we call this method.
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Owner findById(Long id) {
        EntityManager em = getEntityManager();
        Owner owner = em.find(Owner.class, id);
        em.detach(owner);
        return owner;
    }

    public List<Owner> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT id FROM Owner id");
        return query.getResultList();
    }

    public void update(Long id, Owner newOwner) {
        EntityManager em = getEntityManager();
        Owner owner = findById(id);
        if (owner != null) {
            owner.setId(newOwner.getId());
            owner.setFirstName(newOwner.getFirstName());
            owner.setLastName(newOwner.getLastName());
            em.getTransaction();
        }
    }

    public Owner create(Long id, String firstName, String lastName){
        EntityManager em = getEntityManager();
        Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        em.persist(owner);
        return owner;
    }

    public void deleteOwner(Long id) {
        EntityManager em = getEntityManager();
        Owner owner = findById(id);
        if (owner != null) {
            em.remove(owner);
        }
    }

}
