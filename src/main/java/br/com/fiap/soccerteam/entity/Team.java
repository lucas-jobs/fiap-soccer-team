package br.com.fiap.soccerteam.entity;

import br.com.fiap.soccerteam.enums.Country;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_SOCCER_TEAM")
@Data
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TST_ID")
    private Long id;

    @Column(name = "TST_NAME")
    private String name;

    @Column(name = "TST_DESCRIPTION")
    private String description;

    @Column(name = "TST_FOUNDED_IN")
    private LocalDate foundedIn;

    @Column(name = "TST_COUNTRY")
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "TST_LOCATED_IN")
    private String locatedIn;

    @Column(name = "TST_IMAGE_URL")
    private String imageUrl;

}
