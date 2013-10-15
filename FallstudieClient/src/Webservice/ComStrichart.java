
package Webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for comStrichart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="comStrichart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idStrichart" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="strichBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zustand" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comStrichart", propOrder = {
    "idStrichart",
    "strichBez",
    "zustand"
})
public class ComStrichart {

    protected int idStrichart;
    protected String strichBez;
    protected boolean zustand;

    /**
     * Gets the value of the idStrichart property.
     * 
     */
    public int getIdStrichart() {
        return idStrichart;
    }

    /**
     * Sets the value of the idStrichart property.
     * 
     */
    public void setIdStrichart(int value) {
        this.idStrichart = value;
    }

    /**
     * Gets the value of the strichBez property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrichBez() {
        return strichBez;
    }

    /**
     * Sets the value of the strichBez property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrichBez(String value) {
        this.strichBez = value;
    }

    /**
     * Gets the value of the zustand property.
     * 
     */
    public boolean isZustand() {
        return zustand;
    }

    /**
     * Sets the value of the zustand property.
     * 
     */
    public void setZustand(boolean value) {
        this.zustand = value;
    }

}
