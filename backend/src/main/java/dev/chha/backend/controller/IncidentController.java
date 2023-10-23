package dev.chha.backend.controller;

import dev.chha.backend.dto.IncidentDto;
import dev.chha.backend.dto.IncidentResponseDto;
import dev.chha.backend.model.IncidentCategory;
import dev.chha.backend.model.IncidentSeverity;
import dev.chha.backend.model.User;
import dev.chha.backend.repository.IncidentCategoryRepository;
import dev.chha.backend.repository.IncidentRepository;
import dev.chha.backend.model.Incident;
import dev.chha.backend.repository.IncidentSeverityRepository;
import dev.chha.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/incident")
public class IncidentController {

    private final IncidentRepository incidentRepo;

    private final UserRepository userRepo;

    private final IncidentCategoryRepository catRepo;

    private final IncidentSeverityRepository sevRepo;

    public IncidentController(IncidentRepository incidentRepo, UserRepository userRepo, IncidentCategoryRepository catRepo, IncidentSeverityRepository sevRepo) {
        this.incidentRepo = incidentRepo;
        this.userRepo = userRepo;
        this.catRepo = catRepo;
        this.sevRepo = sevRepo;
    }

    @GetMapping("/{incidentId}")
    public ResponseEntity<?> getIncident(@PathVariable Long incidentId) {

        Optional<Incident> incidentOpt = incidentRepo.findById(incidentId);

        if(incidentOpt.isEmpty()) {
            return new ResponseEntity<>("No Incident found", HttpStatus.NOT_FOUND);
        }
        Incident incident = incidentOpt.get();

        IncidentResponseDto responseIncidentDto = getFieldsFromIncident(incident);


        return new ResponseEntity<>(responseIncidentDto, HttpStatus.OK);

    }

    @CrossOrigin(origins = "http://localhost:80")
    @DeleteMapping("/{incidentId}")
    public void delete(@PathVariable Long incidentId) {

        Optional<Incident> incident = incidentRepo.findById(incidentId);


        if (incident.isPresent()) {
            incidentRepo.deleteById(incidentId);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<IncidentResponseDto>> getAll(){

        Iterable<Incident> newIncident = incidentRepo.findAll();

        return new ResponseEntity<>(incidentList(newIncident), HttpStatus.OK);

    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){

        Iterable<IncidentCategory> categories = catRepo.findAll();

        return new ResponseEntity<>( categories, HttpStatus.OK);
    }

    @GetMapping("/severities")
    public ResponseEntity<?> getSeverities() {

        Iterable<IncidentSeverity> severities = sevRepo.findAll();

        return new ResponseEntity<>(severities, HttpStatus.OK);

    }

    @PostMapping("/report")
    @Transactional
    public ResponseEntity<?> createIncident(@RequestBody IncidentDto incidentDto) {


        Optional<User> user = userRepo.findById(incidentDto.getUser_id());


        if(user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Optional<IncidentCategory> cat = catRepo.findById(incidentDto.getCategory());
        if(cat.isEmpty()) {
            return new ResponseEntity<>("Wrong category", HttpStatus.NOT_FOUND);
        }

        Optional<IncidentSeverity> sev = sevRepo.findById(incidentDto.getSeverity());
        if(sev.isEmpty()) {
            return new ResponseEntity<>("Wrong severity", HttpStatus.NOT_FOUND);
        }

        Incident newIncident = new Incident();

        newIncident.setUser(user.get());
        newIncident.setTitel(incidentDto.getTitel());
        newIncident.setDescription(incidentDto.getDescription());
        newIncident.setReportdate(incidentDto.getReportdate());
        newIncident.setSolved(incidentDto.isSolved());
        newIncident.setCategory(cat.get());
        newIncident.setSeverity(sev.get());


        incidentRepo.save(newIncident);

        return new ResponseEntity<>(newIncident, HttpStatus.CREATED);

    }

    @CrossOrigin(origins = "http://frontend:80/api")
    @PatchMapping("/{incidentId}")
    public ResponseEntity<?> setSolved(@PathVariable Long incidentId){

        Optional<Incident> incidentOpt = incidentRepo.findById(incidentId);

        if (incidentOpt.isPresent()) {
            Incident incident = incidentOpt.get();
            incident.setSolved(true);
            return new ResponseEntity<>(incidentRepo.save(incident), HttpStatus.OK);
        }

        return new ResponseEntity<>("Incident not found", HttpStatus.NOT_FOUND);

    }

    private IncidentResponseDto getFieldsFromIncident(Incident incident) {
        IncidentResponseDto dto = new IncidentResponseDto();

        Optional<User> userOpt = userRepo.findById(incident.getUser().getUserId());

        dto.setIncidentId(incident.getIncidentId());
        dto.setTitle(incident.getTitel());
        dto.setDescription(incident.getDescription());
        dto.setReportdate(incident.getReportdate());
        dto.setCategoryName(incident.getCategory().getCategoryName());
        dto.setSeverityName(incident.getSeverity().getSeverityName());
        dto.setSeverity(incident.getSeverity().getSeverityId());
        dto.setSolved(incident.isSolved());
        dto.setAssignedUser(userOpt.get().getUsername());

        return dto;
    }

    public List<IncidentResponseDto> incidentList(Iterable<Incident> incidents) {

        return StreamSupport.stream(incidents.spliterator(), false)
                .map(this::getFieldsFromIncident)
                .collect(Collectors.toList());
    }

}