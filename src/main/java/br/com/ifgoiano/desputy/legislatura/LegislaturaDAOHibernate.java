package br.com.ifgoiano.desputy.legislatura;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ifgoiano.desputy.usuario.Usuario;

public class LegislaturaDAOHibernate implements LegislaturaDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Legislatura legislatura) {
		this.session.save(legislatura);
	}
	
	@Override
	public void atualizar(Legislatura legislatura) {
		this.session.update(legislatura);
	}
	
	@Override
	public void excluir(Legislatura legislatura) {
		this.session.delete(legislatura);
	}

	@Override
	public Legislatura carregar(Integer codigo) {
		return (Legislatura) this.session.get(Legislatura.class, codigo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Legislatura> listar() {
		return this.session.createCriteria(Legislatura.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Legislatura> listarPorUsuario(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Legislatura.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}
		
}