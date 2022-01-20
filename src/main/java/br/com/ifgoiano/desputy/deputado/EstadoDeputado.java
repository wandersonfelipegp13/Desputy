package br.com.ifgoiano.desputy.deputado;

import java.util.Objects;

public class EstadoDeputado {
	
	private String ufnascimento;
	private int deputados;
		
	public EstadoDeputado() {
		super();
	}

	public EstadoDeputado(int id, String uf, int deputados) {
		super();
		this.ufnascimento = uf;
		this.deputados = deputados;
	}

	public String getUfnascimento() {
		return ufnascimento;
	}

	public void setUfnascimento(String ufnascimento) {
		this.ufnascimento = ufnascimento;
	}

	public int getDeputados() {
		return deputados;
	}

	public void setDeputados(int deputados) {
		this.deputados = deputados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deputados, ufnascimento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoDeputado other = (EstadoDeputado) obj;
		return deputados == other.deputados && Objects.equals(ufnascimento, other.ufnascimento);
	}

	@Override
	public String toString() {
		return "EstadoDeputado [ufnascimento=" + ufnascimento + ", deputados=" + deputados + "]";
	}
	
}
