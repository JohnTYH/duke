import java.util.Date;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Event extends Task {

    protected String at;
    protected Date newDate;

    public Event(String description, Date newDate) {
        super(description);
        this.newDate = newDate;
    }

    @Override
    public String toSave() {
        StringBuffer stringBuffer = new StringBuffer();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, h:mmaa");
        simpleDateFormat.format(newDate, stringBuffer, new FieldPosition(0));
        return "E|" + super.toSave() + " at:" + stringBuffer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, h:mmaa");
        simpleDateFormat.format(newDate, stringBuffer, new FieldPosition(0));
        return "[E]" + super.toString() + " (at: " + stringBuffer + ")";
    }


}