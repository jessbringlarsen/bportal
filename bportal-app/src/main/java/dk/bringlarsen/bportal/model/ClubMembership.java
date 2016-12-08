package dk.bringlarsen.bportal.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dk.bringlarsen.bportal.api.converters.json.CustomLocalDateDeserializer;
import dk.bringlarsen.bportal.api.converters.json.CustomLocalDateSerializer;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Specify a specific player has a membership relationship with a specific club.
 */
@Entity
public class ClubMembership extends AbstractPersistable<Long> {

    @Version
    private Integer version;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="player_id")
    private Player player;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Club club;

    @Column
    @NotNull
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate memberFrom;

    @Column
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate memberTo;

    public Integer getVersion() {
        return version;
    }

    public Player getPlayer() {
        return player;
    }

    public ClubMembership setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public LocalDate getMemberFrom() {
        return memberFrom;
    }

    public ClubMembership setMemberFrom(LocalDate memberFrom) {
        this.memberFrom = memberFrom;
        return this;
    }

    public LocalDate getMemberTo() {
        return memberTo;
    }

    public ClubMembership setMemberTo(LocalDate memberTo) {
        this.memberTo = memberTo;
        return this;
    }

    public Club getClub() {
        return club;
    }

    public ClubMembership setClub(Club club) {
        this.club = club;
        return this;
    }
}
