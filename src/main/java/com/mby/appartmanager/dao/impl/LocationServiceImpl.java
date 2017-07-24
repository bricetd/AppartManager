package com.mby.appartmanager.dao.impl;

import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.LocataireService;
import com.mby.appartmanager.dao.LocationService;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Locataire;
import com.mby.appartmanager.models.Location;

public class LocationServiceImpl extends AbstractServiceImpl<Location> implements LocationService {

private static LocationServiceImpl locationServiceImpl;
private DocumentService documentService;
private LocataireService locataireService;


	private LocationServiceImpl() {
		super(Location.class);
	}
	
	public static synchronized LocationServiceImpl getInstance() {
		if (null == locationServiceImpl) {
			locationServiceImpl = new LocationServiceImpl();
		}
		return locationServiceImpl;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	public void setLocataireService(LocataireService locataireService) {
		this.locataireService = locataireService;
	}
	
	@Override
	public Location addDocument(long locationID, long documentID) throws Exception {
		Location location = locationServiceImpl.getObjectById(locationID);
		if(null!=location) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				location.addDocument(document);
				locationServiceImpl.updateObject(locationID, location);
			}
		}
		return location;
	}
	
	@Override
	public Location addLocataire(long locationID, long locataireID) throws Exception {
		Location location = locationServiceImpl.getObjectById(locationID);
		if(null!=location) {
			Locataire locataire = locataireService.getObjectById(locataireID);
			if(null!=locataire) {
				location.addLocataire(locataire);
				locationServiceImpl.updateObject(locationID, location);
			}
		}
		return location;
	}
}
