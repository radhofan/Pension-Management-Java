package com.lgcns.mission.util;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MissionUtil {
	
private static Scanner s = new Scanner(System.in);
	
	public static int getUserInput() {
		return s.nextInt();
	}
	
	public static String getStringInput() {
		return s.nextLine();
	}
	
	@SuppressWarnings("deprecation")
	public static String moneyFormat(int price) {
        //NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);//Mata uang Korea Selatan
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID")); // ubah ke mata uang Indonesia
        return nf.format(price);
    }
	
}
