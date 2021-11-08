package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	Student inStateStudent = Student.createInStateStudent("banodaya", "Boston");
	Student outStateStudent = Student.createOutStateStudent("clancy", "florida", 9,"Massachusetts");
	Student internationalStudent = Student.createIntlStudent("vikas", "LosVegas", 234649, "india");

	@Test
	public void StudentStatus_Instate() throws Exception {
		assertEquals(StudentFactory.INSTATE, inStateStudent.getStatus());
	}
	
	@Test
	public void StudentStatus_OutState() throws Exception{
		assertEquals(StudentFactory.OUTSTATE, outStateStudent.getStatus());
	}
	
	@Test
	public void StudentStatus_InternationalStudent() throws Exception{
		assertEquals(StudentFactory.INTERNATIONAL, internationalStudent.getStatus());
	}
	
	@Test
	public void InstateStudent_tuitionFee() throws Exception{
		assertEquals(9000, inStateStudent.getTuition());
	}
	
	@Test
	public void InstateStudent_tuitionFee_isNot18000() throws Exception{
		assertNotEquals(18000, inStateStudent.getTuition());
	}
	
	
	@Test
	public void InstateStudent_tuitionFee_isNot45000() throws Exception{
		assertNotEquals(45000, inStateStudent.getTuition());
	}
	
	
	@Test
	public void OutstateStudent_tuitionFee() throws Exception{
		assertEquals(12000, outStateStudent.getTuition());
	}
	
	@Test
	public void OutstateStudent_tuitionFee_isNot3000() throws Exception{
		assertNotEquals(3000, outStateStudent.getTuition());
	}
	
	@Test
	public void OutstateStudent_tuitionFee_isNot20000() throws Exception{
		assertNotEquals(20000, outStateStudent.getTuition());
	}
	
	@Test
	public void InternationalStudent_tuitionFee() throws Exception{
		assertEquals(17000, internationalStudent.getTuition());
	}
	
	@Test
	public void InternationalStudent_tuitionFee_isNot10000() throws Exception{
		assertNotEquals(10000, internationalStudent.getTuition());
	}
	
	@Test
	public void InternationalStudent_tuitionFee_isNot25000() throws Exception{
		assertNotEquals(25000, internationalStudent.getTuition());
	}
	
	
	
	
}