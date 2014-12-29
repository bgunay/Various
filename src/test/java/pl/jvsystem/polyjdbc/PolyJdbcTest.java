package pl.jvsystem.polyjdbc;

import java.util.List;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.Test;
import org.polyjdbc.core.PolyJDBC;
import org.polyjdbc.core.dialect.DialectRegistry;
import org.polyjdbc.core.query.InsertQuery;
import org.polyjdbc.core.query.QueryFactory;
import org.polyjdbc.core.query.SelectQuery;
import org.polyjdbc.core.schema.SchemaManager;
import org.polyjdbc.core.schema.model.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PolyJdbcTest
 */
public class PolyJdbcTest {
	private static final Logger LOG = LoggerFactory.getLogger(PolyJdbcTest.class);

	public static final String TABLE_NAME = "PERSON";

	@Test
	public void polyJdbcTest() {
		DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user", "password");
		PolyJDBC polyJdbc = new PolyJDBC(ds, DialectRegistry.H2.getDialect());

		SchemaManager schemaManager = polyJdbc.schemaManager();
		Schema schema = new Schema(polyJdbc.dialect());
		schema.addRelation(TABLE_NAME)
				.withAttribute().longAttr("id").withAdditionalModifiers("AUTO_INCREMENT").notNull().and()
				.withAttribute().string("name").withMaxLength(200).notNull().unique().and()
				.withAttribute().integer("age").notNull().and()
				.primaryKey("PK_PERSON").using("id").and()
				.build();
		schemaManager.create(schema);
		polyJdbc.close(schemaManager);

		InsertQuery insertQuery = polyJdbc.query().insert().into(TABLE_NAME).value("ID", 1).value("name", "test").value("age", 15);
		SelectQuery query = QueryFactory.selectAll(polyJdbc.dialect()).from(TABLE_NAME).where("name = :name")
				.withArgument("name", "test");

		polyJdbc.simpleQueryRunner().insert(insertQuery);
		List<String> list = polyJdbc.simpleQueryRunner().queryList(query, resultSet -> resultSet.getString(2));
		LOG.info("list: {}", list);
	}
}
