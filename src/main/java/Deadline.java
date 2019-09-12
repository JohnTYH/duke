import java.util.Date;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Deadline represents a task with a deadline.
 * Format for deadline entry "deadline xxx /by dd/MM/yyyy hhmm"
 *
 */

public class Deadline extends Task {

    protected String by;
    protected Date newDate;
    /**
     * Deadline object constructor
     * @param by the deadline date
     * @param description the name of the task due
     * @param newDate the reformatted date.
     */
    public Deadline(String description, Date newDate, String by) {
        super(description);
        this.newDate = newDate;
        this.by = by;
    }

    @Override
/**
 * toString represents the string to be printed to the user
 * @return string to be printed by user.
 */

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, h:mmaa");
        simpleDateFormat.format(newDate, stringBuffer, new FieldPosition(0));
        return "[D]" + super.toString() + " (by: " + stringBuffer + ")";
    }

    /**
     * toSave represents the saving format
     * @return string to save
     */
    public String toSave() {

        return "D|" + super.toSave() + " by: " + by;
    }
}