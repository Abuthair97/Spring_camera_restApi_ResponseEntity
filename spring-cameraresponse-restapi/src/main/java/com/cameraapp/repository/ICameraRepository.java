package com.cameraapp.repository;

import com.cameraapp.model.Camera;
import com.cameraapp.model.CameraType;
import com.cameraapp.model.LensType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICameraRepository extends JpaRepository<Camera,Integer> {
    List<Camera> findByBrandAndPriceLessThan(String brand, double price);
    List<Camera> findByLensType(String lensType);
    List<Camera> findByCameraType(String cameraType);
    List<Camera> findByPriceLessThan(double price);
}

