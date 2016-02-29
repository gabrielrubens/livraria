package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public Usuario buscaPeloLogin(String login) {
		TypedQuery<Usuario> createQuery = manager.createQuery("select u from Usuario u where u.login = :login", Usuario.class);
		createQuery.setParameter("login", login);
		return createQuery.getSingleResult();
	}
	
}
