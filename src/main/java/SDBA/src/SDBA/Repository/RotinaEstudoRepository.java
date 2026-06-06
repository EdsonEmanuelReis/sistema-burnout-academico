package SDBA.src.SDBA.Repository;


import SDBA.src.SDBA.MODEL.RotinaEstudo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RotinaEstudoRepository {
    private final ArrayList <RotinaEstudo> rotina = new ArrayList<> ();

    public void salvarRotina (RotinaEstudo r){
        rotina.add(r);
    }

    public RotinaEstudo buscarRotina (int idAluno){
        for (RotinaEstudo r : rotina) {
            if (r.getIdaluno() == idAluno) {
                return r;
            }
        }

        return null;
    }

    public boolean atualizarRotina (int idAluno, RotinaEstudo atualizado){
        for (int i = 0;i<rotina.size();i++){
            if (idAluno == rotina.get(i).getIdaluno()){
                rotina.set (i,atualizado);
                return true;
            }
        }
        return false;
    }

    public boolean deletarRotina (int idAluno){
        return rotina.removeIf(r -> r.getIdaluno() == idAluno);
    }
}
