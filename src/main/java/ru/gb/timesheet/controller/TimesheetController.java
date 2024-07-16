package ru.gb.timesheet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.timesheet.model.Timesheet;
import ru.gb.timesheet.service.TimesheetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {

    private final TimesheetService service;

    public TimesheetController(TimesheetService service){
        this.service = service;
    }

    // GET - получить - не содержит тела
    // POST - create
    // PUT - изменение
    // PATCH - изменение
    // DELETE - удаление

    // @GetMapping("/timesheets/{id}") // получить конкретную запись по идентификатору
    // @DeleteMapping("/timesheets/{id}") // удалить конкретную запись по идентификатору
    // @PutMapping("/timesheets/{id}") // обновить конкретную запись по идентификатору

//    @GetMapping("/timesheets")
//    public Timesheet get(){
//        Timesheet timesheet = new Timesheet();
//        timesheet.setId(1L);
//        timesheet.setProject("spring");
//        timesheet.setMinutes(200);
//        timesheet.setCreatedAt(LocalDate.now());
//
//        return timesheet;
//    }

//    @GetMapping("/timesheets")
//    public List<Timesheet> get(){
//        Timesheet timesheet1 = new Timesheet();
//        timesheet1.setId(1L);
//        timesheet1.setProject("spring");
//        timesheet1.setMinutes(200);
//        timesheet1.setCreatedAt(LocalDate.now());
//
//        Timesheet timesheet2 = new Timesheet();
//        timesheet2.setId(1L);
//        timesheet2.setProject("spring");
//        timesheet2.setMinutes(200);
//        timesheet2.setCreatedAt(LocalDate.now());
//
//        return List.of(timesheet1,timesheet2);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> get (@PathVariable Long id) {
        Optional<Timesheet> ts = service.getById(id);

        if (ts.isPresent()){
            //return ResponseEntity.ok().body(ts.get());
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Timesheet>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet){
        timesheet = service.create(timesheet);
        if (timesheet == null) return ResponseEntity.badRequest().body(timesheet);
        //Location: /timesheets/sequence
        return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        // 204 no content
        return ResponseEntity.noContent().build();
    }


}
