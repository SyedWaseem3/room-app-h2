package com.geekster.Room.APP.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OYO")
public class Room {

    @Id
    private Integer roomId;
    private Integer roomNumber;
    @Enumerated(EnumType.STRING)
    private Type roomType;
    private double roomPrice;
    @Column(name = "Available")
    private boolean roomAvailable;
}
