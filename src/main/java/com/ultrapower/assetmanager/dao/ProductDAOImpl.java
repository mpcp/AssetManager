package com.ultrapower.assetmanager.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ultrapower.assetmanager.model.Product;

public class ProductDAOImpl implements ProductDAO {
	static final Logger LOG = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory
				.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		LOG.trace("Hello World!");
		LOG.debug("How are you today?");
		LOG.info("I am fine.");
		LOG.warn("I love programming.");
		LOG.error("I am programming.");
		return listProduct;
	}
}
