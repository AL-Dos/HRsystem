package com.hrs.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.DTOs.PDSFullDTO;
import com.hrs.backend.Services.PDSProfileService;

import lombok.RequiredArgsConstructor;

import javax.naming.NameNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/persons-profile")
@RequiredArgsConstructor
public class ProfileController {
    private final PDSProfileService profileService;

    @GetMapping("/{id}")
    public PDSFullDTO getFullProfile(@PathVariable Integer personId) throws NameNotFoundException {
        return profileService.getFullProfile(personId);
    }
}
