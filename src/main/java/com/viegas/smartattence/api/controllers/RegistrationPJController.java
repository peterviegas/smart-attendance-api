package com.viegas.smartattence.api.controllers;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viegas.smartattence.api.dto.RegistrationPJDTO;
import com.viegas.smartattence.api.entities.Company;
import com.viegas.smartattence.api.entities.Employee;
import com.viegas.smartattence.api.enums.ProfileEnum;
import com.viegas.smartattence.api.services.CompanyService;
import com.viegas.smartattence.api.services.EmployeeService;
import com.viegas.smartattence.api.utils.PasswordUtils;
import com.viegas.smartattence.api.utils.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/registration-pj")
@CrossOrigin(origins = "*")
public class RegistrationPJController {
	private static final Logger log = LoggerFactory.getLogger(RegistrationPJController.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CompanyService companyService;

	public RegistrationPJController() {
	}

	/**
	 * Cadastra uma pessoa jurídica no sistema.
	 * 
	 * @param registratioPJDTO
	 * @param result
	 * @return ResponseEntity<Response<RegistratioPJDTO>>
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping
	public ResponseEntity<Response<RegistrationPJDTO>> cadastrar(@Valid @RequestBody RegistrationPJDTO registratioPJDTO,
			BindingResult result) throws NoSuchAlgorithmException {
		log.info("Cadastrando PJ: {}", registratioPJDTO.toString());
		Response<RegistrationPJDTO> response = new Response<RegistrationPJDTO>();

		validarDadosExistentes(registratioPJDTO, result);
		Company company = this.converterDtoParaCompany(registratioPJDTO);
		Employee employee = this.converterDtoParaEmployee(registratioPJDTO, result);

		if (result.hasErrors()) {
			log.error("Erro validando dados de registratio PJ: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		this.companyService.persistir(company);
		employee.setCompany(company);
		this.employeeService.persistir(employee);

		response.setData(this.converterRegistratioPJDTO(employee));
		return ResponseEntity.ok(response);
	}

	/**
	 * Verifica se a company ou funcionário já existem na base de dados.
	 * 
	 * @param registratioPJDTO
	 * @param result
	 */
	private void validarDadosExistentes(RegistrationPJDTO registratioPJDTO, BindingResult result) {
		this.companyService.buscarPorCnpj(registratioPJDTO.getCnpj())
				.ifPresent(emp -> result.addError(new ObjectError("company", "Company já existente.")));

		this.employeeService.buscarPorCpf(registratioPJDTO.getCpf())
				.ifPresent(func -> result.addError(new ObjectError("employee", "CPF já existente.")));

		this.employeeService.buscarPorEmail(registratioPJDTO.getEmail())
				.ifPresent(func -> result.addError(new ObjectError("employee", "Email já existente.")));
	}

	/**
	 * Converte os dados do DTO para company.
	 * 
	 * @param registratioPJDTO
	 * @return Company
	 */
	private Company converterDtoParaCompany(RegistrationPJDTO registratioPJDTO) {
		Company company = new Company();
		company.setCnpj(registratioPJDTO.getCnpj());
		company.setLegalName(registratioPJDTO.getLegalName());

		return company;
	}

	/**
	 * Converte os dados do DTO para funcionário.
	 * 
	 * @param registratioPJDTO
	 * @param result
	 * @return Employee
	 * @throws NoSuchAlgorithmException
	 */
	private Employee converterDtoParaEmployee(RegistrationPJDTO registratioPJDTO, BindingResult result)
			throws NoSuchAlgorithmException {
		Employee employee = new Employee();
		employee.setName(registratioPJDTO.getName());
		employee.setEmail(registratioPJDTO.getEmail());
		employee.setCpf(registratioPJDTO.getCpf());
		employee.setProfile(ProfileEnum.ROLE_ADMIN);
		employee.setPassword(PasswordUtils.gerarBCrypt(registratioPJDTO.getPassword()));

		return employee;
	}

	/**
	 * Popula o DTO de registratio com os dados do funcionário e company.
	 * 
	 * @param employee
	 * @return RegistratioPJDTO
	 */
	private RegistrationPJDTO converterRegistratioPJDTO(Employee employee) {
		RegistrationPJDTO registratioPJDTO = new RegistrationPJDTO();
		registratioPJDTO.setId(employee.getId());
		registratioPJDTO.setName(employee.getName());
		registratioPJDTO.setEmail(employee.getEmail());
		registratioPJDTO.setCpf(employee.getCpf());
		registratioPJDTO.setLegalName(employee.getCompany().getLegalName());
		registratioPJDTO.setCnpj(employee.getCompany().getCnpj());

		return registratioPJDTO;
	}

}
