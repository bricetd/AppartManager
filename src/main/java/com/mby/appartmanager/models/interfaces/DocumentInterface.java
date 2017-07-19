package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Document;

public interface DocumentInterface {

	public Set<Document> getDocuments();

	public void setDocuments(Set<Document> documents);
	
	public boolean addDocument(Document document);
	
	public boolean removeDocument(Document document);
}
