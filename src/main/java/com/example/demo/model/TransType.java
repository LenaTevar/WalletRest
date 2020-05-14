package com.example.demo.model;

public enum TransType {

	    DEBIT("D"),
	    CREDIT("C");

	    private final String text;


	    TransType(final String text) {
	        this.text = text;
	    }


	    @Override
	    public String toString() {
	        return text;
	    }
	    
	    public Boolean isEquals(String type) {
	    	return this.text.contentEquals(type);
	    }
	}
