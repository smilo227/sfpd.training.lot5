package io.hackages.learning.webservices.soap;

import javax.jws.WebService;

@WebService(serviceName = "MySampleService", endpointInterface = "io.hackages.learning.webservices.soap.MySampleService")
public class MySampleServiceImpl implements MySampleService{

	/**
	 * Define the service here
	 */
	@Override
	public SampleResponse sampleService(SampleRequest request) {
		SampleResponse response = new SampleResponse();
		// TODO - Process the feature
		return response;
	}
}