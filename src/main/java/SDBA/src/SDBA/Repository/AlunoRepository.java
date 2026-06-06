package SDBA.src.SDBA.Repository;
import org.springframework.stereotype.Repository;
import SDBA.src.SDBA.MODEL.Aluno;

import java.util.ArrayList;

@Repository

public class AlunoRepository {
    private final ArrayList <Aluno> alunos = new ArrayList <> ();

    public void salvarAluno (Aluno a){
        alunos.add (a);
    }

    public Aluno buscarId (int idAluno){
        for (Aluno aluno : alunos){
            if (aluno.getId () == idAluno){
                return aluno;
            }
        }
        return null;
    }

    public ArrayList<Aluno> listarAlunos() {
        return alunos;
    }

    public boolean atualizarAluno (int idaluno, Aluno atualizado){
        for (int i = 0; i<alunos.size();i++){
            if (idaluno == alunos.get(i).getId ()){
                alunos.set(i, atualizado);
                return true;
            }
        }
        return false;
    }

    public boolean  deletarAluno (int idAluno){
       return alunos.removeIf(aluno -> aluno.getId() == idAluno);
        }

    }

