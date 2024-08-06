package com.lgcns.mission.pension.test;

import com.lgcns.mission.pension.biz.PensionBiz;
import com.lgcns.mission.pension.biz.IPensionBiz;
import com.lgcns.mission.util.MissionUtil;

public class PensionTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		IPensionBiz ruang = new PensionBiz();
		ruang.initializeRooomData();
		
		int menu = -1;
		while (menu != 9) {
		    printHeader();

		    try {
		        String menuInput = MissionUtil.getStringInput();
		        if (!menuInput.matches("\\d+")) {
		            throw new NumberFormatException("[Error] Silahkan input menu kembali.");
		        }
		        menu = Integer.parseInt(menuInput);
		    } catch (NumberFormatException e) {
		        System.out.println(e.getMessage());
		        continue; 
		    }
		    
		    if (menu == 1) {
		        ruang.roomList();
		    } else if (menu == 2) {
		        System.out.print("Silahkan input nomor kamar yang akan ditempati >> ");
		        String roomNum = MissionUtil.getStringInput();

		        System.out.print("Silahkan masukkan nama anda >> ");
		        String name = MissionUtil.getStringInput();

		        System.out.print("Silahkan masukkan no.tlp anda >> ");
		        String phone = MissionUtil.getStringInput();

		        try {
		            ruang.checkIn(roomNum, name, phone);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		    } else if (menu == 3) {
		        System.out.print("Silahkan input nomor kamar anda >> ");
		        String roomNum = MissionUtil.getStringInput();

		        try {
		            ruang.checkOut(roomNum);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		    } else if (menu == 0) {
		        System.out.println("Bai");
		        System.exit(0);
		    } else {
		        System.out.println("[Error] silahkan input menu kembali");
		    }
		}
		
		
	}
	
	
	public static void printHeader() {
		System.out.println("======<< Manajemen Sistem Pansion Chun>>======");
		System.out.println("1. Periksa seluruh ruangan");
		System.out.println("2. check in");
		System.out.println("3. check out");
		System.out.println("0. Selesai");
		System.out.println("==========================");
		System.out.print("## input menu : ");
	}
}
