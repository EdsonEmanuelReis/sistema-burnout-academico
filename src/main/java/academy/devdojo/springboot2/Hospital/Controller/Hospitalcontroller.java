package academy.devdojo.springboot2.Hospital.Controller;

import academy.devdojo.springboot2.Hospital.Data.ConsultaData;
import academy.devdojo.springboot2.Hospital.Data.PacienteData;
import academy.devdojo.springboot2.Hospital.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("hospital")
@Log4j2
@RequiredArgsConstructor
public class Hospitalcontroller {

    private final HospitalService service;

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody PacienteData paciente){
        boolean resultado = service.cadastrarPaciente(paciente);
        if (resultado) return "Cadastrado com sucesso!";
        return "Erro ao cadastrar!";
    }

    @PostMapping("/agendar")
    public String agendarConsulta(@RequestBody ConsultaData consulta){
        boolean resultado = service.Agendarconsulta (consulta);
        if (resultado) return "Agendada consulta";
        return "Consulta indisponível!";
    }

    @PostMapping("/realizar")
    public String realizarConsulta(@RequestBody ConsultaData consulta) {
        boolean resultado = service.realizarConsulta(consulta);
        if (resultado) return "Realizado consulta!";
        return "Erro ao realizar consulta!";
    }

    @DeleteMapping("/cancelar")
    public String deletarConsulta(@RequestBody ConsultaData consulta) {
        boolean resultado = service.cancelarConsulta(consulta);
        if (resultado) return "Excluido a consulta!";
        return "Erro ao excluir a consulta!";
    }

}
