package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.PlayerDTO;
import com.scout_tracker.domain.service.impl.PlayerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@Tag(name = "Jogadores", description = "Gerenciamento de jogadores")
public class PlayerController {

    @Autowired
    private PlayerServiceImpl playerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar um jogador", description = "Cria um novo jogador e retorna seus detalhes")
    public PlayerDTO savePlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.savePlayer(playerDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar jogador por ID", description = "Retorna um jogador específico pelo ID")
    public PlayerDTO getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todos os jogadores", description = "Retorna uma lista de todos os jogadores cadastrados")
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/scout/{scoutId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar jogadores por olheiro", description = "Retorna jogadores associados a um olheiro específico")
    public List<PlayerDTO> getPlayersByScout(@PathVariable Long scoutId) {
        return playerService.getPlayersByScoutId(scoutId);
    }

    @GetMapping("/search/name")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar jogadores por nome", description = "Retorna jogadores cujo nome corresponda ao critério de busca")
    public List<PlayerDTO> getPlayersByName(@RequestParam String name) {
        return playerService.getPlayersByName(name);
    }

    @GetMapping("/search/position")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar jogadores por posição", description = "Retorna jogadores que jogam em uma determinada posição")
    public List<PlayerDTO> getPlayersByPosition(@RequestParam String position) {
        return playerService.getPlayersByPosition(position);
    }

    @GetMapping("/search/age-range")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar jogadores por faixa etária", description = "Retorna jogadores dentro de um intervalo de idade especificado")
    public List<PlayerDTO> getPlayersByAgeRange(
            @RequestParam int minAge,
            @RequestParam int maxAge) {
        return playerService.getPlayersByAgeRange(minAge, maxAge);
    }

    @GetMapping("/search/team")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar jogadores por time", description = "Retorna jogadores que pertencem a um determinado time")
    public List<PlayerDTO> getPlayersByTeam(@RequestParam Long teamId) {
        return playerService.getPlayersByTeam(teamId);
    }

    @GetMapping("/search/country")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar jogadores por país", description = "Retorna jogadores que pertencem a um determinado país")
    public List<PlayerDTO> getPlayersByCountry(@RequestParam Long countryId) {
        return playerService.getPlayersByCountry(countryId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar um jogador", description = "Atualiza os dados de um jogador existente")
    public PlayerDTO updatePlayer(
            @PathVariable @Parameter(description = "ID do jogador a ser atualizado") Long id,
            @RequestBody PlayerDTO playerDTO) {
        return playerService.updatePlayer(id, playerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir um jogador", description = "Remove um jogador do sistema")
    public void deletePlayer(@PathVariable @Parameter(description = "ID do jogador a ser excluído") Long id) {
        playerService.deletePlayer(id);
    }
}
