package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hash
 *
 */
public class Settings {
	private String dbhost;
	private String dbuser;
	private String dbpassword;
	private String dbname;
	private String inputXml;
	private String outputXml;
	private String inputTxt;
	private String outputTxt;

	public Settings() {
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
			File config = new File(this.getClass().getClassLoader().getResource("\\").getFile()+"..\\..\\config.properties");
			input = new FileInputStream(config);
			prop.load(input);
	 
			dbhost = prop.getProperty("dbhost");
			dbuser = prop.getProperty("dbuser");
			dbpassword = prop.getProperty("dbpassword");
			dbname = prop.getProperty("dbname");
			inputXml = prop.getProperty("inputXml");
			outputXml = prop.getProperty("outputXml");
			inputTxt = prop.getProperty("inputTxt");
			outputTxt = prop.getProperty("outputTxt");

	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
	}

	/**
	 * @return the dbhost
	 */
	public String getDbhost() {
		return dbhost;
	}

	/**
	 * @return the dbuser
	 */
	public String getDbuser() {
		return dbuser;
	}

	/**
	 * @return the dbpassword
	 */
	public String getDbpassword() {
		return dbpassword;
	}

	/**
	 * @return the dbname
	 */
	public String getDbname() {
		return dbname;
	}

	/**
	 * @return the inputXml
	 */
	public String getInputXml() {
		return inputXml;
	}

	/**
	 * @return the outputXml
	 */
	public String getOutputXml() {
		return outputXml;
	}

	/**
	 * @return the inputTxt
	 */
	public String getInputTxt() {
		return inputTxt;
	}

	/**
	 * @return the outputTxt
	 */
	public String getOutputTxt() {
		return outputTxt;
	}
	
}
