package com.ticketsales.services;

import com.ticketsales.model.Admin;

import java.util.List;

// Her bir interface'i class'inda implemente edip, controller package icerisinde de kullanacagim.



public interface AdminService {
	
	public List<Admin> getAllAdmin();  // Adminleri listelemeye yarıyor.
	public Admin getAdminById(int id); // Id bilgisine gore getirmeye yarıyor.
	public void addAdmin(Admin admin); // Admin eklemeye yarıyor.
	public void deleteAdmin(int id);   // Admin silmeye yarıyor.
    public void deleteAllAdmin();	   // Tum adminleri silmeye yarıyor.
    public Admin getAdminByUsername(String username); 	// Username bilgisine gore admin getirmeye yarıyor.
	
}
