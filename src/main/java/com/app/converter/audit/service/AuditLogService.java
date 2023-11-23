package com.app.converter.audit.service;

import com.app.converter.audit.model.AuditLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuditLogService {
    private List<AuditLog> auditLogs = new ArrayList<>();

    public void logConversion(String conversionType, String input, String result) {
        AuditLog auditLog = new AuditLog();
        auditLog.setTimestamp(new Date());
        auditLog.setConversionType(conversionType);
        auditLog.setInput(input);
        auditLog.setResult(result);
        auditLogs.add(auditLog);
    }

    public List<AuditLog> getAllAuditLogs() {
        return new ArrayList<>(auditLogs);
    }
}

