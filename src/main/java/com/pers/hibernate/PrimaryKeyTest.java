/**
 * @author stacywang
 * @date 2017-06-12
 */

package com.pers.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pers.hibernate.entity.Student;

public class PrimaryKeyTest {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		            .addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Zheng", "Liu", "zhengliu@gmail.com");
			Student tempStudent2 = new Student("Yan", "Zhang", "yanzhang@gmail.com");
			Student tempStudent3 = new Student("Li", "Wang", "liwang@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving 3 students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
