package org.agomez.backend.msvc.agronomic.activities.services;

import org.agomez.backend.msvc.agronomic.activities.client.FarmPlotRestClient;
import org.agomez.backend.msvc.agronomic.activities.models.Activity;
import org.agomez.backend.msvc.agronomic.activities.repositories.ActivityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImplementation implements ActivityService{

    private final ActivityRepository activityRepository;

    private final FarmPlotRestClient farmPlotRestClient;

    public ActivityServiceImplementation(ActivityRepository activityRepository,
                                         FarmPlotRestClient farmPlotRestClient) {
        this.activityRepository = activityRepository;
        this.farmPlotRestClient = farmPlotRestClient;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> list() {
        return (List<Activity>) activityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Activity> findById(Long id) {
        return activityRepository.findById(id);
    }

    @Override
    @Transactional
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        activityRepository.deleteById(id);
        farmPlotRestClient.deleteFarmPlotActivity(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> findAllById(Iterable<Long> ids) {
        return (List<Activity>) activityRepository.findAllById(ids);
    }
}
