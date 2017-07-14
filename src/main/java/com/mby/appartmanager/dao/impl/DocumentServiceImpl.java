package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.models.Document;

public class DocumentServiceImpl extends AbstractServiceImpl<Document> implements DocumentService{

	private static DocumentServiceImpl documentServiceImpl;
	
	private DocumentServiceImpl() {
		super(Document.class);
	}
	

	public static synchronized DocumentServiceImpl getInstance() {
		if (null == documentServiceImpl) {
			documentServiceImpl = new DocumentServiceImpl();
		}
		return documentServiceImpl;
	}
}
