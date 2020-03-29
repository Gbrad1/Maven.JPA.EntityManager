package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PETS")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PET_NAME")
    private String name;

    @Column(name = "PET_TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    public Pet() {}

    public Pet(Long id, String name, String type, Owner owner) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
