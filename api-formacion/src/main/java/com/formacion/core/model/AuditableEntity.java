package com.formacion.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class AuditableEntity {

	@Column(name = "DATA_CREACIO", updatable = false)
	private LocalDateTime dataCreacio;

	@Column(name = "DATA_MODIFICACIO")
	private LocalDateTime dataModificacio;

	@Column(name = "USUARI_CREACIO", updatable = false)
	private String usuariCreacio;

	@Column(name = "USUARI_MODIFICACIO")
	private String usuariModificacio;

	@PrePersist
	protected void setDefaultsOnCreate() {
		usuariModificacio = usuariCreacio;
		dataCreacio = LocalDateTime.now();
		dataModificacio = dataCreacio;
	}

	@PreUpdate
	protected void setDefaultsOnUpdate() {
		dataModificacio = LocalDateTime.now();
	}

}
