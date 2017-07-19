package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.ContratGestion;

public interface ContratGestionInterface {

	public Set<ContratGestion> getContratGestions();

	public void setContratGestions(Set<ContratGestion> contratsGestions);
	
	public boolean addContratGestion(ContratGestion contratGestion);
	
	public boolean removeContratGestion(ContratGestion contratGestion);
}
