package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_mountains")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "mountain.get.all", query = "SELECT m FROM Mountain m"),
        @NamedQuery(name = "mountain.get.by.height", query = "SELECT m FROM Mountain m WHERE m.height BETWEEN :min_height AND :max_height"),
        @NamedQuery(name = "mountain.get.by.name", query = "SELECT m FROM Mountain m WHERE m.name = :mountain_name")
})
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int height;
    @OneToMany(mappedBy = "mountain")
    private List<ClimbingGroup> groups = new ArrayList<>();
}
