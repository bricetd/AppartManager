package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DispositifFiscalService;
import com.mby.appartmanager.models.DispositifFiscal;

public class DispositifFiscalServiceImpl extends AbstractServiceImpl<DispositifFiscal> implements DispositifFiscalService{

	private static DispositifFiscalServiceImpl dispositifFiscalImpl;
	
	private DispositifFiscalServiceImpl() {
		super(DispositifFiscal.class);
	}
	

	public static synchronized DispositifFiscalServiceImpl getInstance() {
		if (null == dispositifFiscalImpl) {
			dispositifFiscalImpl = new DispositifFiscalServiceImpl();
		}
		return dispositifFiscalImpl;
	}

}
