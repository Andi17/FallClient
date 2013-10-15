
package Webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for comStatistik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="comStatistik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hierarchiestufe" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idOrgaEinheit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="jahr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kalenderWoche" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orgaEinheitBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strichBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strichzahl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comStatistik", propOrder = {
    "hierarchiestufe",
    "idOrgaEinheit",
    "jahr",
    "kalenderWoche",
    "orgaEinheitBez",
    "strichBez",
    "strichzahl"
})
public class ComStatistik {

    protected int hierarchiestufe;
    protected int idOrgaEinheit;
    protected int jahr;
    protected int kalenderWoche;
    protected String orgaEinheitBez;
    protected String strichBez;
    protected int strichzahl;

    /**
     * Gets the value of the hierarchiestufe property.
     * 
     */
    public int getHierarchiestufe() {
        return hierarchiestufe;
    }

    /**
     * Sets the value of the hierarchiestufe property.
     * 
     */
    public void setHierarchiestufe(int value) {
        this.hierarchiestufe = value;
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
     * Gets the value of the jahr property.
     * 
     */
    public int getJahr() {
        return jahr;
    }

    /**
     * Sets the value of the jahr property.
     * 
     */
    public void setJahr(int value) {
        this.jahr = value;
    }

    /**
     * Gets the value of the kalenderWoche property.
     * 
     */
    public int getKalenderWoche() {
        return kalenderWoche;
    }

    /**
     * Sets the value of the kalenderWoche property.
     * 
     */
    public void setKalenderWoche(int value) {
        this.kalenderWoche = value;
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
     * Gets the value of the strichzahl property.
     * 
     */
    public int getStrichzahl() {
        return strichzahl;
    }

    /**
     * Sets the value of the strichzahl property.
     * 
     */
    public void setStrichzahl(int value) {
        this.strichzahl = value;
    }

}
