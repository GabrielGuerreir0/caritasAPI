package br.com.caritas.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String descricao;
	@Column
	private String colhidos;
	@Column
	private String consumidos;
	@Column
	private String cultivados;
	@Column
	private String nome;
	@Column
	private String nomef;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<Item> itens;

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

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colhidos, consumidos, cultivados, descricao, id, itens, nome, nomef);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(colhidos, other.colhidos) && Objects.equals(consumidos, other.consumidos)
				&& Objects.equals(cultivados, other.cultivados) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(itens, other.itens)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomef, other.nomef);
	}

}
