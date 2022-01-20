package br.com.ifgoiano.desputy.deputado;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	public List<Deputado> listar() {
		return this.session.createCriteria(Deputado.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deputado> listarPorUsuario(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Deputado.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deputado> listarPorEstado(String estado) {
		Criteria criteria = this.session.createCriteria(Deputado.class);
		criteria.add(Restrictions.eq("ufnascimento", estado));
		return criteria.list();
	}

	/**
	 * Listar os estados por ordem de maior quantidade de deputados.
	 */

	@Override
	public List<EstadoDeputado> listarEstadosPopulosos() {
		/**
		 * A consulta abaixo retorna, em ordem decrescente, o UF e a quantidade de deputados para os estados
		 */
		String hql = "select d.ufNascimento, COUNT(d.ufNascimento) from Deputado as d group by d.ufNascimento order by count(d.ufNascimento) desc";
		Query query = this.session.createQuery(hql);

		List<?> list = query.list();
		List<EstadoDeputado> result = new ArrayList<EstadoDeputado>();

		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			EstadoDeputado obj = new EstadoDeputado();
			obj.setUfnascimento(row[0].toString());
			obj.setDeputados(Integer.parseInt(row[1].toString()));
			result.add(obj);
		}
		
		return result;
	}

}
