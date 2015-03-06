package core;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Sign_Up_Selenium {
	public static void main(String[] args) {

		// WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new FirefoxDriver();
		String text_case_id_01 = "TC-001.01";
		String text_case_id_02 = "TC-001.02";
		String text_case_id_03 = "TC-001.03";
		String text_case_id_04 = "TC-001.04";
		String text_case_id_05 = "TC-001.05";
		String text_case_id_06 = "TC-001.06";
		String url = "http://learn2test.net/qa/apps/sign_up/v1/";
		String Application_title_expected = "Sign Up";
		String title_flickr_expected = "Welcome to Flickr - Photo Sharing";
		String error_email_address_empty_expected = "Please enter Email Address";
		String fname = "Vasya";
		String lname = "Pupkin";
		String email = "pupkin@gmail.com";
		String phone = "415 995-0000";
		String phone1 = "415 90f-0000";
		String error_phone_number_expected = "Invalid Phone Number: should be 10 digits";

		// TC-001.01

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// driver.findElement(By.id("id_f_title")).getText();
		String title_actual = driver.findElement(By.id("id_f_title")).getText();

		if (Application_title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_01
					+ " - PASSED");
			System.out.println("Application_title Expected/Actual: \t"
					+ Application_title_expected + "/" + title_actual);
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_01
					+ " - FAILED");
			System.out.println("Application_title Expected/Actual: \t"
					+ Application_title_expected + "/" + title_actual);
			System.out.println("=======================================");
		}

		// TC-001.02

		driver.findElement(By.id("id_img_flickr")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ArrayList<String> allTabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		String title_flickr_actual = driver.getTitle();
		driver.close();
		driver.switchTo().window(allTabs.get(0));

		if (title_flickr_expected.equals(title_flickr_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_02
					+ " - PASSED");
			System.out.println("Title Expected/Actual: \t"
					+ title_flickr_expected + "/" + title_flickr_actual);
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_02
					+ " - FAILED");
			System.out.println("Title Expected/Actual: \t"
					+ title_flickr_expected + "/" + title_flickr_actual);
			System.out.println("=======================================");
		}

		// TC-001.03

		// driver.findElement(By.id("id_quotes")).getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String quote = driver.findElement(By.id("id_quotes")).getText();
		if (quote != null && quote.length() < 103 && quote.length() > 36) {
			System.out.println("Test Case ID: \t\t" + text_case_id_03
					+ " - PASSED");
			System.out.println("Quote length: " + quote.length());
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_03
					+ " - FAILED");
			System.out.println("Quote length: " + quote.length());
			System.out.println("=======================================");
		}

		// TC-001.04

		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_lname")).sendKeys(lname);
		driver.findElement(By.id("id_submit_button")).click();
		String error_email_address_empty_actual = driver.findElement(
				By.id("ErrorLine")).getText();
		driver.findElement(By.id("id_reset_button")).click();
		if (error_email_address_empty_expected
				.equals(error_email_address_empty_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_04
					+ " - PASSED");
			System.out.println("Error Expected/Actual: \t"
					+ error_email_address_empty_expected + "/"
					+ error_email_address_empty_actual);
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_04
					+ " - FAILED");
			System.out.println("Error Expected/Actual: \t"
					+ error_email_address_empty_expected + "/"
					+ error_email_address_empty_actual);
			System.out.println("=======================================");
		}

		// TC-001.05

		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_lname")).sendKeys(lname);
		driver.findElement(By.id("id_email")).sendKeys(email);
		driver.findElement(By.id("id_phone")).sendKeys(phone);
		driver.findElement(By.id("id_submit_button")).click();

		String fname_conf_actual = driver.findElement(By.id("id_fname_conf"))
				.getText();
		String lname_conf_actual = driver.findElement(By.id("id_lname_conf"))
				.getText();
		String email_conf_actual = driver.findElement(By.id("id_email_conf"))
				.getText();
		String phone_conf_actual = driver.findElement(By.id("id_phone_conf"))
				.getText();
		driver.findElement(By.id("id_back_button")).click();
		if (fname.equals(fname_conf_actual) && lname.equals(lname_conf_actual)
				&& email.equals(email_conf_actual)
				&& phone.equals(phone_conf_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_05
					+ " - PASSED");
			System.out.println("First Expected/Actual: \t" + fname + "/"
					+ fname_conf_actual);
			System.out.println("Last Expected/Actual: \t" + lname + "/"
					+ lname_conf_actual);
			System.out.println("Email Expected/Actual: \t" + email + "/"
					+ email_conf_actual);
			System.out.println("Phone Expected/Actual: \t" + phone + "/"
					+ phone_conf_actual);
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_05
					+ " - FAILED");
			System.out.println("First Expected/Actual: \t" + fname + "/"
					+ fname_conf_actual);
			System.out.println("Last Expected/Actual: \t" + lname + "/"
					+ lname_conf_actual);
			System.out.println("Email Expected/Actual: \t" + email + "/"
					+ email_conf_actual);
			System.out.println("Phone Expected/Actual: \t" + phone + "/"
					+ phone_conf_actual);
			System.out.println("=======================================");
		}

		// TC-001.06

		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_lname")).sendKeys(lname);
		driver.findElement(By.id("id_email")).sendKeys(email);
		driver.findElement(By.id("id_phone")).sendKeys(phone1);
		driver.findElement(By.id("id_submit_button")).click();

		String error_phone_number_actual = driver.findElement(
				By.id("ErrorLine")).getText();

		if (error_phone_number_expected.equals(error_phone_number_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_06
					+ " - PASSED");
			System.out.println("Error Expected/Actual: \t"
					+ error_phone_number_expected + "/"
					+ error_phone_number_actual);
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_06
					+ " - FAILED");
			System.out.println("Error Expected/Actual: \t"
					+ error_phone_number_expected + "/"
					+ error_phone_number_actual);
			System.out.println("=======================================");

		}
		driver.quit();
	}
}