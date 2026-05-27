package academy.devdojo.springboot2.Hospital.Service;

import academy.devdojo.springboot2.Hospital.Data.ConsultaData;
import academy.devdojo.springboot2.Hospital.Data.PacienteData;
import academy.devdojo.springboot2.Hospital.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository r;

    public boolean cadastrarPaciente(PacienteData paciente) {
        if (paciente.getNome().isBlank()) { return false; }
        if (paciente.getCpf().isBlank()) {  return false; }
        if (r.buscarPacientePorId(paciente.getId()) != null) { System.out.println("bloqueou id"); return false; }
        r.salvarPaciente(paciente);
        return true;
    }

    public boolean Agendarconsulta(ConsultaData consulta) {
        PacienteData paciente = r.buscarPacientePorId(consulta.getPaciente().getId());
        if (paciente == null) return false;
        if (r.buscarConsultaPorId(consulta.getId()) != null) return false;
        for (ConsultaData c : r.listarConsultas()) {
            if (c.getPaciente().getId() == consulta.getPaciente().getId()) {
                if (!c.isRealizada()) return false;
            }
        }
        r.salvarConsulta(consulta);
        return true;
    }

    public boolean realizarConsulta(ConsultaData consulta) {
        if (consulta.isRealizada()) return false;
        if (r.buscarConsultaPorId(consulta.getId()) == null) return false;
        consulta.setRealizada(true);
        return true;
    }

    public boolean cancelarConsulta(ConsultaData consulta) {
        if (consulta.isRealizada()) return false;
        if (r.buscarConsultaPorId(consulta.getId()) == null) return false;
        r.deletarConsulta(consulta);
        return true;
    }

}

