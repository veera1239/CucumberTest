package com.model;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {
public static void main(String[] args) {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata m = new MetadataSources(ssr).getMetadataBuilder().build();
	SessionFactory fac= m.getSessionFactoryBuilder().build();
	Session ses =fac.openSession();
	org.hibernate.Transaction t = ses.beginTransaction();
	Product p= new Product();
	p.setId(111);
	p.setpName("pen");
ses.save(p);
t.commit();
System.out.println("Inserted....");fac.close();
ses.close();
}
}
