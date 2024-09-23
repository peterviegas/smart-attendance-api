package com.viegas.smartattence.api.dto;

import com.viegas.smartattence.api.entities.Company;

public class CompanyDTO {
	
	private Long id;
	private String legalName;
	private String cnpj;
	
	public CompanyDTO() {
		super();
	}

	public CompanyDTO(Company obj) {
		this.id = obj.getId();
		this.legalName = obj.getLegalName();
		this.cnpj = obj.getCnpj();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "EmpresaDto [id=" + id + ", legalName=" + legalName + ", cnpj=" + cnpj + "]";
	}
}
