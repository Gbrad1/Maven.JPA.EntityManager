package services;

import entities.Pet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class PetService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");

    public PetService() {}

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Pet findById(Long id) {
        EntityManager em = getEntityManager();
        return em.find(Pet.class, id);
    }

    public List<Pet> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT p FROM Pet p", Pet.class).getResultList();
    }

    public void update(Long id, Pet newPet) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Pet pet = findById(id);
        pet.setId(newPet.getId());
        pet.setName(newPet.getName());
        pet.setType(newPet.getType());
        em.merge(pet);
        em.getTransaction().commit();
    }

    public Pet create(Long id, String name, String type) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setType(type);
        em.persist(pet);
        em.getTransaction().commit();
        return pet;
    }

    public void delete(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Pet pet = findById(id);
        em.remove(pet);
        em.getTransaction().commit();
    }

}
