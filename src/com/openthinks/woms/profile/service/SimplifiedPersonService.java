package com.openthinks.woms.profile.service;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.profile.Person;

public interface SimplifiedPersonService {
	SectionResult<Person> find(String keywords, int pageSize,
			int page) throws Exception;
}
