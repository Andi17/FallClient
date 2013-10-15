
package Webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for comBerechtigung complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="comBerechtigung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="berechtigungBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idBerechtigung" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comBerechtigung", propOrder = {
    "berechtigungBez",
    "idBerechtigung"
})
public class ComBerechtigung {

    protected String berechtigungBez;
    protected int idBerechtigung;

    /**
     * Gets the value of the berechtigungBez property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBerechtigungBez() {
        return berechtigungBez;
    }

    /**
     * Sets the value of the berechtigungBez property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBerechtigungBez(String value) {
        this.berechtigungBez = value;
    }

    /**
     * Gets the value of the idBerechtigung property.
     * 
     */
    public int getIdBerechtigung() {
        return idBerechtigung;
    }

    /**
     * Sets the value of the idBerechtigung property.
     * 
     */
    public void setIdBerechtigung(int value) {
        this.idBerechtigung = value;
    }

}
