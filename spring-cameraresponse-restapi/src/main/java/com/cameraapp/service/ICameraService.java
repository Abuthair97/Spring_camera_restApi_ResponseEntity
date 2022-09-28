package com.cameraapp.service;

import com.cameraapp.exception.CameraNotFoundException;
import com.cameraapp.model.Camera;
import com.cameraapp.model.CameraType;
import com.cameraapp.model.LensType;

import java.util.List;

public interface ICameraService {
    public void addCamera(Camera camera);
    public  void updateCamera(Camera camera);
    public void deleteCamera(int cameraId);
    Camera getById(int cameraId)throws  CameraNotFoundException;

    List<Camera> getAll();
    List<Camera> getByBrandAndPrice(String brand,double price)throws CameraNotFoundException;
    List<Camera> getByLensType(String lensType)throws  CameraNotFoundException;
    List<Camera> getByCameraType(String cameraType) throws  CameraNotFoundException;
    List<Camera> getByPrice(double price)throws CameraNotFoundException;
}
