package dev.chha.backend.controller;

import dev.chha.backend.dto.IncidentUpdateDto;
import dev.chha.backend.model.Incident;
import dev.chha.backend.model.IncidentUpdate;
import dev.chha.backend.model.User;
import dev.chha.backend.repository.IncidentRepository;
import dev.chha.backend.repository.IncidentUpdateRepository;
import dev.chha.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api")
public class IncidentUpdateController {


    private final IncidentUpdateRepository updateRepo;

    private final IncidentRepository incidentRepo;

    private final UserRepository userRepo;

    public IncidentUpdateController(IncidentUpdateRepository updateRepo, IncidentRepository incidentRepo, UserRepository userRepo) {
        this.updateRepo = updateRepo;
        this.incidentRepo = incidentRepo;
        this.userRepo = userRepo;
    }

    @PostMapping("/newUpdate")
    public ResponseEntity<?> updateIncident(@RequestBody IncidentUpdateDto incidentUpdateDto) {


        IncidentUpdate update =  new IncidentUpdate();

        Optional<Incident> incident = incidentRepo.findById(incidentUpdateDto.getIncidentId());
        Optional<User> user = userRepo.findByUsername(incidentUpdateDto.getUsername());

        if(incident.isEmpty()) {
            return new ResponseEntity<>("THere is no Incident with id" + incidentUpdateDto.getIncidentId(), HttpStatus.NOT_FOUND);
        }
        if(user.isEmpty()) {
            return new ResponseEntity<>("THere is no User with id" + incidentUpdateDto.getUserId(), HttpStatus.NOT_FOUND);
        }


        Incident relatedIncident = incident.get();

        update.setShortDescription(incidentUpdateDto.getShortDescription());
        update.setUpdateText(incidentUpdateDto.getUpdateText());
        update.setIncident(relatedIncident);
        update.setUser(user.get());

        updateRepo.save(update);
        List<IncidentUpdate> updates = updateRepo.findAllByIncident_IdOrderByCreatedAtDesc(update.getIncident().getIncidentId());

        return new ResponseEntity<>(updateList(updates), HttpStatus.CREATED);

    }
    @GetMapping("/allUpdates")
    public ResponseEntity<Iterable<IncidentUpdateDto>> getAllUpdatesBy() {

        Iterable<IncidentUpdate> updates = updateRepo.findAll();

        return new ResponseEntity<>(updateList(updates), HttpStatus.OK);


    }
    @GetMapping("/updates/{incidentId}")
    public ResponseEntity<?> getAllUpdatesByIncident(@PathVariable Long incidentId) {
        List<IncidentUpdate> updates = updateRepo.findAllByIncident_IdOrderByCreatedAtDesc(incidentId);
        return new ResponseEntity<>(updateList(updates), HttpStatus.OK);
    }

    private IncidentUpdateDto getFieldsFromUpdate(IncidentUpdate incidentUpdates) {
        IncidentUpdateDto dto = new IncidentUpdateDto();

        dto.setShortDescription(incidentUpdates.getShortDescription());
        dto.setUpdateText(incidentUpdates.getUpdateText());
        dto.setCreatedAt(incidentUpdates.getCreatedAt());

        if(incidentUpdates.getUser() != null){
            dto.setUserId(incidentUpdates.getUser().getUserId());
            dto.setUsername(incidentUpdates.getUser().getUsername());
        }

        if(incidentUpdates.getIncident() != null){
            dto.setIncidentId(incidentUpdates.getIncident().getIncidentId());
        }
        return dto;
    }
    public Iterable<IncidentUpdateDto> updateList(Iterable<IncidentUpdate> incidentUpdates) {

        return StreamSupport.stream(incidentUpdates.spliterator(), false)
                .map(this::getFieldsFromUpdate)
                .collect(Collectors.toList());


    }



}