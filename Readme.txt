Message Dispatcher Servlet:
Setps:
1)Spring configuration by using @Configuration
2)Enable Spring WebService configuration using @EnableWs

Dispatcher -
*is the front Contoller 
*all the request will first come to Dispatcher servlet
*it will indentify which Contoller can handle the request

MessageDispatcherServlet:
It will handle all the SOAP request and identify the endpoint
Servlet for simplified dispatching of Web service messages. 
This servlet is a convenient alternative to the standard Spring-MVC DispatcherServlet 
with separate WebServiceMessageReceiverHandlerAdapter, MessageDispatcher, and WsdlDefinitionHandlerAdapterinstances. 
This servlet automatically detects EndpointAdapters, EndpointMappings, and EndpointExceptionResolvers by type. 
