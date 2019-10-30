package br.com.fiap.soccerteam.service.impl;

import br.com.fiap.soccerteam.dto.CreateTeamDTO;
import br.com.fiap.soccerteam.dto.SimpleTeamDTO;
import br.com.fiap.soccerteam.dto.TeamDTO;
import br.com.fiap.soccerteam.entity.Team;
import br.com.fiap.soccerteam.repository.TeamRepository;
import br.com.fiap.soccerteam.service.TeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<SimpleTeamDTO> search(String name) {
        return findByName(name)
                .stream()
                .map(SimpleTeamDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDTO findById(Long id) {
        return Optional.ofNullable(getById(id)).map(TeamDTO::new).get();
    }

    @Override
    public TeamDTO create(CreateTeamDTO team) {
        Team created = teamRepository.save(copyPaste(team, new Team()));
        return new TeamDTO(created);
    }

    @Override
    public TeamDTO update(Long id, CreateTeamDTO team) {
        Team updated = teamRepository.save(copyPaste(team, getById(id)));
        return new TeamDTO(updated);
    }

    @Override
    public void delete(Long id) {
        teamRepository.delete(getById(id));
    }

    private Team getById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private Team copyPaste(CreateTeamDTO copy, Team paste) {
        BeanUtils.copyProperties(copy, paste);
        return paste;
    }

    private List<Team> findByName(String name) {
        if(StringUtils.isEmpty(name)) {
            return teamRepository.findAll();
        }

        return teamRepository.findByNameContainingIgnoreCase(name);
    }
}
