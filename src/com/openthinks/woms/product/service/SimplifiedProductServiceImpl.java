package com.openthinks.woms.product.service;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.SimplifiedProduct;
import com.openthinks.woms.product.dao.SimplifiedProductDao;

public class SimplifiedProductServiceImpl implements SimplifiedProductService {

	private SimplifiedProductDao simplifiedProductDao;

	public void setSimplifiedProductDao(
			SimplifiedProductDao simplifiedProductDao) {
		this.simplifiedProductDao = simplifiedProductDao;
	}

	@Override
	public SectionResult<SimplifiedProduct> find(String keywords, int pageSize,
			int page) throws Exception {
		return simplifiedProductDao.read(keywords, pageSize, page);
	}

}
