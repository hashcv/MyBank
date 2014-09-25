package test3;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author hash
 *
 */
public class IODatabase implements InputOutput {
	private static Storage storage = Storage.getInstance();
	private static List<Customer> custs = storage.getCusts();
	private static List<Account> accs = storage.getAccs();
	private Statement st;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#read()
	 */
	public void read() throws IOException {
		MysqlUtil mysql = new MysqlUtil();
		ResultSet rs = mysql.queryRs("select * from customers");

		try {
			while (rs.next()) {
				custs.add(new Customer(rs.getString("firstName"), rs
						.getString("lastName"), rs.getLong("ipn"), rs
						.getString("address"), rs.getString("phone"), rs
						.getString("email")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rs = mysql.queryRs("select * from accounts");
		try {
			while (rs.next()) {
				accs.add(new Account(rs.getLong("number"),
						rs.getString("name"), Currencies.valueOf(rs
								.getString("currency")), rs.getDouble("debit"),
						rs.getDouble("creditLimit"), Storage.findCustomer(rs
								.getLong("ipn"))));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.valentyn_tymku.bank.InputOutput#write()
	 */
	public void write() throws IOException {
		MysqlUtil mysql = new MysqlUtil();

		for (Customer cust : custs) {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append("customers1");
			sb.append(" (firstName, lastName, ipn, address, phone, email");
			sb.append(") VALUES ('");
			sb.append(cust.getFirstName());
			sb.append("', '");
			sb.append(cust.getLastName());
			sb.append("', '");
			sb.append(cust.getIpn());
			sb.append("', '");
			sb.append(cust.getAddress());
			sb.append("', '");
			sb.append(cust.getPhone());
			sb.append("', '");
			sb.append(cust.getEmail());
			sb.append("')");
			mysql.queryNoRs(sb.toString());
		}

		for (Account acc : accs) {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append("accounts1");
			sb.append(" (number, name, currency, debit, creditLimit, ipn");
			sb.append(") VALUES ('");
			sb.append(acc.getNumber());
			sb.append("', '");
			sb.append(acc.getName());
			sb.append("', '");
			sb.append(acc.getCurrency().toString());
			sb.append("', '");
			sb.append(acc.getDebit());
			sb.append("', '");
			sb.append(acc.getCreditLimit());
			sb.append("', '");
			sb.append(acc.getCustomer().getIpn());
			sb.append("')");
			mysql.queryNoRs(sb.toString());
		}

	}
}
