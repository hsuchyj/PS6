package base;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import util.HibernateUtil;

public class Person_Test {

	static PersonDomainModel p1 = new PersonDomainModel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		p1.setBirthday(new Date(0));
		p1.setCity("wilm");
		p1.setFirstName("hunt");
		p1.setLastName("smith");
		p1.setPostalCode(18999);
		p1.setStreet("blue street");
		
	}
	//update and delete only work in @afterclass
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		

		//test read
		PersonDomainModel p2 = PersonDAL.getPerson(p1.getPersonID());
		assertTrue(PersonDAL.getPerson(p1.getPersonID()) != null);
		
		//test update
		p1.setCity("Newark");
		PersonDAL.updatePerson(p1);
		assertTrue(!(p1.getCity().equals(p2.getCity())));
		
		//test delete
		//PersonDAL.deletePerson(p1.getPersonID());
		//assertTrue(PersonDAL.getPerson(p1.getPersonID()) == null);
		
		//nothing left
		
		
		
		
		
	}
	

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void AddPerson() {
		
		//test add
		PersonDAL.addPerson(p1);
		assertTrue(PersonDAL.getPerson(p1.getPersonID()) != null);
		
		
	}
	
	@Test
	public void UpdatePerson() {
		
		
		//doesnt work here
		
	}
	
	@Test
	public void DeletePerson() {
		
		//doesnt work here
		
		
	}
	
	
	
	
	

}


