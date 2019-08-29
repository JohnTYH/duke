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


            String[] s = ss.split(" ",2);
          // System.out.println(s[0]);
          // System.out.println(s[1]);

            if(s[0].equals("todo"))
            {
                String[] todoArray = ss.split(" ",2);
                Todo obj = new Todo(todoArray[1]);
                info.add(obj);

                System.out.println("Got it. I've added this task:");
                System.out.println(" " + obj.toString());
                System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");

            }

            else if(s[0].equals("deadline"))
            {
                String[] DLarray = s[1].split("/by ");
                Deadline obj = new Deadline(DLarray[0],DLarray[1]);
                info.add(obj);
                System.out.println("Got it. I've added this task:");
                System.out.println(" " + obj.toString());
                System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");

            }

            else if(s[0].equals("event"))
            {
                String[] Earray = s[1].split("/at ");
                Event obj = new Event(Earray[0],Earray[1]);
                info.add(obj);
                System.out.println("Got it. I've added this task:");
                System.out.println(" " + obj.toString());
                System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");

            }


            if(s[0].equals("list"))
            {
                System.out.println("Here are the tasks in your list:");

                int x = 1;

                for(int i=0; i<info.size(); i++)
                {

                    System.out.println(" " + x + ". " + info.get(i).toString());
                    x++;
                }

             /*   for(Task i: info)
                {
                   System.out.println(x + "." + i.printer());
                   x++;
                }*/
            }



            else if(s[0].equals("done"))
            {
             //   Scanner in = new Scanner(System.in);
                //int b = s[2] - '0' ;
                int b = Integer.valueOf(s[1]);
                //int b = in.nextInt();



               // Task c = info.get(b-1);
                if(b < 1 || b > info.size())
                    System.out.println("Invalid. Please try again");
                else {
                    if(info.get(b-1).isDone)
                        System.out.println("This task is already completed");
                    else
                    {
                      System.out.println("Nice! I've marked this task as done:");
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
     /*       else {
                Task obj = new Task(ss);
                info.add(obj);
                System.out.print("added: ");
                System.out.println(ss);
            }*/
        }
    }


}
