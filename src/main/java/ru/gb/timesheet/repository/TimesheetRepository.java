package ru.gb.timesheet.repository;

import org.springframework.stereotype.Repository;
import ru.gb.timesheet.model.Timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository //Работает с базой данных
public class TimesheetRepository {

    private static Long sequence = 1L;
    private final List<Timesheet> timesheets = new ArrayList<>();

    public Optional<Timesheet> getById (Long id) {
         return timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public List<Timesheet> getAll(){
        return List.copyOf(timesheets);
    }

    public Timesheet create(Timesheet timesheet){
        timesheet.setId(sequence++);
        timesheets.add(timesheet);

        //Location: /timesheets/sequence
        return timesheet;
    }

    public void delete(Long id){
        timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .ifPresent(timesheets::remove);
    }
}
