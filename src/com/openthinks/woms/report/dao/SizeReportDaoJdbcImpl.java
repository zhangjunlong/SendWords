package com.openthinks.woms.report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.openthinks.woms.report.SizeReportItem;

public class SizeReportDaoJdbcImpl implements SizeReportDao {

	private static final Logger logger = Logger
			.getLogger(SizeReportDaoJdbcImpl.class);

	private static StringBuilder sb;

	static {
		sb = new StringBuilder();
		sb.append("select {style}.id CANDIDATE_ID, {style}.name CANDIDATE_NAME, sz.sortId SIZE_SORT_ID, sz.name SIZE_NAME, o.quantity QTY, (o.quantity / x_q ) * 100 QTY_RATIO, y_q QTY_SUM ");
		sb.append("from Product p, ProductOrder o, Style style, Size sz, Category category, Series series, Account ac, ");

		sb.append("(select xs.id x_id, sum(xo.quantity) x_q from  Product xp, ProductOrder xo, Style xs, Size xsz ");
		sb.append("where xp.style_id=xs.id and xp.id=xo.product_id and xo.size_id=xsz.id group by xs.id) x, ");
		sb.append("(select sum(yo.quantity) y_q from ProductOrder yo) y ");

		sb.append("where p.style_id=style.id and p.id=o.product_id and o.size_id=sz.id and style.id=x.x_id and series.id = p.series_id and category.id=p.category_id and ac.id = o.account_id ");
		sb.append("and ac.id like '{accoundId}' ");
		sb.append("group by {style}.id, sz.id");

	}

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Collection<SizeReportItem> countSizeByCandidate(String accountId,
			String candidate) {

		String sql = sb.toString().replaceAll("\\{style\\}", candidate)
				.replaceAll("\\{accoundId\\}", accountId);

		logger.debug(sql);

		return jdbcTemplate.query(sql, new ActorMapper());
	}

	private static final class ActorMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SizeReportItem sr = new SizeReportItem();
			sr.getSize().setSortId(rs.getInt("SIZE_SORT_ID"));
			sr.getSize().setName(rs.getString("SIZE_NAME"));
			sr.setCandidateId(rs.getString("CANDIDATE_ID"));
			sr.setCandidate(rs.getString("CANDIDATE_NAME"));
			sr.setQuantity(rs.getLong("QTY"));
			sr.setQuantityRatio(rs.getDouble("QTY_RATIO"));

			return sr;
		}
	}

}
