package br.com.dac.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Document   Usuario
 * @Date  12/09/2016 
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
@SequenceGenerator(name = "usuario_sequencia" , sequenceName = "usuario_sequencia",
        allocationSize = 1 , initialValue = 1)
public class Usuario implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "usuario_sequencia")
  private String id;
  private String nome;
  private String email;
  private String CPF;
  private String telefone;
  private String celular;
  private String observacao;

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", CPF=" + CPF + ", telefone=" + telefone + ", celular=" + celular + ", observacao=" + observacao + '}';
    }

  
}