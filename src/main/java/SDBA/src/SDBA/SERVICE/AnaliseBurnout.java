package SDBA.src.SDBA.SERVICE;


import SDBA.src.SDBA.MODEL.Alerta;
import SDBA.src.SDBA.MODEL.DesempenhoAcademico;
import SDBA.src.SDBA.MODEL.NivelRisco;
import SDBA.src.SDBA.MODEL.RotinaEstudo;
import org.springframework.stereotype.Service;

@Service

public class AnaliseBurnout {


    public int riscoSono(RotinaEstudo rotina) {
        int pontos = 0;
        if (rotina.getHorasSono() < 6) pontos += 1;
        if (rotina.getHorasSono() > 12) pontos += 1;
        return pontos;
    }

    public int riscoAcademico(RotinaEstudo rotina, DesempenhoAcademico desempenho) {
        int pontos = 0;
        double porcentagem = desempenho.getAtividadesEntregues() * 100.0 / desempenho.getAtividadesTotais();
        if (rotina.getHorasEstudo() < 2) pontos += 1;
        if (porcentagem < 50) pontos += 1;
        if (porcentagem < 70) pontos += 1;
        if (desempenho.getFaltas() > 20) pontos += 1;
        if (desempenho.getFaltas() > 30) pontos += 2;
        if (desempenho.getAtrasos() > 10) pontos += 1;
        if (desempenho.getAtrasos() > 20) pontos += 2;
        if (desempenho.getMediaNotas() < 60) pontos += 1;
        return pontos;
    }

    public int tempoDeQualidade(RotinaEstudo rotina) {
        int pontos = 0;
        if (rotina.getTempoLazer() < 6) pontos += 1;
        if (rotina.getTempoLazer() < 3) pontos += 2;
        if (rotina.getPausas() < 1) pontos += 1;
        if (rotina.getPausas() < 3) pontos += 2;
        return pontos;
    }


    public int calcularEstresse (RotinaEstudo rotinaEstudo){
        int pontos = 0;
        if (rotinaEstudo.getNivelEstresse() >= 7) pontos += 2;
        if (rotinaEstudo.getNivelEstresse() >= 10) pontos += 4;
        return pontos;
    }

    public int totalRisco (RotinaEstudo rotina, DesempenhoAcademico desempenho){
        int pontuacaoRisco = 0;
        pontuacaoRisco += riscoSono (rotina);
        pontuacaoRisco += riscoAcademico (rotina, desempenho);
        pontuacaoRisco += tempoDeQualidade (rotina);
        pontuacaoRisco += calcularEstresse (rotina);
        return pontuacaoRisco;
    }

    public Alerta resultadoRiscos( int pontuacaoRisco) {

        Alerta alerta = new Alerta();
        if (pontuacaoRisco == 0)
            alerta.setMensagemAlerta(NivelRisco.SEM_RISCO.getMensagem());
        else if (pontuacaoRisco <= 2)
            alerta.setMensagemAlerta(NivelRisco.BAIXO.getMensagem());
        else if (pontuacaoRisco <= 4)
            alerta.setMensagemAlerta (NivelRisco.MEDIO.getMensagem ());
        else if (pontuacaoRisco <= 7)
            alerta.setMensagemAlerta (NivelRisco.ALTO.getMensagem ());
        else
            alerta.setMensagemAlerta (NivelRisco.CRITICO.getMensagem ());
        return alerta;
    }

}
