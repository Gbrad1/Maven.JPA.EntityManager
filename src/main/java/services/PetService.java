package services;

import entities.Owner;
import entities.Pet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PetService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");

    public PetService() {}

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Pet findById(Long id) {
        EntityManager em = getEntityManager();
        Pet pet = em.find(Pet.class, id);
        em.detach(pet);
        return pet;
    }

    public List<Pet> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT id FROM Pet id");
        return query.getResultList();
    }

    public void update(Long id, Pet newPet) {
        EntityManager em = getEntityManager();
        Pet pet = findById(id);
        if (pet != null) {
            pet.setId(newPet.getId());
            pet.setName(newPet.getName());
            pet.setType(newPet.getType());
            em.getTransaction();
        }
    }

    public Pet create(Long id, String name, String type) {
        EntityManager em = getEntityManager();
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setType(type);
        em.persist(pet);
        return pet;
    }

}
