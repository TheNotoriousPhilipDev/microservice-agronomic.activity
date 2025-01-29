package org.agomez.backend.msvc.agronomic.activities.controllers;

import org.agomez.backend.msvc.agronomic.activities.models.Activity;
import org.agomez.backend.msvc.agronomic.activities.models.AgronomicInputs;
import org.agomez.backend.msvc.agronomic.activities.services.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getActivities() {
        return activityService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivity(@PathVariable Long id) {
        Optional<Activity> optionalActivity = activityService.findById(id);
        if (optionalActivity.isPresent()) {
            return ResponseEntity.ok(optionalActivity.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createActivity(@RequestBody Activity activity) {
        if (activity.getDate() == null) {
            activity.setDate(new Date());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.save(activity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        Optional<Activity> optionalActivity = activityService.findById(id);
        if (optionalActivity.isPresent()) {
            Activity activityToUpdate = optionalActivity.get();
            if (activity.getDate() != null) {
                activityToUpdate.setDate(activity.getDate());
            }
            activityToUpdate.setDate(new Date());
            activityToUpdate.setName(activity.getName());
            activityToUpdate.setActivityDuration(activity.getActivityDuration());
            activityToUpdate.setActivityType(activity.getActivityType());

            List<AgronomicInputs> updatedInputs = activity.getAgronomicInputsList();
            if (updatedInputs != null) {
                activityToUpdate.getAgronomicInputsList().clear();

                for (AgronomicInputs input : updatedInputs) {
                    activityToUpdate.getAgronomicInputsList().add(input);
                }
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(activityService.save(activityToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long id) {
        Optional<Activity> optionalActivity = activityService.findById(id);
        if (optionalActivity.isPresent()) {
            activityService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-farm-plot")
    public ResponseEntity<?> getActivitiesByFarmPlots(@RequestParam Iterable<Long> ids) {
        return ResponseEntity.ok(activityService.findAllById(ids));
    }

}
