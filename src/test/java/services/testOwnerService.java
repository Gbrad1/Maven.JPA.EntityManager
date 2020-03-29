package services;

import entities.Owner;
import entities.Pet;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testOwnerService {

    private OwnerService os;
    private PetService ps;
    private Pet pet;
    private Owner owner;

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
        os.deleteOwner(1L);
        Assert.assertNull(owner);
    }

}
