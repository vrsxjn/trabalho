package trabalho;

import connection.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class RegistroDAO {
  
  public void inserir(PacienteModel pacienteModel) throws SQLException {
	  
	  	Connection con = database.getConnection();
	    PreparedStatement stmt = null;
	  //  ResultSet rs = null;
	    
	  try {

 /*   stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?"); // coloca pra pega quemt a registrando
    
    rs = stmt.executeQuery();
    if(rs.next()) {
      int testezin = rs.getInt("permission");
      
      */
    
      if(true) {
        stmt = con.prepareStatement("INSERT INTO paciente(cpf,rg,nome,idade,endereco,numero_endereco) VALUES(?,?,?,?,?,?)");
        stmt.setString(1, pacienteModel.getCpf());
        stmt.setString(2, pacienteModel.getRg());
        stmt.setString(3, pacienteModel.getNome());
        stmt.setString(4, pacienteModel.getIdade());
        stmt.setString(5, pacienteModel.getEndereco());
        stmt.setString(6, pacienteModel.getNumeroEndereco());
        stmt.executeUpdate();
      }else {
        JOptionPane.showMessageDialog(null, "Você não tem premissão");
      }
	  }
	  catch(SQLException se){
		  System.out.println(se.getMessage());	  
	  }
      finally {
    	  con.close();
    	  stmt.close();
    	//  rs.close();
      }
    }

//}
public static void registroPermission(int numero) throws SQLException {
  
  Connection con = database.getConnection();
  PreparedStatement stmt = null;
  ResultSet rs = null;

  
  stmt = con.prepareStatement(""); // coloca pra puxa a de quem ta usando permissao
  rs = stmt.executeQuery();
  if(rs.next()) {
    int testezin = rs.getInt("permission");
    if(testezin == 2) {
      stmt = con.prepareStatement(""); // da upload no usuario
      rs = stmt.executeQuery();
      JOptionPane.showMessageDialog(null, "Permissão alterada com sucesso");

    }else {
      JOptionPane.showMessageDialog(null, "Você não tem premissão");
    }
  }

}
public static void registroRelatorio(int numero) throws SQLException {
  
  Connection con = database.getConnection();
  PreparedStatement stmt = null;
  ResultSet rs = null;

  
  stmt = con.prepareStatement(""); // coloca pra puxa a de quem ta usando permissao
  rs = stmt.executeQuery();
  if(rs.next()) {
    int testezin = rs.getInt("permission");
    if(testezin == 1) {
      stmt = con.prepareStatement(""); // da upload no usuario
      rs = stmt.executeQuery();
      JOptionPane.showMessageDialog(null, "Registro do relatorio efetuado");

    }else {
      JOptionPane.showMessageDialog(null, "Você não tem premissão");
    }
  }
}
public static void registroConsulta(int numero) throws SQLException {
  
  Connection con = database.getConnection();
  PreparedStatement stmt = null;
  ResultSet rs = null;

  
  stmt = con.prepareStatement(""); // coloca pra puxa a de quem ta usando permissao
  rs = stmt.executeQuery();
  if(rs.next()) {
    int testezin = rs.getInt("permission");
    if(testezin == 1) {
      stmt = con.prepareStatement(""); // da upload no usuario
      rs = stmt.executeQuery();
      JOptionPane.showMessageDialog(null, "Registro do relatorio efetuado");

    }else {
      JOptionPane.showMessageDialog(null, "Você não tem premissão");
    }
  }

}
public static void registroHospital(int numero) throws SQLException {
  
  Connection con = database.getConnection();
  PreparedStatement stmt = null;
  ResultSet rs = null;

  
  stmt = con.prepareStatement(""); // coloca pra puxa a de quem ta usando permissao
  rs = stmt.executeQuery();
  if(rs.next()) {
    int testezin = rs.getInt("permission");
    if(testezin == 1) {
      stmt = con.prepareStatement(""); // da upload no usuario
      rs = stmt.executeQuery();
      JOptionPane.showMessageDialog(null, "Registro do relatorio efetuado");

    }else {
      JOptionPane.showMessageDialog(null, "Você não tem premissão");
    }
  }

}
}