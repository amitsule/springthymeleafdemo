package com.cognitech.springthymeleafdemo.model;

import java.util.List;

public record Student(String firstName, String lastName, String country, String favLanguage, List<String> os)
{
}
