package SDBA.src.SDBA.SERVICE;


import SDBA.src.SDBA.MODEL.Professor;
import SDBA.src.SDBA.Repository.AlunoRepository;
import SDBA.src.SDBA.Repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Gerenciadordeprofessores {
    private final ProfessorRepository professorRepository;

    public boolean registrarProfessor (Professor professor){
        if (professor.getNome ().isEmpty ()) return false;
        if (professor.getEmail ().isEmpty ()||!professor.getEmail ().contains("@gmail.com")) return false;
        professorRepository.salvarProf (professor);
        return true;
    }

    public Professor buscarProf (int id){
        if (id<=0) return null;
        return professorRepository.buscarId (id);
    }

    public boolean atualizarProf (int id, Professor prof){
        if (id <=0){
            return false;
        }
        return professorRepository.atualizarProfessor(id, prof);
    }

    public boolean deletar (int id){
        if (id<=0) return false;
       return professorRepository.deletarProf(id);
    }

    public ArrayList <Professor> listarProfessores (){
        ArrayList <Professor> professores = professorRepository.listarProf ();
        if (professores.isEmpty()) return null;
        return professores;
    }



}
