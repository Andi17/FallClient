
package Webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for comBenutzer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="comBenutzer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benutzername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gesperrt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idOrgaEinheit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orgaEinheitBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passwort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comBenutzer", propOrder = {
    "benutzername",
    "gesperrt",
    "idOrgaEinheit",
    "orgaEinheitBez",
    "passwort"
})
public class ComBenutzer {

    protected String benutzername;
    protected boolean gesperrt;
    protected int idOrgaEinheit;
    protected String orgaEinheitBez;
    protected String passwort;

    /**
     * Gets the value of the benutzername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenutzername() {
        return benutzername;
    }

    /**
     * Sets the value of the benutzername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenutzername(String value) {
        this.benutzername = value;
    }

    /**
     * Gets the value of the gesperrt property.
     * 
     */
    public boolean isGesperrt() {
        return gesperrt;
    }

    /**
     * Sets the value of the gesperrt property.
     * 
     */
    public void setGesperrt(boolean value) {
        this.gesperrt = value;
    }

    /**
     * Gets the value of the idOrgaEinheit property.
     * 
     */
    public int getIdOrgaEinheit() {
        return idOrgaEinheit;
    }

    /**
     * Sets the value of the idOrgaEinheit property.
     * 
     */
    public void setIdOrgaEinheit(int value) {
        this.idOrgaEinheit = value;
    }

    /**
     * Gets the value of the orgaEinheitBez property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgaEinheitBez() {
        return orgaEinheitBez;
    }

    /**
     * Sets the value of the orgaEinheitBez property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgaEinheitBez(String value) {
        this.orgaEinheitBez = value;
    }

    /**
     * Gets the value of the passwort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswort() {
        return passwort;
    }

    /**
     * Sets the value of the passwort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswort(String value) {
        this.passwort = value;
    }

}
