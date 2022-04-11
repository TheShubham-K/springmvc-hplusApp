package com.shubham.springmvc.convertors;

import com.shubham.springmvc.beans.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConvertor implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        if(source.equals("Male")){
            return Gender.MALE;
        }
        else if(source.equals("Female")){
            return Gender.FEMALE;
        }
        return Gender.OTHER;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Gender, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
