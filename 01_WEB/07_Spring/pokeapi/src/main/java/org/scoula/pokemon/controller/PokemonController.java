package org.scoula.pokemon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.pokemon.dto.PokemonListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
@Log4j2
@Api(tags="피카츄 API")
public class PokemonController {

    @GetMapping("/list")
    @ApiOperation(value = "목록 조회", notes = "포켓몬 목록을 얻는 API")
    public ResponseEntity<List<PokemonListResponse>> list() {
return
    }
}
