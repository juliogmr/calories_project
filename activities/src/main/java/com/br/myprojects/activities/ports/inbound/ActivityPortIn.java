package com.br.myprojects.activities.ports.inbound;

import com.br.myprojects.activities.application.dto.ActivityDTO;

import java.util.List;

public interface ActivityPortIn {

    public ActivityDTO createActivity(ActivityDTO exercicios);

    public ActivityDTO getActivity(String name);

    public List<ActivityDTO> getActivities();
}
