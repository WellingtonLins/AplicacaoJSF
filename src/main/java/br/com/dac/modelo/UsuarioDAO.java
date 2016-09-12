package br.com.dac.modelo;

import br.com.dac.beans.Usuario;
import br.com.dac.util.UtilErros;
import br.com.dac.util.UtilMensagens;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Document   UsuarioDAO
 * @Date  12/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Stateless
public class UsuarioDAO {
  
    @PersistenceContext(unitName = "AplicacaoJSF_PU")
    private EntityManager em;

    public List<Usuario> ListarTodos() {
        return em.createQuery("select u from Usuario u").getResultList();
    }

    public boolean gravar(Usuario obj) {
        try {
            
            if (obj.getId() == null) {
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            
            UtilMensagens.mensagemInformacao("Objeto persistido com sucesso!");
            return true;
        } catch (Exception e) {
            
            UtilMensagens.mensagemErro("Erro ao persistir objeto: " + UtilErros.getMensagemErro(e));
            return false;
        }
    }

    public boolean excluir(Usuario obj) {
        try {            
            Usuario g = em.merge(obj);
            em.remove(g);
//            em.remove(em.merge(obj));
            UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
            return true;
        } catch (Exception e) {
            
            UtilMensagens.mensagemErro("Erro ao remover objeto: " + UtilErros.getMensagemErro(e));
            return false;
        }
    }

    public Usuario localizar(Integer id) {
        return em.find(Usuario.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}