package model.login;

import connection.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class RegistroDAO {
  
  public static void inserir(String cpf, String rg, String nome) throws SQLException {
    Connection con = database.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?"); // coloca pra pega quemt a registrando
    
    rs = stmt.executeQuery();
    if(rs.next()) {
      int testezin = rs.getInt("permission");
      if(testezin == 1) {
        stmt = con.prepareStatement("INSERT INTO pacientes(cpf,rg,nome) VALUES(?,?,?)");
        stmt.setString(1, cpf);
        stmt.setString(2, rg);
        stmt.setString(3, nome);
        rs = stmt.executeQuery();
      }else {
        JOptionPane.showMessageDialog(null, "Você não tem premissão");
      }
    }

}
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