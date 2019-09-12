import java.util.Date;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Deadline represents a task with a deadline.
 * Format for event entry "event xxx /at dd/MM/yyyy hhmm"
 */
public class Event extends Task {

    protected String at;
    protected Date newDate;

    /**
     * Event object constructor
     * @param at the event date
     * @param description the name of the event
     * @param newDate the reformatted date.
     */

    public Event(String description, Date newDate, String at) {
        super(description);
        this.newDate = newDate;
        this.at = at;
    }

    @Override
    /**
     * toSave represents the saving format
     * @return string to save
     */
    public String toSave() {

        return "E|" + super.toSave() + " at: " + at;
    }

    /**
     * toString represents the string to be printed to the user
     * @return string to be printed by user.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, h:mmaa");
        simpleDateFormat.format(newDate, stringBuffer, new FieldPosition(0));
        return "[E]" + super.toString() + " (at: " + stringBuffer + ")";
    }


}