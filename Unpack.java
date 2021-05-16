package project_Java;
import java.util.HashMap;

import java.util.Map;
import java.util.TreeMap;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
/**
 * 
 * @author Fname Lname
 * @version 1.0 
 * @since 13 May 2021
 */

public class Unpack {

	/***
	 * This function decode the iso8583 message into message field numbers and their corresponding values.
	 * The input iso8583 message format contains header length, MTI, bitmap and field.
	 * During unpacking, header length characters (first 4 characters) need to be removed.
	 * Unpacking is done based on the iso8583 format based on iso8583 field information which is contained in iso87assii xml file.
	 * @param iso8583Message ISO8583 message contains header, MTI, bitmap, data field.
	 * @param iso87asciiFile xml file location which contains iso8583 field information.
	 * @return iso message details field number and value pairs.
	 * @throws Exception ISO exception
	 */	
	public Map<Integer, String> decode(String iso8583Message, String iso87asciiFile) throws Exception {
		Integer headerLength = 4;
		try {
			// Initialize packager.
			// Using XML packager.
			// This code throws ISOException.
			GenericPackager packager = new GenericPackager(iso87asciiFile);

			// Setting packager
			ISOMsg isoMsg = new ISOMsg();
			isoMsg.setPackager(packager);
			
			//remove header bit from iso message.
			iso8583Message = iso8583Message.substring(headerLength,iso8583Message.length()); 

			// first, convert ISO8583 Message String to byte[]
			byte[] bIsoMessage = new byte[iso8583Message.length()];
			for (int i = 0; i < bIsoMessage.length; i++) {
				bIsoMessage[i] = (byte) (int) iso8583Message.charAt(i);
			}
			// second, unpack the message
			isoMsg.unpack(bIsoMessage);
			
			//store iso field information in key value pair.
			HashMap<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
			
			// put MTI format in 0 field number
			fieldKeyValue.put(0, (String) isoMsg.getMTI()); 

			for (int i = 1; i <= isoMsg.getMaxField(); i++) {
				if (isoMsg.hasField(i))
					fieldKeyValue.put(i, isoMsg.getString(i));
			}
			
			// sorting by key
			Map<Integer, String> sortedFieldKeyValue = new TreeMap<Integer, String>(fieldKeyValue);
			
			return sortedFieldKeyValue;

		} catch (ISOException e) {
			throw new Exception(e);
		}
	}
}
