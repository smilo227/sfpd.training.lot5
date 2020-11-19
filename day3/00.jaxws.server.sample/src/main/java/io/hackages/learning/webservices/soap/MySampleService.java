package io.hackages.learning.webservices.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MySampleService {

    @WebMethod
    SampleResponse sampleService(SampleRequest request);
}
