package Task_manager;

import java.util.Calendar;

public class Event {
     private final String NAME;
     private final Calendar DATE;
     private final String DESCRIPTION;

     public Calendar getDATE() {
          return DATE;
     }

     public String getNAME() {
          return NAME;
     }

     public String getDESCRIPTION() {
          return DESCRIPTION;
     }

     public Event(String name, Calendar date, String description) {
          // Проверка входных параметров
          if (name == null || name.trim().isEmpty()) {
               throw new IllegalArgumentException("Название события не может быть пустым");
          }
          if (date == null) {
               throw new IllegalArgumentException("Дата события не может быть null");
          }
          if (description == null) {
               description = "";
          }

          this.NAME = name.trim();
          this.DATE = date;
          this.DESCRIPTION = description.trim();
     }
}
