
package Webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="idStrichBez" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="jahr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kalenderWoche" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orgaEinheitBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgaEinheitTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strichBez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strichzahl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unterOrgaEinheiten" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
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
    "idStrichBez",
    "jahr",
    "kalenderWoche",
    "orgaEinheitBez",
    "orgaEinheitTyp",
    "strichBez",
    "strichzahl",
    "unterOrgaEinheiten"
})
public class ComStatistik {

    protected int hierarchiestufe;
    protected int idOrgaEinheit;
    protected int idStrichBez;
    protected int jahr;
    protected int kalenderWoche;
    protected String orgaEinheitBez;
    protected String orgaEinheitTyp;
    protected String strichBez;
    protected int strichzahl;
    @XmlElement(nillable = true)
    protected List<Integer> unterOrgaEinheiten;

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
     * Gets the value of the idStrichBez property.
     * 
     */
    public int getIdStrichBez() {
        return idStrichBez;
    }

    /**
     * Sets the value of the idStrichBez property.
     * 
     */
    public void setIdStrichBez(int value) {
        this.idStrichBez = value;
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

    /**
     * Gets the value of the unterOrgaEinheiten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unterOrgaEinheiten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnterOrgaEinheiten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getUnterOrgaEinheiten() {
        if (unterOrgaEinheiten == null) {
            unterOrgaEinheiten = new ArrayList<Integer>();
        }
        return this.unterOrgaEinheiten;
    }

}
