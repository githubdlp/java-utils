package com.dlp.social.java_utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dlp.java.utils.StringUtil;

public class StringUtilTest {

	private StringUtil stringUtil = null;

	@Before
	public void setup() {
		stringUtil = new StringUtil();
	}

	@Test
	public void testReverse() {
		Assert.assertEquals("tupnItset", stringUtil.reverse("testInput"));
	}

	@Test
	public void testReverse_oneCharString() {
		Assert.assertEquals("t", stringUtil.reverse("t"));
	}

	@Test
	public void testReverse_nullString() {
		Assert.assertNull(stringUtil.reverse(null));
	}

	@Test
	public void testReverse_emptyString() {
		Assert.assertEquals("", stringUtil.reverse(""));
	}

	@Test
	public void testReverse_spaceString() {
		Assert.assertEquals("  ", stringUtil.reverse("  "));
	}

	@Test
	public void testHasLength() {
		Assert.assertTrue(stringUtil.hasLength("test"));
	}

	@Test
	public void testHasLength_emptyString() {
		Assert.assertFalse(stringUtil.hasLength(""));
	}

	@Test
	public void testHasLength_spaceString() {
		Assert.assertFalse(stringUtil.hasLength(" "));
	}

	@Test
	public void testHasLength_nullString() {
		Assert.assertFalse(stringUtil.hasLength(null));
	}
}
