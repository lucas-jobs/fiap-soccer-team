package br.com.fiap.soccerteam.service;

import br.com.fiap.soccerteam.dto.CreateTeamDTO;
import br.com.fiap.soccerteam.dto.SimpleTeamDTO;
import br.com.fiap.soccerteam.dto.TeamDTO;

import java.util.List;

public interface TeamService {

    List<SimpleTeamDTO> search(String name);
    TeamDTO findById(Long id);
    TeamDTO create(CreateTeamDTO team);
    TeamDTO update(Long id, CreateTeamDTO team);
    void delete(Long id);

}
