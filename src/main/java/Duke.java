import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class Duke {

    public static void main(String[] args) {


        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");


        ArrayList<Task> info = new ArrayList<Task>();

        boolean end = false;


                try {
                    FileReader fr = new FileReader("C:\\Users\\Johnt.DESKTOP-H969RCO\\Documents\\GitHub\\duke\\Data\\Duke.txt"); //Load from this local address
                    BufferedReader br = new BufferedReader(fr); //Use buffered reader, file reader to load.
                    String line_X;
                    while ((line_X = br.readLine()) != null) {

                        String[] temp = line_X.split("|", 3); //Temp[0] represents the type of event "D/E/T"
                        String[] tempp = temp[2].split("",3); //Tempp[2] represents the content to be saved.
//                        System.out.println(temp[0]);
//                        System.out.println(temp[1]);
//                        System.out.println(temp[2]);
//
//                        System.out.println(tempp[0]);
//                        System.out.println(tempp[1]);
//                        System.out.println(tempp[2]);


                        if (temp[0].equals("D")) {
                            Date newDate = new Date();
                            try {
                                String[] temp2 = tempp[2].split("by: ", 2); //split date from content.
                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");
                                newDate = format.parse(temp2[0]);
                                // System.out.println(newDate);
                                Deadline obj = new Deadline(temp2[0], newDate,temp2[1]);
                                if(temp[1].equals("1"))
                                    obj.markAsDone();
                                info.add(obj); //push object
                            } catch (ParseException e) { //catch if date format is wrong.
                                System.out.println("Invalid date format!");
                            }
                        }
                        else if (temp[0].equals("T")) {
                            Todo obj = new Todo(tempp[2]);
                            if (tempp[0].equals("1"))
                                obj.markAsDone();
                            info.add(obj); // push object
                            // System.out.println(obj.toString());
                        }
                        else if (temp[0].equals("E")) {
                            Date newDate = new Date();
                            try {
                                String[] temp2 = tempp[2].split("at: ", 2); //split date from content.
                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");
                                newDate = format.parse(temp2[0]);
                                // System.out.println(newDate);
                                Event obj = new Event(temp2[0], newDate,temp2[1]);
                                if(temp[1].equals("1"))
                                    obj.markAsDone();
                                info.add(obj); //push object
                            } catch (ParseException e) { //catch exception if date format is wrong.
                                System.out.println("Invalid date format!");
                            }
                        }
                        br.close(); //close reader
                    }
                } catch (IOException e) {
                    System.out.println(" file not found, creating file...");
                }
        Scanner in = new Scanner(System.in);

        while(!end)
        {

            String ss = in.nextLine(); //read in next input


            String[] s = ss.split(" ",2); //split input for command.
            boolean donewrong = false;
            if(s.length == 1)
                donewrong = true;
          // System.out.println(s[0]);
          // System.out.println(s[1]);

            if(s[0].equals("todo")) { //if command is todo

                try {

                   // String[] todoArray = ss.split(" ", 2);
                    Todo obj = new Todo(s[1]);
                    info.add(obj); //push object.

                    System.out.println("Got it. I've added this task:");
                    System.out.println(" " + obj.toString()); //print
                    System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");

            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
            }
            }
            else if(s[0].equals("find")) //if command is find
            {
               // try {
                    int a = 1; //index start from 1
                    System.out.println("Here are matching tasks in your list:");
                    for(int i=0; i<info.size(); i++)
                    {
                        if(info.get(i).description.contains(s[1]))
                        {
                           System.out.println(a+". " + info.get(i).toString()); //print out index and info containing keyword
                           a++; //increment index
                        }
                    }
              //  }
            }

            else if(s[0].equals("deadline")) {
                //   try{
                String[] DLarray = s[1].split("/by ");

                Date newDate = new Date();
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");
                    newDate = format.parse(DLarray[1]);
                    Deadline obj = new Deadline(DLarray[0], newDate, DLarray[1]);
                    info.add(obj);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(" " + obj.toString());
                    System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");

                } catch (ParseException e) {
                    System.out.println("Invalid date format!");
                }
            }
            

            else if(s[0].equals("event"))
            {
                String[] Earray = s[1].split("/at ");
                Date newDate = new Date();
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");
                    newDate = format.parse(Earray[1]);
                    Event obj = new Event(Earray[0], newDate, Earray[1]);
                    info.add(obj);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(" " + obj.toString());
                    System.out.println("Now you have " + Integer.toString(Task.getTask()) + " task(s) in the list.");

                } catch (ParseException e) {
                    System.out.println("Invalid date format!");
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
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\Johnt.DESKTOP-H969RCO\\Documents\\GitHub\\duke\\Data\\Duke.txt");
                    BufferedWriter bw = new BufferedWriter(writer);
                    for (int i = 0; i < info.size(); i++) {
                        writer.write(info.get(i).toSave() + "\n");
                    //    System.out.print(info.get(i).toSave() + "\n");
                    }
                    writer.close();
                    System.out.println("Saved to data.txt");
                }
                catch (IOException e)
                {
                    System.out.println("Unable to save.");
                }

                System.out.println("Bye. Hope to see you again soon!");
                end = true;
            }
            else {
                 System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }


}
