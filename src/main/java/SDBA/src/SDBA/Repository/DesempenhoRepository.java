package SDBA.src.SDBA.Repository;

import SDBA.src.SDBA.MODEL.DesempenhoAcademico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DesempenhoRepository {
   private final ArrayList <DesempenhoAcademico> desempenho = new ArrayList <> ();

   public void salvarDesempenho (DesempenhoAcademico d){
       desempenho.add(d);
   }

   public DesempenhoAcademico buscarDesempenhoPorIdAluno (int idAluno){
       for (DesempenhoAcademico d : desempenho){
        if (d.getIdAluno () == idAluno){
            return d;
            }
        }
       return null;
   }

   public boolean atualizarDesempenho (int idAluno, DesempenhoAcademico atualizado){
       for (int i = 0;i<desempenho.size ();i++){
           if (idAluno == desempenho.get(i).getIdAluno()){
               desempenho.set(i,atualizado);
               return true;
           }
       }
       return false;
   }

   public boolean  deletarDesempenho (int idAluno){
       return desempenho.removeIf(d -> d.getIdAluno() == idAluno);
   }
}
