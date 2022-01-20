package br.com.ifgoiano.desputy.legislatura;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.ifgoiano.desputy.usuario.Usuario;

@Entity
@Table(name = "legislatura")
public class Legislatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idlegislatura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLegislatura;

	@Column(name = "uri")
	private String uri;

	@Column(name = "datainicio")
	private Date dataInicio;

	@Column(name = "datafim")
	private Date dataFim;

	@Column(name = "anoeleicao")
	private int anoEleicao;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "usuario", foreignKey = @ForeignKey(name = "fk_legislatura_usuario"))
	private Usuario usuario;

	public int getIdLegislatura() {
		return idLegislatura;
	}

	public void setIdLegislatura(int idLegislatura) {
		this.idLegislatura = idLegislatura;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getAnoEleicao() {
		return anoEleicao;
	}

	public void setAnoEleicao(int anoEleicao) {
		this.anoEleicao = anoEleicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoEleicao, dataFim, dataInicio, idLegislatura, uri, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Legislatura other = (Legislatura) obj;
		return anoEleicao == other.anoEleicao && Objects.equals(dataFim, other.dataFim)
				&& Objects.equals(dataInicio, other.dataInicio) && idLegislatura == other.idLegislatura
				&& Objects.equals(uri, other.uri) && Objects.equals(usuario, other.usuario);
	}

}
