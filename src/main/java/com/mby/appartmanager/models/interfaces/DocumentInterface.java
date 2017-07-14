package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Document;

public interface DocumentInterface {

	public List<Document> getDocuments();

	public void setDocuments(List<Document> documents);
	
	public boolean addDocument(Document document);
	
	public boolean removeDocument(Document document);
}
