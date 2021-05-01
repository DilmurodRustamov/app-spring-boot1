package uz.pdp.appspringboot1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String nameUz;

    @Column(unique = true,nullable = false)
    private String nameRu;

    @Column(unique = true,nullable = false)
    private String nameEn;

    @ManyToOne
    private Region region;
}
