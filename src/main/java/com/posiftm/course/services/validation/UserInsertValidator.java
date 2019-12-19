package com.posiftm.course.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.posiftm.course.dto.UserInsertDTO;
import com.posiftm.course.entities.User;
import com.posiftm.course.repositories.UserRepository;
import com.posiftm.course.resources.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		User user = userRepository.findByEmail(dto.getEmail());	
		if(user != null) {
			list.add(new FieldMessage("email", "email already taken"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}
}