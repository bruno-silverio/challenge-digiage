package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/digiage", method = RequestMethod.GET)
public class EmployeeController {

	@Autowired /* Injecao de Dependencia - CDI ou IC/CD */
	private EmployeeRepository employeeRepository;

	@GetMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public String retornaOlaMundo(@PathVariable String name) {

		Employee employee = new Employee();
		employee.setName(name);

		employeeRepository.save(employee);/* grava no banco de dados */

		return "Ola mundo " + name;
	}

	@GetMapping(value = "listall") // URL
	@ResponseBody /* Retorna os dados par ao corpo da resposta */
	public ResponseEntity<List<Employee>> employeeList() {

		List<Employee> emp = employeeRepository.findAll(); /* executa a consulta no banco de dados */

		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK); /* Retorna a lista em JSON */
	}

	@PostMapping(value = "save") // URL
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<Employee> save(@RequestBody Employee employee) { /* Recebe os dados para salvar */

		Employee emp = employeeRepository.save(employee);

		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "delete") // URL
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<String> delete(@RequestParam Long idemployee) { /* Recebe os dados para delete */

		employeeRepository.deleteById(idemployee);

		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}

	@PutMapping(value = "update") // URL
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<?> update(@RequestBody Employee employee) { /* Recebe os dados para salvar */

		if (employee.getId() == null) {
			return new ResponseEntity<String>("ID was not provided for update", HttpStatus.OK);
		}

		Employee emp = employeeRepository.saveAndFlush(employee);

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping(value = "findbyid") // URL
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<Employee> findById(
			@RequestParam(name = "idemployee") Long idemployee) { /* Recebe os dados para consultar */

		Employee emp = employeeRepository.findById(idemployee).get();

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping(value = "findbyname") // URL
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<List<Employee>> findByName(
			@RequestParam(name = "name") String name) { /* Recebe os dados para consultar */

		List<Employee> employee = employeeRepository.findByName(name.trim().toUpperCase());

		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
	}
}
