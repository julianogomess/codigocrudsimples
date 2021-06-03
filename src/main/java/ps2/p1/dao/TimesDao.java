package ps2.p1.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;



public interface TimesDao {
	@SqlUpdate("CREATE TABLE times(" +
			" id BIGINT NOT NULL" +
			" GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"+
			" nome VARCHAR(255)  NOT NULL,"+
			" mascote VARCHAR(255) NOT NULL,"+
			" treinador VARCHAR(100) NOT NULL,"+
			" qtd BIGINT NOT NULL,"+
			" PRIMARY KEY(id)"+
			")")
	void createTable();
	
	@SqlUpdate("DROP TABLE times")
	void dropTable();
	
	@SqlUpdate("INSERT INTO times(nome, mascote, treinador, qtd) VALUES (?, ?, ?, ?)")
	@GetGeneratedKeys("id")
	long create(String nome,String mascote, String treinador, long qtd);
	
	@SqlQuery("SELECT * FROM times")
	@RegisterBeanMapper(Time.class)
	List<Time> read();
	
	@SqlQuery("SELECT * FROM times WHERE id=?")
	@RegisterBeanMapper(Time.class)
	Time readById(long id);
	
	@SqlUpdate("UPDATE times SET nome=:nome, mascote=:mascote, treinador=:treinador, qtd=:qtd WHERE id=:id")
	void update(@BindBean Time t);
	
	@SqlUpdate("DELETE FROM times WHERE id =?")
	void delete(long id);
	

}
