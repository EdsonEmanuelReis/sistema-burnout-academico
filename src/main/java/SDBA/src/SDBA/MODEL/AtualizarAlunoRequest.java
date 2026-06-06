package SDBA.src.SDBA.MODEL;

public class AtualizarAlunoRequest {
    private int id;
    private Aluno aluno;
    private DesempenhoAcademico desempenho;
    private RotinaEstudo rotina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public DesempenhoAcademico getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(DesempenhoAcademico desempenho) {
        this.desempenho = desempenho;
    }

    public RotinaEstudo getRotina() {
        return rotina;
    }

    public void setRotina(RotinaEstudo rotina) {
        this.rotina = rotina;
    }
}
