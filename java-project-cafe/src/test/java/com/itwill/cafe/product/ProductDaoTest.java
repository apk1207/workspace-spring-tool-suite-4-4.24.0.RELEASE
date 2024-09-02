package com.itwill.cafe.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductDaoTest {
	ProductDao productDao;
	
	@BeforeEach
	void setUp() throws Exception {
		productDao = new ProductDao();
		assertNotNull(productDao);
	}

	//@Test
	void testSelectByNo() throws Exception {
		productDao.selectByNo(1);
	}

	//@Test
	void testSelectAll() throws Exception {
		productDao.selectAll();
	}

}
