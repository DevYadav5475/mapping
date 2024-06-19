package com.demo.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bus_name", nullable = false)
    private String busName;

    @ManyToMany
    @JoinTable(name = "bus_journey",//joining of 2 tables in hibernate
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "busStops_id"))
    private Set<BusStop> busStops = new LinkedHashSet<>();

    public Set<BusStop> getBusStops() {
        return busStops;
    }

    public void setBusStops(Set<BusStop> busStops) {
        this.busStops = busStops;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}