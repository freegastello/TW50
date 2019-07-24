package ru.user.Main;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
	public static void main(String[] args) {
		String encodedAdmin = new BCryptPasswordEncoder().encode("admin");
		System.out.println("admin = " + encodedAdmin);
		//$2a$10$74X3wer6KhA4giOgjJaM0.oF4qnRPl8.xGZ21J1DrPLBiH1mCwccm

		String encodedUser = new BCryptPasswordEncoder().encode("user");
		System.out.println("user = " + encodedUser);
		//$2a$10$/c37AKvik1/NHu9iFjXuMOigrp2CE2Cw4wBe1znFpzy8quKAP6/7q

		String encodedPassword1 = new BCryptPasswordEncoder().encode("1");
		System.out.println("1 = " + encodedPassword1);
		//$2a$10$2UUt7CaxIqfppL4XhU09kO4gJmcXrRKtSozOnbvDfhswhxs3N0fFa

		String encodedPassword2 = new BCryptPasswordEncoder().encode("2");
		System.out.println("2 = " + encodedPassword2);
		//$2a$10$5uGVD7fOTpUmzFTCoLHf1uMD/TNb845dmJnNCT6dSHooTCtlByiY2

		String encodedPassword3 = new BCryptPasswordEncoder().encode("password");
		System.out.println("password = " + encodedUser);
		//
	}
}
