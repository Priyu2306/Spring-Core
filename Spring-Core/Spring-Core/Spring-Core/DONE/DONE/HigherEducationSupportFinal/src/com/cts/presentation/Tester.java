/**
 * This file contains Tester class
 */
package com.cts.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.bo.DetailsVO;
import com.cts.bo.RegistrationVO;
import com.cts.exceptions.InvalidCollegeIdException;
import com.cts.exceptions.InvalidJobLevelException;
import com.cts.exceptions.InvalidModeOfStudyException;
import com.cts.exceptions.NoRecordsException;
import com.cts.manager.HESManager;


/**
 * <h3>Description :</h3>This is the tester class of the application which
 * displays the menu and accepts data and populates the transfer object and
 * sends it to the Manager class.
 *
 * @author Academy Java Solutions, Bangalore, Cognizant Technology Solutions
 */
public class Tester {

	private static HESManager manager;
	private static RegistrationVO registrationVO;
	//private static DetailsVO detailsVO;

	public static HESManager getManager() {
		return manager;
	}

	public static void setManager(HESManager manager) {
		Tester.manager = manager;
	}


	public static RegistrationVO getRegistrationVO() {
		return registrationVO;
	}

	public static void setRegistrationVO(RegistrationVO registrationVO) {
		Tester.registrationVO = registrationVO;
	}

	/*public static DetailsVO getDetailsVO() {
		return detailsVO;
	}

	public static void setDetailsVO(DetailsVO detailsVO) {
		Tester.detailsVO = detailsVO;
	}
*/
	public void registerCourse() {

		try
		{
			
			  Integer registrationId= manager.registerCourse(registrationVO);
			  System.out.println("Course Registered successfully with Registration No: "+registrationId);
			
		}
		catch(InvalidCollegeIdException e)
		{
			System.out.println("College Id is invalid");
			e.printStackTrace();
			
		}
		catch(InvalidJobLevelException e)
		{
			System.out.println("Job level is invalid");
			e.printStackTrace();
		}
		catch(InvalidModeOfStudyException e)
		{
			System.out.println("ModeOfStudy is invalid");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("General Exception");
			e.printStackTrace();
		}



	}

	public void viewRegisteredDetails() {

		try
		{
			System.out.println("Enter Collge Id:");
			Integer collgeId=Integer.parseInt(acceptString());
			System.out.println("Enter Mode of Study:");
			String modeOfStudy=acceptString();
			try
			{
				List<DetailsVO> list=manager.viewRegisteredDetails(collgeId, modeOfStudy);
				
				for(DetailsVO details: list)
				{
					System.out.print(details.getRegistrationId()+"\t"+details.getEmpNo()+"\t"+details.getCollegeName()+"\t"+details.getDescription()+"\t"+details.getModeOfStudy()+"\t"+details.getRegistrationDate()+"\n");
				}
			}
			catch (NoRecordsException ex)
			{
				System.out.println("List is empty");
				ex.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws Exception  {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("hes_config.xml");
		manager=(HESManager) context.getBean("hesManager");
		registrationVO=(RegistrationVO) context.getBean("registrationVO");
		registrationVO.setRegistrationDate(new Date());
		System.out.println("Choose your option:");
		System.out.println("1. Register");
		System.out.println("2. View");
		Scanner scanner=new Scanner(System.in);
		int input=scanner.nextInt();
		switch(input)
		{
			case 1: 
				new Tester().registerCourse();
			break;
			case 2:
				new Tester().viewRegisteredDetails();
			break;
			
			default:
				System.out.println("Inavlid Choice");
			break;
			
		}
		
	}

	public static String acceptString() {
		// the return variable initialization
		Scanner scanner=new Scanner(System.in);
		
		return scanner.next();
	}

}
