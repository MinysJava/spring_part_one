package Lesson.Home_Work;

import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = factory.createEntityManager();

        System.out.println("Команды:");
        System.out.println("1 - Найти клиентов купивших товр;");
        System.out.println("2 - Найти товар купленный клиентами;");
        System.out.println("3 - Добавить товар;");
        System.out.println("4 - Удалитьтовар товар;");
        System.out.println("5 - Добавить клиента;");
        System.out.println("6 - Удалитьтовар клиента;");

        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер команды:");
        int num_com = in.nextInt();

        switch (num_com){
            case 1:
                List<Product> products = em.createQuery("from Product p").getResultList();
                System.out.println("Товары:");
                for (Product p: products) {
                    System.out.println(p.getId() + " - " + p.getTitle());
                }
                System.out.println("Введите название товара:");
                String f_title = in.next();
                Query query = em.createQuery("from Client c join fetch c.products p where p.title = :title");
                query.setParameter("title", f_title);
                List<Client> clients = query.getResultList();
                System.out.println("Этот товар покупали:");
                for (Client c : clients) {
                    System.out.println(c.getId() + " - " + c.getName());
                }
                break;

            case 2:
                List<Client> clients1 = em.createQuery("from Client c").getResultList();
                System.out.println("Клиенты:");
                for (Client с: clients1) {
                    System.out.println(с.getId() + " - " + с.getName());
                }
                System.out.println("Введите id клиента:");
                long id_c = in.nextLong();
                Query query1 = em.createQuery("from Product p join fetch p.clients c where c.id = :id");
                query1.setParameter("id", id_c);
                List<Product> products1 = query1.getResultList();
                System.out.println("Этот клиент покупал:");
                for (Product p : products1) {
                    System.out.println(p.getId() + " - " + p.getTitle() + " - " + p.getCost());
                }
                break;

            case 3:
                System.out.println("Введите название товара:");
                String in_title = in.next();
                System.out.println("Введите цену товара:");
                int in_cost = in.nextInt();
                Product new_product = new Product();
                new_product.setTitle(in_title);
                new_product.setCost(in_cost);
                try {
                    em.getTransaction().begin();
                    em.persist(new_product);
                    em.flush();
                    em.getTransaction().commit();
                } catch (Exception ex){
                    em.getTransaction().rollback();
                }
                List<Product> products2 = em.createQuery("from Product p").getResultList();
                System.out.println("Товары:");
                for (Product p: products2) {
                    System.out.println(p.getId() + " - " + p.getTitle() + " - " + p.getCost());
                }
                break;

            case 4:
                List<Product> products3 = em.createQuery("from Product p").getResultList();
                System.out.println("Товары:");
                for (Product p: products3) {
                    System.out.println(p.getId() + " - " + p.getTitle());
                }
                System.out.println("Введите id товара:");
                int del_id = in.nextInt();
                try {
                    em.getTransaction().begin();
                    Query query2 = em.createQuery("delete from Product p where p.id = :id");
                    query2.setParameter("id", del_id);
                    query2.executeUpdate();
                    em.getTransaction().commit();
                }catch (Exception ex){
                    em.getTransaction().rollback();
                }
                List<Product> products4 = em.createQuery("from Product p").getResultList();
                System.out.println("Товары:");
                for (Product p : products4) {
                    System.out.println(p.getId() + " - " + p.getTitle());
                }
                break;

            case 5:
                System.out.println("Введите имя клиента:");
                String in_name = in.next();
                Client new_client = new Client();
                new_client.setName(in_name);
                try {
                    em.getTransaction().begin();
                    em.persist(new_client);
                    em.flush();
                    em.getTransaction().commit();
                } catch (Exception ex){
                    em.getTransaction().rollback();
                }
                List<Client> clients2 = em.createQuery("from Client c").getResultList();
                System.out.println("Клиенты:");
                for (Client c: clients2) {
                    System.out.println(c.getId() + " - " + c.getName());
                }
                break;

            case 6:
                List<Client> clients3 = em.createQuery("from Client c").getResultList();
                System.out.println("Клиенты:");
                for (Client с: clients3) {
                    System.out.println(с.getId() + " - " + с.getName());
                }
                System.out.println("Введите id клиента:");
                int del_id_2 = in.nextInt();
                try {
                    em.getTransaction().begin();
                    Query query2 = em.createQuery("delete from Client c where c.id = :id");
                    query2.setParameter("id", del_id_2);
                    query2.executeUpdate();
                    em.getTransaction().commit();
                }catch (Exception ex){
                    em.getTransaction().rollback();
                }
                List<Client> clients4 = em.createQuery("from Client c").getResultList();
                System.out.println("Клиенты:");
                for (Client с : clients4) {
                    System.out.println(с.getId() + " - " + с.getName());
                }
                break;


        }



//        try{
//            em.getTransaction().begin();



//        Client client1 = em.find(Client.class, 2L);
//            System.out.println(client1);

//            Query query = em.createNativeQuery("SELECT * from client join (product, basket) ON ( client.id = basket.client_id and basket.product_id = product.id) Where (product.id = ?);");
//            query.setParameter(1, 1);
//            Query query = em.createQuery("from Client c join fetch c.products p where p.id = 1");
//
//            List<Client> clients = query.getResultList();

//           for (int i = 0; i <= clients.size(); i++){
//               clients1.add(clients.get(i));
//           }
//            for (Object c : clients
//                 ) {
//                System.out.println("1 - " + c.toString());
//
//            }

//            clients.forEach(System.out::println);
//            System.out.println(clients.size());
//
//        } catch (Exception ex){
//            em.getTransaction().rollback();
//        }

//        for (int i = 0; i <= clients1.size(); i++){
//            System.out.println(i + " - " + clients1.get(i).getName());
//        }
//        persons.forEach(System.out::println);

        in.close();
        em.close();

    }
}
