package fakerDataGenerater;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataCass {
	
	@Test
	void testFakerData() {
		Faker f = new Faker();
		String fullname = f.name().fullName();
		String firstname = f.name().firstName();
		String username = f.name().username();
		String password = f.internet().password();
		String phonoNo = f.phoneNumber().cellPhone();
		String email = f.internet().safeEmailAddress();
		String bookname = f.book().title();
		
		
		System.out.println("fullname : "+fullname);
		System.out.println("firstname : "+firstname);
		System.out.println("username : "+username);
		System.out.println("password : "+password);
		System.out.println("phonoNo : "+phonoNo);
		System.out.println("email : "+email);
		System.out.println("bookname : "+bookname);
	}
	
	
	
}
