public class Task {
    protected String description;
    protected boolean isDone;
    private static int TotalTask = 0;

    /**
     * Task Constructor
     * @param description which represents the task to be done
     * is.Done represents whether the task is done or not. If the task is added it will not be done. Thus set isDone to false
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        TotalTask++;
    }

    /**
     * getStatusIcon will return whether the task is done or not through a tick or a cross
     * @return tick or cross.
     */
    public String getStatusIcon() {
         return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String printIcon()
    {
        return "[" + this.getStatusIcon() + "] ";
    }

    /**
     * printer prints the box and tick icon followed by the task name
     * @return tick or cross in a box followed by the task.
     */
    public String printer()
    {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * getTask gets the total number of task inside the loop
     * @return total number of task
     */
    public static int getTask()
    {
        return TotalTask;
    }

    /**
     * toString represents the string to be printed to the user
     * @return string to be printed by user.
     */
    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * marks as done changes isDone to true.
     * This will cause getStatusIcon() to return a different symbol
     */
    public void markAsDone()
    {
        this.isDone = true;
    }

    /**
     * toSave represents the saving format
     * @return string to save
     */
    public String toSave()
    {
        if(isDone)
            return "1|" + this.description;
        else
            return "0|" + this.description;
    }
}