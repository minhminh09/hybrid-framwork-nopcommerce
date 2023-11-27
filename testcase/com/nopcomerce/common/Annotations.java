package com.nopcomerce.common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotations {
	@Test
	public void TC_01() {
		System.out.println("Run Test case");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Run Before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Run After class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Run Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Run After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Run Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Run After Suite");
	}

}
