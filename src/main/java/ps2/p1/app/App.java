package ps2.p1.app;

import org.apache.derby.jdbc.ClientDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import ps2.p1.UI.TimesUI;
import ps2.p1.dao.TimesDao;


public class App {
	public static void main(String[] args) {
		ClientDataSource ds;
		ds = new ClientDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(1527);
		ds.setDatabaseName("faculdadeV2;create=true");
		ds.setUser("app");
		ds.setPassword("app");
		Jdbi jdbi = Jdbi.create(ds);
		jdbi.installPlugin(new SqlObjectPlugin());
		TimesDao dao = jdbi.onDemand(TimesDao.class);		
		TimesUI ui = new TimesUI(dao);
		ui.dialogar();
	}
}
