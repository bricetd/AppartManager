package com.mby.appartmanager.models.interfaces;

import java.util.Set;

import com.mby.appartmanager.models.Charges;

public interface ChargesInterface {

	public Set<Charges> getCharges();

	public void setCharges(Set<Charges> charges);
	
	public boolean addCharge(Charges charge);
	
	public boolean removeCharge(Charges charge);
}
