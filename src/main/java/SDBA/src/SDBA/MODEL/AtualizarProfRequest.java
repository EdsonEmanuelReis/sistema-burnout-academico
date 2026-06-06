package SDBA.src.SDBA.MODEL;

public class AtualizarProfRequest {
    private int id;
    private Professor professor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
