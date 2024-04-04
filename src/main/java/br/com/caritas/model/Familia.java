package br.com.caritas.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nome = "";
	@Column
	private String telefone = "";
	@Column
	private String tec = "";
	@Column
	private String tel = "";
	@Column
	private String data = "";
	@Column
	private String gp = "";
	@Column
	private String cnpj = "";
	@Column
	private String dap = "";
	@Column
	private String cpf = "";
	@Column
	private String nit = "";
	@Column
	private String ende = "";
	@Column
	private String lat = "";
	@Column
	private String lon = "";
	@Column
	private String proj = "";
	@Column
	private String inte = "";
	@Column
	private String outro = "";
	@Column
	private String area1 = "";
	@Column
	private String area2 = "";
	@Column
	private String area3 = "";
	@Column
	private String equip = "";
	@Column
	private String quantidadeEquipamentos = "";
	@Column
	private String estadoEquipamento = "";
	@Column
	private String selecao = "";
	@Column
	private String selecao2 = "";
	@Column
	private String selecao3 = "";
	@Column
	private String selecao4 = "";
	@Column
	private String selecao5 = "";
	@Column
	private String selecao6 = "";
	@Column
	private String selecao7 = "";
	@Column
	private String selecao8 = "";
	@Column
	private String selecao9 = "";
	@Column
	private String selecao11 = "";
	@Column
	private String selecao12 = "";

	public Long getKey() {
		return id;
	}

	public void setKey(Long key) {
		this.id = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTec() {
		return tec;
	}

	public void setTec(String tec) {
		this.tec = tec;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getGp() {
		return gp;
	}

	public void setGp(String gp) {
		this.gp = gp;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDap() {
		return dap;
	}

	public void setDap(String dap) {
		this.dap = dap;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getEnde() {
		return ende;
	}

	public void setEnde(String ende) {
		this.ende = ende;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getProj() {
		return proj;
	}

	public void setProj(String proj) {
		this.proj = proj;
	}

	public String getInte() {
		return inte;
	}

	public void setInte(String inte) {
		this.inte = inte;
	}

	public String getOutro() {
		return outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}

	public String getArea1() {
		return area1;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public String getArea2() {
		return area2;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	public String getArea3() {
		return area3;
	}

	public void setArea3(String area3) {
		this.area3 = area3;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	public String getQuantidadeEquipamentos() {
		return quantidadeEquipamentos;
	}

	public void setQuantidadeEquipamentos(String quantidadeEquipamentos) {
		this.quantidadeEquipamentos = quantidadeEquipamentos;
	}

	public String getEstadoEquipamento() {
		return estadoEquipamento;
	}

	public void setEstadoEquipamento(String estadoEquipamento) {
		this.estadoEquipamento = estadoEquipamento;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}

	public String getSelecao2() {
		return selecao2;
	}

	public void setSelecao2(String selecao2) {
		this.selecao2 = selecao2;
	}

	public String getSelecao3() {
		return selecao3;
	}

	public void setSelecao3(String selecao3) {
		this.selecao3 = selecao3;
	}

	public String getSelecao4() {
		return selecao4;
	}

	public void setSelecao4(String selecao4) {
		this.selecao4 = selecao4;
	}

	public String getSelecao5() {
		return selecao5;
	}

	public void setSelecao5(String selecao5) {
		this.selecao5 = selecao5;
	}

	public String getSelecao6() {
		return selecao6;
	}

	public void setSelecao6(String selecao6) {
		this.selecao6 = selecao6;
	}

	public String getSelecao7() {
		return selecao7;
	}

	public void setSelecao7(String selecao7) {
		this.selecao7 = selecao7;
	}

	public String getSelecao8() {
		return selecao8;
	}

	public void setSelecao8(String selecao8) {
		this.selecao8 = selecao8;
	}

	public String getSelecao9() {
		return selecao9;
	}

	public void setSelecao9(String selecao9) {
		this.selecao9 = selecao9;
	}

	public String getSelecao11() {
		return selecao11;
	}

	public void setSelecao11(String selecao11) {
		this.selecao11 = selecao11;
	}

	public String getSelecao12() {
		return selecao12;
	}

	public void setSelecao12(String selecao12) {
		this.selecao12 = selecao12;
	}
}
