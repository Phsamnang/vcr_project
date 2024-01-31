package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.payload.importDetial.ImportDetailRequest;
import com.vcr.vcr_project.service.ImportProduct.IImportProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ImportController extends VCRRestController {
    private final IImportProductService service;
   @PostMapping("/import")
   public ResponseEntity<?>createImport(){
       service.createImportProduct();
       return ok();
   }
   @PostMapping("/import/detail")
    public ResponseEntity<?>createImportDetail(@RequestBody ImportDetailRequest payload){
       service.createImportDetail(payload);
       return ok();
   }
   @GetMapping("/import/{id}")
    public ResponseEntity<?>getImportById(@PathVariable("id") Long id){
       return ok(service.getImportDetailById(id));
   }
}
