package br.com.ifgoiano.desputy.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.ifgoiano.desputy.legislatura.Legislatura;
import br.com.ifgoiano.desputy.legislatura.LegislaturaRN;

@ManagedBean
@RequestScoped
public class LegislaturaBean {
	
	private Legislatura selecionada = new Legislatura();
	private List<Legislatura> lista = null;
	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;

	public String salvar() {
		this.selecionada.setUsuario(this.contextoBean.getUsuarioLogado());
		LegislaturaRN LegislaturaRN = new LegislaturaRN();
		LegislaturaRN.salvar(this.selecionada);
		this.selecionada = new Legislatura();
		this.lista = null;
		return null;
	}

	public String excluir() {
		LegislaturaRN LegislaturaRN = new LegislaturaRN();
		LegislaturaRN.excluir(this.selecionada);
		this.selecionada = new Legislatura();
		this.lista = null;
		return null;
	}

	public Legislatura getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Legislatura selecionada) {
		this.selecionada = selecionada;
	}

	public List<Legislatura> getLista() {
		if (this.lista == null) {
			LegislaturaRN LegislaturaRN = new LegislaturaRN();
			this.lista = LegislaturaRN.listarPorUsuario(this.contextoBean.getUsuarioLogado());
		}
		return this.lista;

	}

	public void setLista(List<Legislatura> lista) {
		this.lista = lista;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}

}
