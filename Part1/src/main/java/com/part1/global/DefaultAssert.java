package com.part1.global;

import java.util.List;
import java.util.Optional;

import com.part1.global.error.DefaultAuthenticationException;
import com.part1.global.error.DefaultException;
import com.part1.global.error.DefaultNullPointerException;
import com.part1.global.error.InvalidParameterException;
import com.part1.global.payload.ErrorCode;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;

public class DefaultAssert extends Assert{

    public static void isTrue(boolean value){
        if(!value){
            throw new DefaultException(ErrorCode.INVALID_CHECK);
        }
    }

    public static void isTrue(boolean value, String message){
        if(!value){
            throw new DefaultException(ErrorCode.INVALID_CHECK, message);
        }
    }

    public static void isValidParameter(Errors errors){
        if(errors.hasErrors()){
            throw new InvalidParameterException(errors);
        }
    }
    
    public static void isObjectNull(Object object){
        if(object == null){
            throw new DefaultNullPointerException(ErrorCode.INVALID_CHECK);
        }
    }

    public static void isListNull(List<Object> values){
        if(values.isEmpty()){
            throw new DefaultException(ErrorCode.INVALID_FILE_PATH);
        }
    }

    public static void isListNull(Object[] values){
        if(values == null){
            throw new DefaultException(ErrorCode.INVALID_FILE_PATH);
        }
    }

    public static void isOptionalPresent(Optional<?> value){
        if(!value.isPresent()){
            throw new DefaultException(ErrorCode.INVALID_PARAMETER);
        }
    }

    public static void isAuthentication(String message){
        throw new DefaultAuthenticationException(message);
    }

    public static void isAuthentication(boolean value){
        if(!value){
            throw new DefaultAuthenticationException(ErrorCode.INVALID_AUTHENTICATION);
        }
    }
}