package br.com.fiap.soccerteam.dto;

import br.com.fiap.soccerteam.entity.Team;
import br.com.fiap.soccerteam.enums.Country;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TeamDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDate foundedIn;
    private Country country;
    private String locatedIn;
    private String imageUrl;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.description = team.getDescription();
        this.foundedIn = team.getFoundedIn();
        this.country = team.getCountry();
        this.locatedIn = team.getLocatedIn();
        this.imageUrl = team.getImageUrl();
    }
}
