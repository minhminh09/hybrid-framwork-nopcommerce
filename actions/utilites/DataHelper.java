package utilites;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker();

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	// Firstname/Lastname/Email/City/Phone/Address/zipcode/pin....
	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getFullName() {
		return faker.name().fullName();
	}

	public String getCity() {
		return faker.address().city();
	}

	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getPassWord() {
		return faker.internet().password(6, 12, true, true);
	}
}
