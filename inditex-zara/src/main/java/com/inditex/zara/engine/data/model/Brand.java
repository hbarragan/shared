package com.inditex.zara.engine.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "BRAND")
public class Brand  implements Serializable
{
	@Id
	private Long id;

	@Column(name = "CODE")
	private String code;
}
