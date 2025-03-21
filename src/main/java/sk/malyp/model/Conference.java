package sk.malyp.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Conference extends PanacheEntity {

    public String name;
    public LocalDate date;

}
