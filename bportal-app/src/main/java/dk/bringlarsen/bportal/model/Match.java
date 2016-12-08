package dk.bringlarsen.bportal.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "match_table")
public class Match extends AbstractPersistable<Long> {

    @Version
    private Integer version;

    @Column(name = "when_column")
    private LocalDateTime when;

    @NotNull
    @JoinColumn(name="player1_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Player player1;

    @NotNull
    @JoinColumn(name="player2_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Player player2;

    @Column
    private String result;

    public String getResult() {
        return result;
    }

    public Match setResult(String result) {
        this.result = result;
        return this;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public Match setWhen(LocalDateTime when) {
        this.when = when;
        return this;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Match setPlayer1(Player player1) {
        this.player1 = player1;
        return this;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Match setPlayer2(Player player2) {
        this.player2 = player2;
        return this;
    }
}
