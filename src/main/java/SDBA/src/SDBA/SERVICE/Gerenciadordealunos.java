package SDBA.src.SDBA.SERVICE;


import SDBA.src.SDBA.MODEL.Alerta;
import SDBA.src.SDBA.MODEL.Aluno;
import SDBA.src.SDBA.MODEL.DesempenhoAcademico;
import SDBA.src.SDBA.MODEL.RotinaEstudo;
import SDBA.src.SDBA.Repository.AlunoRepository;
import SDBA.src.SDBA.Repository.DesempenhoRepository;
import SDBA.src.SDBA.Repository.RotinaEstudoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Gerenciadordealunos {

    private final AlunoRepository alunoRepository;
    private final DesempenhoRepository desempenhoRepository;
    private final RotinaEstudoRepository rotinaEstudoRepository;
    private final AnaliseBurnout analise;

    public boolean registrarAluno (Aluno aluno){
        if (aluno.getNome ().isEmpty ()) return false;
        if (aluno.getIdade ()<=0 || aluno.getIdade ()>120) return false;
        if (aluno.getEmail ().isEmpty () || !aluno.getEmail ().contains("@gmail.com")) return false;
        alunoRepository.salvarAluno (aluno);
        return true;
    }

    public Aluno buscarAluno (int id){
        if (id <= 0) return null;

        return alunoRepository.buscarId(id);
    }

    public boolean atualizarAluno (int id, Aluno atualizado, DesempenhoAcademico atualizadoDesem,
                                   RotinaEstudo atualizadoRotina){
        if (id <= 0) return false;

        boolean alunoAtualizado = alunoRepository.atualizarAluno (id,atualizado);

        if (!alunoAtualizado)
            return false;

        desempenhoRepository.atualizarDesempenho (id, atualizadoDesem);
        rotinaEstudoRepository.atualizarRotina(id,atualizadoRotina);
        return true;
    }

    public boolean deletarAluno(int id) {

        if (id <= 0)
            return false;

        boolean alunoRemovido = alunoRepository.deletarAluno (id);

        if (!alunoRemovido)
            return false;

        desempenhoRepository.deletarDesempenho(id);
        rotinaEstudoRepository.deletarRotina(id);

        return true;
    }

    public ArrayList<Aluno> listarAlunos (){
        ArrayList<Aluno> alunos = alunoRepository.listarAlunos();
        if (alunos.isEmpty()) return null;
        return alunos;
    }

    public boolean registrarDesempenho (DesempenhoAcademico desempenho){
        if (desempenho.getIdAluno()<=0) return false;
        if (desempenho.getMediaNotas ()<0) return false;
        if (desempenho.getFaltas ()<0) return false;
        if (desempenho.getAtividadesEntregues()<0) return false;
        if (desempenho.getAtrasos ()<0) return false;
        if (desempenho.getAtividadesTotais ()<0) return false;
        desempenhoRepository.salvarDesempenho (desempenho);
        return true;
    }

    public boolean registrarRotina (RotinaEstudo rotina){
        if (rotina.getIdaluno()<=0) return false;
        if (rotina.getTempoLazer ()<0) return false;
        if (rotina.getPausas ()<0) return false;
        if (rotina.getHorasSono ()<0) return false;
        if (rotina.getHorasEstudo ()<0)return false;
        rotinaEstudoRepository.salvarRotina (rotina);
        return true;
    }

    public String analisarBurnout (int idAluno){
        Aluno aluno = alunoRepository.buscarId (idAluno);
        if (aluno == null) return "Aluno não encontrado";
        DesempenhoAcademico desempenho = desempenhoRepository.buscarDesempenhoPorIdAluno (idAluno);
        if (desempenho == null) return "Desempenho não cadastrado";

        RotinaEstudo rotina = rotinaEstudoRepository.buscarRotina(idAluno);
        if (rotina == null) return "Rotina não cadastrada";

        int pontuacao = analise.totalRisco(rotina, desempenho);
        Alerta alerta = analise.resultadoRiscos (pontuacao);
        return alerta.getMensagemAlerta();
    }

}
