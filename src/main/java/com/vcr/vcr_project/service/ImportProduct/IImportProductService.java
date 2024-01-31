package com.vcr.vcr_project.service.ImportProduct;

import com.vcr.vcr_project.model.Import.ImportDetail;
import com.vcr.vcr_project.payload.importDetial.ImportDetailMainResponse;
import com.vcr.vcr_project.payload.importDetial.ImportDetailRequest;

public interface IImportProductService {
    void createImportProduct();
    void createImportDetail(ImportDetailRequest payload);
    ImportDetailMainResponse getImportDetailById(Long id);
}
