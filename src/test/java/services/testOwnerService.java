package services;

import entities.Owner;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testOwnerService {

    private OwnerService os;
    private PetService ps;

    @Before
    public void setup() {
        os = new OwnerService();
        ps = new PetService();
    }

    @Test
    public void testFindById() {
        Owner owner = os.findById(1L);
        Assert.assertNotNull(owner);
    }
}
