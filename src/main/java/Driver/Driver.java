package Driver;

import Entity.Employe;
import Service.Service;

import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Service service = new Service();

        java.util.Scanner sc = new Scanner(System.in);

        System.out.println("welcome to my CRUD OPERTION JDBC");

        boolean flag = true;

        while(flag) {

            System.out.println("1 for save");
            System.out.println("2 for update");
            System.out.println("3 for delete");
            System.out.println("4 for fetch");

            System.out.println("enter your choice");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("enter your ID");
                    int id = sc.nextInt();

                    System.out.println("enter your name");
                    String name = sc.next();

                    System.out.println("enter your age");
                    int age = sc.nextInt();

                    System.out.println("enter your salary");
                    int sal = sc.nextInt();

                    Entity.Employe employe = new Employe(id, name, age, sal);

                    int res1 = service.save(employe);

                    if (res1 != 0) {

                        System.out.println("data saved!!!");

                    } else {

                        System.out.println("data not saved!!!");
                    }

                    break;


                case 2:

                    System.out.println("enter your ID");
                    int updateId = sc.nextInt();

                    System.out.println("enter your name");
                    String updateName = sc.next();

                    System.out.println("enter your age");
                    int updateAge = sc.nextInt();

                    System.out.println("enter your salary");
                    int updateSal = sc.nextInt();

                    Entity.Employe employe1 =
                            new Employe(updateId, updateName, updateAge, updateSal);

                    int res2 = service.update(employe1);

                    if (res2 != 0) {

                        System.out.println("data updated!!!");

                    } else {

                        System.out.println("data not updated!!!");
                    }

                    break;


                case 3:

                    System.out.println("enter your ID");
                    int deleteId = sc.nextInt();

                    int res3 = service.delete(deleteId);

                    if (res3 != 0) {

                        System.out.println("data deleted!!!");

                    } else {

                        System.out.println("data not deleted!!!");
                    }

                    break;


                case 4:

                    java.util.List<Employe> list = service.fetchall();

                    if (list != null) {

                        for(Employe emp : list) {

                            System.out.println(emp.getName());

                            //
                        }
                    }

                    break;
            }
        }
    }
}