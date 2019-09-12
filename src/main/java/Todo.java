/**
 * Todo represents a task without a deadline.
 * Format for todo entry "todo xxx"
 */
public class Todo extends Task {

   // protected String by;

    /**
     * Todo Constructor
     * @param description literally the description of the task
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    /**
     * toSave represents the saving format
     * @return string to save
     */
    public String toSave() {
        return "T|" + super.toSave();
    }

    /**
     * toString represents the string to be printed to the user
     * @return string to be printed by user.
     */
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