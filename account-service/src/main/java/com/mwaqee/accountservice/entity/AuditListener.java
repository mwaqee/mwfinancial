package com.mwaqee.accountservice.entity;

import com.mwaqee.accountservice.util.TokenUtil;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        auditable.setCreatedAt(new Date());
        auditable.setLastUpdatedAt(new Date());

        String userId = TokenUtil.getUserIdFromToken();
        auditable.setCreatedBy(userId);
        auditable.setLastUpdatedBy(userId);
    }

    @PreUpdate
    public void setUpdatedOn(Auditable auditable) {
        auditable.setLastUpdatedAt(new Date());
        String userId = TokenUtil.getUserIdFromToken();
        auditable.setLastUpdatedBy(userId);
    }
}
