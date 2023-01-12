
package sv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para volumenCubo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="volumenCubo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lado1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lado2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lado3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "volumenCubo", propOrder = {
    "lado1",
    "lado2",
    "lado3"
})
public class VolumenCubo {

    protected double lado1;
    protected double lado2;
    protected double lado3;

    /**
     * Obtiene el valor de la propiedad lado1.
     * 
     */
    public double getLado1() {
        return lado1;
    }

    /**
     * Define el valor de la propiedad lado1.
     * 
     */
    public void setLado1(double value) {
        this.lado1 = value;
    }

    /**
     * Obtiene el valor de la propiedad lado2.
     * 
     */
    public double getLado2() {
        return lado2;
    }

    /**
     * Define el valor de la propiedad lado2.
     * 
     */
    public void setLado2(double value) {
        this.lado2 = value;
    }

    /**
     * Obtiene el valor de la propiedad lado3.
     * 
     */
    public double getLado3() {
        return lado3;
    }

    /**
     * Define el valor de la propiedad lado3.
     * 
     */
    public void setLado3(double value) {
        this.lado3 = value;
    }

}
