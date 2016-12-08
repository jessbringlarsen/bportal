package dk.bringlarsen.bportal.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dk.bringlarsen.bportal.api.converters.json.CustomLocalDateDeserializer;
import dk.bringlarsen.bportal.api.converters.json.CustomLocalDateSerializer;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Player extends AbstractPersistable<Long> {

    @Version
    private Integer version;

    @NotNull
    @Column
    private String name;

    @Column
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate birthdate;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<ClubMembership> clubMemberships;

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Player setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public List<ClubMembership> getClubMemberships() {
        return clubMemberships;
    }

    public Player setClubMemberships(List<ClubMembership> clubMemberships) {
        this.clubMemberships = clubMemberships;
        return this;
    }
}
