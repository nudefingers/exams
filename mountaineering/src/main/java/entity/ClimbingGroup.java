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
@NamedQuery(name = "group.get.future.date", query = "SELECT g FROM ClimbingGroup g WHERE g.start > :start_date")
public class ClimbingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Mountain mountain;
    @OneToMany(mappedBy = "climbingGroup")
    private List<Climber> climbers = new ArrayList<>();
    private LocalDateTime start;
}
