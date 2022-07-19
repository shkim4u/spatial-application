package com.example.demo.model.aggregate;

import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
//import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Setter
@Getter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Point location;

    public Store() {
    }

    public Store(String name, Point location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store that = (Store) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location);
    }
}
