package com.nt.niranjana.kafka.producer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.niranjana.kafka.producer.model.Patient;

public class JsonUtil 
{

	public static String convertJavaObjectToJsonObject(Patient patient)
	{
		try
		{
			//return new ObjectMapper().writeValueAsString(patient); //if u want in single line or use below
			
			ObjectMapper obm = new ObjectMapper();
			String patiientJsonData = obm.writeValueAsString(patient);
			System.out.println("Patient JSon Data: "+patiientJsonData);
			return patiientJsonData;
		}
		catch(JsonProcessingException jspe)
		{
			jspe.printStackTrace();
		}
		return null;
	}
	
	public static Patient convertJsonObjectTojavaObject(String message)
	{
		try
		{
			//return new ObjectMapper().readValue(message,Patient.class); //if u want in single line or use below
			
			ObjectMapper obm = new ObjectMapper();
			Patient patientJavaObjectData = obm.readValue(message, Patient.class);
			System.out.println("Patient Java Object Data: "+patientJavaObjectData);
			return patientJavaObjectData;
		}
		catch(JsonProcessingException jspe)
		{
			jspe.printStackTrace();
		}
		return null;
	}
}
