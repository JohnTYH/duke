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
            boolean donewrong = false;
            if(s.length == 1)
                donewrong = true;
          // System.out.println(s[0]);
          // System.out.println(s[1]);

            if(s[0].equals("todo")) {

                try {
               // if (donewrong) {
                 //   System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
              //  } else {
                    String[] todoArray = ss.split(" ", 2);
                    Todo obj = new Todo(todoArray[1]);
                    info.add(obj);

                    System.out.println("Got it. I've added this task:");
                    System.out.println(" " + obj.toString());
                    System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");

                //}
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
            }
            }

            else if(s[0].equals("deadline"))
            {
                try{
                    String[] Date;
                    String[] Months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August",
                            "September", "October", "November", "December"};
                    String[] DLarray = s[1].split("/by ");
                    Deadline obj = new Deadline(DLarray[0], DLarray[1]);
                    if(DLarray[1].contains("/"))
                    {
                        String[] getDate = DLarray[1].split("/");
                        if(getDate.length == 3)
                        {
                            info.add(obj);
                            System.out.println("Got it. I've added this task:");
                            System.out.println(" " + obj.toString());
                            System.out.println("Now you have " + Integer.toString(Task.getTask()) + " (by: " + getDate[0] +" " + Months[Integer.valueOf(getDate[1]) - 1] + " " + getDate[2] + ")" + " task(s) in the list.");
                         //   System.out.print(getDate[0] +" " + Months[Integer.valueOf(getDate[1]) - 1] + " " + getDate[2]);
                        }
                    }
                    else {
                        info.add(obj);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(" " + obj.toString());
                        System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");
                        }
                    }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid. Please use '/by' keyword eg. (return book /by 1pm)");
                }

            }

            else if(s[0].equals("event"))
            {
                try {
                    String[] Earray = s[1].split("/at ");
                    Event obj = new Event(Earray[0], Earray[1]);
                    info.add(obj);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(" " + obj.toString());
                    System.out.println("Now you have " + info.size() + " task(s) in the list.");
                    }
                catch(ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid. Please use '/at' keyword eg. (event /at 1pm)");
                }
            }


            else if(s[0].equals("list"))
            {
                System.out.println("Here are the tasks in your list:");

                int x = 1;

                for(int i=0; i<info.size(); i++)
                {

                    System.out.println(" " + x + ". " + info.get(i).toString());
                    x++;
                }
            }

            else if(s[0].equals("delete"))
            {
               // try {
                    if(donewrong)
                        System.out.println("Invalid. Please add a number");
                    else {
                        int b = Integer.valueOf(s[1]);
                        if(b < 1 || b > info.size())
                            System.out.println("Invalid. Please try again.");
                        else
                        {
                            System.out.println("Noted. I've removed this task:");
                            System.out.println(info.get(b-1).toString());
                            info.remove(b-1);
                            System.out.println("Now you have " + info.size() + " task(s) in the list.");

                        }
                    }
               // }
            }

            else if(s[0].equals("done")) {
                try {

                    if (donewrong)
                        System.out.println("Invalid. Please add a number");
                    else {

                        int b = Integer.valueOf(s[1]);
                        if (b < 1 || b > info.size())
                            System.out.println("Invalid. Please try again.");
                        else {
                            if (info.get(b - 1).isDone)
                                System.out.println("This task is already completed.");
                            else {
                                System.out.println("Nice! I've marked this task as done:");
                                info.get(b - 1).markAsDone();
                                System.out.println(info.get(b - 1).printer());
                            }
                        }
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid. Please try again.");
                }
            }
            else if(s[0].equals("bye"))
            {
                System.out.println("Bye. Hope to see you again soon!");
                end = true;
            }
            else {
                 System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }


}
