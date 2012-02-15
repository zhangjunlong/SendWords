package com.openthinks.woms.product.service;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.SimplifiedProduct;

public interface SimplifiedProductService {
	SectionResult<SimplifiedProduct> find(String keywords, int pageSize,
			int page) throws Exception;
}
