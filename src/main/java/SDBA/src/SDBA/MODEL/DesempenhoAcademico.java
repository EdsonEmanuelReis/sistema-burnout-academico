package SDBA.src.SDBA.MODEL;

public class DesempenhoAcademico {
    private int idAluno;
    private int mediaNotas;
    private int faltas;
    private int atrasos;
    private double atividadesEntregues;
    private double atividadesTotais;


    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public double getAtividadesTotais() {
        return atividadesTotais;
    }

    public void setAtividadesTotais(double atividadesTotais) {
        this.atividadesTotais = atividadesTotais;
    }

    public int getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(int mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(int atrasos) {
        this.atrasos = atrasos;
    }

    public double getAtividadesEntregues() {
        return atividadesEntregues;
    }

    public void setAtividadesEntregues(double atividadesEntregues) {
        this.atividadesEntregues = atividadesEntregues;
    }
}
