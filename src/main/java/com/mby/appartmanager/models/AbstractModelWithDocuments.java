package com.mby.appartmanager.models;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.mby.appartmanager.models.interfaces.DocumentInterface;

@MappedSuperclass
public abstract class AbstractModelWithDocuments extends AbstractModel implements DocumentInterface {

	@OneToMany(fetch = FetchType.EAGER)
//	@Cascade(CascadeType.ALL)
	protected List<Document> documents;
	
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public boolean addDocument(Document document) {
		boolean result = false;
		if(null!=documents){
			documents.add(document);
		}
		return result;
	}

	public boolean removeDocument(Document document) {
		boolean result = false;
		if(null!=documents&&null!=document){
			result = documents.remove(document);
		}
		return result;
	}
}
