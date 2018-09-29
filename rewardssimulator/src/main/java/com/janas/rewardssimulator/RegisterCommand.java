package com.janas.rewardssimulator;

import java.util.List;
import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.partner.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partner.boundary.PartnerLevel;
import com.janas.rewardssimulator.business.partner.entity.Partner;

public class RegisterCommand {

	public static void perform(StringTokenizer stringTokenizer) {
		
		Partner partner = new Partner();
		partner.setLevel(PartnerLevel.ANT);
		
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
