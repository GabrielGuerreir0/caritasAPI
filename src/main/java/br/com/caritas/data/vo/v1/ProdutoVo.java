package br.com.caritas.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


public class ProdutoVo extends RepresentationModel<ProdutoVo> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private String colhidos;
	private String consumidos;
	private String cultivados;
	private String nome;
	private String nomef;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getColhidos() {
		return colhidos;
	}

	public void setColhidos(String colhidos) {
		this.colhidos = colhidos;
	}

	public String getConsumidos() {
		return consumidos;
	}

	public void setConsumidos(String consumidos) {
		this.consumidos = consumidos;
	}

	public String getCultivados() {
		return cultivados;
	}

	public void setCultivados(String cultivados) {
		this.cultivados = cultivados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomef() {
		return nomef;
	}

	public void setNomef(String nomef) {
		this.nomef = nomef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(colhidos, consumidos, cultivados, descricao, id, nome, nomef);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoVo other = (ProdutoVo) obj;
		return Objects.equals(colhidos, other.colhidos) && Objects.equals(consumidos, other.consumidos)
				&& Objects.equals(cultivados, other.cultivados) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomef, other.nomef);
	}

}
