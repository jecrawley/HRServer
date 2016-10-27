package crawley.james.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import crawley.james.spring.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by jamescrawley on 10/26/16.
 */

@Entity
@Table(name="timecards")
public class TimeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startTime;
    private String endTime;
    private Date date;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public TimeCard (String startTime, String endTime, String date) throws ParseException {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = format.parse(date);
    }

    TimeCard () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    @JsonIgnore
    public String getDateAsShort(){
        return format.format(date);
    }

    public String toString(){
        StringBuilder value = new StringBuilder("{");
        value.append("\"id\": ");
        value.append("\"" + id + "\"");
        value.append(",\"startTime\": ");
        value.append("\"" + startTime + "\"");
        value.append(",\"endTime\": ");
        value.append("\"" + endTime + "\"");
        value.append(",\"date\": ");
        value.append("\"" + format.format(date) + "\"");
        value.append("},");
        return value.toString();
    }

}
