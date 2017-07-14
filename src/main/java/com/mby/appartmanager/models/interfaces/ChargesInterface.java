package com.mby.appartmanager.models.interfaces;

import java.util.List;

import com.mby.appartmanager.models.Charges;

public interface ChargesInterface {

	public List<Charges> getCharges();

	public void setCharges(List<Charges> charges);
	
	public boolean addCharge(Charges charge);
	
	public boolean removeCharge(Charges charge);
}
