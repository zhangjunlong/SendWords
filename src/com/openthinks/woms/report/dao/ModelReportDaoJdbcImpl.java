package com.openthinks.woms.report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.openthinks.woms.report.ModelReportByAccountItem;
import com.openthinks.woms.rest.SignController;
import common.Logger;

public class ModelReportDaoJdbcImpl implements ModelReportDao {
	private static final Logger logger = Logger
			.getLogger(ModelReportDaoJdbcImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Collection<ModelReportByAccountItem> countModeByAccount(
			String accountId) throws Exception {

		String sql = "SELECT ac.name as AC_NAME, p.model as MODEL, p.name as PRO_NAME, p.sellingPrice as SEL_PRICE, count(distinct c.id) as COLOR_COUNT, SUM(p.orderingPrice*o.quantity) as AMOUNT ";
		sql += "FROM Account ac, productorder o, product p, product_colorSizesComposition p_csc, colorsizescomposition csc, color c ";
		sql += "WHERE ac.id = o.account_id and o.product_id=p.id and p.id=p_csc.product_id and p_csc.colorSizesCompositions_id=csc.id and csc.color_id=c.id AND ac.id LIKE '"
				+ accountId + "' ";
		sql += "GROUP BY p.model";

		logger.debug(sql);

		return jdbcTemplate.query(sql, new ActorMapper());
	}

	private static final class ActorMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			ModelReportByAccountItem mra = new ModelReportByAccountItem();
			mra.setAccountName(rs.getString("AC_NAME"));
			mra.setModel(rs.getString("MODEL"));
			mra.setProductName(rs.getString("PRO_NAME"));
			mra.setPrice(rs.getFloat("SEL_PRICE"));
			mra.setColorModelCount(rs.getInt("COLOR_COUNT"));
			mra.setAmount(rs.getLong("AMOUNT"));

			return mra;
		}
	}
}
