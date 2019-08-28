import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;

public class Duke {

    public static void main(String[] args) {


        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");


        ArrayList<Task> info = new ArrayList<Task>();
        boolean end = false;

        while(!end)
        {
            Scanner in = new Scanner(System.in);
            String ss = in.nextLine();


            String[] s = ss.split(" ");


            if(s[0].equals("list"))
            {
                System.out.println("Here are the tasks in your list:");

                int x = 1;

                for(Task i: info)
                {
                   // PrintWriter consoleOut = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"));
                  //  consoleOut.println(filename);


                    //PrintStream out = new PrintStream(System.out, true, "UTF-8");
                    System.out.println(x + "." + i.printer());
                   // consoleOut.println(x + "." + i.printer());
                    x++;
                }
            }

            else if(s[0].equals("done"))
            {
             //   Scanner in = new Scanner(System.in);
                //int b = s[2] - '0' ;
                int b = Integer.valueOf(s[1]);
                //int b = in.nextInt();

                System.out.println("Nice! I've marked this task as done:");

               // Task c = info.get(b-1);
                if(b < 1 || b > info.size())
                    System.out.println("Invalid. Please try again");
                else {
                    if(info.get(b-1).isDone)
                        System.out.println("This task is already completed");
                    else
                    {
                      info.get(b - 1).markAsDone();
                      System.out.println(info.get(b - 1).printer());
                    }
                }
            }

            else if(s[0].equals("bye"))
            {
                System.out.println("Bye. Hope to see you again soon!");
                end = true;
            }
            else {
                Task obj = new Task(ss);
                info.add(obj);
                System.out.print("added: ");
                System.out.println(ss);
            }
        }
    }


}
