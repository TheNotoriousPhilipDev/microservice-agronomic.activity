package org.agomez.backend.msvc.agronomic.activities.repositories;

import org.agomez.backend.msvc.agronomic.activities.models.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
