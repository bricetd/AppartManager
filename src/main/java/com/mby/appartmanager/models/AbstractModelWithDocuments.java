package com.mby.appartmanager.models;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.mby.appartmanager.models.interfaces.DocumentInterface;

@MappedSuperclass
public abstract class AbstractModelWithDocuments extends AbstractModel implements DocumentInterface {

	@OneToMany
	@Cascade({CascadeType.ALL})
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
