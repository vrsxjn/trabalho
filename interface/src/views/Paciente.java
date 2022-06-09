import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paciente {
    
    private String nome;
    private String idade;
    private String rg;
    private String cpf;
    private String endereco;
    private String numero;
    private String cep;
    private String sexo;
    private String tipoExame;
    private Date data;

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
        
    public String salvar(){
         try {


             FileWriter fw = new FileWriter("funcionarios.txt",true);
             PrintWriter pw = new PrintWriter(fw);
             pw.println("Nome: " + this.nome );
             pw.println("Sexo: "+ this.sexo );
             pw.println("Idade: "+ this.idade);
             pw.println("RG: "+ this.rg);
             pw.println("CPF: "+ this.cpf);
             pw.println("Endereço: "+ this.endereco);
             pw.println("Número: "+ this.numero);
             pw.println("CEP: "+ this.cep);
             pw.flush();
             pw.close();
             fw.close();

        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Cadastrado com Sucesso!";

     }
    
}
