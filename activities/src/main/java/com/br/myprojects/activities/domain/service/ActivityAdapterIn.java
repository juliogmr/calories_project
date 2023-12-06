package com.br.myprojects.activities.domain.service;

import com.br.myprojects.activities.application.dto.ActivityDTO;
import com.br.myprojects.activities.domain.entity.Activities;
import com.br.myprojects.activities.infraestructure.persistence.ActivityRepository;
import com.br.myprojects.activities.ports.inbound.ActivityPortIn;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityAdapterIn implements ActivityPortIn {

    private final ActivityRepository repository;

    private final ModelMapper mapper;

    private final ObjectMapper objectMapper;

    @Override
    public ActivityDTO createActivity(ActivityDTO exercicios) {
        var optionalActivity = repository.save(mapper.map(exercicios, Activities.class));
        return  mapper.map(optionalActivity, ActivityDTO.class);
    }

    @Override
    public ActivityDTO getActivity(String name) {
        return repository.findByNome(name)
                .map(entity -> mapper.map(entity, ActivityDTO.class))
                .orElse(null);
    }

    @Override
    public List<ActivityDTO> getActivities() {
            return repository.findAll().stream()
                    .map(activities -> objectMapper.convertValue(activities, ActivityDTO.class))
                    .toList();
    }
}
