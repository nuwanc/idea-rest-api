package com.app.idea.exception;

/**
 * Created by nchandrasoma on 6/19/2015.
 */
public class IdeaNotFoundException extends RuntimeException {
    public IdeaNotFoundException(long id){
        super(Long.toString(id));
    }
}
