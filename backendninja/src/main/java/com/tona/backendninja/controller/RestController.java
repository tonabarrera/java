package com.tona.backendninja.controller;

import com.tona.backendninja.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tona created on 17/03/2018 for backendninja.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @GetMapping("/check")
    public ResponseEntity<ContactModel> checkRest() {
        ContactModel cm = new ContactModel(1, "MOY", "MOY","MOY", "77790666");
        return new ResponseEntity<>(cm, HttpStatus.OK);
    }
}
