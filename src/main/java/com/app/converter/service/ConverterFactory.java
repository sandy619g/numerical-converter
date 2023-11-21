package com.app.converter.service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum ConverterFactory {
    BINARY_TO_ROMAN {
        @Override
        public Converter createConverter() {
            return new BinaryToRomanConverter();
        }
    },
    DECIMAL_TO_ROMAN {
        @Override
        public Converter createConverter() {
            return new DecimalToRomanConverter();
        }
    };

    public abstract Converter createConverter();
}