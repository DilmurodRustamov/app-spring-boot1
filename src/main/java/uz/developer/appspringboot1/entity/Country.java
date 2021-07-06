package uz.developer.appspringboot1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String nameUz;

    @Column(unique = true,nullable = false)
    private String nameRu;

    @Column(unique = true,nullable = false)
    private String nameEn;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Region> regions;

}
