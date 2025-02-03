package vttp.batch5.paf.day27.models;

import java.util.Date;

public class Event {
    private String id;
    private Date timestamp;
    private String operation;
    private String tableName;
    private String fields;

    public String toJSON() {
        return "";
    }
}
