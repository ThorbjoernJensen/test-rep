package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;
    private String phone;
    @ManyToMany
    private Set<Boat> boats = new LinkedHashSet<>();

    public Owner() {
    }

    public Owner(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Boat> getBoats() {
        return boats;
    }

    public void addBoat(Boat boat) {
        this.boats.add(boat);
        boat.getOwners().add(this);
    }

//    public void addHobbytoHobbySet(Hobby hobby){
//        this.hobbySet.add(hobby);
//        hobby.getPersonSet().add(this);
//
//    }


}