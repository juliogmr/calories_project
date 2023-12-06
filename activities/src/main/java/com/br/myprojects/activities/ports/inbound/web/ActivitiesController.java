package com.br.myprojects.activities.ports.inbound.web;

import com.br.myprojects.activities.application.dto.ActivityDTO;
import com.br.myprojects.activities.ports.inbound.ActivityPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activities")
class ActivitiesController {

    private final ActivityPortIn activityPortIn;

    @GetMapping("/all")
    public ResponseEntity<List<ActivityDTO>> getAll(){
        return new ResponseEntity<>(activityPortIn.getActivities(), HttpStatus.OK);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<ActivityDTO> getByName(@PathVariable("name") String name){
        return new ResponseEntity<>(activityPortIn.getActivity(name), HttpStatus.OK);
    }
}
