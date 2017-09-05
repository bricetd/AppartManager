package com.mby.appartmanager.dao.impl;

import java.util.Set;

import com.mby.appartmanager.dao.AppartementService;
import com.mby.appartmanager.dao.ChargesService;
import com.mby.appartmanager.dao.CoordonneesService;
import com.mby.appartmanager.dao.DocumentService;
import com.mby.appartmanager.dao.GestionnaireService;
import com.mby.appartmanager.dao.LocationService;
import com.mby.appartmanager.dao.PieceService;
import com.mby.appartmanager.dao.TransactionService;
import com.mby.appartmanager.models.Appartement;
import com.mby.appartmanager.models.Charges;
import com.mby.appartmanager.models.Coordonnees;
import com.mby.appartmanager.models.Document;
import com.mby.appartmanager.models.Gestionnaire;
import com.mby.appartmanager.models.Location;
import com.mby.appartmanager.models.Piece;
import com.mby.appartmanager.models.Transaction;

public class AppartementServiceImpl  extends AbstractServiceImpl<Appartement> implements AppartementService {

private static AppartementServiceImpl appartementServiceImpl;
private DocumentService documentService;

private TransactionService transactionService;
private ChargesService chargesService;
private PieceService pieceService;
private LocationService locationService;
private CoordonneesService coordonneesService;
private GestionnaireService gestionnaireService;


	private AppartementServiceImpl() {
		super(Appartement.class);
	}
	
	public static synchronized AppartementServiceImpl getInstance() {
		if (null == appartementServiceImpl) {
			appartementServiceImpl = new AppartementServiceImpl();
		}
		return appartementServiceImpl;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	public void setChargesService(ChargesService chargesService) {
		this.chargesService = chargesService;
	}
	public void setGestionnaireService(GestionnaireService gestionnaireService) {
		this.gestionnaireService = gestionnaireService;
	}
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	public void setCoordonneesService(CoordonneesService coordonneesService) {
		this.coordonneesService = coordonneesService;
	}
	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}
	
	
	@Override
	public Appartement addDocument(long appartementID, long documentID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		if(null!=appartement) {
			Document document = documentService.getObjectById(documentID);
			if(null!=document) {
				appartement.addDocument(document);
				appartementServiceImpl.updateObject(appartementID, appartement);
			}
		}
		return appartement;
	}

	@Override
	public Appartement addTransaction(long appartementID, long transactionID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		if(null!=appartement) {
			Transaction transaction = transactionService.getObjectById(transactionID);
			if(null!=transaction) {
				appartement.addTransaction(transaction);
				appartementServiceImpl.updateObject(appartementID, appartement);
			}
		}
		return appartement;
	}

	@Override
	public Appartement addLocation(long appartementID, long locationID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		if(null!=appartement) {
			Location location = locationService.getObjectById(locationID);
			if(null!=location) {
				appartement.addLocation(location);
				appartementServiceImpl.updateObject(appartementID, appartement);
			}
		}
		return appartement;
	}

	@Override
	public Appartement addPiece(long appartementID, long pieceID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		if(null!=appartement) {
			Piece piece = pieceService.getObjectById(pieceID);
			if(null!=piece) {
				appartement.addPiece(piece);
				appartementServiceImpl.updateObject(appartementID, appartement);
			}
		}
		return appartement;
	}

	@Override
	public Appartement addCharges(long appartementID, long chargesID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		if(null!=appartement) {
			Charges charge = chargesService.getObjectById(chargesID);
			if(null!=charge) {
				appartement.addCharge(charge);
				appartementServiceImpl.updateObject(appartementID, appartement);
			}
		}
		return appartement;
	}

	@Override
	public Appartement addGestionnaire(long appartementID, long gestionnaireID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		if(null!=appartement) {
			Gestionnaire gestionnaire = gestionnaireService.getObjectById(gestionnaireID);
			if(null!=gestionnaire) {
				appartement.addGestionnaire(gestionnaire);
				appartementServiceImpl.updateObject(appartementID, appartement);
			}
		}
		return appartement;
	}

	@Override
	public Appartement setCoordonnees(long appartementID, long coordonneesID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		if(null!=appartement) {
			Coordonnees coordonnees = coordonneesService.getObjectById(coordonneesID);
			if(null!=coordonnees) {
				appartement.setCoordonnees(coordonnees);
				appartementServiceImpl.updateObject(appartementID, appartement);
			}
		}
		return appartement;
	}

	@Override
	public Set<Document> getAppartementDocuments(long appartementID) throws Exception {
		Appartement appartement = appartementServiceImpl.getObjectById(appartementID);
		return null!=appartement?appartement.getDocuments():null;
	}
}
