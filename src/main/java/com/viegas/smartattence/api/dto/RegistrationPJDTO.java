package com.viegas.smartattence.api.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class RegistrationPJDTO {

	private Long id;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private String legalName;
	private String cnpj;
	
	public RegistrationPJDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Name can't empty.")
	@Length(min = 3, max = 200, message = "Name must between 3 e 200 characteres.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(message = "Email can't to be empty.")
	@Length(min = 5, max = 200, message = "Email must between 5 e 200 characteres.")
	@Email(message="Email inválido.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "Passworf can't to be empty.")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty(message = "CPF can't to be empty.")
	@CPF(message="CPF not valid")
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	@NotEmpty(message = "CNPJ can't to be empty.")
	@CNPJ(message="CNPJ not valid.")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "FuncionarioDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", legalName=" + legalName+ ", cnpj=" + cnpj + "]";
	}
}
