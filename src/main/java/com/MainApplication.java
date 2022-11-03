package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DaoImplementation daoImplementation = new DaoImplementation();
        boolean flag=true;
        while(flag){
            System.out.println("press 0 to exit");
            System.out.println("press 1 to insert");
            System.out.println("press 2 to update");
            System.out.println("press 3 to retrieve");
            System.out.println("press 4 to delete");
            System.out.println("press 5 to doctor criteria");
            System.out.println("press 6 to doctor criteria with name");
            System.out.println("press 7 to pateint criteria");
            System.out.println("press 8 to show all data");
            System.out.println("enter your choice");
            int choice=Integer.parseInt(bufferedReader.readLine());
            switch (choice){
                case 0:
                    System.out.println("exit");
                    flag=false;
                    System.exit(0);
                    break;

                case 1:
                    daoImplementation.inserting();
                    break;

                case 2:
                    daoImplementation.updating();
                    break;

                case 3:
                    daoImplementation.retrive();
                    break;

                case 4:
                    daoImplementation.delete();
                    break;

                case 5:
                    daoImplementation.particularDoctor();
                    break;

                case 6:
                    daoImplementation.particularDoctorwithName();
                    break;

                case 7:
                    daoImplementation.particularPatient();
                    break;

                case 8:
                    daoImplementation.showAll();
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }
    }
}
