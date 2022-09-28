package com.cameraapp.controllers;

import com.cameraapp.model.Camera;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera-api")
public class CameraController {

    @Autowired
    ICameraService iCameraService;

    //http:localhost:8080/camera
    @GetMapping("/cameras")
    public ResponseEntity<List<Camera>> showCamera() {
        List<Camera> cameras =iCameraService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","showing all camera");
        ResponseEntity<List<Camera>> responseEntity = new ResponseEntity<>(cameras,headers,HttpStatus.OK);
        return  responseEntity  ;
    }

    //http:localhost:8080/camera/price/300
    @GetMapping("/cameras/price/{price}")
    public ResponseEntity<List<Camera>> showByPrice(@PathVariable("price") double price) {
        List<Camera> cameras = iCameraService.getByPrice(price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by price"+price);
        ResponseEntity<List<Camera>> responseEntity = new ResponseEntity<>(cameras,headers, HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping("/cameras/lensType/{lensType}")
    public ResponseEntity<List<Camera>> showByLensType(@PathVariable("lensType") String lensType) {
        List<Camera> cameras = iCameraService.getByLensType(lensType);
        HttpHeaders headers = new HttpHeaders();
       headers.add("desc","getting By LensType"+lensType);
       ResponseEntity<List<Camera>> responseEntity = new ResponseEntity<>(cameras,headers,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/cameras/brand/{brand}/price/{price}")
    public ResponseEntity<List<Camera>> showByByBrandAndPrice(@PathVariable("brand")String brand,@PathVariable("price")double price){
        List<Camera> cameras = iCameraService.getByBrandAndPrice(brand,price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting By brand"+brand+"price"+price);
        ResponseEntity<List<Camera>> responseEntity = new ResponseEntity<>(cameras,headers,HttpStatus.OK);
        return responseEntity;
    }
@GetMapping("/cameras/cameraType/{cameraType}")
    public ResponseEntity<List<Camera>> showByCameraType(@PathVariable("cameraType")String cameraType){
        List<Camera> cameras = iCameraService.getByCameraType(cameraType);
        HttpHeaders headers = new HttpHeaders();
    headers.add("desc","getting By cameraType"+cameraType);
    ResponseEntity<List<Camera>> responseEntity = new ResponseEntity<>(cameras,headers,HttpStatus.OK);
    return responseEntity;
}
@PostMapping("/cameras")
    public ResponseEntity<Void>addCamera(@RequestBody Camera camera){
        iCameraService.addCamera(camera);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}
@PutMapping("/cameras")
public  ResponseEntity<Void> updateCamera(@RequestBody Camera camera){
        iCameraService.updateCamera(camera);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
}
@DeleteMapping("/cameras/cameraId/{cameraId}")
    public ResponseEntity<Object> deleteCamera(@PathVariable("cameraId")int cameraId){
        iCameraService.deleteCamera(cameraId);
    HttpHeaders headers = new HttpHeaders();
    headers.add("desc", "deleted using id");
    return ResponseEntity.status(HttpStatus.OK).build();
}
}
