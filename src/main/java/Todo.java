public class Todo extends Task {

   // protected String by;

    public Todo(String description) {
        super(description);
    }

    @Override

    public String toSave() {
        return "T|" + super.toSave();
    }

    public String toString() {
        return "[T]" + super.toString();
    }


   /* public String printer()
    {
        String s1 = "Got it. I've added this task:";
        String s2 = " [T]" + Task.getStatusIcon() + toString();
        String s3 = "Now you have " + Integer.toString(Task.getTask) + " tasks in the list"

    }*/

}