import java.util.Date;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Deadline extends Task {

    protected String by;
    protected Date newDate;

    public Deadline(String description, Date newDate) {
        super(description);
        this.newDate = newDate;
    }

    @Override

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, h:mmaa");
        simpleDateFormat.format(newDate, stringBuffer, new FieldPosition(0));
        return "[D]" + super.toString() + " (by: " + stringBuffer + ")";
    }
    public String toSave() {
        StringBuffer stringBuffer = new StringBuffer();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM YYYY, h:mmaa");
        simpleDateFormat.format(newDate, stringBuffer, new FieldPosition(0));
        return "D|" + super.toSave() + " by:" + stringBuffer;
    }
}