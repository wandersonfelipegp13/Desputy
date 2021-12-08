package br.com.ifgoiano.desputy.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.ifgoiano.desputy.usuario.Usuario;
import br.com.ifgoiano.desputy.usuario.UsuarioRN;

@ManagedBean
@SessionScoped
public class ContextoBean implements Serializable {

	private static final long serialVersionUID = -2071855184464371947L;

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if (login != null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			return usuarioRN.buscarPorLogin(login);
		}
		return null;
	}

}
