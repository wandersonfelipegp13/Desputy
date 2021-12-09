package br.com.ifgoiano.desputy.deputado;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.ifgoiano.desputy.usuario.Usuario;

@Entity
@Table(name = "deputado")
public class Deputado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "uri")
	private String uri;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "idlegislaturainicial")
	private int idLegislaturaInicial;
	
	@Column(name = "idlegislaturafinal")
	private int idLegislaturaFinal;
	
	@Column(name = "nomecivil")
	private String nomeCivil;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "siglasexo")
	private String siglaSexo;
	
	@Column(name = "datanascimento")
	private String dataNascimento;
	
	@Column(name = "datafalecimento")
	private String dataFalecimento;
	
	@Column(name = "ufnascimento")
	private String ufNascimento;
	
	@Column(name = "municipionascimento")
	private String municipioNascimento;
	
	@ManyToOne
	@JoinColumn(name = "usuario", foreignKey = @ForeignKey(name = "fk_deputado_usuario"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuario usuario;

	public Deputado() {
		super();
	}

	public Deputado(int id, String uri, String nome, int idLegislaturaInicial, int idLegislaturaFinal,
			String nomeCivil, String cpf, String siglaSexo, String dataNascimento, String dataFalecimento,
			String ufNascimento, String municipioNascimento, Usuario usuario) {
		super();
		this.setId(id);
		this.setUri(uri);
		this.setNome(nome);
		this.setIdLegislaturaInicial(idLegislaturaInicial);
		this.setIdLegislaturaFinal(idLegislaturaFinal);
		this.setNomeCivil(nomeCivil);
		this.setCpf(cpf);
		this.setSiglaSexo(siglaSexo);
		this.setDataNascimento(dataNascimento);
		this.setDataFalecimento(dataFalecimento);
		this.setUfNascimento(ufNascimento);
		this.setMunicipioNascimento(municipioNascimento);
		this.setUsuario(usuario);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdLegislaturaInicial() {
		return idLegislaturaInicial;
	}

	public void setIdLegislaturaInicial(int idLegislaturaInicial) {
		this.idLegislaturaInicial = idLegislaturaInicial;
	}

	public int getIdLegislaturaFinal() {
		return idLegislaturaFinal;
	}

	public void setIdLegislaturaFinal(int idLegislaturaFinal) {
		this.idLegislaturaFinal = idLegislaturaFinal;
	}

	public String getNomeCivil() {
		return nomeCivil;
	}

	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSiglaSexo() {
		return siglaSexo;
	}

	public void setSiglaSexo(String siglaSexo) {
		this.siglaSexo = siglaSexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataFalecimento() {
		return dataFalecimento;
	}

	public void setDataFalecimento(String dataFalecimento) {
		this.dataFalecimento = dataFalecimento;
	}

	public String getUfNascimento() {
		return ufNascimento;
	}

	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}

	public String getMunicipioNascimento() {
		return municipioNascimento;
	}

	public void setMunicipioNascimento(String municipioNascimento) {
		this.municipioNascimento = municipioNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataFalecimento, dataNascimento, id, idLegislaturaFinal, idLegislaturaInicial,
				municipioNascimento, nome, nomeCivil, siglaSexo, ufNascimento, uri, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deputado other = (Deputado) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataFalecimento, other.dataFalecimento)
				&& Objects.equals(dataNascimento, other.dataNascimento) && id == other.id
				&& idLegislaturaFinal == other.idLegislaturaFinal && idLegislaturaInicial == other.idLegislaturaInicial
				&& Objects.equals(municipioNascimento, other.municipioNascimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeCivil, other.nomeCivil) && Objects.equals(siglaSexo, other.siglaSexo)
				&& Objects.equals(ufNascimento, other.ufNascimento) && Objects.equals(uri, other.uri)
				&& Objects.equals(usuario, other.usuario);
	}
	
	
}