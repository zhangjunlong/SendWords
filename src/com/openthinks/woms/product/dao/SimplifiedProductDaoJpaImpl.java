package com.openthinks.woms.product.dao;

import com.openthinks.dao.GenericDao;
import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.SimplifiedProduct;

public class SimplifiedProductDaoJpaImpl implements SimplifiedProductDao {

	private GenericDao<SimplifiedProduct, Object> genericDao;

	public void setGenericDao(GenericDao<SimplifiedProduct, Object> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public SectionResult<SimplifiedProduct> read(String keywords, int pageSize,
			int page) throws Exception {
		String[] conditions = keywords.split(",");
		StringBuilder ql = new StringBuilder(
				"select new com.openthinks.woms.product.SimplifiedProduct(p.id,p.brand.text,p.model,p.name) from Product p where ");

		for (String condition : conditions) {
			ql.append("p.name like '%");
			ql.append(condition);
			ql.append("%' OR ");

			ql.append("p.model like '%");
			ql.append(condition);
			ql.append("%' OR ");
		}
		ql.delete(ql.length() - 4, ql.length());

		return genericDao.readSpecifiedSection(ql.toString(), pageSize, page);
	}

}
