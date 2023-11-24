package com.niranjana.jwt.main;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GenerateToken 
{

		public static void main(String[] args) 
		{
			String secret = "TestAppOneSample";
			
			String token = 
			Jwts.builder()
			.setId("8562455") //user UnqId
			.setSubject("Niranjana") //username
			.setIssuedAt(new Date(System.currentTimeMillis())) //token created time
			.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2))) //token exp time
			.setIssuer("EIDIKO") //token provider name
			.signWith(SignatureAlgorithm.HS256, secret.getBytes()) //see algo, secret
			.compact();
			
			System.out.println("Token is: "+token);
			System.out.println();
			
			//To know the token is valid or not, then we need to Claim the token and get  the data from token
			Claims c =
			Jwts.parser()   //parser means details
			.setSigningKey(secret.getBytes())
			.parseClaimsJws(token).getBody();
			
			System.out.println("Token Username :"+c.getSubject());
			System.out.println("Token Provided by: "+c.getIssuer());
			System.out.println("Token Issue on: "+c.getIssuedAt());
			System.out.println("Token ID: "+c.getId());
			System.out.println("Token Expire on: "+c.getExpiration());
			
		}
}
