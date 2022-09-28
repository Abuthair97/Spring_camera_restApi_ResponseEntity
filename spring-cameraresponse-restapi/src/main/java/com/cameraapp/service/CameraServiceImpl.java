package com.cameraapp.service;

import com.cameraapp.exception.CameraNotFoundException;
import com.cameraapp.model.Camera;
import com.cameraapp.model.CameraType;
import com.cameraapp.model.LensType;
import com.cameraapp.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CameraServiceImpl implements ICameraService{
    @Autowired
    ICameraRepository iCameraRepository;
    @Override
    public void addCamera(Camera camera) {
        iCameraRepository.save(camera);

    }

    @Override
    public void updateCamera(Camera camera) {
    iCameraRepository.save(camera);
    }

    @Override
    public void deleteCamera(int cameraId) {
     iCameraRepository.deleteById(cameraId);
    }

    @Override
    public Camera getById(int cameraId) {
       Camera camera= iCameraRepository.findById(cameraId).get();
       if(camera==null)
           throw new CameraNotFoundException("Id not Found");
       return camera;
    }

    @Override
    public List<Camera> getAll() {
        return iCameraRepository.findAll();
    }

    @Override
    public List<Camera> getByBrandAndPrice(String brand, double price) {

       List<Camera> cameras = iCameraRepository.findByBrandAndPriceLessThan(brand, price);
        if (cameras.isEmpty()){
            throw  new CameraNotFoundException("Camera Not Found");
        }return  cameras;
    }

    @Override
    public List<Camera> getByLensType(String lensType) {
        List<Camera> cameras = iCameraRepository.findByLensType(lensType);
        if (cameras.isEmpty()){
            throw  new CameraNotFoundException("Camera Not Found");
        }return  cameras;
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) {
       List<Camera> cameras = iCameraRepository.findByCameraType(cameraType);
        if (cameras.isEmpty()){
            throw  new CameraNotFoundException("Camera Not Found");
        }return  cameras;
    }

    @Override
    public List<Camera> getByPrice(double price) {
        List<Camera> cameras =iCameraRepository.findByPriceLessThan(price);
        if (cameras.isEmpty()){
            throw  new CameraNotFoundException("Camera Not Found");
        }return  cameras;
    }



}
