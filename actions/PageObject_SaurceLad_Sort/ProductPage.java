package PageObject_SaurceLad_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;

public class ProductPage extends BasePage {
	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemProductSortDropdown(String textItem) {
		waitForElementClick(driver, Product_P_UI.PRODUCT_CONTENER_SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, Product_P_UI.PRODUCT_CONTENER_SORT_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByAscending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, Product_P_UI.PRODUCT_NAME_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productname : productNameText) {
			productUIList.add(productname.getText());
			System.out.println("Product name trên UI: " + productname.getText());
		}
		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList xem đúng hay không

		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		// Sort 2 cái productList
		Collections.sort(productSortList);
		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort: " + productName);
		}

		// So sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, Product_P_UI.PRODUCT_NAME_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productname : productNameText) {
			productUIList.add(productname.getText());
			System.out.println("Product name trên UI: " + productname.getText());
		}
		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList xem đúng hay không

		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		// Sort 2 cái productList
		Collections.sort(productSortList);
		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort ASC: " + productName);
		}

		// Reverse cái productList
		Collections.reverse(productSortList);
		for (String productName : productSortList) {
			System.out.println("Product Name sau khi sort DESSC: " + productName);
		}
		// So sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);

	}

	public boolean isProductPriceSortByAscending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productPriceText = getListWebElement(driver, Product_P_UI.PRODUCT_PRICE_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));

			System.out.println("Price Product trên UI: " + productPrice.getText());
		}
		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList xem đúng hay không

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		// Sort 2 cái productList
		Collections.sort(productSortList);
		for (Float productName : productSortList) {
			System.out.println("Product Name sau khi sort: " + productName);
		}

		// So sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		// Khai báo ra 1 ArrayList để chứa các product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productPriceText = getListWebElement(driver, Product_P_UI.PRODUCT_PRICE_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));

			System.out.println("Price Product trên UI: " + productPrice.getText());
		}
		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList xem đúng hay không

		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		// Sort 2 cái productList
		Collections.sort(productSortList);
		for (Float productPrice : productSortList) {
			System.out.println("Product Name sau khi sort ASC: " + productPrice);
		}

		// Reverse cái productList
		Collections.reverse(productSortList);
		for (Float productPrice : productSortList) {
			System.out.println("Product Name sau khi sort DESSC: " + productPrice);
		}
		// So sánh 2 list đã bằng nhau
		return productSortList.equals(productUIList);

	}

}
