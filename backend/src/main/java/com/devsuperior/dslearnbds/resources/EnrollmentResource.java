package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.EnrollmentDTO;
import com.devsuperior.dslearnbds.services.EnrollmentService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentResource {

	@Autowired
	private EnrollmentService enrollmentService;

	@PostMapping
	public ResponseEntity<Void> enroll(@RequestBody EnrollmentDTO enrollmentDTO) 
			throws ObjectNotFoundException {
	enrollmentService.salvarEnrollment(enrollmentDTO.getUserId(), enrollmentDTO.getOfferId(),
				enrollmentDTO.getEnrollMoment(), enrollmentDTO.getRefundMoment(), enrollmentDTO.isAvailable(),
				enrollmentDTO.isOnlyUpdate());

		return ResponseEntity.created(null).build();
	}

}
