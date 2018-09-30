package com.janas.rewardssimulator.business.bartners.boundary;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.janas.rewardssimulator.business.partners.boundary.CSVPartnerManager;
import com.janas.rewardssimulator.business.partners.entity.Partner;

public class CSVPartnerManagerTest {
	
	CSVPartnerManager cut;
	List<Partner> partners;
	final int AMOUNT_OF_PARTNERS = 6;
	
	@Before
	public void init() {
		partners = new ArrayList<>();
		partners.add(new Partner(1));
		partners.add(new Partner(2));		
		partners.add(new Partner(3,1));
		partners.add(new Partner(4,1));
		partners.add(new Partner(5,4));
		partners.add(new Partner(6,2));
	}

	@Test
	public void testSave() {
		CSVPartnerManager.save(partners);
		int countet = CSVPartnerManager.findAll().size();
		assertThat(countet, equalTo(AMOUNT_OF_PARTNERS));
	}

	@Test
	public void testFindSubPartners() {
		Partner parentPartner = partners.get(0);
		List<Partner> subPartners = CSVPartnerManager.findSubPartners(parentPartner.getPartnerId());
		assertThat(subPartners.size(), equalTo(2));
	}

}
