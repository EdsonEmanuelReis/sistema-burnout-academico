package SDBA.src.SDBA.CONTROLLER;


import SDBA.src.SDBA.MODEL.*;
import SDBA.src.SDBA.SERVICE.Gerenciadordeprofessores;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("professor")
@Log4j2
@RequiredArgsConstructor

public class ProfessorController {

    private final Gerenciadordeprofessores gerenciadorProf;

    @PostMapping("/cadastrarProfessor")
    public String cadastrar(@RequestBody Professor professor) {
        boolean resultado = gerenciadorProf.registrarProfessor (professor);
        if (resultado) return "Professor cadastrado com sucesso";
        return "Erro ao cadastrar";
    }

    @DeleteMapping("/deletarProfessor")
    public String deletar (@RequestParam int id){
        boolean resultado = gerenciadorProf.deletar (id);
        if (resultado) return "Professor deletado com sucesso";
        return "Erro ao deletar";
    }

    @GetMapping("/buscarProf")
    public Professor buscaridProf (@RequestParam int id){
        return gerenciadorProf.buscarProf (id);
    }

    @GetMapping ("/listar")
    public ArrayList<Professor> listarProfessores (){
        return gerenciadorProf.listarProfessores ();
    }

    @PutMapping("/atualizarProf")
    public String atualizarProf(@RequestBody AtualizarProfRequest request) {
        boolean resultado = gerenciadorProf.atualizarProf(
                request.getId(),
                request.getProfessor()
        );
        if (resultado) return "Professor atualizado!";
        return "Erro ao atualizar!";
    }

}
