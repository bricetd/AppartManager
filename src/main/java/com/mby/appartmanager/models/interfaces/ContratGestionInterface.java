package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.ContratGestion;

public interface ContratGestionInterface {

	public List<ContratGestion> getContratGestions();

	public void setContratGestions(List<ContratGestion> contratsGestions);
	
	public boolean addContratGestion(ContratGestion contratGestion);
	
	public boolean removeContratGestion(ContratGestion contratGestion);
}
