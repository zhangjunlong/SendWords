package com.openthinks.woms.product.dao;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.SimplifiedProduct;

public interface SimplifiedProductDao {
	SectionResult<SimplifiedProduct> read(String keywords, int pageSize,
			int page) throws Exception;
}
