package com.inditex.zara.engine.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@Table(name = "PRICES")
public class Prices implements Serializable {

	private static final long serialVersionUID = -8255034066541840871L;

	@Id
	@SequenceGenerator(name = "PRICES_ID_SEQ", sequenceName = "PRICES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PRICES_ID_SEQ")
	@Column(nullable = false, length = 19)
	private Long id;

	// uni-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(nullable = false, name = "BRAND_ID")
	private Brand brand;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "PRICE_LIST")
	private Integer priceList;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "CURR")
	private String curr;
}
