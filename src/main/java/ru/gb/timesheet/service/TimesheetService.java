package ru.gb.timesheet.service;

import org.springframework.stereotype.Service;
import ru.gb.timesheet.model.Timesheet;
import ru.gb.timesheet.repository.ProjectRepository;
import ru.gb.timesheet.repository.TimesheetRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetService {

    private final TimesheetRepository repository;
    private final ProjectRepository projectRepository;

    public TimesheetService(TimesheetRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    public Optional<Timesheet> getById (Long id) {
        return repository.getById(id);
    }

    public List<Timesheet> getAll(){
        return repository.getAll();
    }

    public Timesheet create(Timesheet timesheet){
        if (projectRepository.getById(timesheet.getProjectId()).isPresent()){
            timesheet.setCreatedAt(LocalDate.now());
            return repository.create(timesheet);
        }
        return null;
    }

    public void delete(Long id){
        repository.delete(id);
    }
}
