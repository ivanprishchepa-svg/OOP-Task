package Task_manager;

import java.util.Calendar;

public class Event {
     private String name;
     private Calendar date;
     private String description;

     public Calendar get_date(){
          return date;
     }

     public String get_name(){
          return name;
     }
     public String get_description(){
          return description;
     }

     public Event(String name, Calendar date, String description){
          this.name = name;
          this.date = date;
          this.description = description;
     }
}
