package com.openthinks.woms.product.dao;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.ColorSizesComposition;

public class ColorSizesCompositionDaoImpl extends
		GenericJpaDaoBean<ColorSizesComposition, Integer> implements
		ColorSizesCompositionDao {

	public ColorSizesCompositionDaoImpl() {
		super(ColorSizesComposition.class);
	}

}
