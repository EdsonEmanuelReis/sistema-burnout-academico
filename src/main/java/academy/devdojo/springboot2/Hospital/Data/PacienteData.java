package academy.devdojo.springboot2.Hospital.Data;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
public class PacienteData {
    private int id;
    private String nome;
    private int idade;
    private String cpf;

}
