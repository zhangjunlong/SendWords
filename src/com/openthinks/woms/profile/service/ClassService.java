package com.openthinks.woms.profile.service;

import java.util.Collection;

import com.openthinks.woms.profile.Class;

public interface ClassService {
	void create(Class category) throws Exception;

	Class find(int id) throws Exception;

	Collection<Class> find() throws Exception;

	void update(Class category) throws Exception;

	void delete(int id) throws Exception;
}
