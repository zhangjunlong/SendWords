package com.openthinks.woms.product.service;

import java.util.Collection;
import java.util.List;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.Color;
import com.openthinks.woms.product.ColorSizesComposition;
import com.openthinks.woms.product.Product;
import com.openthinks.woms.product.Size;
import com.openthinks.woms.product.dao.ColorDao;
import com.openthinks.woms.product.dao.ProductDao;
import com.openthinks.woms.product.dao.SizeDao;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	private ColorDao colorDao;

	private SizeDao sizeDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setColorDao(ColorDao colorDao) {
		this.colorDao = colorDao;
	}

	public void setSizeDao(SizeDao sizeDao) {
		this.sizeDao = sizeDao;
	}
	
	@Override
	public List<Product> find() throws Exception {
		return productDao.read();
	}

	@Override
	public SectionResult<Product> find(int size, int section) throws Exception {
		return productDao.read(size, section);
	}

	@Override
	public SectionResult<Object> find(String accountId, String keywords,String productSeason,String productStyle,
			int orderType, int size, int section) throws Exception {
		return productDao.read(accountId, keywords,productSeason,productStyle, orderType, size, section);
	}

	@Override
	public Product find(long id) throws Exception {
		return productDao.read(id);
	}

	public void create(Product product) throws Exception {
		for (ColorSizesComposition csc : product.getColorSizesCompositions()) {
			Color c = colorDao.read(csc.getColor().getId());
			csc.setColor(c);
			for (Size size : csc.getSizes()) {
				size = sizeDao.read(size.getId());
			}

			// colorSizesCompositionDao.create(csc);
		}

		productDao.create(product);
	}

	public void create(Collection<Product> products) throws Exception {
		try {
			for (Product product : products) {
				productDao.create(product);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Product product) throws Exception {
		productDao.update(product);
	}

	@Override
	public void delete(long id) throws Exception {
		Product persistentProduct = productDao.read(id);
		productDao.delete(persistentProduct);
	}

	@Override
	public List<Object> getProductSeason() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
