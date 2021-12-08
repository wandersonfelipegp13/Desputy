package br.com.ifgoiano.desputy.deputado;

import java.util.List;

import org.hibernate.Session;

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

	
}
