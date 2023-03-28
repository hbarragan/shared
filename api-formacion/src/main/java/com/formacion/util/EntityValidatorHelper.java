package com.formacion.util;

import com.formacion.core.exception.CustomErrorException;
import com.formacion.core.model.AuditableEntity;
import com.formacion.core.util.MessageConstants;
import com.formacion.core.util.Utils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

public class EntityValidatorHelper {
	public static Object validateIfExists(JpaRepository repository, Long id) {
		Optional<Object> auditable = repository.findById(id);
		return auditable.orElseThrow(() -> new EntityNotFoundException());
	}

	public static AuditableEntity validateExistsAndLastModified(JpaRepository repository, Long id, LocalDateTime date) {
		AuditableEntity auditable = (AuditableEntity) validateIfExists(repository, id);
		// yyyy-MM-dd HH:mm:ss
		if (!Utils.dateToString(auditable.getDataModificacio()).equals(Utils.dateToString(date))) {
			throw new CustomErrorException(HttpStatus.BAD_REQUEST, MessageConstants.UPDATE_ENTITY_OTHER_USER);
		}
		return auditable;
	}
}
