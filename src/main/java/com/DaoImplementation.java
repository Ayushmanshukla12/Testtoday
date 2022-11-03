package com;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements DaoInterface{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void inserting() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        DoctorPojo doctorPojo = new DoctorPojo();
        System.out.println("enter the doctor name");
        doctorPojo.setDoctorName(bufferedReader.readLine());
        System.out.println("enter the doctor experience");
        doctorPojo.setDoctorExperience(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("enter the doctor specialization");
        doctorPojo.setDoctorSpecialization(bufferedReader.readLine());
        System.out.println("enter the doctor fees");
        doctorPojo.setDoctorFees(Integer.parseInt(bufferedReader.readLine()));

        List<DoctorPojo> doctorPojoList = new ArrayList<>();
        doctorPojoList.add(doctorPojo);

        PatientPojo patientPojo = new PatientPojo();
        System.out.println("enter the pateint name");
        patientPojo.setPatientName(bufferedReader.readLine());
        System.out.println("enter the pateint age");
        patientPojo.setPatientAge(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("enter teh patient rating");
        patientPojo.setPatientRating(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("enter the pateint disease");
        patientPojo.setPatientDisease(bufferedReader.readLine());
        System.out.println("enter the pateint feedback");
        patientPojo.setPatientFeedback(bufferedReader.readLine());

        List<PatientPojo> patientPojoList = new ArrayList<>();
        patientPojoList.add(patientPojo);

        doctorPojo.setPatientPojos(patientPojoList);
        patientPojo.setDoctorPojos(doctorPojoList);

        entityManager.persist(doctorPojo);
        entityManager.persist(patientPojo);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void updating() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("enter the patient id whose feedback u want to update");
        int pid=Integer.parseInt(bufferedReader.readLine());
        System.out.println("enter the new feedback");
        String newfeedback=bufferedReader.readLine();
        PatientPojo patientPojo=entityManager.find(PatientPojo.class,pid);
        patientPojo.setPatientFeedback(newfeedback);

        System.out.println("enter the doctor id whose fees u want to update");
        int did=Integer.parseInt(bufferedReader.readLine());
        System.out.println("enter the new fees");
        int newfees= Integer.parseInt(bufferedReader.readLine());
        DoctorPojo doctorPojo=entityManager.find(DoctorPojo.class,did);
        doctorPojo.setDoctorFees(newfees);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void retrive() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("enter the doctor id u want to retreive");
        int did=Integer.parseInt(bufferedReader.readLine());
        DoctorPojo doctorPojo=entityManager.find(DoctorPojo.class,did);
        System.out.println(doctorPojo);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void delete() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("enter the patient id u want to delete");
        int pid=Integer.parseInt(bufferedReader.readLine());

        PatientPojo patientPojo=entityManager.find(PatientPojo.class,pid);
        entityManager.remove(patientPojo);

        System.out.println("enter the doctor id u want to delete");
        int did=Integer.parseInt(bufferedReader.readLine());

        DoctorPojo doctorPojo=entityManager.find(DoctorPojo.class,did);
        entityManager.remove(doctorPojo);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void particularDoctor() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<DoctorPojo> root = criteriaQuery.from(DoctorPojo.class);

        System.out.println("enter the specialisation  of the doctor");
        String specialisation= bufferedReader.readLine();
        Query query= entityManager.createQuery("Select doctorPojo from DoctorPojo doctorPojo where " +
                "doctorPojo.doctorSpecialization='"+specialisation+"'");

        Query query1 = entityManager.createQuery(criteriaQuery.select(root)
                        .where(criteriaBuilder.like(root.get("doctorSpecialization"),specialisation)));

        List<DoctorPojo> list1=(List<DoctorPojo>) query1.getResultList();
        list1.stream().forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void particularDoctorwithName() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<DoctorPojo> root = criteriaQuery.from(DoctorPojo.class);

        System.out.println("enter the name  of the doctor");
        String name= bufferedReader.readLine();
        Query query= entityManager.createQuery("Select doctorPojo from DoctorPojo doctorPojo where " +
                "doctorPojo.doctorName='"+name+"'");

        Query query1 =entityManager.createQuery(criteriaQuery.select(root).where(criteriaBuilder.like(root.get("doctorName")
                ,name)));

        List<DoctorPojo> list1=(List<DoctorPojo>) query1.getResultList();
        list1.stream().forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void particularPatient() throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<PatientPojo> root = criteriaQuery.from(PatientPojo.class);

        System.out.println("enter the rating of the patient");
        int rating= Integer.parseInt(bufferedReader.readLine());
        Query query= entityManager.createQuery("Select patientPojo from PatientPojo patientPojo where " +
                "patientPojo.patientRating>='"+rating+"'");

        Query query1 =entityManager.createQuery(criteriaQuery.select(root).where(criteriaBuilder.gt(root.
                get("patientRating"),rating)));

        List<PatientPojo> list1=(List<PatientPojo>) query1.getResultList();
        list1.stream().forEach(System.out::println);
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void showAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ayushman");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
    Root<DoctorPojo> root = criteriaQuery.from(DoctorPojo.class);
    CriteriaQuery<Object> select = criteriaQuery.select(root);
    TypedQuery<Object> typedQuery = entityManager.createQuery(select);
    List<Object> resultlist = typedQuery.getResultList();
        resultlist.forEach(System.out::println);
    }
}
