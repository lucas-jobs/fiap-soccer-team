package br.com.fiap.soccerteam.controller;

import br.com.fiap.soccerteam.dto.CreateTeamDTO;
import br.com.fiap.soccerteam.dto.TeamDTO;
import br.com.fiap.soccerteam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping()
    public ResponseEntity<?> search(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(this.teamService.search(name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.teamService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TeamDTO> create(@RequestBody @Valid CreateTeamDTO team) {
        return new ResponseEntity<>(this.teamService.create(team), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> update(@PathVariable Long id,
                       @RequestBody @Valid CreateTeamDTO team) {
        return new ResponseEntity<>(this.teamService.update(id, team), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.teamService.delete(id);
    }
}