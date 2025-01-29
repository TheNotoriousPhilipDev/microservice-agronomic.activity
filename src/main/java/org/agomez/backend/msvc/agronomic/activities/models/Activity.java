package org.agomez.backend.msvc.agronomic.activities.models;

import jakarta.persistence.*;
import org.agomez.backend.msvc.agronomic.activities.utils.ActivityType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String name;

    @Column(name = "activity_duration")
    private double activityDuration;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type", nullable = false)
    private ActivityType activityType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "activity_id")
    private List<AgronomicInputs> agronomicInputsList;


    public Activity() {
        this.agronomicInputsList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getActivityDuration() {
        return activityDuration;
    }

    public void setActivityDuration(double activityDuration) {
        this.activityDuration = activityDuration;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public List<AgronomicInputs> getAgronomicInputsList() {
        return agronomicInputsList;
    }

    public void setAgronomicInputsList(List<AgronomicInputs> agronomicInputsList) {
        this.agronomicInputsList = agronomicInputsList;
    }
}
