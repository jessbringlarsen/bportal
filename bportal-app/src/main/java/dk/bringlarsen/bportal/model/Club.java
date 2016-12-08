package dk.bringlarsen.bportal.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class Club extends AbstractPersistable<Long> {

    @Version
    private Integer version;

    @NotNull
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public Club setName(String name) {
        this.name = name;
        return this;
    }
}
