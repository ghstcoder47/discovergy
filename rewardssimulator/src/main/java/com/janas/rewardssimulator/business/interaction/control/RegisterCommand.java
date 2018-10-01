package com.janas.rewardssimulator.business.interaction.control;

import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.partners.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partners.entity.Partner;

public class RegisterCommand {

	public static void perform(StringTokenizer stringTokenizer) {
		
		Partner partner = new Partner();
		
		long partnerId = Long.parseLong(stringTokenizer.nextToken());
		partner.setPartnerId(partnerId);

		if (stringTokenizer.hasMoreTokens()) {
			long parentPartnerId = Long.parseLong(stringTokenizer.nextToken());
			partner.setParentPartnerId(parentPartnerId);
		}

		List<Partner> partners = CSVPartnerManager.findAll();
		partners.add(partner);
		CSVPartnerManager.save(partners);
	}

}
