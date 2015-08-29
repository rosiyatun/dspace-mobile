package id.ac.ipb.dspacemobileapps.models;

import java.sql.Timestamp;

/**
 * Created by Hanif Affandi Hartanto on 7/17/2015.
 */
public class Event {
    private String id;
    private String name;
    private String description;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    private String eventIdOnDevice;
    private String hasCalendarId;
    private String hasCalendarName;
    private String hasAlarm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public String getEventIdOnDevice() {
        return eventIdOnDevice;
    }

    public void setEventIdOnDevice(String eventIdOnDevice) {
        this.eventIdOnDevice = eventIdOnDevice;
    }

    public String getHasCalendarId() {
        return hasCalendarId;
    }

    public void setHasCalendarId(String hasCalendarId) {
        this.hasCalendarId = hasCalendarId;
    }

    public String getHasCalendarName() {
        return hasCalendarName;
    }

    public void setHasCalendarName(String hasCalendarName) {
        this.hasCalendarName = hasCalendarName;
    }

    public String getHasAlarm() {
        return hasAlarm;
    }

    public void setHasAlarm(String hasAlarm) {
        this.hasAlarm = hasAlarm;
    }
}
