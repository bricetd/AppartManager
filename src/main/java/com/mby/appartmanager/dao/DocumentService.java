package com.mby.appartmanager.dao;

import java.util.List;

import com.mby.appartmanager.models.Document;

public interface DocumentService {

	public Document deleteObject(long documentID);
	public Document getObjectById(long id);
	public List<Document> getAllObjects();
	public Document updateObject(long id, Document document) throws Exception;
	public Document saveObject(Document document);

}
