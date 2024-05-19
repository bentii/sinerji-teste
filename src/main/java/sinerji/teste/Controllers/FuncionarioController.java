package sinerji.teste.Controllers;

import sinerji.teste.Models.FuncionarioRequest;
import sinerji.teste.Services.FuncionarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/pesquisar")
    public ResponseEntity<?> getFuncionariosByNomes(@RequestBody FuncionarioRequest request) {
        return funcionarioService.processFuncionarioRequest(request);
    }
}