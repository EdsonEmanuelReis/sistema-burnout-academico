package academy.devdojo.springboot2.Hospital.Data;

import lombok.*;

@Data
@Getter
@Setter

public class ConsultaData {
    private int id;
    PacienteData paciente;
    private String medico;
    private int data;
    private boolean realizada;

    public ConsultaData(int id, PacienteData paciente, String medico, int data) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }
}
