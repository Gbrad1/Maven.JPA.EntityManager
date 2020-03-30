package services;

import entities.Owner;
import entities.Pet;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class testOwnerService {

    private OwnerService os;
    private PetService ps;
    private Pet pet;
    private Owner owner;
    private List<Owner> owners;

    @Before
    public void setup() {
        os = new OwnerService();
        ps = new PetService();
        pet = new Pet();
        owner = new Owner();
    }

    @Test
    public void testAddOwner() {
        os.create(1L, "Kali", "Linux");
        Owner owner = os.findById(1L);
        Assert.assertNotNull(owner);
    }

    @Test
    public void removeOwner() {
        os.create(1L, "Kali", "Linux");
        Owner owner = os.findById(1L);
        owners = os.findAll();
        Assert.assertTrue(owners.contains(owner));

        os.deleteOwner(owner.getId());
        owners = os.findAll();
        Assert.assertFalse(owners.contains(owner));
    }

    @Test
    public void updateOwner() {
        os.create(2L, "Link", "Link");
        Owner owner = os.findById(2L);
        Owner newOwner = new Owner(2L, "Link", "Link");
        os.update(2L, newOwner);
        Assert.assertEquals("Zelda", owner.getFirstName());
    }

}
