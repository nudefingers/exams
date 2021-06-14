package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_climbers")
@Getter
@Setter
public class Climber {
    @EmbeddedId
    private ClimberKey key;
    @Column(nullable = false)
    private int age;
    private String email;
    @Column(nullable = false, unique = true)
    private UUID uuid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group")
    private ClimbingGroup group;

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    @Embeddable
    @EqualsAndHashCode
    @Getter
    @Setter
    @NamedQuery(name = "climber.get.by.name.mail", query = "SELECT c FROM Climber c WHERE c.email = :climber_mail")
    public static class ClimberKey implements Serializable {
        @Column(length = 30)
        private String name;
        @Column(length = 100)
        private String surname;
    }

}
