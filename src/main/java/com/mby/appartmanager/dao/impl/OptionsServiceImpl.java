package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.OptionsService;
import com.mby.appartmanager.models.Options;

public class OptionsServiceImpl extends AbstractServiceImpl<Options> implements OptionsService{

	private static OptionsServiceImpl optionServiceImpl;
	
	private OptionsServiceImpl() {
		super(Options.class);
	}
	

	public static synchronized OptionsServiceImpl getInstance() {
		if (null == optionServiceImpl) {
			optionServiceImpl = new OptionsServiceImpl();
		}
		return optionServiceImpl;
	}

}
