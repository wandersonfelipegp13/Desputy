package br.com.ifgoiano.desputy.util;

import br.com.ifgoiano.desputy.deputado.DeputadoDAO;
import br.com.ifgoiano.desputy.deputado.DeputadoDAOHibernate;
import br.com.ifgoiano.desputy.usuario.UsuarioDAO;
import br.com.ifgoiano.desputy.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static DeputadoDAO criarDeputadoDAO() {
		DeputadoDAOHibernate deputadoDAO = new DeputadoDAOHibernate();
		deputadoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return deputadoDAO;
	}

}
