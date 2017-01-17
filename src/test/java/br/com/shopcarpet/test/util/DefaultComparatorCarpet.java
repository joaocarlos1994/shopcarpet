/*
 * shopcarpet 1.0 17 de jan de 2017
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.shopcarpet.test.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.skyscreamer.jsonassert.comparator.DefaultComparator;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 17 de jan de 2017
 */
public class DefaultComparatorCarpet extends DefaultComparator {

	private final String[] ignoredTerms;

	public DefaultComparatorCarpet(final JSONCompareMode mode, final String... ignoredTerms) {
		super(mode);
		this.ignoredTerms = ignoredTerms;
	}
	
	public DefaultComparatorCarpet(final String... ignoredTerms) {
		this(JSONCompareMode.STRICT, ignoredTerms);
	}

	@Override
	public void compareValues(final String prefix, final Object expectedValue, final Object actualValue,
			final JSONCompareResult result) throws JSONException {
		if (expectedValue.getClass().isAssignableFrom(JSONObject.class)) {
			super.compareValues(prefix, expectedValue, actualValue, result);
		} else {
			boolean found = false;
			for (final String term : ignoredTerms) {
				if (prefix.equals(term)) {
					result.passed();
					found = true;
					break;
				}
			}
			if (!found) {
				super.compareValues(prefix, expectedValue, actualValue, result);
			}
		}

	}

}
