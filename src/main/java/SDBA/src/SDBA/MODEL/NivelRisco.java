package SDBA.src.SDBA.MODEL;

public enum NivelRisco {

    SEM_RISCO("Sem riscos!"),
    BAIXO("Rotina saudável!"),
    MEDIO("Risco médio!"),
    ALTO("Risco alto!"),
    CRITICO("RISCO CRÍTICO!");

    private String mensagem;

    NivelRisco(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
