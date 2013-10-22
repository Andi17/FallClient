
package Webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Webservice", targetNamespace = "http://Webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Webservice {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns Webservice.ComBenutzer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEinzelnenBenutzer", targetNamespace = "http://Webservice/", className = "Webservice.GetEinzelnenBenutzer")
    @ResponseWrapper(localName = "getEinzelnenBenutzerResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetEinzelnenBenutzerResponse")
    @Action(input = "http://Webservice/Webservice/getEinzelnenBenutzerRequest", output = "http://Webservice/Webservice/getEinzelnenBenutzerResponse")
    public ComBenutzer getEinzelnenBenutzer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "benutzerErstellen", targetNamespace = "http://Webservice/", className = "Webservice.BenutzerErstellen")
    @ResponseWrapper(localName = "benutzerErstellenResponse", targetNamespace = "http://Webservice/", className = "Webservice.BenutzerErstellenResponse")
    @Action(input = "http://Webservice/Webservice/benutzerErstellenRequest", output = "http://Webservice/Webservice/benutzerErstellenResponse")
    public boolean benutzerErstellen(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "benutzerLoeschen", targetNamespace = "http://Webservice/", className = "Webservice.BenutzerLoeschen")
    @ResponseWrapper(localName = "benutzerLoeschenResponse", targetNamespace = "http://Webservice/", className = "Webservice.BenutzerLoeschenResponse")
    @Action(input = "http://Webservice/Webservice/benutzerLoeschenRequest", output = "http://Webservice/Webservice/benutzerLoeschenResponse")
    public boolean benutzerLoeschen(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "benutzerOrgaEinheitAendern", targetNamespace = "http://Webservice/", className = "Webservice.BenutzerOrgaEinheitAendern")
    @ResponseWrapper(localName = "benutzerOrgaEinheitAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.BenutzerOrgaEinheitAendernResponse")
    @Action(input = "http://Webservice/Webservice/benutzerOrgaEinheitAendernRequest", output = "http://Webservice/Webservice/benutzerOrgaEinheitAendernResponse")
    public boolean benutzerOrgaEinheitAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "benutzernameAendern", targetNamespace = "http://Webservice/", className = "Webservice.BenutzernameAendern")
    @ResponseWrapper(localName = "benutzernameAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.BenutzernameAendernResponse")
    @Action(input = "http://Webservice/Webservice/benutzernameAendernRequest", output = "http://Webservice/Webservice/benutzernameAendernResponse")
    public boolean benutzernameAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "istBenutzerSchonLeiter", targetNamespace = "http://Webservice/", className = "Webservice.IstBenutzerSchonLeiter")
    @ResponseWrapper(localName = "istBenutzerSchonLeiterResponse", targetNamespace = "http://Webservice/", className = "Webservice.IstBenutzerSchonLeiterResponse")
    @Action(input = "http://Webservice/Webservice/istBenutzerSchonLeiterRequest", output = "http://Webservice/Webservice/istBenutzerSchonLeiterResponse")
    public String istBenutzerSchonLeiter(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "gibtesBenutzerschon", targetNamespace = "http://Webservice/", className = "Webservice.GibtesBenutzerschon")
    @ResponseWrapper(localName = "gibtesBenutzerschonResponse", targetNamespace = "http://Webservice/", className = "Webservice.GibtesBenutzerschonResponse")
    @Action(input = "http://Webservice/Webservice/gibtesBenutzerschonRequest", output = "http://Webservice/Webservice/gibtesBenutzerschonResponse")
    public boolean gibtesBenutzerschon(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "neuesPasswortSetzen", targetNamespace = "http://Webservice/", className = "Webservice.NeuesPasswortSetzen")
    @ResponseWrapper(localName = "neuesPasswortSetzenResponse", targetNamespace = "http://Webservice/", className = "Webservice.NeuesPasswortSetzenResponse")
    @Action(input = "http://Webservice/Webservice/neuesPasswortSetzenRequest", output = "http://Webservice/Webservice/neuesPasswortSetzenResponse")
    public boolean neuesPasswortSetzen(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "passwortSperren", targetNamespace = "http://Webservice/", className = "Webservice.PasswortSperren")
    @ResponseWrapper(localName = "passwortSperrenResponse", targetNamespace = "http://Webservice/", className = "Webservice.PasswortSperrenResponse")
    @Action(input = "http://Webservice/Webservice/passwortSperrenRequest", output = "http://Webservice/Webservice/passwortSperrenResponse")
    public void passwortSperren(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "passwortEntsperren", targetNamespace = "http://Webservice/", className = "Webservice.PasswortEntsperren")
    @ResponseWrapper(localName = "passwortEntsperrenResponse", targetNamespace = "http://Webservice/", className = "Webservice.PasswortEntsperrenResponse")
    @Action(input = "http://Webservice/Webservice/passwortEntsperrenRequest", output = "http://Webservice/Webservice/passwortEntsperrenResponse")
    public boolean passwortEntsperren(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.ComOrgaEinheit>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgaEinheiten", targetNamespace = "http://Webservice/", className = "Webservice.GetOrgaEinheiten")
    @ResponseWrapper(localName = "getOrgaEinheitenResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetOrgaEinheitenResponse")
    @Action(input = "http://Webservice/Webservice/getOrgaEinheitenRequest", output = "http://Webservice/Webservice/getOrgaEinheitenResponse")
    public List<ComOrgaEinheit> getOrgaEinheiten(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        boolean arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns Webservice.ComOrgaEinheit
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrgaEinheitZuName", targetNamespace = "http://Webservice/", className = "Webservice.GetOrgaEinheitZuName")
    @ResponseWrapper(localName = "getOrgaEinheitZuNameResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetOrgaEinheitZuNameResponse")
    @Action(input = "http://Webservice/Webservice/getOrgaEinheitZuNameRequest", output = "http://Webservice/Webservice/getOrgaEinheitZuNameResponse")
    public ComOrgaEinheit getOrgaEinheitZuName(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "OrgaEinheitErstellen")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "OrgaEinheitErstellen", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitErstellen")
    @ResponseWrapper(localName = "OrgaEinheitErstellenResponse", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitErstellenResponse")
    @Action(input = "http://Webservice/Webservice/OrgaEinheitErstellenRequest", output = "http://Webservice/Webservice/OrgaEinheitErstellenResponse")
    public boolean orgaEinheitErstellen(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "orgaEinheitZustandAendern", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitZustandAendern")
    @ResponseWrapper(localName = "orgaEinheitZustandAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitZustandAendernResponse")
    @Action(input = "http://Webservice/Webservice/orgaEinheitZustandAendernRequest", output = "http://Webservice/Webservice/orgaEinheitZustandAendernResponse")
    public boolean orgaEinheitZustandAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        boolean arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "orgaEinheitLeiterAendern", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitLeiterAendern")
    @ResponseWrapper(localName = "orgaEinheitLeiterAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitLeiterAendernResponse")
    @Action(input = "http://Webservice/Webservice/orgaEinheitLeiterAendernRequest", output = "http://Webservice/Webservice/orgaEinheitLeiterAendernResponse")
    public boolean orgaEinheitLeiterAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "gibtEsOrgaEinheitSchon", targetNamespace = "http://Webservice/", className = "Webservice.GibtEsOrgaEinheitSchon")
    @ResponseWrapper(localName = "gibtEsOrgaEinheitSchonResponse", targetNamespace = "http://Webservice/", className = "Webservice.GibtEsOrgaEinheitSchonResponse")
    @Action(input = "http://Webservice/Webservice/gibtEsOrgaEinheitSchonRequest", output = "http://Webservice/Webservice/gibtEsOrgaEinheitSchonResponse")
    public boolean gibtEsOrgaEinheitSchon(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.ComStrichart>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStrichelArten", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichelArten")
    @ResponseWrapper(localName = "getStrichelArtenResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichelArtenResponse")
    @Action(input = "http://Webservice/Webservice/getStrichelArtenRequest", output = "http://Webservice/Webservice/getStrichelArtenResponse")
    public List<ComStrichart> getStrichelArten(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        boolean arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns Webservice.ComStrichart
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStrichelArt", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichelArt")
    @ResponseWrapper(localName = "getStrichelArtResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichelArtResponse")
    @Action(input = "http://Webservice/Webservice/getStrichelArtRequest", output = "http://Webservice/Webservice/getStrichelArtResponse")
    public ComStrichart getStrichelArt(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "neueStrichelart", targetNamespace = "http://Webservice/", className = "Webservice.NeueStrichelart")
    @ResponseWrapper(localName = "neueStrichelartResponse", targetNamespace = "http://Webservice/", className = "Webservice.NeueStrichelartResponse")
    @Action(input = "http://Webservice/Webservice/neueStrichelartRequest", output = "http://Webservice/Webservice/neueStrichelartResponse")
    public boolean neueStrichelart(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "strichelArtZustandAendern", targetNamespace = "http://Webservice/", className = "Webservice.StrichelArtZustandAendern")
    @ResponseWrapper(localName = "strichelArtZustandAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.StrichelArtZustandAendernResponse")
    @Action(input = "http://Webservice/Webservice/strichelArtZustandAendernRequest", output = "http://Webservice/Webservice/strichelArtZustandAendernResponse")
    public boolean strichelArtZustandAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        boolean arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.ComStatistik>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBereichsStatistik", targetNamespace = "http://Webservice/", className = "Webservice.GetBereichsStatistik")
    @ResponseWrapper(localName = "getBereichsStatistikResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetBereichsStatistikResponse")
    @Action(input = "http://Webservice/Webservice/getBereichsStatistikRequest", output = "http://Webservice/Webservice/getBereichsStatistikResponse")
    public List<ComStatistik> getBereichsStatistik(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.ComStatistik>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBereichsStatistikJahr", targetNamespace = "http://Webservice/", className = "Webservice.GetBereichsStatistikJahr")
    @ResponseWrapper(localName = "getBereichsStatistikJahrResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetBereichsStatistikJahrResponse")
    @Action(input = "http://Webservice/Webservice/getBereichsStatistikJahrRequest", output = "http://Webservice/Webservice/getBereichsStatistikJahrResponse")
    public List<ComStatistik> getBereichsStatistikJahr(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.ComStatistik>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStrichartStatistik", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichartStatistik")
    @ResponseWrapper(localName = "getStrichartStatistikResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichartStatistikResponse")
    @Action(input = "http://Webservice/Webservice/getStrichartStatistikRequest", output = "http://Webservice/Webservice/getStrichartStatistikResponse")
    public List<ComStatistik> getStrichartStatistik(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.ComStatistik>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStrichartStatistikJahr", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichartStatistikJahr")
    @ResponseWrapper(localName = "getStrichartStatistikJahrResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichartStatistikJahrResponse")
    @Action(input = "http://Webservice/Webservice/getStrichartStatistikJahrRequest", output = "http://Webservice/Webservice/getStrichartStatistikJahrResponse")
    public List<ComStatistik> getStrichartStatistikJahr(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAktuellesJahr", targetNamespace = "http://Webservice/", className = "Webservice.GetAktuellesJahr")
    @ResponseWrapper(localName = "getAktuellesJahrResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetAktuellesJahrResponse")
    @Action(input = "http://Webservice/Webservice/getAktuellesJahrRequest", output = "http://Webservice/Webservice/getAktuellesJahrResponse")
    public int getAktuellesJahr();

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAktuelleKalendarwoche", targetNamespace = "http://Webservice/", className = "Webservice.GetAktuelleKalendarwoche")
    @ResponseWrapper(localName = "getAktuelleKalendarwocheResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetAktuelleKalendarwocheResponse")
    @Action(input = "http://Webservice/Webservice/getAktuelleKalendarwocheRequest", output = "http://Webservice/Webservice/getAktuelleKalendarwocheResponse")
    public int getAktuelleKalendarwoche();

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "dbZugriffBeenden", targetNamespace = "http://Webservice/", className = "Webservice.DbZugriffBeenden")
    @ResponseWrapper(localName = "dbZugriffBeendenResponse", targetNamespace = "http://Webservice/", className = "Webservice.DbZugriffBeendenResponse")
    @Action(input = "http://Webservice/Webservice/dbZugriffBeendenRequest", output = "http://Webservice/Webservice/dbZugriffBeendenResponse")
    public void dbZugriffBeenden();

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "stricheln", targetNamespace = "http://Webservice/", className = "Webservice.Stricheln")
    @ResponseWrapper(localName = "strichelnResponse", targetNamespace = "http://Webservice/", className = "Webservice.StrichelnResponse")
    @Action(input = "http://Webservice/Webservice/strichelnRequest", output = "http://Webservice/Webservice/strichelnResponse")
    public boolean stricheln(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        boolean arg4);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://Webservice/", className = "Webservice.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://Webservice/", className = "Webservice.LoginResponse")
    @Action(input = "http://Webservice/Webservice/loginRequest", output = "http://Webservice/Webservice/loginResponse")
    public int login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.ComBenutzer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBenutzer", targetNamespace = "http://Webservice/", className = "Webservice.GetBenutzer")
    @ResponseWrapper(localName = "getBenutzerResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetBenutzerResponse")
    @Action(input = "http://Webservice/Webservice/getBenutzerRequest", output = "http://Webservice/Webservice/getBenutzerResponse")
    public List<ComBenutzer> getBenutzer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.Integer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "anzeige", targetNamespace = "http://Webservice/", className = "Webservice.Anzeige")
    @ResponseWrapper(localName = "anzeigeResponse", targetNamespace = "http://Webservice/", className = "Webservice.AnzeigeResponse")
    @Action(input = "http://Webservice/Webservice/anzeigeRequest", output = "http://Webservice/Webservice/anzeigeResponse")
    public List<Integer> anzeige(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAlleMoeglichenOrgaEinheitTypen", targetNamespace = "http://Webservice/", className = "Webservice.GetAlleMoeglichenOrgaEinheitTypen")
    @ResponseWrapper(localName = "getAlleMoeglichenOrgaEinheitTypenResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetAlleMoeglichenOrgaEinheitTypenResponse")
    @Action(input = "http://Webservice/Webservice/getAlleMoeglichenOrgaEinheitTypenRequest", output = "http://Webservice/Webservice/getAlleMoeglichenOrgaEinheitTypenResponse")
    public List<String> getAlleMoeglichenOrgaEinheitTypen(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAlleOrgaEinheitenBezeichnungenVomTyp", targetNamespace = "http://Webservice/", className = "Webservice.GetAlleOrgaEinheitenBezeichnungenVomTyp")
    @ResponseWrapper(localName = "getAlleOrgaEinheitenBezeichnungenVomTypResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetAlleOrgaEinheitenBezeichnungenVomTypResponse")
    @Action(input = "http://Webservice/Webservice/getAlleOrgaEinheitenBezeichnungenVomTypRequest", output = "http://Webservice/Webservice/getAlleOrgaEinheitenBezeichnungenVomTypResponse")
    public List<String> getAlleOrgaEinheitenBezeichnungenVomTyp(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "orgaEinheitBezeichnungAendern", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitBezeichnungAendern")
    @ResponseWrapper(localName = "orgaEinheitBezeichnungAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitBezeichnungAendernResponse")
    @Action(input = "http://Webservice/Webservice/orgaEinheitBezeichnungAendernRequest", output = "http://Webservice/Webservice/orgaEinheitBezeichnungAendernResponse")
    public boolean orgaEinheitBezeichnungAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "orgaEinheitUeberOrgaEinheitAendern", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitUeberOrgaEinheitAendern")
    @ResponseWrapper(localName = "orgaEinheitUeberOrgaEinheitAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.OrgaEinheitUeberOrgaEinheitAendernResponse")
    @Action(input = "http://Webservice/Webservice/orgaEinheitUeberOrgaEinheitAendernRequest", output = "http://Webservice/Webservice/orgaEinheitUeberOrgaEinheitAendernResponse")
    public boolean orgaEinheitUeberOrgaEinheitAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "StrichelArtBezeichnungAendern")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "StrichelArtBezeichnungAendern", targetNamespace = "http://Webservice/", className = "Webservice.StrichelArtBezeichnungAendern")
    @ResponseWrapper(localName = "StrichelArtBezeichnungAendernResponse", targetNamespace = "http://Webservice/", className = "Webservice.StrichelArtBezeichnungAendernResponse")
    @Action(input = "http://Webservice/Webservice/StrichelArtBezeichnungAendernRequest", output = "http://Webservice/Webservice/StrichelArtBezeichnungAendernResponse")
    public boolean strichelArtBezeichnungAendern(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "gibtEsStrichelBezeichnungSchon", targetNamespace = "http://Webservice/", className = "Webservice.GibtEsStrichelBezeichnungSchon")
    @ResponseWrapper(localName = "gibtEsStrichelBezeichnungSchonResponse", targetNamespace = "http://Webservice/", className = "Webservice.GibtEsStrichelBezeichnungSchonResponse")
    @Action(input = "http://Webservice/Webservice/gibtEsStrichelBezeichnungSchonRequest", output = "http://Webservice/Webservice/gibtEsStrichelBezeichnungSchonResponse")
    public boolean gibtEsStrichelBezeichnungSchon(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

}
