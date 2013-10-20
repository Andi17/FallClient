
package Webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for comOrgaEinheit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="comOrgaEinheit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idLeiterBerechtigung" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idMitarbeiterBerechtigung" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idOrgaEinheit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idUeberOrgaEinheit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="leitername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgaEinheitBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgaEinheitTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ueberOrgaEinheit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "comOrgaEinheit", propOrder = {
    "idLeiterBerechtigung",
    "idMitarbeiterBerechtigung",
    "idOrgaEinheit",
    "idUeberOrgaEinheit",
    "leitername",
    "orgaEinheitBez",
    "orgaEinheitTyp",
    "ueberOrgaEinheit",
    "zustand"
})
public class ComOrgaEinheit {

    protected int idLeiterBerechtigung;
    protected int idMitarbeiterBerechtigung;
    protected int idOrgaEinheit;
    protected int idUeberOrgaEinheit;
    protected String leitername;
    protected String orgaEinheitBez;
    protected String orgaEinheitTyp;
    protected String ueberOrgaEinheit;
    protected boolean zustand;

    /**
     * Gets the value of the idLeiterBerechtigung property.
     * 
     */
    public int getIdLeiterBerechtigung() {
        return idLeiterBerechtigung;
    }

    /**
     * Sets the value of the idLeiterBerechtigung property.
     * 
     */
    public void setIdLeiterBerechtigung(int value) {
        this.idLeiterBerechtigung = value;
    }

    /**
     * Gets the value of the idMitarbeiterBerechtigung property.
     * 
     */
    public int getIdMitarbeiterBerechtigung() {
        return idMitarbeiterBerechtigung;
    }

    /**
     * Sets the value of the idMitarbeiterBerechtigung property.
     * 
     */
    public void setIdMitarbeiterBerechtigung(int value) {
        this.idMitarbeiterBerechtigung = value;
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
     * Gets the value of the idUeberOrgaEinheit property.
     * 
     */
    public int getIdUeberOrgaEinheit() {
        return idUeberOrgaEinheit;
    }

    /**
     * Sets the value of the idUeberOrgaEinheit property.
     * 
     */
    public void setIdUeberOrgaEinheit(int value) {
        this.idUeberOrgaEinheit = value;
    }

    /**
     * Gets the value of the leitername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeitername() {
        return leitername;
    }

    /**
     * Sets the value of the leitername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeitername(String value) {
        this.leitername = value;
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
     * Gets the value of the orgaEinheitTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgaEinheitTyp() {
        return orgaEinheitTyp;
    }

    /**
     * Sets the value of the orgaEinheitTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgaEinheitTyp(String value) {
        this.orgaEinheitTyp = value;
    }

    /**
     * Gets the value of the ueberOrgaEinheit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUeberOrgaEinheit() {
        return ueberOrgaEinheit;
    }

    /**
     * Sets the value of the ueberOrgaEinheit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUeberOrgaEinheit(String value) {
        this.ueberOrgaEinheit = value;
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
