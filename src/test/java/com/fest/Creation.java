package com.fest;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.fest.persistence.FestivityParser;
import com.fest.persistence.SingletonMemoryPersistence;

public class Creation {

	@Test
	public void test() {
		FestivityParser parser = SingletonMemoryPersistence.getInstance();
		long result = parser.createFestivity("Wilson1", "2015-11-03T14:34:07.007Z", "2015-11-08T14:34:07.007Z", "THeplace");
		System.out.println(result);
		fail("Not yet implemented");
	}

}
