package com.cameraapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Camera {
    @Id
    @GeneratedValue(generator = "camera_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "camera_gen",sequenceName = "camera_sequence",initialValue = 1,allocationSize = 1)
    private Integer cameraId;
    @Column(length = 30)
    private String model;
    @Column(length = 30)
    private String cameraType;
    @Column(length = 30)
    private  String lensType;
    private  double price;
    @Column(length = 30)
    private String brand;
}
