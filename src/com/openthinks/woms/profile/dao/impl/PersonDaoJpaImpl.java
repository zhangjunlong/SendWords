package com.openthinks.woms.profile.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.dao.SectionResult;
import com.openthinks.woms.profile.Person;
import com.openthinks.woms.profile.dao.PersonDao;

public class PersonDaoJpaImpl extends GenericJpaDaoBean<Person, Long>
		implements PersonDao {

	public PersonDaoJpaImpl() {
		super(Person.class);
	}

	@Override
	public List<Person> read() throws Exception {
		String ql = "select p from Person p order by p.name";

		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}

	@Override
	public SectionResult<Person> read(int size, int section) throws Exception {
		String ql = "select p from Person p order by p.name";

		return this.readSpecifiedSection(ql, size, section);
	}

	@Override
	public SectionResult<Object> read(String accountId, String keywords,
			String productSeason, String productStyle, int orderType, int size,
			int section)
			throws Exception {
		String searchCondition = "";
		if (StringUtils.isNotEmpty(keywords)) {
			searchCondition = " where";
            String brevityCodeCondition = "";

			String[] keywordArray = keywords.split(",");
			for (String keyword : keywordArray) {
                brevityCodeCondition += " p.brevityCode = '" + keyword + "' or";
			}

            brevityCodeCondition = StringUtils.removeEnd(brevityCodeCondition, "or");

			searchCondition += brevityCodeCondition ;
			
		}else{
			if(StringUtils.isNotEmpty(productSeason)||StringUtils.isNotEmpty(productStyle)){
				searchCondition = " where ";
				if(StringUtils.isNotEmpty(productSeason)){
					if(orderType==2){
						searchCondition += "temp.seasonId='"+productSeason+"'";
					}else{
						searchCondition += "p.season_id='"+productSeason+"'";
					}
				}
				if(StringUtils.isNotEmpty(productStyle)){
					if(searchCondition.length()>10){
						searchCondition += " and ";
					}
					if(orderType==2){
						searchCondition += "temp.styleId='"+productStyle+"'";
					}else{
						searchCondition += "p.style_id='"+productStyle+"'";
					}
				}
			}
		}

		String sql;
		if(orderType == 1){
		    sql = "select p.id as id,b.text as brand,p.model as model,p.name as name,p.orderingPrice as orderingPrice,p.brevityCode as brevityCode," +
		        "p.sellingPrice as sellingPrice,p.originalPrice as originalPrice,s.id as styleId,s.name as style,p.promotional as promotional,p.code as code," +
		        "se.name as series,sea.id as seasonId,sea.name as season,c.name as category,p.remark as remark,sum(o.quantity) as orderCount " +
                "from (select * from productOrder po where po.account_id='"+accountId+"') o inner join product p on o.product_id=p.id " +
                "inner join category c on p.category_id=c.id inner join series se on p.series_id=se.id inner join style s on p.style_id=s.id " +
                "inner join season sea on p.season_id=sea.id inner join brand b on p.brand_id=b.id " +
                searchCondition + " group by p.id order by p.model";
		}else if(orderType == 2){
		    sql = "select * from(select p.id as id,b.text as brand,p.model as model,p.orderingPrice as orderingPrice,p.brevityCode as brevityCode," +
		    	"p.name as name,p.sellingPrice as sellingPrice,p.originalPrice as originalPrice,s.id as styleId,p.promotional as promotional," +
		    	"se.name as series,p.code as code,p.season_id as seasonId,sea.name as season,c.name as category,p.remark as remark," +
		    	"s.name as style,0 as orderCount,o.id as tempcolum " +
		        "from (select * from productOrder po where po.account_id='"+accountId+"') o right join product p on p.id=o.product_id " +
		        "inner join category c on p.category_id=c.id inner join series se on p.series_id=se.id inner join style s on p.style_id=s.id " +
		        "inner join season sea on p.season_id=sea.id inner join brand b on p.brand_id=b.id ) as temp " +
		        (searchCondition==""?"where":(searchCondition + " and ")) + " temp.tempcolum is null order by temp.model";
		}else{
            sql = "select p.id as id,b.text as brand,p.model as model,p.name as name,p.orderingPrice as orderingPrice,p.brevityCode as brevityCode," +
                "p.sellingPrice as sellingPrice,p.originalPrice as originalPrice,p.promotional as promotional,p.code as code,se.name as series," +
                "sea.id as seasonId,sea.name as season,c.name as category,s.id as styleId,s.name as style,p.remark as remark,sum(o.quantity) as orderCount " +
                "from (select * from productOrder po where po.account_id='"+accountId+"') o right join product p on o.product_id=p.id " +
                "inner join category c on p.category_id=c.id inner join series se on p.series_id=se.id inner join style s on p.style_id=s.id " +
                "inner join season sea on p.season_id=sea.id inner join brand b on p.brand_id=b.id " +
                searchCondition + " group by p.id order by p.model";
		}
		
		return this.readSpecifiedSectionWithSql(sql, size, section, "ProductResult");
	}
}
