package br.com.caritas.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

public class FamiliaVo extends RepresentationModel<FamiliaVo> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long id;
	private String nome = "";
	private String telefone = "";
	private String tec = "";
	private String tel = "";
	private String data = "";
	private String gp = "";
	private String cnpj = "";
	private String dap = "";
	private String cpf = "";
	private String nit = "";
	private String ende = "";
	private String lat = "";
	private String lon = "";
	private String proj = "";
	private String inte = "";
	private String outro = "";
	private String area1 = "";
	private String area2 = "";
	private String area3 = "";
	private String equip = "";
	private String quantidadeEquipamentos = "";
	private String estadoEquipamento = "";
	private String selecao = "";
	private String selecao2 = "";
	private String selecao3 = "";
	private String selecao4 = "";
	private String selecao5 = "";
	private String selecao6 = "";
	private String selecao7 = "";
	private String selecao8 = "";
	private String selecao9 = "";
	private String selecao11 = "";
	private String selecao12 = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(area1, area2, area3, cnpj, cpf, dap, data, ende, equip,
				estadoEquipamento, gp, inte, id, lat, lon, nit, nome, outro, proj, quantidadeEquipamentos, selecao,
				selecao11, selecao12, selecao2, selecao3, selecao4, selecao5, selecao6, selecao7, selecao8, selecao9,
				tec, tel, telefone);
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
		FamiliaVo other = (FamiliaVo) obj;
		return Objects.equals(area1, other.area1) && Objects.equals(area2, other.area2)
				&& Objects.equals(area3, other.area3) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(dap, other.dap) && Objects.equals(data, other.data)
				&& Objects.equals(ende, other.ende) && Objects.equals(equip, other.equip)
				&& Objects.equals(estadoEquipamento, other.estadoEquipamento) && Objects.equals(gp, other.gp)
				&& Objects.equals(inte, other.inte) && Objects.equals(id, other.id) && Objects.equals(lat, other.lat)
				&& Objects.equals(lon, other.lon) && Objects.equals(nit, other.nit) && Objects.equals(nome, other.nome)
				&& Objects.equals(outro, other.outro) && Objects.equals(proj, other.proj)
				&& Objects.equals(quantidadeEquipamentos, other.quantidadeEquipamentos)
				&& Objects.equals(selecao, other.selecao) && Objects.equals(selecao11, other.selecao11)
				&& Objects.equals(selecao12, other.selecao12) && Objects.equals(selecao2, other.selecao2)
				&& Objects.equals(selecao3, other.selecao3) && Objects.equals(selecao4, other.selecao4)
				&& Objects.equals(selecao5, other.selecao5) && Objects.equals(selecao6, other.selecao6)
				&& Objects.equals(selecao7, other.selecao7) && Objects.equals(selecao8, other.selecao8)
				&& Objects.equals(selecao9, other.selecao9) && Objects.equals(tec, other.tec)
				&& Objects.equals(tel, other.tel) && Objects.equals(telefone, other.telefone);
	}

	

}
