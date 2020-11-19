# Day 3 : JAXB

## Workshop 1

1. Sample project `00.jaxb.marshall.xsd.sample`
    1. Check the configuration 
    1. Run the using command for POJO generation : `mvn clean generate-sources`  
    1. Check the generated classes, are there differences ? 

1. Test the unmarshalling of sample file `workshop.files/customers.xml`
    * Add some Assertions
    * [Example Tutorial](https://www.javaguides.net/2018/10/jaxb-tutorial.html)
    * Compare the execution time with sample file  `workshop.files/customersLarge.xml`

1. Using the module from Day 1 Workshop as base
    * Test a service that returns the results of the query fetching all the orders purchased as an XML document 
    * [Example Tutorial](https://www.developer.com/java/data/Converting-JDBC-Result-Sets-to-XML-3329001.htm)

### Online resources 
* [API Documentation](https://javaee.github.io/jaxb-v2/doc/user-guide/release-documentation.html#users-guide)

## Workshop 2

* Import the Postman collection https://documenter.getpostman.com/view/8854915/Szf26WHn?version=latest#intro 

* Sample module  `00.jaxws.client.sample`
    1. Check the configuration 
    1. Run the using command for POJO generation : `mvn clean install`  
    1. Check the generated classes

* Build and publish a SOAP web Service based on the data modeled from Day 1 Workshop
    1. Metro is a high-performance, extensible, easy-to-use web service stack
    1. Create a new module from JAX-WS reference implementation (Glassfish Metro)
    1. Apply the data model previously worked on Day 1 
    1. Test the WSDL url in a web browser
    1. Test with a client module from  

### Online resources 
* [Importing SoapUI projects into Postman](https://blog.postman.com/importing-soapui-projects-into-postman/)

* [Developing Web Services with Glassfish](https://glassfish.org/docs/5.1.0/application-development-guide/webservices.html)

* [Jakarta XML Web Services](https://javaee.github.io/metro-jax-ws/)
* [Eclipse Implementation of Jakarta XML Web Services - Project Page](https://github.com/eclipse-ee4j/metro-jax-ws)

## Workshop 3 : Arquillian

Arquillian is an innovative and highly extensible testing platform for the JVM that enables developers to easily create automated integration, functional and acceptance tests for Java middleware.

* Fork or clone this repository https://github.com/robertpanzer/persistence-test 
    * Check the documentation and configuration
    * Run the Test classes
    * Try to switch to an embedded TomEE http://tomee.apache.org/arquillian-available-adapters.html

### Online resources 
* [Guide to SOA](https://www.xenonstack.com/insights/service-oriented-architecture/)

* [WebServices Github Documentation](https://javaee.github.io/tutorial/webservices-intro002.html)

* [Jakarta XML Web Services - GitHub Pages](https://eclipse-ee4j.github.io/metro-jax-ws/2.3.3/docs/ch03.html)
