package com.app.converter.audit.model;

import lombok.Data;

import java.util.Date;

@Data
public class AuditLog {
    private Date timestamp;
    private String conversionType;
    private String input;
    private String result;
}
