package br.com.fiap.soccerteam.dto;

import br.com.fiap.soccerteam.entity.Team;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SimpleTeamDTO {

    private Long id;
    private String name;
    private LocalDate foundedIn;

    public SimpleTeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.foundedIn = team.getFoundedIn();
    }

}
