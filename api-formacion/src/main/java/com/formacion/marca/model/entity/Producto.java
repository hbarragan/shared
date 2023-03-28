package com.formacion.marca.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PRODUCTO_ID_SEQ")
	@SequenceGenerator(allocationSize=1,  name="PRODUCTO_ID_SEQ", sequenceName = "PRODUCTO_ID_SEQ")
	private Long id;

	@Column(name = "marca_id")
	private Long marcaId;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "product_desc")
	private String productDescription;

	private Float price;

	@Column(name = "curr")
	private String currency;

}
