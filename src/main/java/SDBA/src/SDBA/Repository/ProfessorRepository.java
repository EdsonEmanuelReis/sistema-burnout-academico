package SDBA.src.SDBA.Repository;


import SDBA.src.SDBA.MODEL.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProfessorRepository {
    private final ArrayList <Professor> professores = new ArrayList <> ();

    public void salvarProf (Professor p){
        professores.add (p);
    }

    public Professor buscarId (int idProf){
        for (Professor prof : professores){
            if (prof.getId () == idProf){
                return prof;
            }
        }
        return null;
    }

    public boolean atualizarProfessor (int idProf, Professor atualizado){
        for (int i = 0;i<professores.size ();i++){
            if (professores.get(i).getId () == idProf){
                professores.set(i,atualizado);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Professor> listarProf() {
        return professores;
    }

    public boolean deletarProf (int idProf){
        return professores.removeIf(prof -> prof.getId() == idProf);
    }
}

