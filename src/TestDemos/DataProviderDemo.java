package TestDemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class DataProviderDemo {
	
	public static Logger logger=Logger.getLogger(DataProviderDemo.class);
	
	private static Connection con=null;

	
	@BeforeClass
	@Parameters({"driverclass","url","passkey","uname"})
	public void createConnection(String driverclass, String URL
			,String password,String username) throws ClassNotFoundException, SQLException {
		
		
		String path=System.getProperty("user.dir")+"\\src\\resources\\Logging.Properties";
		
		PropertyConfigurator.configure(path);
		
		//DOMConfigurator.configure(filename);--> for xml configuration
		// BasicConfigurator.configure();
		
		Class.forName(driverclass);
		con=DriverManager.getConnection(URL, username, password);
		
	}
	
	
	

	@Test(dataProvider="StaticData",priority=-1, groups= {"group1"})
	public void parametrizedTestCase(int id, String name) {
		
		logger.info("inside parametrized test Cases");
		System.out.println("inside test");
		System.out.println("id value is: "+id+" name is: "+name);
		
	}
	
	@Test(priority=0,groups= {"group2"})	
	public void f() {
		logger.info("inside dependent method");
		System.out.println("dependent method");
	}
	
	@DataProvider(name="StaticData")	
	public  Object[][] getdata() throws SQLException {
		
		Object[][] b=null;
		try {
			PreparedStatement ps=con.prepareStatement("select BloodBankId,BloodBankName from bloodbankdetails");
			
			ResultSet res=ps.executeQuery();
			
			b = new Object[20][];
			int i=0;
			while(res.next()) {
			int id=	res.getInt(1);
			String name=res.getString(2);
			Object[] intemediate= {id,name};
			b[i]=intemediate;
			i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		return b;
	}
	
}
