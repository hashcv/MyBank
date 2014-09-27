package test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import sun.misc.Resource;

/**
 * @author hash
 *
 */
public class IOTxt implements InputOutput {
	private static Settings settings = new Settings();
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#read()
	 */
	public void read() throws IOException {

		File dest1 = new File(this.getClass().getClassLoader()
				.getResource("\\").getFile()
				+ "..\\..\\"+settings.getReadTxtCusts());

		BufferedReader custReader = new BufferedReader(new FileReader(dest1));
		String str;
		while ((str = custReader.readLine()) != null) {
			Storage.getCusts().add(Customer.parseCust(str));
		}

		File dest2 = new File(this.getClass().getClassLoader()
				.getResource("\\").getFile()
				+ "..\\..\\"+settings.getReadTxtAccs());
		BufferedReader accReader = new BufferedReader(new FileReader(dest2));

		while ((str = accReader.readLine()) != null) {
			Storage.getAccs().add(Account.parseAcc(str));
		}

		custReader.close();
		accReader.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#write()
	 */
	public void write() throws IOException {
		BufferedWriter cw = new BufferedWriter(new FileWriter(settings.getWriteTxtCusts()));
		BufferedWriter ca = new BufferedWriter(new FileWriter(settings.getWriteTxtAccs()));
		for (Customer cust : Storage.getCusts()) {
			cw.write(cust.toString());
			cw.newLine();
		}

		for (Account acc : Storage.getAccs()) {
			ca.write(acc.toString());
			cw.newLine();
		}

		cw.close();
		ca.close();

	}

}
