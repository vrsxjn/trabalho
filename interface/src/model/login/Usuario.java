package model.login;

import connection.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class Usuario {
	
	private String loginUsuario;
	private String senhaUsuario;

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

public static boolean checkLogin(String login, String senha) {
    login = login.replaceAll(" ", "");
    senha = senha.replaceAll(" ", "");
    if(login.length() > 32 || login.length() <= 0){
      JOptionPane.showMessageDialog(null, "Digita o login entre 1 - 32!");
    }else if(senha.length() <= 0 || senha.length() > 16){
      JOptionPane.showMessageDialog(null, "Digita uma senha entre 1 - 16!");
    }else {
    Connection con = database.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    boolean check = false;
    try {
    stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
    stmt.setString(1, login);
    stmt.setString(2, senha);
    rs = stmt.executeQuery();
      if(rs.next()) {
        String testezin = rs.getString("login");
        String senhazin = rs.getString("senha");
        
        if(testezin.equals(login) && senhazin.equals(senha)) {
      
          check = true;
          JOptionPane.showMessageDialog(null, "Usuario conectado sucesso!");
        
        }else {
          check = false;
          JOptionPane.showMessageDialog(null, "Usuario invalido!");
        }
       }
      } catch (SQLException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
        database.closeConnection(con, stmt, rs);
       }
       return check;
    }
    JOptionPane.showMessageDialog(null, "Usuario invalido!");
    return false;
  }

  public static void registroUsuario(UsuarioModel usuario) {
    Connection con = database.getConnection();
    PreparedStatement stmt = null;
   /*   if(login.indexOf(" ") == -1 && senha1.indexOf(" ") == -1 && senha2.indexOf(" ") == -1){
          if(senha1 == senha2) {
          */
            try{
              stmt = con.prepareStatement("INSERT INTO usuario(login, senha, permission) VALUES (?,?,?)");
              stmt.setString(1, usuario.getLoginUsuario());
              stmt.setString(2, usuario.getCpf());
              stmt.setInt(3, usuario.getPermissao());
              stmt.executeUpdate();
              JOptionPane.showMessageDialog(null, "Usuario criado com sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
               } finally {
                database.closeConnection(con, stmt);
               }
         /* }else {
            JOptionPane.showMessageDialog(null, "Senha incopativeis!");
          } */
    }
  }
