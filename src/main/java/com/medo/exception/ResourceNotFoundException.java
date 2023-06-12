package com.medo.exception;

public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String filedName;
    String filedValue;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String resourceName, String filedName, String filedValue) {
        super(
                String.format("%s not found with %s : %s", resourceName, filedName, filedValue)
        );
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.filedValue = filedValue;
    }

}
