import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	public void fakerDataGenerator() {		
	Faker f=new Faker();
//	System.out.println(f.name().fullName());	
//	System.out.println(f.name().firstName());
	//System.out.println(f.internet().password(5, 10, true));	
//	System.out.println(f.phoneNumber().cellPhone());
//	System.out.println(f.internet().emailAddress());
//	System.out.println(f.business().creditCardExpiry());//2012-11-12
//	System.out.println(f.business().creditCardType());//
	System.out.println(f.business().creditCardNumber());//1211-1221-1234-2201,1211-1221-1234-2201
	System.out.println(f.address().country());
	}

}
/*
FAKER API:- It is useful when need to test API with multiple sets of data..
JSON Object:-
JSON Array:-
JSON element:-




*/