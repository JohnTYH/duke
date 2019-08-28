import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        ArrayList<String> info = new ArrayList<String>();
        boolean end = false;

        while(!end)
        {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();


            if(s.equals("list"))
            {
                int x = 1;

                for(String i: info)
                {
                    System.out.println(x +". "+ i);
                    x++;
                }
            }

            else if(s.equals("bye"))
            {
                System.out.println("Bye. Hope to see you again soon!");
                end = true;
            }
            else {
                info.add(s);
                System.out.print("added: ");
                System.out.println(s);
            }
        }
    }


}
