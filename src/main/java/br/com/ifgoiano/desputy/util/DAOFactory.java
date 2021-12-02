package br.com.ifgoiano.desputy.util;

import br.com.ifgoiano.desputy.usuario.UsuarioDAO;
import br.com.ifgoiano.desputy.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

}
