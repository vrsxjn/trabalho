package trabalho;

import java.sql.SQLException;

public class Cadastro {

	private PacienteModel paciente = new PacienteModel();
	private RegistroDAO registro = new RegistroDAO();
	
	
	public String inserirPaciente(PacienteModel paciente) {
		try {
			registro.inserir(paciente);
			return "Cadastro realizado com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
