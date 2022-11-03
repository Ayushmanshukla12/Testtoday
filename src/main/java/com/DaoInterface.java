package com;

import java.io.IOException;

public interface DaoInterface {

    public void inserting() throws IOException;
    public void updating() throws IOException;
    public void retrive() throws IOException;
    public void delete() throws IOException;

    public  void particularDoctor() throws IOException;
    public  void particularDoctorwithName() throws IOException;
    public void particularPatient() throws IOException;
    public void showAll();

}
