package SDBA.src.SDBA.CONTROLLER;


import SDBA.src.SDBA.MODEL.Aluno;
import SDBA.src.SDBA.MODEL.AtualizarAlunoRequest;
import SDBA.src.SDBA.MODEL.DesempenhoAcademico;
import SDBA.src.SDBA.MODEL.RotinaEstudo;
import SDBA.src.SDBA.SERVICE.Gerenciadordealunos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping ("/aluno")
@Log4j2
@RequiredArgsConstructor

public class AlunoController {

    private final Gerenciadordealunos gerenciadorAluno;

    @PostMapping ("/cadastrarAluno")
    public String cadastrar(@RequestBody Aluno aluno) {
        boolean resultado = gerenciadorAluno.registrarAluno(aluno);
        if (resultado) return "Aluno cadastrado com sucesso";
        return "Erro ao cadastrar";
    }

    @DeleteMapping("/deletar")
    public String deletarAluno (@RequestParam int id) {
        boolean resultado = gerenciadorAluno.deletarAluno (id);
        if (resultado) return "Deletado com sucesso";
        return "Erro ao deletar";
    }

    @GetMapping("/buscar")
    public Aluno buscarAluno (@RequestParam int id){
        return gerenciadorAluno.buscarAluno (id);
    }

    @GetMapping ("/analisar")
    public String analisarBurnout(@RequestParam int idAluno) {
        return gerenciadorAluno.analisarBurnout(idAluno);
    }

    @GetMapping ("/listar")
    public ArrayList<Aluno> listarAlunos() {
        return gerenciadorAluno.listarAlunos();
    }

    @PostMapping ("/registrarDesempenho")
    public String registrarDesempenho (@RequestBody DesempenhoAcademico desempenho) {
        boolean resultado = gerenciadorAluno.registrarDesempenho (desempenho);
        if (resultado) return "Registrado desempenho";
        return "Erro ao registrar";
    }
    @PostMapping ("/registrarRotina")
    public String registrarRotina (@RequestBody RotinaEstudo rotinaEstudo) {
        boolean resultado = gerenciadorAluno.registrarRotina (rotinaEstudo);
        if (resultado) return "Registrado rotina";
        return "Erro ao registrar";
    }

    @PutMapping("/atualizarAluno")
    public String atualizarAluno(@RequestBody AtualizarAlunoRequest request) {
        boolean resultado = gerenciadorAluno.atualizarAluno(
                request.getId(),
                request.getAluno(),
                request.getDesempenho(),
                request.getRotina()
        );
        if (resultado) return "Atualizado aluno";
        return "Erro ao atualizar aluno";
    }
}
