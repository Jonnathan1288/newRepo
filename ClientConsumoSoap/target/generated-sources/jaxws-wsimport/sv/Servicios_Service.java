
package sv;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "servicios", targetNamespace = "http://sv/", wsdlLocation = "http://localhost:8080/ProyectoSoapServer/servicios?WSDL")
public class Servicios_Service
    extends Service
{

    private final static URL SERVICIOS_WSDL_LOCATION;
    private final static WebServiceException SERVICIOS_EXCEPTION;
    private final static QName SERVICIOS_QNAME = new QName("http://sv/", "servicios");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ProyectoSoapServer/servicios?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOS_WSDL_LOCATION = url;
        SERVICIOS_EXCEPTION = e;
    }

    public Servicios_Service() {
        super(__getWsdlLocation(), SERVICIOS_QNAME);
    }

    public Servicios_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOS_QNAME, features);
    }

    public Servicios_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOS_QNAME);
    }

    public Servicios_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOS_QNAME, features);
    }

    public Servicios_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Servicios_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Servicios
     */
    @WebEndpoint(name = "serviciosPort")
    public Servicios getServiciosPort() {
        return super.getPort(new QName("http://sv/", "serviciosPort"), Servicios.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Servicios
     */
    @WebEndpoint(name = "serviciosPort")
    public Servicios getServiciosPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://sv/", "serviciosPort"), Servicios.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOS_EXCEPTION!= null) {
            throw SERVICIOS_EXCEPTION;
        }
        return SERVICIOS_WSDL_LOCATION;
    }

}
