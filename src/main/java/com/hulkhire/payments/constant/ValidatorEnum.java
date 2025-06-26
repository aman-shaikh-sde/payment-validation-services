package com.hulkhire.payments.constant;

import com.hulkhire.payments.service.Validator;
import com.hulkhire.payments.service.impl.validator.Check1Validator;
import com.hulkhire.payments.service.impl.validator.Check2Validator;

import java.util.HashMap;
import java.util.Map;


public enum ValidatorEnum {

    CHECK1_VALIDATOR("CHECK1_VALIDATOR", Check1Validator.class),
    CHECK2_VALIDATOR("CHECK2_VALIDATOR", Check2Validator.class);

    private final String name;
    private final Class<? extends Validator> validatorClass;

    // Optimized static map for O(1) lookup
    private static final Map<String, ValidatorEnum> NAME_TO_ENUM_MAP = new HashMap<>();

    // Static block to fill the map once
    static {
        for (ValidatorEnum type : values()) {
            NAME_TO_ENUM_MAP.put(type.name, type);
        }
    }

    ValidatorEnum(String name, Class<? extends Validator> validatorClass) {
        this.name = name;
        this.validatorClass = validatorClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends Validator> getValidatorClass() {
        return validatorClass;
    }

    /** ✅ Method to get validator class from string name */
    public static Class<? extends Validator> getClassByName(String name) {
        ValidatorEnum type = NAME_TO_ENUM_MAP.get(name);
        return type.validatorClass;
    }
}
