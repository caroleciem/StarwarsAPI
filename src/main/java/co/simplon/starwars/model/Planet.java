package co.simplon.starwars.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="planets")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="plan_gen")
    @SequenceGenerator(name = "plan_gen",
            sequenceName = "planets_id_seq",
            allocationSize = 1)
    Long id;
    @Column
    String planetName;
    @Column
    Integer rotation_period;
    @Column
    Integer orbital_period;
    @Column
    Integer diameter;
    @Column
    Double gravity;
    String climateName;
    public Planet(String name) {
        this.planetName = name;

    }

    public Planet(long id,String name) {
        this.planetName = name;
        this.id=id;

    }

    public void setPlanetClimates(Set<Climate> planetClimates) {
        this.planetClimates = planetClimates;
    }

    @Column
    Integer surface_water;
    @Column
    BigInteger population;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "planet_climates",
            joinColumns = {@JoinColumn(name = "planet_idx") },
            inverseJoinColumns = { @JoinColumn(name = "climate_idx") })
    private Set<Climate> planetClimates = new HashSet<>();


    //public Planet(Long id, String planet_name, Integer rotation_period, Integer orbital_period, Integer diameter,Double gravity, Integer surface_water,BigInteger population) {
    //    this.id = id;
    //    this.planet_name=planet_name;
    //    this.rotation_period=rotation_period;
    //    this.orbital_period=orbital_period;
    //    this.diameter=diameter;
    //    this.gravity=gravity;
    //    this.surface_water=surface_water;
    //    this.population=population;
    //}
    public Planet(){

    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public void setRotation_period(Integer rotation_period) {
        this.rotation_period = rotation_period;
    }

    public void setOrbital_period(Integer orbital_period) {
        this.orbital_period = orbital_period;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public void setSurface_water(Integer surface_water) {
        this.surface_water = surface_water;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }
    public Set<Climate> getPlanetClimates() {
        return planetClimates;
    }


    public Long getId() {
        return id;
    }

    public String getPlanetName() {
        return planetName;
    }

    public Integer getRotation_period() {
        return rotation_period;
    }

    public Integer getOrbital_period() {
        return orbital_period;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public Double getGravity() {
        return gravity;
    }

    public Integer getSurface_water() {
        return surface_water;
    }

    public BigInteger getPopulation() {
        return population;
    }
}
