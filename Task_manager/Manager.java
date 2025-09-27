package Task_manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Manager {
    private ArrayList<Event> EVENT_LIST = new ArrayList<>();

    public ArrayList<Event> getEVENT_LIST() {
        return new ArrayList<>(EVENT_LIST); // Возвращаем копию для избежания неконтролируемого изменения
    }

    public void addEvent(String name, String description, int day, int month, int year) {
        // Проверка параметров
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название события не может быть пустым");
        }
        if (description == null) {
            description = "";
        }

        // Проверка корректности даты
        if (year < 1) {
            throw new IllegalArgumentException("Год должен быть положительным числом");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Месяц должен быть от 1 до 12");
        }

        Calendar tempCalendar = new GregorianCalendar(year, month - 1, 1);
        int maxDays = tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day < 1 || day > maxDays) {
            throw new IllegalArgumentException("День должен быть от 1 до " + maxDays + " для указанного месяца и года");
        }

        Calendar date = new GregorianCalendar(year, month - 1, day);
        // Проверка, чтобы дата не была в прошлом
        Calendar today = new GregorianCalendar();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        if (date.before(today)) {
            throw new IllegalArgumentException("Нельзя добавлять события с прошедшей датой");
        }

        Event event = new Event(name, date, description);
        EVENT_LIST.add(event);
    }

    public void deleteEvent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название события не может быть пустым");
        }

        boolean found = false;
        for (int i = 0; i < EVENT_LIST.size(); i++) {
            Event event = EVENT_LIST.get(i);
            if (event.getNAME().equals(name.trim())) {
                EVENT_LIST.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Событие с названием '" + name + "' не найдено");
        }
    }

    public ArrayList<Event> thisDayEvents() {
        ArrayList<Event> current_events = new ArrayList<>();
        Calendar current_date = Calendar.getInstance();

        for (Event event : EVENT_LIST) {
            Calendar event_date = event.getDATE();
            if (event_date != null &&
                    current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR) &&
                    current_date.get(Calendar.MONTH) == event_date.get(Calendar.MONTH) &&
                    current_date.get(Calendar.DAY_OF_MONTH) == event_date.get(Calendar.DAY_OF_MONTH)) {
                current_events.add(event);
            }
        }
        return current_events;
    }

    public ArrayList<Event> thisWeekEvents() {
        ArrayList<Event> current_events = new ArrayList<>();
        Calendar current_date = Calendar.getInstance();

        for (Event event : EVENT_LIST) {
            Calendar event_date = event.getDATE();
            if (event_date != null &&
                    current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR) &&
                    current_date.get(Calendar.WEEK_OF_YEAR) == event_date.get(Calendar.WEEK_OF_YEAR)) {
                current_events.add(event);
            }
        }
        return current_events;
    }

    public ArrayList<Event> thisMonthEvents() {
        ArrayList<Event> current_events = new ArrayList<>();
        Calendar current_date = Calendar.getInstance();

        for (Event event : EVENT_LIST) {
            Calendar event_date = event.getDATE();
            if (event_date != null &&
                    current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR) &&
                    current_date.get(Calendar.MONTH) == event_date.get(Calendar.MONTH)) {
                current_events.add(event);
            }
        }
        return current_events;
    }

    public ArrayList<Event> thisYearEvents() {
        ArrayList<Event> current_events = new ArrayList<>();
        Calendar current_date = Calendar.getInstance();

        for (Event event : EVENT_LIST) {
            Calendar event_date = event.getDATE();
            if (event_date != null &&
                    current_date.get(Calendar.YEAR) == event_date.get(Calendar.YEAR)) {
                current_events.add(event);
            }
        }
        return current_events;
    }
}
