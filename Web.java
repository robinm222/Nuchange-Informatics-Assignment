import java.util.LinkedList;
import java.util.Scanner;
import com.google.gson.Gson;

public class Web {
    public static void main(String[] args) {

        LinkedList<Table> list = new LinkedList<Table>();
        Scanner sc = new Scanner(System.in);
        int x = 1;
        String jsonArray;

        do {
            System.out.println("Enter the command");

            String user_command = sc.nextLine();
            String[] command = user_command.split(" ");

            // To store a url in the table
            if (command[0].equals("storeurl")) {
                int shortkey = command[1].hashCode();
                Table instance = new Table(shortkey, command[1], 0);
                list.add(instance);
                System.out.println("Stored......");

            } else
                // incrementing count of the Url
                if (command[0].equals("get")) {
                    int list_size = list.size();
                    for (int i = 0; i < list_size; i++) {
                        String value = list.get(i).name;
                        if (value.equals(command[1])) {
                            list.get(i).count += 1;
                            System.out.println(list.get(i).shortkey + " count incremented");
                            break;
                        }
                    }
                } else
                    // To view the Present Count of the url
                    if (command[0].equals("count")) {
                        int list_size = list.size();
                        for (int i = 0; i < list_size; i++) {
                            String value = list.get(i).name;
                            if (value.equals(command[1])) {
                                System.out.println(list.get(i).count + " is the present count");
                                break;
                            }
                        }
                    } else
                        // Listing complete urls details in Json format
                        if (command[0].equals("list")) {
                            Gson gson = new Gson(); // Creating an object gson which is used to convert Linkedlist to Json Format
                            jsonArray = gson.toJson(list);
                            System.out.println(jsonArray);
                        } else if (command[0].equals("exit")) {
                            System.out.println("exiting");
                            x = 0;
                        } else {

                            System.out.println("Entered command is wrong");

                        }
        } while (x == 1);

    }
}
