package com.janas.rewardssimulator.business.bartners.boundary;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.janas.rewardssimulator.business.partners.boundary.PartnerLevel;




public class PartnerLevelTest {
	
	final long ANT = 5;
	final long BEE = 12;
	final long CAT = 150;
	final long DOG = 999;
	final long ELEPHANT = 1001;

	@Test
	public void testComputeLevelANT() {
		PartnerLevel level = PartnerLevel.computeLevel(ANT);
		assertThat(level, equalTo(PartnerLevel.ANT));
	}
	
	@Test
	public void testComputeLevelBEE() {
		PartnerLevel level = PartnerLevel.computeLevel(BEE);
		assertThat(level, equalTo(PartnerLevel.BEE));
	}
	
	@Test
	public void testComputeLevelCAT() {
		
		PartnerLevel level = PartnerLevel.computeLevel(CAT);
		assertThat(level, equalTo(PartnerLevel.CAT));
	}
	
	@Test
	public void testComputeLevelDOG() {
		PartnerLevel level = PartnerLevel.computeLevel(DOG);
		assertThat(level, equalTo(PartnerLevel.DOG));
	}
	
	@Test
	public void testComputeLevelELEPHANT() {
		PartnerLevel level = PartnerLevel.computeLevel(ELEPHANT);
		assertThat(level, equalTo(PartnerLevel.ELEPHANT));
	}

}
