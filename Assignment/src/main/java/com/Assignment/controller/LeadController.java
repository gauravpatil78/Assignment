package com.Assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.Assignment.Status.ApiError;
import com.Assignment.Status.ErrorResponse;
import com.Assignment.Status.SuccessResponse;
import com.Assignment.entity.Lead;
import com.Assignment.service.LeadService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/leads")
@Validated
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public ResponseEntity<?> createLead(@Valid @RequestBody Lead lead) {
        if (leadService.isLeadIdExists(lead.getLeadId())) {
            // Return error response if leadId already exists
            ErrorResponse errorResponse = new ErrorResponse("E10010", "Lead Already Exists in the database with the lead id");
            return new ResponseEntity<>(new ApiError("error", errorResponse), HttpStatus.BAD_REQUEST);
        }

        leadService.saveLead(lead);
        SuccessResponse successResponse = new SuccessResponse("success", "Created Leads Successfully");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/byMobileNumber/{mobileNumber}")
    public ResponseEntity<Object> getLeadsByMobileNumber(@PathVariable String mobileNumber) {
        List<Lead> leads = leadService.getLeadsByMobileNumber(mobileNumber);

        if (leads.isEmpty()) {
            // Return a response with a proper message if no leads are found
            ErrorResponse errorResponse = new ErrorResponse("E10020", "No leads found with the given mobile number");
            return new ResponseEntity<>(new ApiError("error", errorResponse), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(leads, HttpStatus.OK);
            
            
        }
    }
}
