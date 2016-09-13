package br.com.dac.controle;

import br.com.dac.beans.Usuario;
import br.com.dac.modelo.UsuarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Document   ControleUsuario
 * @Date  12/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 

@Named
@SessionScoped
public class ControleUsuario implements Serializable{

@EJB
    private UsuarioDAO dao;
    private Usuario objeto;

    public ControleUsuario() {
        dao = new UsuarioDAO();
    }

    public String listar() {
        return "/paginas/usuario/listar.xhtml?faces-redirect=true";
    }

    public String novo() {
        objeto = new Usuario();
        return "form";
    }

    public String cancelar() {
        return "listar";
    }

    public String gravar() {
        if (dao.gravar(objeto)) {
            return "listar";
        } else {
            return "form";
        }
    }

    public String alterar(Usuario obj) {
        objeto = obj;
        return "form";
    }

    public String excluir(Usuario obj) {
        dao.excluir(obj);
        return "listar";
    }
    
     public String visao(Usuario obj) {
        objeto = obj;
        return "visao";
    }

    public UsuarioDAO getDao() {
        return  dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }

    public Usuario getObjeto() {
        return objeto;
    }

    public void setObjeto(Usuario objeto) {
        this.objeto = objeto;
    }
    
    public List<Usuario> getUsuarios(){
        return dao.ListarTodos();
    }

}