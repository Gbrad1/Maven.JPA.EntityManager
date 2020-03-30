package services;

import entities.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        return em.find(Owner.class, id);
    }

    public List<Owner> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT o FROM Owner o", Owner.class).getResultList();
    }

    public void update(Long id, Owner newOwner) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Owner owner = findById(id);
        owner.setId(newOwner.getId());
        owner.setFirstName(newOwner.getFirstName());
        owner.setLastName(newOwner.getLastName());
        em.merge(owner);
        em.getTransaction().commit();
    }

    public Owner create(Long id, String firstName, String lastName){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        em.merge(owner);
        em.getTransaction().commit();
        return owner;
    }

    public void deleteOwner(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Owner owner = findById(id);
        em.remove(owner);
        em.getTransaction().commit();
    }

}
