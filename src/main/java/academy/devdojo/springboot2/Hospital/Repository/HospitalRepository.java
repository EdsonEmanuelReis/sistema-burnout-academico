package academy.devdojo.springboot2.Hospital.Repository;

import academy.devdojo.springboot2.Hospital.Data.ConsultaData;
import academy.devdojo.springboot2.Hospital.Data.PacienteData;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository

public class HospitalRepository {
    private static ArrayList<PacienteData> paciente = new ArrayList<>();
    private static ArrayList<ConsultaData> consulta = new ArrayList<>();

    public void salvarPaciente (PacienteData p){
    paciente.add (p);
    }

    public PacienteData buscarPacientePorId (int idBuscarPaciente) {
        for (PacienteData buscarpaciente : paciente) {
            if (idBuscarPaciente == buscarpaciente.getId()) {
                return buscarpaciente;
            }
        }
        return null;
    }

    public void salvarConsulta (ConsultaData c){
    consulta.add(c);
    }

    public void deletarConsulta (ConsultaData c){
        consulta.remove(c);
    }

    public ConsultaData buscarConsultaPorId (int idBuscarConsulta){
        for (ConsultaData buscarconsulta: consulta){
            if (idBuscarConsulta == buscarconsulta.getId ()){
                return buscarconsulta;
            }
        }
        return null;
    }

    public ArrayList<ConsultaData> listarConsultas () {
        for (ConsultaData buscarconsulta : consulta) {
            System.out.println("ID: " + buscarconsulta.getId ());
            System.out.println("Medico: " + buscarconsulta.getMedico ());
            System.out.println("Paciente: " + buscarconsulta.getPaciente ());
            System.out.println("Data: " + buscarconsulta.getData ());
        }

        return consulta;
    }
}
