package Task_manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Manager {
    private ArrayList<Event> event_list = new ArrayList<>();

    public ArrayList<Event> get_event_list(){
        return event_list;
    }

    public void add_event(String name, String description, int day, int month, int year){
        Calendar date = new GregorianCalendar(year, month - 1, day);
        Event event = new Event(name, date, description);
        event_list.add(event);
    }

    public void delete_event(String name){
        for (Event event : event_list)
            if (event.get_name() == name) {
                event_list.remove(event_list.indexOf(event));
                break;
            }
    }

    public ArrayList<Event> this_day_events(){
        ArrayList<Event> current_events = new ArrayList();
        Calendar current_date = new GregorianCalendar();
        current_date = Calendar.getInstance();
        for (Event event : event_list){
            Calendar event_date = event.get_date();
            if ((current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR)) &&
                    (current_date.get(Calendar.MONTH) == event_date.get(Calendar.MONTH)) &&
                    (current_date.get(Calendar.DAY_OF_MONTH) == event_date.get(Calendar.DAY_OF_MONTH)))
                current_events.add(event);
        }
        return current_events;
    }

    public ArrayList<Event> this_week_events(){
        ArrayList<Event> current_events = new ArrayList();
        Calendar current_date = new GregorianCalendar();
        current_date = Calendar.getInstance();
        for (Event event : event_list){
            Calendar event_date = event.get_date();
            if ((current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR)) &&
                    (current_date.get(Calendar.WEEK_OF_YEAR) == event_date.get(Calendar.WEEK_OF_YEAR)))
                current_events.add(event);
        }
        return current_events;
    }

    public ArrayList<Event> this_month_events(){
        ArrayList<Event> current_events = new ArrayList();
        Calendar current_date = new GregorianCalendar();
        current_date = Calendar.getInstance();
        for (Event event : event_list){
            Calendar event_date = event.get_date();
            if ((current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR)) &&
                    (current_date.get(Calendar.MONTH) == event_date.get(Calendar.MONTH)))
                current_events.add(event);
        }
        return current_events;
    }

    public ArrayList<Event> this_year_events(){
        ArrayList<Event> current_events = new ArrayList();
        Calendar current_date = new GregorianCalendar();
        current_date = Calendar.getInstance();
        for (Event event : event_list){
            Calendar event_date = event.get_date();
            if (current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR))
                current_events.add(event);
        }
        return current_events;
    }
}
