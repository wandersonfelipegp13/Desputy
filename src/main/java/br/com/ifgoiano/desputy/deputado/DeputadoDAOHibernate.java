package br.com.ifgoiano.desputy.deputado;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ifgoiano.desputy.usuario.Usuario;

public class DeputadoDAOHibernate implements DeputadoDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Deputado deputado) {
		this.session.save(deputado);
	}

	public void atualizar(Deputado deputado) {
		this.session.update(deputado);
	}

	public void excluir(Deputado deputado) {
		this.session.delete(deputado);
	}

	public Deputado carregar(Integer codigo) {
		return (Deputado) this.session.get(Deputado.class, codigo);
	}

	public List<Deputado> listar() {
		return this.session.createCriteria(Deputado.class).list();
	}

	@Override
	public List<Deputado> listarPorUsuario(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Deputado.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}

	
}
