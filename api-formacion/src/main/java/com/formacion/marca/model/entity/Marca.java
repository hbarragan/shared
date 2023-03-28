package com.formacion.marca.model.entity;

import com.formacion.core.model.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MARCA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca extends AuditableEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MARCA_ID_SEQ")
	@SequenceGenerator(allocationSize=1,  name="MARCA_ID_SEQ", sequenceName = "MARCA_ID_SEQ")
	private Long id;
	@Column(nullable = false)
	private String code;
	@Column(nullable = false)
	private String description;

	public Marca(String code , String description){
		this.code = code;
		this.description = description;
	}

}
