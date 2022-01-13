package com.gudev.productercase.exception;


import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;


import java.util.List;

public class PlayerNotFoundEception  extends RuntimeException implements GraphQLError {
    public PlayerNotFoundEception(String message){
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
