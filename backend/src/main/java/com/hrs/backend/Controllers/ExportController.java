package com.hrs.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.DTOs.EmploymentForm;
import com.hrs.backend.DTOs.ServiceForm;
import com.hrs.backend.Models.PersonalInfo.PersonalInfo;
import com.hrs.backend.Pdf.Employment.EmpCertPdfBuilder;
import com.hrs.backend.Pdf.ServiceRendered.CertServicePdfBuilder;
import com.hrs.backend.Services.DateFormatService;
import com.hrs.backend.Services.PersonalInfoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class ExportController {
    private final PersonalInfoService piService;
    private final DateFormatService dfService;
    private final EmpCertPdfBuilder ebuilder;
    private final CertServicePdfBuilder cBuilder;

    @PostMapping(value = "/employment-certificate", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateEmploymentCertificate(@RequestBody EmploymentForm form) throws Exception {
        PersonalInfo info = piService.getByPersonId(form.getPersonId());
        byte[] pdf = ebuilder.build(info, dfService, form.getRows());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("Certificate_of_Compensation.pdf").build()); 
        
        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/service-certificate", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateServiceCertificate(@RequestBody ServiceForm form) throws Exception {
        PersonalInfo info = piService.getByPersonId(form.getPersonId());
        byte[] pdf = cBuilder.build(info, dfService, form.getRows());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("Certificate_of_Service.pdf").build()); 
        
        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
