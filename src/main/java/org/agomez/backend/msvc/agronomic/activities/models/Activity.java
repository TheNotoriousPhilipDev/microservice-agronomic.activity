package org.agomez.backend.msvc.agronomic.activities.models;

import jakarta.persistence.*;
import org.agomez.backend.msvc.agronomic.activities.utils.ActivityType;

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



}
