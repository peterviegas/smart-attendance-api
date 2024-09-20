package com.viegas.smartattence.api.entities;

import java.io.Serializable;

public class Company  implements Serializable {
	
private static final long serialVersionUID = 3960436649365666213L;
	
	private Long id;
	private String legalName;
	private String cnpj;
	private Date createDate;
	private Date updateDate;
	private List<Employee> employees;

}
