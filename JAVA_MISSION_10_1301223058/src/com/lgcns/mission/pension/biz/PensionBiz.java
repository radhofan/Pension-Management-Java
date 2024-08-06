package com.lgcns.mission.pension.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.lgcns.mission.pension.Customer;
import com.lgcns.mission.pension.Standard;
import com.lgcns.mission.pension.Suite;
import com.lgcns.mission.pension.exception.AlreadyCheckoutException;
import com.lgcns.mission.pension.exception.AlreadyReservedException;

public class PensionBiz implements IPensionBiz{
	
	private ArrayList<HashMap<String, Object>> data;
	
	public void checkIn(String roomId, String custName, String custPhone) throws Exception {
		try {
			//cek apakah input kamar adalah angka
			if (!roomId.matches("\\d+")) {
	            throw new Exception("[Error] Silahkan masukkan angka untuk nomor kamar.");
	        }
			
			//cek apakah kamar ada
			boolean roomExist = false;
		    for (HashMap<String, Object> room : data) {
		    	if (room.containsKey(roomId)) {
		    		roomExist = true;
		        }
		    }
		    if (!roomExist) {
		    	throw new Exception("[Error] Silahkan masukkan nomor kamar yang benar.");
		    }
		    
		    //cek apakah kamar sudah dipesan
		    boolean roomReserved = false;
		    for (HashMap<String, Object> room : data) {
		    	if (room.size() > 1) {
		    		roomReserved = true;
		        }
		    }
		    if (roomReserved) {
		    	throw new AlreadyReservedException();
		    }
		    
		    //add hashmap customer ke hashmap room yang sesuai
		    for (HashMap<String, Object> room : data) {
		    	if (room.containsKey(roomId)) {
		    		room.put("Guest", new Customer("custName", "custPhone"));
		        }
		    }

		     System.out.println("@ Berhasil dipesan.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void checkOut(String roomId) throws Exception {
		try {
			//cek apakah input kamar adalah angka
			if (!roomId.matches("\\d+")) {
	            throw new Exception("[Error] Silahkan masukkan angka untuk nomor kamar.");
	        }
			
			//cek apakah kamar ada
			boolean roomExist = false;
		    for (HashMap<String, Object> room : data) {
		    	if (room.containsKey(roomId)) {
		    		roomExist = true;
		        }
		    }
		    if (!roomExist) {
		    	throw new Exception("[Error] Silahkan masukkan nomor kamar yang benar.");
		    }
		    
		    //add hashmap customer ke hashmap room yang sesuai
		    boolean found = false;
		    for (HashMap<String, Object> room : data) {
		    	if (room.containsKey("Guest")) {
		    		room.remove("Guest");
		    		found = true;
		        }
		    }
		    
		    if(!found) {
		    	throw new AlreadyCheckoutException();
		    }

		     System.out.println("@ Berhasil checkout.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void initializeRooomData() {
		 this.data = new ArrayList<HashMap<String, Object>>();

		 HashMap<String, Object> room101 = new HashMap<>();
		 room101.put("101", new Standard());
		 data.add(room101);

		 HashMap<String, Object> room102 = new HashMap<>();
		 room102.put("102", new Standard());
		 data.add(room102);

		 HashMap<String, Object> room103 = new HashMap<>();
		 room103.put("103", new Standard());
		 data.add(room103);

		 HashMap<String, Object> room104 = new HashMap<>();
		 room104.put("104", new Suite());
		 data.add(room104);

		 HashMap<String, Object> room105 = new HashMap<>();
		 room105.put("105", new Suite());
		 data.add(room105);
	}
	
	public void roomList() {
		System.out.println("------------- Informasi ruangan -------------");
		for (HashMap<String, Object> room : data) {
		     for (Map.Entry<String, Object> entry : room.entrySet()) {
		    	 String key = entry.getKey();
		         Object value = entry.getValue();

		         if (value instanceof Standard || value instanceof Suite) {
		              System.out.print("Kamar " + key + ": ");
		              System.out.print(value.toString());
		         } else if (value instanceof Customer) {
		              System.out.print(value.toString());
		         }
		         System.out.println();
		     }
		 }
	}
}
