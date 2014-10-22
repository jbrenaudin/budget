package fr.chezwams.budget.domain.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import fr.chezwams.budget.domain.Person;

public class PersonRepository {

	public List<Person> all() {
		Configuration configuration = new Configuration()
			.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
			.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/budget")
			.setProperty("hibernate.connection.username", "root")
			.setProperty("hibernate.connection.password", "test")
			.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
			.setProperty("hibernate.show_sql", "true")
			.setProperty("hibernate.hbm2ddl.auto", "update")
			.addFile("src/fr/chezwams/budget/domain/repository/hbm/Person.hbm.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Query query = session.createQuery("from Person");
        return query.list();
	}
}
