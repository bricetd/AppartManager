package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Options;

public interface OptionsService {

	public Options deleteObject(long optionsID);
	public Options getObjectById(long id);
	public List<Options> getAllObjects();
	public Options updateObject(long id, Options options) throws Exception;
	public Options saveObject(Options options);
}
