package com.ansham.SBGraalvmExample.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "default")
public class DPRequest {
    @Id
    @Column(name = "consentid", nullable = false)
    private long  consentid;

    private String tppName;

    public DPRequest(long consentid, String tppName) {
        this.consentid = consentid;
        this.tppName = tppName;
    }
}
