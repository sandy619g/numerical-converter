package com.app.converter.audit.service;

import com.app.converter.audit.model.AuditLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AuditLogServiceTest {

    private AuditLogService auditLogService;

    @BeforeEach
    public void setUp() {
        auditLogService = new AuditLogService();
    }

    @Test
    public void testLogConversion() {
        String conversionType = "decimal-to-roman";
        String input = "123";
        String result = "CXXIII";

        auditLogService.logConversion(conversionType, input, result);

        List<AuditLog> auditLogs = auditLogService.getAllAuditLogs();

        assertEquals(1, auditLogs.size());

        AuditLog auditLog = auditLogs.get(0);
        assertEquals(conversionType, auditLog.getConversionType());
        assertEquals(input, auditLog.getInput());
        assertEquals(result, auditLog.getResult());
        assertNotNull(auditLog.getTimestamp());
    }

    @Test
    public void testGetAllAuditLogs() {
        List<AuditLog> auditLogs = auditLogService.getAllAuditLogs();

        assertNotNull(auditLogs);
        assertEquals(0, auditLogs.size());
    }
}
