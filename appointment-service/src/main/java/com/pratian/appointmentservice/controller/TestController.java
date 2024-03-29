package com.pratian.appointmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.appointmentservice.entities.Test;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.TestAlreadyPresentException;
import com.pratian.appointmentservice.exceptions.TestNotFoundException;
import com.pratian.appointmentservice.service.TestService;

import io.swagger.v3.oas.annotations.Operation;
@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
//@RequestMapping("/appointments")
public class TestController {
	
	@Autowired
	TestService testService;
	
	/*
	 * Method to add test
	 * throws
	 */
	
	@PostMapping("/tests")
	@Operation(summary = "To add the test")
	public ResponseEntity<?> createTest(@RequestBody Test test) throws TestAlreadyPresentException{
		ResponseEntity<?> response = null;
			
				response = new ResponseEntity<>(testService.addTest(test), HttpStatus.OK);

		
		return response;
	}
	
	@PostMapping("/appointments/{id}/tests")
	@Operation(summary = "To add the test to appointments")
	public ResponseEntity<?> addTestToAppointment(@PathVariable(value="id")long id , @RequestBody Test test) throws AppointmentNotFoundException {
		ResponseEntity<?> response = null;
			
				response = new ResponseEntity<>(testService.addTestByAppointmentsId(id,test), HttpStatus.OK);
//			
		
		return response;
	}

	/*
	 * Method to get all tests
	 */
	@GetMapping("/tests")
	@Operation(summary = "Get all tests")
	public ResponseEntity<?> getTests(){
		ResponseEntity<?> response = null;
		response= new ResponseEntity<>(testService.getAllTest(),HttpStatus.OK);		
		return response;
	}
	
	/*
	 * Method to get test by id
	 */
	@GetMapping("/tests/id/{id}")
	public ResponseEntity<?> getTestByTestId(@PathVariable(value="id")long tid)throws TestNotFoundException {
		ResponseEntity<?> response = null;
		response= new ResponseEntity<>(testService.getTestById(tid),HttpStatus.OK);
		return response;
	}
	/*
	 * Method to get test by name
	 */
	@GetMapping("/tests/name/{name}")
	public Test getTestByName(@PathVariable(value="name")String name)throws TestNotFoundException {
		return testService.getTestByName(name);
		
	}
	/*
	 * Method to remove test
	 */
	@DeleteMapping("/tests/{id}") 
	public void deleteTest(@PathVariable(value="id") long id) throws TestNotFoundException{
		testService.removeTest(id);
	}
	
	@PutMapping(value="/tests/{id}")
	public  ResponseEntity<?> editTest(@PathVariable(name="id") long id,  @RequestBody Test test) throws TestNotFoundException{
		ResponseEntity<?> response = null;

			response = new ResponseEntity<Test>(testService.updateTest(id, test), HttpStatus.OK);

		return response;
	}
	
	@PutMapping(value="/appointments/{appointment_id}/test/{test_id}")
	public  ResponseEntity<?> editTestForAppointment(@PathVariable(name="appointment_id") long id,@PathVariable(name="test_id") long testId ,  @RequestBody Test test) throws AppointmentNotFoundException{
		ResponseEntity<?> response = null;

			response = new ResponseEntity<Test>(testService.updateTestForAppointment(id,testId,test), HttpStatus.OK);
	
		return response;
	}
	
	
	
}
