package com.itwill.shop.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductDaoTest {
	ProductDao productDao;
	@Test
	@BeforeEach
	void setUp() throws Exception {
		productDao = new ProductDao();
		assertNotNull(productDao);
	}

	@Test
	void testFindByNo() throws Exception {
		Product product = productDao.findByNo(1);
		assertNotNull(product);
		assertEquals(1, product.getP_no());
	}

	@Test
	void testFindAll() throws Exception {
		List<Product> productList = productDao.findAll();
		assertTrue(productList.size() >= 0);
	}

}
