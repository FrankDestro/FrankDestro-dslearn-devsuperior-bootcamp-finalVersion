package com.devsuperior.dslearnbds.services;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslearnbds.entities.Enrollment;
import com.devsuperior.dslearnbds.entities.Offer;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.EnrollmentRepository;
import com.devsuperior.dslearnbds.repositories.OfferRepository;
import com.devsuperior.dslearnbds.repositories.UserRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void salvarEnrollment(Long userId, Long offerId, Instant enrollMoment, Instant refundMoment,
			boolean available, boolean onlyUpdate) 
					
		throws ObjectNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("User not found"));

		Offer offer = offerRepository.findById(offerId)
				.orElseThrow(() -> new ObjectNotFoundException("Offer not found"));

		Enrollment enrollment = new Enrollment(user, offer, enrollMoment, refundMoment, available, onlyUpdate);

		enrollmentRepository.save(enrollment);
	}
}
