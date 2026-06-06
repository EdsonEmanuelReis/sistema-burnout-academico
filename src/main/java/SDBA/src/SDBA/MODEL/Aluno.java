package SDBA.src.SDBA.MODEL;

public class Aluno {
    private String nome;
    private int  idade;
    private String email;
    private String curso;
    private String periodo;
    private int id;

    public Aluno(String nome, int idade, String email, String curso, String periodo, int id) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.curso = curso;
        this.periodo = periodo;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
