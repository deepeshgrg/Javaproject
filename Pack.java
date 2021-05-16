package project_Java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

/**
 * 
 * @author Fname Lname
 * @version 1.0 
 * @since 13 May 2021
 */

public class Pack {
	/***
	 * 
	 * @param fieldKeyValue The value is assigned to the fieldKeyValue for displaying transaction information:
	 * @param iso87asciiFile :
	 * @return the isoMessage :
	 * @throws Exception :
	 */
	public String encode(HashMap<Integer, String> fieldKeyValue, String iso87asciiFile) throws Exception 
	{

		try {

			// Initialize packager.
			// Use XML packager. We also can use Java Code Packager
			// This code throws ISOException
			GenericPackager packager = new GenericPackager(iso87asciiFile);

			// Setting packager
			ISOMsg isoMsg = new ISOMsg();
			isoMsg.setPackager(packager);

			// Iterate the map using
			// for-each loop
			for (Map.Entry<Integer, String> kv : fieldKeyValue.entrySet()) {
				// Setting MTI
				isoMsg.set(kv.getKey(), kv.getValue());
			}

			// encode the ISO 8583 Message
			byte[] bIsoMsg = isoMsg.pack();

			// output ISO 8583 Message String
			String isoMessage = "";
			for (int i = 0; i < bIsoMsg.length; i++) {
				isoMessage += (char) bIsoMsg[i];
			}
			
			//add header length in the begining of iso message
			isoMessage = String.format("%04d", isoMessage.length()).concat(isoMessage);
					
			return isoMessage;
			} catch (ISOException e) {
			throw new Exception(e);
			}

	}
	
	/***
	 * 
	 * @param isoFieldValues : data filed <0:Mti, 7:Transmission date & time, 11:STAN, 32:Acquiring institution identification code, 70:Network management information code> 
	 * @param iso87asciiFile : xml file location which contains iso8583 field information.
	 * @return string iso8583 message
	 * @throws Exception
	 */
	 public String signonRequest(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(7, isoFieldValues.get(1));
		fieldKeyValue.put(11, isoFieldValues.get(2));
		fieldKeyValue.put(32, isoFieldValues.get(3));
		fieldKeyValue.put(70, isoFieldValues.get(4));
		
		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
	}
	
	/***
	 * @param isoFieldValues : data field <0:mti, 7:Transmission date & time, 11:STAN, 32:Acquiring institution identification code, 39:Response code, 70:Network management information code>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information
	 * @return string iso8583 message
	 * @throws Exception
	 */
	 public String signonResponse(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(7, isoFieldValues.get(1));
		fieldKeyValue.put(11, isoFieldValues.get(2));
		fieldKeyValue.put(32, isoFieldValues.get(3));
		fieldKeyValue.put(39, isoFieldValues.get(4));
		fieldKeyValue.put(70, isoFieldValues.get(5));
		
		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
		
	}
	
	/***
	 * 
	 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 22:Point of service entry mode, 25:Point of service condition code, 32:Acquiring institution identification code, 35:Track 2 data, 37:Retrieval reference number, 41:Card acceptor terminal identification, 42:Card acceptor identification code, 43:Card acceptor name/location, 49:Currency code,transaction, 52:Personal identification number data, 102:Account identification 1>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information.
	 * @return string iso8583 message
	 * @throws Exception
	 */
	public String balEnqRequest(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(22, isoFieldValues.get(10));
		fieldKeyValue.put(25, isoFieldValues.get(11));
		fieldKeyValue.put(32, isoFieldValues.get(12));
		fieldKeyValue.put(35, isoFieldValues.get(13));
		fieldKeyValue.put(37, isoFieldValues.get(14));
		fieldKeyValue.put(41, isoFieldValues.get(15));
		fieldKeyValue.put(42, isoFieldValues.get(16));
		fieldKeyValue.put(43, isoFieldValues.get(17));
		fieldKeyValue.put(49, isoFieldValues.get(18));
		fieldKeyValue.put(52, isoFieldValues.get(19));
		fieldKeyValue.put(102, isoFieldValues.get(20));
		
		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
	}
	
	/***
	 * 
	 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction 15:Date,settlement, 18:Merchant type, 32:Acquiring institution identification code, 37:Retrieval reference number, 38:Authorization identification response, 39:Response code, 41:Card acceptor terminal identificaation, 42:Card acceptor, 49:Currency code,transaction, 54:Additional amounts>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information
	 * @return string iso8583 message
	 * @throws Exception
	 */
	public String balEnqResponse(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(32, isoFieldValues.get(10));
		fieldKeyValue.put(37, isoFieldValues.get(11));
		fieldKeyValue.put(38, isoFieldValues.get(12));
		fieldKeyValue.put(39, isoFieldValues.get(13));
		fieldKeyValue.put(41, isoFieldValues.get(14));
		fieldKeyValue.put(42, isoFieldValues.get(15));
		fieldKeyValue.put(49, isoFieldValues.get(16));
		fieldKeyValue.put(54, isoFieldValues.get(17));

		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
	}
	
	/***
	 * 
	 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 22:Point of service entry mode, 25:Point of service condition code, 32:Acquiring institution identification code, 35:Track 2 data, 37:Retrieval reference number, 41:Card acceptor terminal identificaation, 42:Card acceptor, 43:Card acceptor name/location, 49:Currency code,transaction, 52:Personal identification number data, 102:Account identification1>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information.
	 * @return string iso8583 message
	 * @throws Exception
	 */
	public String cashWithRequest(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(22, isoFieldValues.get(10));
		fieldKeyValue.put(25, isoFieldValues.get(11));
		fieldKeyValue.put(32, isoFieldValues.get(12));
		fieldKeyValue.put(35, isoFieldValues.get(13));
		fieldKeyValue.put(37, isoFieldValues.get(14));
		fieldKeyValue.put(41, isoFieldValues.get(15));
		fieldKeyValue.put(42, isoFieldValues.get(16));
		fieldKeyValue.put(43, isoFieldValues.get(17));
		fieldKeyValue.put(49, isoFieldValues.get(18));
		fieldKeyValue.put(52, isoFieldValues.get(19));
		fieldKeyValue.put(102, isoFieldValues.get(20));


		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
	}
	
	/***
	 * 
	 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 32:Acquiring institution identification code, 37:Retrieval reference number, 38:Authorization identification response, 39:Response code, 41:Card acceptor terminal identification, 42:Card acceptor, 49:Currency code,transaction, 54:Additional amounts>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information
	 * @return string iso8583 message
	 * @throws Exception
	 */
	public String cashWithResponse(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(32, isoFieldValues.get(10));
		fieldKeyValue.put(37, isoFieldValues.get(11));
		fieldKeyValue.put(38, isoFieldValues.get(12));
		fieldKeyValue.put(39, isoFieldValues.get(13));
		fieldKeyValue.put(41, isoFieldValues.get(14));
		fieldKeyValue.put(42, isoFieldValues.get(15));
		fieldKeyValue.put(49, isoFieldValues.get(16));
		fieldKeyValue.put(54, isoFieldValues.get(17));

		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
		
	}
	
	/***
	 * 
	 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 22:Point of service entry mode, 25:Point of service condition code, 32:Acquiring institution identification code, 37:Retrieval reference number, 39:Response code, 41:Card acceptor terminal identification, 42:Card acceptor, 43:Card acceptor name/location, 49:Currency code,transaction, 90:Original data elements, 102:Account identification 1>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information.
	 * @return string iso8583 message
	 * @throws Exception
	 */
     public String finRevAdvRequest(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(22, isoFieldValues.get(10));
		fieldKeyValue.put(25, isoFieldValues.get(11));
		fieldKeyValue.put(32, isoFieldValues.get(12));
		fieldKeyValue.put(37, isoFieldValues.get(13));
		fieldKeyValue.put(39, isoFieldValues.get(14));
		fieldKeyValue.put(41, isoFieldValues.get(15));
		fieldKeyValue.put(42, isoFieldValues.get(16));
		fieldKeyValue.put(43, isoFieldValues.get(17));
		fieldKeyValue.put(49, isoFieldValues.get(18));
		fieldKeyValue.put(90, isoFieldValues.get(19));
		fieldKeyValue.put(102, isoFieldValues.get(20));


		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
	}
   
	/***
	 * 
	 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 32:Acquiring institution identification code, 37:Retrieval reference number, 38:Authorization identification response, 39:Response code, 41:Card acceptor terminal identification, 42:Card acceptor identification code, 49:Currency code, transaction>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information
	 * @return string iso8583 message
	 * @throws Exception
	 */
	 public String finRevAdvResponse(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(32, isoFieldValues.get(10));
		fieldKeyValue.put(37, isoFieldValues.get(11));
		fieldKeyValue.put(38, isoFieldValues.get(12));
		fieldKeyValue.put(39, isoFieldValues.get(13));
		fieldKeyValue.put(41, isoFieldValues.get(14));
		fieldKeyValue.put(42, isoFieldValues.get(15));
		fieldKeyValue.put(49, isoFieldValues.get(16));

		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
	
	}
	
	/***
	 * 
	 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 22:Point of service entry mode, 25:Point of service condition code, 32:Acquiring institution identification code, 35:Track 2 data, 37:Retrieval reference number, 41:Card acceptor terminal identification, 42:Card acceptor identification code, 43:Card acceptor name/location, 49:Currency code, transaction>
	 * @param iso87asciiFile : xml file location which contains iso8583 field information.
	 * @return string iso8583 message
	 * @throws Exception
	 */
     public String finAdvRequest(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
		
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(22, isoFieldValues.get(10));
		fieldKeyValue.put(25, isoFieldValues.get(11));
		fieldKeyValue.put(32, isoFieldValues.get(12));
		fieldKeyValue.put(35, isoFieldValues.get(13));
		fieldKeyValue.put(37, isoFieldValues.get(14));
		fieldKeyValue.put(41, isoFieldValues.get(15));
		fieldKeyValue.put(42, isoFieldValues.get(16));
		fieldKeyValue.put(43, isoFieldValues.get(17));
		fieldKeyValue.put(49, isoFieldValues.get(18));


		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
		
   		}
		
		/***
		 * 
		 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 32:Acquiring institution identification code, 37:Retrieval reference number, 38:Authorization identification response, 39:Response code, 41:Card acceptor terminal identification, 42:Card acceptor identification code, 49:Currency code, transaction>
		 * @param iso87asciiFile : xml file location which contains iso8583 field information
		 * @return string iso8583 message
		 * @throws Exception
		 */
		public String finAdvResponse(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
			
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(32, isoFieldValues.get(10));
		fieldKeyValue.put(37, isoFieldValues.get(11));
		fieldKeyValue.put(38, isoFieldValues.get(12));
		fieldKeyValue.put(39, isoFieldValues.get(13));
		fieldKeyValue.put(41, isoFieldValues.get(14));
		fieldKeyValue.put(42, isoFieldValues.get(15));
		fieldKeyValue.put(49, isoFieldValues.get(16));

		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
		
		}
			
		/***
		 * 
		 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 22:Point of service entry mode, 25:Point of service condition code, 32:Acquiring institution identification code, 35:Track 2 data, 37:Retrieval reference number, 41:Card acceptor terminal identification, 42:Card acceptor, 43:Card acceptor name/location, 49:Currency code,transaction, 52:Personal identification number data, 102:Account identification 1>
		 * @param iso87asciiFile : xml file location which contains iso8583 field information.
		 * @return string iso8583 message
		 * @throws Exception
		 */
		 public String salPurRequest(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
				
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(22, isoFieldValues.get(10));
		fieldKeyValue.put(25, isoFieldValues.get(11));
		fieldKeyValue.put(32, isoFieldValues.get(12));
		fieldKeyValue.put(35, isoFieldValues.get(13));
		fieldKeyValue.put(37, isoFieldValues.get(14));
		fieldKeyValue.put(41, isoFieldValues.get(15));
		fieldKeyValue.put(42, isoFieldValues.get(16));
		fieldKeyValue.put(43, isoFieldValues.get(17));
		fieldKeyValue.put(49, isoFieldValues.get(18));
		fieldKeyValue.put(52, isoFieldValues.get(19));
		fieldKeyValue.put(102, isoFieldValues.get(20));


		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
				
	   }
		   
		/***
		 * 
		 * @param isoFieldValues : data field <0:mti, 2:PAN, 3:Processing code, 4:Amount,transaction, 7:Transmission date and time, 11:STAN, 12:Time,local transaction, 13:Date,local transaction, 15:Date,settlement, 18:Merchant type, 32:Acquiring institution identification code, 37:Retrieval reference number, 38:Authorization identification response, 39:Response code, 41:Card acceptor terminal identification, 42:Card acceptor, 49:Currency code,transaction, 54:Additional amounts>
		 * @param iso87asciiFile : xml file location which contains iso8583 field information
		 * @return string iso8583 message
		 * @throws Exception
		 */		 
		public String salPurResponse(ArrayList<String> isoFieldValues, String iso87asciiFile) throws Exception {
					
		//store iso field information in key value pair.
		HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		fieldKeyValue.put(0, isoFieldValues.get(0));
		fieldKeyValue.put(2, isoFieldValues.get(1));
		fieldKeyValue.put(3, isoFieldValues.get(2));
		fieldKeyValue.put(4, isoFieldValues.get(3));
		fieldKeyValue.put(7, isoFieldValues.get(4));
		fieldKeyValue.put(11, isoFieldValues.get(5));
		fieldKeyValue.put(12, isoFieldValues.get(6));
		fieldKeyValue.put(13, isoFieldValues.get(7));
		fieldKeyValue.put(15, isoFieldValues.get(8));
		fieldKeyValue.put(18, isoFieldValues.get(9));
		fieldKeyValue.put(32, isoFieldValues.get(10));
		fieldKeyValue.put(37, isoFieldValues.get(11));
		fieldKeyValue.put(38, isoFieldValues.get(12));
		fieldKeyValue.put(39, isoFieldValues.get(13));
		fieldKeyValue.put(41, isoFieldValues.get(14));
		fieldKeyValue.put(42, isoFieldValues.get(15));
		fieldKeyValue.put(49, isoFieldValues.get(16));
		fieldKeyValue.put(54, isoFieldValues.get(17));


		// output ISO 8583 Message String
		String isoMessage = encode(fieldKeyValue, iso87asciiFile);
		return isoMessage;
					
	}
}
	

