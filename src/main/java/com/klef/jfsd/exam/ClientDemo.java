package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class ClientDemo {
	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure();
    SessionFactory factory = cfg.buildSessionFactory();

    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();


    Device device = new Device();
    device.setBrand("Generic");
    device.setModel("DeviceModel1");
    device.setPrice(100.0);

    Smartphone smartphone = new Smartphone();
    smartphone.setBrand("Samsung");
    smartphone.setModel("Galaxy S21");
    smartphone.setPrice(999.99);
    smartphone.setOperatingSystem("Android");
    smartphone.setCameraResolution("108 MP");



    Tablet tablet = new Tablet();
    tablet.setBrand("Apple");
    tablet.setModel("iPad Pro");
    tablet.setPrice(799.99);
    tablet.setScreenSize("12.9 inches");
    tablet.setBatteryLife(10);
    session.persist(tablet);
    session.persist(device);
    session.persist(smartphone);
    tx.commit();
    session.close();
    factory.close();

    System.out.println("Records inserted successfully!");

	}
}
