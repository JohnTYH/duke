public class Task {
    protected String description;
    protected boolean isDone;
    private static int TotalTask = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        TotalTask++;
    }

    public String getStatusIcon() {
         return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String printIcon()
    {
        return "[" + this.getStatusIcon() + "] ";
    }
    public String printer()
    {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public static int getTask()
    {
        return TotalTask;
    }

    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public void markAsDone()
    {
        this.isDone = true;
    }
    public String toSave()
    {
        if( isDone)
            return "1|" + this.description;
        else
            return "0|" + this.description;
    }
}