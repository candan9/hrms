package com.example.HRMS.core.helpers;

import java.rmi.RemoteException;
import java.util.Locale;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements MernisCheckService {

	@Override
	public boolean validate(MernisPerson mernisPerson) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		var result =true;
		try {
			result =client.TCKimlikNoDogrula(Long.parseLong( mernisPerson.getIdentificationNumber()), mernisPerson.getFirstName().toUpperCase(new Locale("tr"))
					, mernisPerson.getLastName().toUpperCase(new Locale("tr")),Integer.parseInt( mernisPerson.getBirthYear()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return result;
	}

}
