package com.vcr.vcr_project.model.Import;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@NoArgsConstructor
public class ImportDetailId implements Serializable {
    @Column(nullable = false, insertable = false)
    private Long productId;
    @Column(nullable = false, insertable = false)
    private Long importId;
}
