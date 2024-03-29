package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.DAO.SupplierDAO;
import com.ecommerce.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/supplier")
	public String showCategory(Model m)
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		
		m.addAttribute("supplierList", listSuppliers);
		
		return "supplier";
	}
	
	@RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
	public String saveCategoryDetail(@RequestParam("supName")String supplierName,@RequestParam("supDesc") String supplierDesc,Model m)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		supplierDAO.addSupplier(supplier);
		
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", listSuppliers);
		
		return "supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", listSuppliers);
		
		return "supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		m.addAttribute(supplier);
		return "updatesupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	 public String updateCategory(Model m,@RequestParam("supId")int supplierID,@RequestParam("supName")String supplierName,@RequestParam("supDesc")String supplierDesc)
	 {
		 Supplier supplier=supplierDAO.getSupplier(supplierID);
		 supplier.setSupplierName(supplierName);
		 supplier.setSupplierDesc(supplierDesc);
		 supplierDAO.updateSupplier(supplier);
		 List< Supplier> listSuppliers=supplierDAO.listSuppliers();
		 m.addAttribute("supplierList",listSuppliers);
		 return "supplier";
	 }
	
	
}
