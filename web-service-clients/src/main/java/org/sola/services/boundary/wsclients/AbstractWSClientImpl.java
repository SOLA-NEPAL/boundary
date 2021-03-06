/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations (FAO).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice,this list
 *       of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice,this list
 *       of conditions and the following disclaimer in the documentation and/or other
 *       materials provided with the distribution.
 *    3. Neither the name of FAO nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.wsclients;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;
import org.sola.common.messaging.ServiceMessage;
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.services.boundary.wsclients.exception.WebServiceClientExceptionType;

/**
 * Implementation class for the {@linkplain AbstractWSClient} interface. Also provides common
 * functionality for descendent web service implementation classes. 
 * @author amcdowell
 */
public abstract class AbstractWSClientImpl implements AbstractWSClient {

    protected Service service = null;
    private String userName;
    protected String url;
    protected QName qName;
    private char[] options;

    /**
     * Constructor for the {@linkplain AbstractWSClientImpl}
     * @param url The location of the wsdl file for the web service. 
     * @param qName The QName for the web service. 
     */
    public AbstractWSClientImpl(String url, QName qName) {
        this.url = url;
        this.qName = qName;
    }

    /** 
     * Sets the request context parameters for the port. Includes setting the username and password
     * for each request. 
     * @param port The web service port. 
     */
    protected void setContextParameters(BindingProvider port) {
        if (userName != null) {
            port.getRequestContext().put(com.sun.xml.wss.XWSSConstants.USERNAME_PROPERTY, userName);
        }
        if (options != null && options.length > 0) {
            port.getRequestContext().put(com.sun.xml.wss.XWSSConstants.PASSWORD_PROPERTY,
                    new String(options));
        }
    }

    /**
     * Provides a generic method for creating a new port. This will also instantiate the service
     * object if it is not already instantiated. 
     * <p>This method should be used by descendent implementation classes to obtain a port object 
     * that is configured with the appropriate context parameters. It should be wrapped by 
     * a getPort() method. e.g. </p>
     * <pre>
     *  private CaseManagement getPort() {
    return getPort(CaseManagement.class, CasemanagementService.class);
    }
     * </pre>
     * @param <T> Represents the type of the port interface class (i.e. the service client interface class)
     * @param <S> Represents the type of the service class to instantiate. Must extend 
     * {@linkplain javax.xml.ws.Service}
     * @param portInterfaceClass The service client interface class to create. e.g. SecurityClient.class
     * @param serviceClass The service class to use e.g. SecurityService.class
     * @return A new port object that implements the service client interface class
     * @throws WebServiceClientException If an error occurs while instantiating the service object
     */
    protected <T, S extends Service> T getPort(Class<T> portInterfaceClass, Class<S> serviceClass)
            throws WebServiceClientException {
        T port = getService(serviceClass).getPort(portInterfaceClass);
        setContextParameters((BindingProvider) port);
        return port;
    }

    /**
     * Creates a new service object if one does not already exist for the Service Client. 
     * @param <T> Represents the type of the service class to instantiate. Must extend 
     * {@linkplain javax.xml.ws.Service}
     * @param serviceClass The service class to use e.g. SecurityService.class
     * @return An instantiated service object. 
     * @throws WebServiceClientException If an error occurs while instantiating the service class
     */
    protected <T extends Service> T getService(Class<T> serviceClass)
            throws WebServiceClientException {
        if (service == null) {
            try {
                Constructor<T> constructor = serviceClass.getConstructor(URL.class, QName.class);
                service = constructor.newInstance(new URL(url), qName);
            } catch (MalformedURLException ex) {
                // Check the protocol for the URL is valid and that its not missing a : or similar.   
                Object[] parms = {ex.getLocalizedMessage(), ex};
                throw new WebServiceClientException(ServiceMessage.EXCEPTION_MALFORMED_URL, parms);
            } catch (InvocationTargetException ex) {
                // The real cause has been wrapped by the InvocationTargetException
                Object[] parms = {url, ex.getCause().getLocalizedMessage(), ex.getCause()};
                throw new WebServiceClientException(ServiceMessage.EXCEPTION_SERVICE_CONNECTION, parms);
            } catch (Exception ex) {
                Object[] parms = {url, ex.getLocalizedMessage(), ex};
                throw new WebServiceClientException(ServiceMessage.EXCEPTION_SERVICE_CONNECTION, parms);
            }
        }
        return (T) service;
    }

    /** 
     * Processes web service client exceptions such as Authentication Failed, Malformed URLs, etc.
     * This method must be used to catch any throwable exceptions not handled as faults by the 
     * service client web methods.  
     * @param methodName The name of the service client method were the exception was caught. 
     * @param t The throwable exception
     * @return A WebServiceClientException. This exception should be thrown by the calling method. 
     */
    protected WebServiceClientException processException(String methodName, Throwable t) {
        // Output the original error to standard error to help with debugging
        System.err.println(t); 
        if (WebServiceClientException.class.isAssignableFrom(t.getClass())) {
            // Already a WebServiceClientException
            return (WebServiceClientException) t;
        }
        if (SOAPFaultException.class.isAssignableFrom(t.getClass())
                && t.getMessage().equalsIgnoreCase("Authentication of Username Password Token Failed")) {
            // User failed to log in so create a more user friendly "failed to authenticate" message
            return new WebServiceClientException(ServiceMessage.EXCEPTION_AUTHENTICATION_FAILED,
                    WebServiceClientExceptionType.AUTHENTICATION_FAILED);
        }
        if (WebServiceException.class.isAssignableFrom(t.getClass())) {
            Object[] parms = {url, t.getLocalizedMessage(), t};
            throw new WebServiceClientException(ServiceMessage.EXCEPTION_SERVICE_CONNECTION, parms);
        }
        Object[] parms = {methodName, t.getLocalizedMessage(), t};
        return new WebServiceClientException(ServiceMessage.GENERAL_UNEXPECTED_ERROR_DETAILS, parms);
    }

    /** Gets the username configured for the service */
    public String getUserName() {
        return userName;
    }

    /** Gets the url configured for the service */
    public String getUrl() {
        return url;
    }

    /** Sets the Url for the service. Using this method has a performed impact. Setting the url 
     * will invalidate the cached service object and a new service object will be created on the 
     * next web method request. This may add several seconds to the request. */
    public void setUrl(String url) {
        if (this.url != null && !this.url.equals(url)) {
            service = null;
        }
        this.url = url;
    }

    /**
     * Sets the user credentials to be used for each service request. 
     * @param userName The username
     * @param password The users password. This is handled as a char array to be consistent with
     * best practice for handling passwords in java. Handling passwords as Strings should be 
     * avoided. 
     */
    @Override
    public void setCredentials(String userName, char[] password) {
        this.userName = userName;
        if (password != null) {
            this.options = password.clone();
        }
    }

    protected String getLanguageCode() {
        return Locale.getDefault().getLanguage();
    }
    
    
    
      protected void handleExceptionsMethod(
            String serviceName,    
            Throwable e) throws  WebServiceClientException {
 

//          ###  org.sola.webservices.casemanagement  ##
           if (org.sola.webservices.casemanagement.SOLAAccessFault.class.isAssignableFrom(e.getClass())) {
            org.sola.webservices.casemanagement.SOLAAccessFault fault  = (org.sola.webservices.casemanagement.SOLAAccessFault)e;   
            throw new WebServiceClientException(WebServiceClientExceptionType.ACCESS_VIOLATION,
                    fault.getFaultInfo());
           }
           
                   
           if (org.sola.webservices.casemanagement.SOLAValidationFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.casemanagement.SOLAValidationFault fault  = (org.sola.webservices.casemanagement.SOLAValidationFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SOLA_VALIDATION_FAILED,
                        fault.getFaultInfo());
            } 
           
           if (org.sola.webservices.casemanagement.OptimisticLockingFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.casemanagement.OptimisticLockingFault fault  = (org.sola.webservices.casemanagement.OptimisticLockingFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.OPTIMISTIC_LOCK,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.casemanagement.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.casemanagement.SOLAFault fault  = (org.sola.webservices.casemanagement.SOLAFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.casemanagement.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.casemanagement.UnhandledFault fault  = (org.sola.webservices.casemanagement.UnhandledFault)e; 
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }
//          ###  org.sola.webservices.admin ##
           if (org.sola.webservices.admin.SOLAAccessFault.class.isAssignableFrom(e.getClass())) {
            org.sola.webservices.admin.SOLAAccessFault fault  = (org.sola.webservices.admin.SOLAAccessFault)e;  
            throw new WebServiceClientException(WebServiceClientExceptionType.ACCESS_VIOLATION,
                    fault.getFaultInfo());
           }
           
           if (org.sola.webservices.admin.SOLAValidationFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.admin.SOLAValidationFault fault  = (org.sola.webservices.admin.SOLAValidationFault)e;     
                throw new WebServiceClientException(WebServiceClientExceptionType.SOLA_VALIDATION_FAILED,
                        fault.getFaultInfo());
            } 
           if (org.sola.webservices.admin.OptimisticLockingFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.admin.OptimisticLockingFault fault  = (org.sola.webservices.admin.OptimisticLockingFault)e;     
                throw new WebServiceClientException(WebServiceClientExceptionType.OPTIMISTIC_LOCK,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.admin.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.admin.SOLAFault fault = (org.sola.webservices.admin.SOLAFault)e;     
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.admin.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.admin.UnhandledFault fault  = (org.sola.webservices.admin.UnhandledFault)e;       
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }
//          ###  org.sola.webservices.administrative ##
           if (org.sola.webservices.administrative.SOLAAccessFault.class.isAssignableFrom(e.getClass())) {
            org.sola.webservices.administrative.SOLAAccessFault fault  = (org.sola.webservices.administrative.SOLAAccessFault)e;       
            throw new WebServiceClientException(WebServiceClientExceptionType.ACCESS_VIOLATION,
                    fault.getFaultInfo());
           }
           
           if (org.sola.webservices.administrative.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.administrative.SOLAFault fault  = (org.sola.webservices.administrative.SOLAFault)e;         
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.administrative.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.administrative.UnhandledFault fault  = (org.sola.webservices.administrative.UnhandledFault)e;         
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }
//          ###  org.sola.webservices.cadastre ##
           if (org.sola.webservices.cadastre.SOLAAccessFault.class.isAssignableFrom(e.getClass())) {
            org.sola.webservices.cadastre.SOLAAccessFault fault = (org.sola.webservices.cadastre.SOLAAccessFault)e;
            throw new WebServiceClientException(WebServiceClientExceptionType.ACCESS_VIOLATION,
                    fault.getFaultInfo());
           }
           
           if (org.sola.webservices.cadastre.SOLAValidationFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.cadastre.SOLAValidationFault fault  = (org.sola.webservices.cadastre.SOLAValidationFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SOLA_VALIDATION_FAILED,
                        fault.getFaultInfo());
            } 
           if (org.sola.webservices.cadastre.OptimisticLockingFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.cadastre.OptimisticLockingFault fault  = (org.sola.webservices.cadastre.OptimisticLockingFault)e;
                throw new WebServiceClientException(WebServiceClientExceptionType.OPTIMISTIC_LOCK,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.cadastre.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.cadastre.SOLAFault fault  = (org.sola.webservices.cadastre.SOLAFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.cadastre.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.cadastre.UnhandledFault fault  =  (org.sola.webservices.cadastre.UnhandledFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }
//          ###  org.sola.webservices.digitalarchive ##
           if (org.sola.webservices.digitalarchive.OptimisticLockingFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.digitalarchive.OptimisticLockingFault fault  =  (org.sola.webservices.digitalarchive.OptimisticLockingFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.OPTIMISTIC_LOCK,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.digitalarchive.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.digitalarchive.SOLAFault fault  =(org.sola.webservices.digitalarchive.SOLAFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.digitalarchive.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.digitalarchive.UnhandledFault fault  = (org.sola.webservices.digitalarchive.UnhandledFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }
//          ###  org.sola.webservices.referencedata ##
           if (org.sola.webservices.referencedata.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.referencedata.SOLAFault fault  = (org.sola.webservices.referencedata.SOLAFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                       fault.getFaultInfo());
            }
           if (org.sola.webservices.referencedata.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.referencedata.UnhandledFault fault  = (org.sola.webservices.referencedata.UnhandledFault)e;
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }
//          ###  org.sola.webservices.search ##
           if (org.sola.webservices.search.SOLAAccessFault.class.isAssignableFrom(e.getClass())) {
            org.sola.webservices.search.SOLAAccessFault fault  = (org.sola.webservices.search.SOLAAccessFault)e;  
            throw new WebServiceClientException(WebServiceClientExceptionType.ACCESS_VIOLATION,
                    fault.getFaultInfo());
           }
           
           if (org.sola.webservices.search.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.search.SOLAFault fault = (org.sola.webservices.search.SOLAFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.search.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.search.UnhandledFault fault  =(org.sola.webservices.search.UnhandledFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }
//          ###  org.sola.webservices.spatial ##
           if (org.sola.webservices.spatial.SOLAFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.spatial.SOLAFault fault  = (org.sola.webservices.spatial.SOLAFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_GENERAL,
                        fault.getFaultInfo());
            }
           if (org.sola.webservices.spatial.UnhandledFault.class.isAssignableFrom(e.getClass())) {
                org.sola.webservices.spatial.UnhandledFault fault  = (org.sola.webservices.spatial.UnhandledFault)e;  
                throw new WebServiceClientException(WebServiceClientExceptionType.SERVICE_UNHANDLED,
                        fault.getFaultInfo());
            }

//           ###  Throwable              
           if (Throwable.class.isAssignableFrom(e.getClass())) {
            throw processException(serviceName, e);
           }
         
      } 
      
      /** Converts {@link XMLGregorianCalendar} to {@link Date}*/
    public static Date XMLDateToDate(XMLGregorianCalendar xmlDate) {
        if (xmlDate == null) {
            return null;
        }
        return xmlDate.toGregorianCalendar().getTime();
    }

    /** Converts {@link Date} to {@link XMLGregorianCalendar}*/
    public static XMLGregorianCalendar DateToXMLDate(Date date) {
        if (date == null) {
            return null;
        }

        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);

        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException ex) {
            return null;
        }
    }
}
