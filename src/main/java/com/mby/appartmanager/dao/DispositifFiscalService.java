package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.DispositifFiscal;

public interface DispositifFiscalService {

	public DispositifFiscal saveObject(DispositifFiscal dispositifFiscal);
	public DispositifFiscal deleteObject(long dispositifFiscalID);
	public DispositifFiscal getObjectById(long id);
	public List<DispositifFiscal> getAllObjects();
	public DispositifFiscal updateObject(long id, DispositifFiscal dispositifFiscal) throws Exception;
}
