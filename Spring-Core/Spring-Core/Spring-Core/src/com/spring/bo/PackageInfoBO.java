package com.spring.bo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bean.BookPackageVO;
import com.bean.CustomerVO;
import com.bean.PackageVO;
import com.spring.dao.PackageInfoDAO;

@Component
@Scope("prototype")
public class PackageInfoBO {
	
	@Autowired
	private PackageInfoDAO packageInfoDAO;
	@Autowired
	private MessageSource messageSource;
	
	public String addPackageInfo(PackageVO packageVO){
		String generatedPackageId="";
		generatedPackageId = Integer.toString(getPackageCount());
		generatedPackageId = generatedPackageId + packageVO.getPackage_name();
		packageVO.setPackage_id(generatedPackageId);
		if(packageVO.getNo_of_nights()==1){
			int insertStatus=packageInfoDAO.insertPackageInfo(packageVO);
		}
		return generatedPackageId;
	}
	
	@PostConstruct
	public int getPackageCount(){
		int packageId=this.packageInfoDAO.getCount();
		return packageId;
	}
	
	public float addBookingDetails(String packageId, CustomerVO customerVO, BookPackageVO bookPackageVO){
		float tariff=0;
		int insertStatus1=0;
		int status=0;
		float baseTariff = packageInfoDAO.getPackageBaseTariff(packageId);
		if(baseTariff!=0){
			String discount = getSeasonDiscount(bookPackageVO.getSeason());
			if(discount!=null){
				tariff=(baseTariff * bookPackageVO.getNoOfNights())+(baseTariff * (Integer.parseInt(discount)/100));
				insertStatus1 = packageInfoDAO.addCustomer(customerVO);
			}
			if(insertStatus1!=0){
				bookPackageVO.setTotalTariff(tariff);
				bookPackageVO.setCustomerId(insertStatus1);
				status=packageInfoDAO.addBookingDetails(bookPackageVO,packageId);
			}
		}
		
		return tariff;
	}
	
	public String getSeasonDiscount(String season){
		String discount = "";
		discount = messageSource.getMessage(season, null,null, null);
		return discount;
	}

}
