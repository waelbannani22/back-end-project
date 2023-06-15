package com.stage.backend.controller;

import com.stage.backend.entity.ActeOptique;
import com.stage.backend.repository.ActeOptiqueRepository;
import com.stage.backend.service.ActeOptiqueService;
import jakarta.websocket.server.PathParam;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/acte-optique")
@CrossOrigin("*")
public class ActeOptiqueController {

    @Autowired
    private  ActeOptiqueService acteOptiqueService;
    @Autowired
    private ActeOptiqueRepository acteOptiqueRepository;
    @Autowired
    ActeOptique acteOptique;

    // add
    @PostMapping(value = "/add-acte",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addActe(@RequestBody @NonNull ActeOptique acteOptique){

        acteOptiqueService.addActe(acteOptique);
        HashMap<String, Object > map2 = new HashMap<>();
        map2.put("success",true);
        map2.put("acte",acteOptique);

        return ResponseEntity
                .status(200)
                .body(map2);
    }

    // update
    @PutMapping(value = "/update-acte/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> updateActe(@PathVariable("id")Long id,@RequestBody ActeOptique acteOptique){
        ActeOptique acteOptique1=acteOptiqueService.updateActe(id,acteOptique);
        if(acteOptique1.getId() == null){
            HashMap<String, Object > map2 = new HashMap<>();
            map2.put("success",false);
            map2.put("acte",null);

            return ResponseEntity
                    .status(500)
                    .body(map2);
        }else{
            HashMap<String, Object > map2 = new HashMap<>();
            map2.put("success",true);
            map2.put("acte",acteOptique1);

            return ResponseEntity
                    .status(200)
                    .body(map2);
        }
    }
    //get all
    @GetMapping(value = "/get-allActes",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActes(){

        HashMap<String, Object > map2 = new HashMap<>();
        map2.put("success",true);
        map2.put("actes",acteOptiqueService.getAllActes());

        return ResponseEntity
                .status(200)
                .body(acteOptiqueService.getAllActes());
    }
    @DeleteMapping(value = "/deleteActe/{id}")
    public ResponseEntity<?> deleteActe(@PathVariable("id") Long id){
        acteOptiqueService.deleteActe(id);
        HashMap<String, Object > map2 = new HashMap<>();
        map2.put("success",true);


        return ResponseEntity
                .status(200)
                .body(map2);
    }
    @PutMapping("/updateActe/{id}")
    public ResponseEntity<?> updateResource(@PathVariable("id") Long id, @RequestBody Map<String, Object> updatedProperties) {
        Optional<ActeOptique> existing = acteOptiqueRepository.findById(id);

        if (existing.isPresent()) {
            ActeOptique acteOptique = existing.get();

            for (Map.Entry<String, Object> entry : updatedProperties.entrySet()) {
                String propertyName = entry.getKey();
                Object propertyValue = entry.getValue();

                // Update the property if it exists in ActeOptique
                if (isPropertyValid(propertyName)) {
                    setProperty(acteOptique, propertyName, propertyValue);
                }
            }

            // Save the updated ActeOptique entity
            acteOptiqueRepository.save(acteOptique);

            // Perform any additional logic or validations if needed

            // Return an appropriate response
            HashMap<String, Object > map2 = new HashMap<>();
            map2.put("success",true);
            map2.put("acte",acteOptique);

            return ResponseEntity
                    .status(200)
                    .body(map2);
        }

        return ResponseEntity.notFound().build();
    }

    // Check if the property is valid in ActeOptique
    private boolean isPropertyValid(String propertyName) {
        // Implement your logic to validate the property
        // For example, check if propertyName exists in ActeOptique or if it's allowed to be updated
        return true;
    }

    // Set the property value using reflection
    private void setProperty(ActeOptique acteOptique, String propertyName, Object propertyValue) {
        try {
            // Use reflection to set the property value
            Field field = acteOptique.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(acteOptique, propertyValue);
        } catch (Exception e) {
            // Handle any exceptions that occur during the reflection process
            e.printStackTrace();
        }
    }


}
