package com.example.backend.controller;

import com.example.backend.entity.Complaint;
import com.example.backend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints") // The base resource path
@CrossOrigin
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // POST /api/complaints - Creates a new complaint
    @PostMapping // No more "/add"
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintService.createComplaint(complaint);
    }

    // GET /api/complaints - Gets all complaints
    @GetMapping // No more "/getAll"
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    // GET /api/complaints/{id} - Gets a single complaint by its ID
    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    // PUT /api/complaints/{id} - Updates an existing complaint
    @PutMapping("/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestBody Complaint complaint) {
        return complaintService.updateComplaint(id, complaint);
    }

    // DELETE /api/complaints/{id} - Deletes a complaint
    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}