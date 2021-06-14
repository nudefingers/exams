package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_climbing_groups")
@Getter
@Setter
@NamedQuery(name = "group.get.future.date", query = "SELECT g FROM ClimbingGroup c WHERE c.start > :start_date")
public class ClimbingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mountain")
    private Mountain mountain;
    @OneToMany(mappedBy = "group")
    private List<Climber> climbers = new ArrayList<>();
    private LocalDateTime start;
}
