package org.agomez.backend.msvc.agronomic.activities.models;

import jakarta.persistence.*;


@Entity
@Table(name = "agronomic_inputs")
public class AgronomicInputs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double quantity;

    private String unit;


}
