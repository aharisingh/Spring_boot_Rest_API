package com.example.restAPI.api.mappers;

import org.springframework.stereotype.Service;

public interface Mapper<A,B> {

    B MapTo(A a);

    A MapFrom(B b);
}
