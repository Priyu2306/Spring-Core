package com.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.bean.BookPackageVO;
import com.bean.Collection;
import com.bean.CustomerVO;
import com.bean.PackageVO;
import com.spring.bo.PackageInfoBO;

@Component
@Scope("prototype")
public class PackageInfoService {
	
	@Autowired
	private PackageInfoBO packageInfoBO;
	
	@Autowired
	Collection collection;
	
	public String addPackageInfo(String packageName, int no_of_nights, String room_type, float base_tariff,
			int no_of_adults, int no_of_kids){
		String packageId="";
		PackageVO packageVO =new PackageVO();
		packageVO.setPackage_name(packageName);
		packageVO.setNo_of_nights(no_of_nights);
		packageVO.setRoom_type(room_type);
		packageVO.setBase_tariff(base_tariff);
		packageVO.setNo_of_adults(no_of_adults);
		packageVO.setNo_of_kids(no_of_kids);
		packageId=packageInfoBO.addPackageInfo(packageVO);
		
		return packageId;
		
	}
	
	public float addBookingDetails(String customerName,String address,String contactno, String packageId,
			int noOfAdults, int noOfKids,String checkin, String checkout,String season) throws ParseException{
		int noOfNights = 0;
		float totalTariff=0;
		CustomerVO customerVO = new CustomerVO();
		customerVO.setCustomerName(customerName);
		customerVO.setAddress(address);
		customerVO.setContctno(contactno);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mmm/yyyy");
		noOfNights = (int) ((sdf.parse(checkout).getTime() - sdf.parse(checkin).getTime())/(1000*60*24*60));
		BookPackageVO bookPackageVO = new BookPackageVO();
		bookPackageVO.setCheckin(sdf.parse(checkin));
		bookPackageVO.setCheckout(sdf.parse(checkout));
		bookPackageVO.setNoOfAdults(noOfAdults);
		bookPackageVO.setNoOfKids(noOfKids);
		bookPackageVO.setSeason(season);
		bookPackageVO.setNoOfNights(noOfNights);
		totalTariff = packageInfoBO.addBookingDetails(packageId, customerVO, bookPackageVO);
		return totalTariff;
	}
	
	public void getData(){
		 
		Map<String,String> testdata = new HashMap<String,String>();
		testdata = collection.getMap();
		for(Map.Entry<String, String> entry: testdata.entrySet()){
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
	}

}
