import services.editions.*;
import services.readers.*;
import services.subscriptions.DeleteSubscription;
import services.subscriptions.ObtainSubscriptionsByReaderId;
import services.subscriptions.SubscribeReader;

import java.util.Scanner;

/*
For using this project You have to carry out two steps:

1. You should set up login, password and url for your connection to DataBase
in EditionDAO, ReaderUserDAO, SubscriptionDAO interfaces accordingly. These interfaces are in implementation package.

2. You should create three MySQL tables in db.sql file which locates in dbMySQL package.

Enjoy using!
 */
public class Main {
    public static void main(String[] args) {
        boolean start = true;
        while (start){
            System.out.println("Where would you like to work?\n" +
                    " In Readers DataBase, input 1:\n" +
                    " In Editions DataBase, input 2\n" +
                    " To Manage Subscriptions, input 3:\n" +
                    " To Close Program, input 0");
            int command_main;
            Scanner in_main = new Scanner(System.in);
            command_main = in_main.nextInt();
            switch (command_main){
                case 0:
                    start=false;
                    break;
                case 1:
                    int command_reader;
                    Scanner in = new Scanner(System.in);
                    System.out.print("Input a command: " +
                            "\n To Obtain Reader, input 1:\n" +
                            " To Add Reader, input 2:\n" +
                            " To Update Surname Reader input 3:\n" +
                            " To Delete Reader input 4:\n" +
                            " To Obtain All Readers input 5\n" +
                            " ");
                    command_reader = in.nextInt();

                    switch (command_reader){

                        case (1):
                            System.out.println("If you would like to obtain Reader by id, input 1:\n" +
                                    "by name input 2:");
                            Scanner in_choose_identifier = new Scanner(System.in);
                            int choose_identifier = in_choose_identifier.nextInt();
                            if(choose_identifier==1){
                                System.out.println("Input id:");
                                Scanner in_id_reader = new Scanner(System.in);
                                String id_reader = in_id_reader.next();
                                ObtainTheReaderById req = new ObtainTheReaderById();
                                req.obtainReader(id_reader);
                            }
                            if(choose_identifier==2){
                                System.out.println("Input Name:");
                                Scanner in_name_reader = new Scanner(System.in);
                                System.out.println("Input Surname:");
                                Scanner in_surname_reader = new Scanner(System.in);
                                String reader_name = in_name_reader.next();
                                String reader_surname = in_surname_reader.next();
                                ObtainTheReaderByName req = new ObtainTheReaderByName();
                                req.obtainUserByName(reader_name,reader_surname);
                            }
                         break;

                        case (2):
                            System.out.println("Input Name:");
                            System.out.println("Input Surname:");
                            System.out.println("Input Birthday in format yyyy-mm-dd:");
                            Scanner in_input_name_reader = new Scanner(System.in);
                            Scanner in_input_surname_reader = new Scanner(System.in);
                            Scanner in_input_birthday_reader = new Scanner(System.in);
                            String input_name_reader = in_input_name_reader.next();
                            String input_surname_reader = in_input_surname_reader.next();
                            String input_birthday_reader = in_input_birthday_reader.next();
                            CreateReader new_reader = new CreateReader();
                            new_reader.createReader(input_name_reader,input_surname_reader,input_birthday_reader);
                            break;

                        case(3):
                            System.out.println("Input id Reader:");
                            Scanner in_id_reader = new Scanner(System.in);
                            System.out.println("Input new Surname:");
                            Scanner in_new_surname = new Scanner(System.in);
                            String out_id_reader = in_id_reader.next();
                            String new_surname = in_new_surname.next();
                            UpdateReaderSurnameById req = new UpdateReaderSurnameById();
                            req.updateReaderSurname(out_id_reader,new_surname);
                            break;

                        case(4):
                            System.out.println("Input id Reader:");
                            Scanner in_delete_id_reader = new Scanner(System.in);
                            String delete_id_reader = in_delete_id_reader.next();
                            DeleteReader del = new DeleteReader();
                            del.deleteReader(delete_id_reader);
                            break;

                        case(5):
                            ObtainAllReaders allReaders = new ObtainAllReaders();
                            allReaders.obtainAllReaders();
                            break;
                    }
                    break;

                case(2):
                     int command_edition;
                     Scanner in_edition = new Scanner(System.in);
                     System.out.print("Input a command: " +
                             "\n To Obtain Edition, input 1:\n" +
                             " To Add Edition, input 2:\n" +
                             " To Update Edition Name input 3:\n" +
                             " To Delete Edition input 4:\n" +
                             " To Obtain All Editions input 5\n" +
                             " ");
                     command_edition = in_edition.nextInt();
                     switch (command_edition){

                         case (1):
                             System.out.println("If you would like to obtain Edition by id, input 1:\n" +
                                     "by name input 2:");
                             Scanner in_choose_identifier = new Scanner(System.in);
                             int choose_identifier = in_choose_identifier.nextInt();
                             if(choose_identifier==1){
                                 System.out.println("Input id:");
                                 Scanner in_id_edition = new Scanner(System.in);
                                 String id_edition = in_id_edition.next();
                                 ObtainEditionById req = new ObtainEditionById();
                                 req.readEdition(id_edition);
                                 break;
                             }
                             if(choose_identifier==2){
                                 System.out.println("Input Name:");
                                 Scanner in_name_edition = new Scanner(System.in);
                                 String edition_name = in_name_edition.next();
                                 ObtainEditionByName req = new ObtainEditionByName();
                                 req.readByName(edition_name);
                                 break;
                             }
                          break;

                         case (2):
                             System.out.println("Input Name:");
                             Scanner in_input_name_edition = new Scanner(System.in);
                             String input_name_edition = in_input_name_edition.next();
                             CreateEdition new_reader = new CreateEdition();
                             new_reader.createEdition(input_name_edition);
                          break;

                         case(3):
                             System.out.println("Input id Edition:");
                             Scanner in_id_edition = new Scanner(System.in);
                             System.out.println("Input new Name:");
                             Scanner in_new_name = new Scanner(System.in);
                             String out_id_edition = in_id_edition.next();
                             String new_edition_name = in_new_name.next();
                             UpdateEditionNameById req = new UpdateEditionNameById();
                             req.updateEditionName(Integer.parseInt(out_id_edition),new_edition_name);
                          break;

                         case(4):
                             System.out.println("Input id Edition:");
                             Scanner in_delete_id_edition = new Scanner(System.in);
                             String delete_id_edition = in_delete_id_edition.next();
                             DeleteEdition del_edition = new DeleteEdition();
                             del_edition.deleteEdition(delete_id_edition);
                          break;

                         case(5):
                             ObtainAllEditions allEditions = new ObtainAllEditions();
                             allEditions.obtainAllEditions();
                          break;
                     }
                     break;

                case (3):
                    int command_subscription;
                    Scanner in_subscription = new Scanner(System.in);
                    System.out.print("Input a command: " +
                            "\n To Obtain Reader`s Subscriptions, input 1:\n" +
                            " To Subscribe Reader, input 2:\n" +
                            " To Delete Subscription, input 3:\n"
                           );
                    command_subscription = in_subscription.nextInt();
                    switch(command_subscription){
                        case (1):
                            System.out.println("Input id Reader:");
                            Scanner in_obtain_subs = new Scanner(System.in);
                            String obtain_subs = in_obtain_subs.next();
                            ObtainSubscriptionsByReaderId resp = new ObtainSubscriptionsByReaderId();
                            resp.obtainSubscriptions(obtain_subs);
                            break;

                        case(2):
                            System.out.println("Input id Reader:");
                            Scanner in_id_reader_to_sub = new Scanner(System.in);
                            System.out.println("Input id Edition:");
                            Scanner in_edition_to_sub = new Scanner(System.in);
                            String reader_to_sub = in_id_reader_to_sub.next();
                            String edition_to_sub = in_edition_to_sub.next();
                            SubscribeReader req = new SubscribeReader();
                            req.subscribeReader(reader_to_sub,edition_to_sub);
                            break;

                        case(3):
                            System.out.println("Input id Reader:");
                            Scanner in_id_reader_to_del = new Scanner(System.in);
                            System.out.println("Input id Edition:");
                            Scanner in_edition_to_del = new Scanner(System.in);
                            String reader_to_del = in_id_reader_to_del.next();
                            String edition_to_del = in_edition_to_del.next();
                            DeleteSubscription request = new DeleteSubscription();
                            request.deleteSubscription(reader_to_del,edition_to_del);
                            break;
                    }
                    break;
            }
        }
    }
}
