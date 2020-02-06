package co.simplon.starwars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="climates")
public class Climate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="clim_gen")
    @SequenceGenerator(name = "clim_gen",
            sequenceName = "climates_id_seq",
            allocationSize = 1)
    Long id;
    @Column
    String climateName;
    public Climate(String name) {
         this.climateName = name;

    }

    public Climate(long id ,String name) {
        this.climateName = name;
        this.id = id;

    }
    @JsonIgnore
    @ManyToMany(mappedBy = "planetClimates")
    private Set<Planet> planetSet = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setClimateName(String climateName) {
        this.climateName = climateName;
    }

    public Long getId() {
        return id;
    }

    public String getClimateName() {
        return climateName;
    }

    public Climate(){};
}
