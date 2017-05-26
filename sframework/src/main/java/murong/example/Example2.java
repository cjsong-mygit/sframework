package murong.example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by murong on 2017/5/3.
 */
public class Example2 {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;
    public Example2(String message,Date time){
        this(message,time,null,null);
    }
    public Example2(String message,Date time,Double longitude,Double latitude){
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this,that,"id","time");
    }
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this,"id","time");
    }
}
