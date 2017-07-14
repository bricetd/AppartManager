package com.mby.appartmanager.rest;

import com.mby.appartmanager.dao.impl.DispositifFiscalServiceImpl;
import com.mby.appartmanager.models.DispositifFiscal;

public class DispositifFiscalAPI extends GenericAPI<DispositifFiscal>{

		public DispositifFiscalAPI() {
			super(DispositifFiscalServiceImpl.getInstance());
		}

}
