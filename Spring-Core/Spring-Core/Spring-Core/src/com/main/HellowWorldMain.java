package com.main;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.HelloWorldBean;
import com.spring.service.PackageInfoService;
import com.spring.service.TriangleService;

public class HellowWorldMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		//HelloWorldBean obj = (HelloWorldBean) context.getBean("helloWorld");
		//obj.getMessage();
		
		//TriangleService triangleService = (TriangleService)context.getBean("triangleService");
		//triangleService.draw();
		//triangleService.getDetails();
		
		
		//System.out.println(context.getMessage("Regular", null, null, null));
		
		PackageInfoService packageInfoService = (PackageInfoService)context.getBean("packageInfoService");
		//String packageId = PackageInfoService.addPackageInfo("Delux", 1, "Normal", 4000, 2, 1);
	    //System.out.println("packageId---"+packageId);
		/*try {
			float totalTariff = packageInfoService.addBookingDetails("Sudip", "Baguiati", "555", "103Delux", 2, 1,"24/09/2016", "26/09/2016", "Regular");
			System.out.println("totalTariff=="+totalTariff);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		packageInfoService.getData();
	}

}
