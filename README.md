# Numeral Converter

Numeral Converter is a Spring Boot application that provides conversion services for different numeral types, such as converting decimal and binary numbers to Roman numerals. It includes an audit log feature to track conversions.

## Setup

1. Open the project in your preferred Java IDE.

2. Build and run the `NumericalConverterApplication` class.

## Usage

Once the application is running, you can use the provided API endpoints to perform numeral conversions. The frontend can be developed separately and connected to these API endpoints.

## API Endpoints

### Convert Numeral

- **URL:** `/api/v1/numerical-converter/{type}/{numeral}`
- **Method:** `GET`
- **Parameters:**
    - `{type}`: Conversion type (e.g., `decimal-to-roman`, `binary-to-roman`).
    - `{numeral}`: Numeral to be converted.
- **Response:** Returns the converted numeral.

### Audit Logs

- **URL:** `/api/v1/numerical-converter/audit-logs`
- **Method:** `GET`
- **Response:** Returns a list of audit logs containing conversion details.

## Audit Log

The application includes an audit log feature to track numeral conversions. Audit logs can be retrieved through the `/api/v1/numerical-converter/audit-logs` endpoint. The audit log includes the timestamp, conversion type, input numeral, and the result of the conversion.

## Enhancements

To add new conversion follow the below steps
1. Create a Converter (eg. RomanToStringConverter)
2. Add Converter entry to ConverterFactory
