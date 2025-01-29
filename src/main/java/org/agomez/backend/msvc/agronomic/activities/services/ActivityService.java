package org.agomez.backend.msvc.agronomic.activities.services;

import org.agomez.backend.msvc.agronomic.activities.models.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    List<Activity> list();
    Optional<Activity> findById(Long id);
    Activity save(Activity activity);
    void deleteById(Long id);
    List<Activity> findAllById(Iterable <Long> ids);
}
