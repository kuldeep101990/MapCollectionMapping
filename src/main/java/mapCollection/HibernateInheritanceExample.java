package mapCollection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateInheritanceExample {

	 public static void main(String[] args) {
	        // Load the configuration and build the SessionFactory
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	        		.applySettings(configuration.getProperties())
	        		.build();
	        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	        // Create a session
	        Session session = sessionFactory.openSession();
	        Transaction transaction = null;

	        try {
	            transaction = session.beginTransaction();

	            // Create a new Department
	            Department department = new Department();
	            department.setName("Engineering");

	            Map<Long, String> employees = new HashMap();
	            employees.put(1L, "John Doe");
	            employees.put(2L, "Jane Smith");
	            employees.put(3L, "Emily Davis");
	            department.setEmployeeNames(employees);

	            // Save the Department
	            session.save(department);

	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	            sessionFactory.close();
	        }
	    }	            
}