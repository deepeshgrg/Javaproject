package project_Java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Fname Lname
 * @version 1.0 
 * @since 13 May 2021
 */

public class Main {
	
	/**
	 * 
	 * @param args unused
	 * @throws Exception if any exception occurred
	 * @return nothing
	 */

	public static void main(String[] args) throws Exception {
		//iso 8583 filed information xml file
		String iso87asciiFile = "C:\\Users\\Dell\\Desktop\\Java Code\\JavaProject\\src\\test\\iso87ascii.xml";
		
		//create an object of the class Unpack
		Unpack d = new Unpack();		
			
		//create a Hashmap object called fieldKeyValue
		Map<Integer, String> fieldKeyValue = new HashMap<Integer, String>();
		
		//call the decode method
		fieldKeyValue = d.decode("02720200F23A448128E09000000000000400000016665544******07013010000000000000000629090044236030100044062906296011901020666554435665544******0701=170102000000000000617409236030NMBL1101SCT HBL NMB DHGSCT NMB DHANGADHI KAILAL SETI         NP5249BAC4CF0CC2427F22010000121524009054018", iso87asciiFile);
		
		System.out.println(fieldKeyValue);//print the value
		
		//create an object of class Pack
		Pack e = new Pack();
		
		//get field information		
		ArrayList<String> isoField = new ArrayList<String>();
		
		//sign on request message 
		isoField.add("0800");
		isoField.add("0824064819");
		isoField.add("094869");
		isoField.add("665544");
		isoField.add("001");
		
		//call the signonRequest method
		String isoMessage = e.signonRequest(isoField, iso87asciiFile);
		System.out.println("sign on request message:" +" "+ isoMessage);
		
		//Sign on Response message 
		isoField.clear();
		isoField.add("0810");
		isoField.add("0824064819");
		isoField.add("094869");
		isoField.add("665544");
		isoField.add("00");
		isoField.add("001");
		
		//call the signonResponse method
		isoMessage = e.signonResponse(isoField, iso87asciiFile);
		System.out.println("Sign on Response message:" +" "+ isoMessage);				
		 
		//Balance Enquiry Request message 
		isoField.clear();
		isoField.add("0200");
		isoField.add("665544******0701");
		isoField.add("301000");
		isoField.add("000000000000");
		isoField.add("0629090044");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6011");
		isoField.add("901");
		isoField.add("02");
		isoField.add("665544");
		isoField.add("665544******0701=170102000000000000");
		isoField.add("617409236030");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("SCT NMB DHANGADHI KAILAL SETI   NP");
		isoField.add("524");
		isoField.add("9BAC4CF0CC2427F2");
		isoField.add("10000121524009054018");

		//call the balEnqRequest method
		isoMessage = e.balEnqRequest(isoField, iso87asciiFile);
		System.out.println("Balance Enquiry Request message:"+" "+isoMessage);				
				
		//Balance Enquiry Response message 
		isoField.clear();
		isoField.add("0210");
		isoField.add("665544******0701");
		isoField.add("301000");
		isoField.add("000000000000");
		isoField.add("0629090044");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6011");
		isoField.add("665544");
		isoField.add("617409236030");
		isoField.add("531114");
		isoField.add("00");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("524");
		isoField.add("1001524C0000001165941002524C000000066594");
		
		//call the balEnqResponse method
		isoMessage = e.balEnqResponse(isoField, iso87asciiFile);
		System.out.println("Balance Enquiry Response message:"+" "+isoMessage);

		//Cash Withdraw Request message 
		isoField.clear();
		isoField.add("0200");
		isoField.add("665544******0701");
		isoField.add("011000");
		isoField.add("000000500000");
		isoField.add("0629090044");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6011");
		isoField.add("901");
		isoField.add("02");
		isoField.add("665544");
		isoField.add("665544******0701=170102000000000000");
		isoField.add("617409236030");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("SCT NMB DHANGADHI KAILAL SETI   NP");
		isoField.add("524");
		isoField.add("9BAC4CF0CC2427F2");
		isoField.add("10000121524009054018");

		//call the cashWithRequest method
		isoMessage = e.cashWithRequest(isoField, iso87asciiFile);
		System.out.println("Cash Withdraw Request message:"+" "+isoMessage);
					
		//Cash Withdraw Response message 
		isoField.clear();
		isoField.add("0210");
		isoField.add("665544******0701");
		isoField.add("011000");
		isoField.add("000000500000");
		isoField.add("0629090044");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6011");
		isoField.add("665544");
		isoField.add("617409236030");
		isoField.add("531114");
		isoField.add("00");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("524");
		isoField.add("1001524C0000001165941002524C000000066594");
			
		//call the cashWithResponse method
		isoMessage = e.cashWithResponse(isoField, iso87asciiFile);
		System.out.println("Cash Withdraw Response message:"+" "+isoMessage);
					
		//Financial Reversal Advice Request message 
	    isoField.clear();
		isoField.add("0420");
		isoField.add("665544******0701");
		isoField.add("011000");
		isoField.add("000000500000");
		isoField.add("0629090240");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6011");
		isoField.add("901");
		isoField.add("02");
		isoField.add("665544");
		isoField.add("617409236030");
		isoField.add("08");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("SCT NMB DHANGADHI KAILAL SETI   NP");
		isoField.add("524");
		isoField.add("020023603006290900440000066554400000000000");
		isoField.add("10000121524009054018");

		//call the finRevAdvRequest method
		isoMessage = e.finRevAdvRequest(isoField, iso87asciiFile);
		System.out.println("Financial Reversal Advice Request message:"+" "+isoMessage);
						
		//Financial Reversal Advice Response message 
		isoField.clear();
		isoField.add("0430");
		isoField.add("665544******0701");
		isoField.add("011000");
		isoField.add("000000500000");
		isoField.add("0629090240");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6011");
		isoField.add("665544");
		isoField.add("617409236030");
		isoField.add("531114");
		isoField.add("00");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("524");
			
		//call the finRevAdvResponse method
		isoMessage = e.finRevAdvResponse(isoField, iso87asciiFile);
		System.out.println("Financial Reversal Advice Response message:"+" "+isoMessage);
						
		//FinanciaL Advice Request message 
	    isoField.clear();
		isoField.add("0220");
		isoField.add("654321******1789");
		isoField.add("010000");
		isoField.add("000001500000");
		isoField.add("0824075234");
		isoField.add("108962");
		isoField.add("133734");
		isoField.add("0824");
		isoField.add("0825");
		isoField.add("6011");
		isoField.add("901");
		isoField.add("02");
		isoField.add("665544");
		isoField.add("654321******1789=170102000000000000");
		isoField.add("523607108962");
		isoField.add("NMBL0801");
		isoField.add("SCT HBL NMB BIR");
		isoField.add("SCT NMB BIRATNAGAR MORAG KOSHI   NP");
		isoField.add("524");

		//call the finAdvRequest method
		isoMessage = e.finAdvRequest(isoField, iso87asciiFile);
		System.out.println("Financial Advice Request message:"+" "+isoMessage);
							
		//Financial Advice Response message 
		isoField.clear();
		isoField.add("0230");
		isoField.add("654321******1789");
		isoField.add("010000");
		isoField.add("000001500000");
		isoField.add("0824075234");
		isoField.add("108962");
		isoField.add("133734");
		isoField.add("0824");
		isoField.add("0825");
		isoField.add("6011");
		isoField.add("665544");
		isoField.add("523607108962");
		isoField.add("412688");
		isoField.add("00");
		isoField.add("NMBL0801");
		isoField.add("SCT HBL NMB BIR");
		isoField.add("524");
			
		//call the finAdvResponse method
		isoMessage = e.finAdvResponse(isoField, iso87asciiFile);
		System.out.println("Financial Advice Response message:"+" "+isoMessage);
							
		//Sale/Purchase Request message 
	    isoField.clear();
		isoField.add("0200");
		isoField.add("665544******0701");
		isoField.add("001000");
		isoField.add("000000500000");
		isoField.add("0629090044");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6010");
		isoField.add("021");
		isoField.add("00");
		isoField.add("665544");
		isoField.add("665544******0701=170102000000000000");
		isoField.add("617409236030");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("SCT NMB DHANGADHI KAILAL SETI   NP");
		isoField.add("524");
		isoField.add("9BAC4CF0CC2427F2");
		isoField.add("10000121524009054018");

		//call the salPurRequest method
		isoMessage = e.salPurRequest(isoField, iso87asciiFile);
		System.out.println("Sale/Purchase Request message:"+" "+isoMessage);
								
		//Sale/Purchase Response message 
		isoField.clear();
		isoField.add("0210");
		isoField.add("665544******0701");
		isoField.add("001000");
		isoField.add("000000500000");
		isoField.add("0629090044");
		isoField.add("236030");
		isoField.add("100044");
		isoField.add("0629");
		isoField.add("0629");
		isoField.add("6010");
		isoField.add("665544");
		isoField.add("617409236030");
		isoField.add("531114");
		isoField.add("00");
		isoField.add("NMBL1101");
		isoField.add("SCT HBL NMB DHG");
		isoField.add("524");
		isoField.add("1001524C0000001165941002524C000000066594");
		
		//call the salPurResponse method
		isoMessage = e.salPurResponse(isoField, iso87asciiFile);
		System.out.println("Sale/Purchase Response message:"+" "+isoMessage);
					
	}

}

