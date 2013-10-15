
package Webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PasswortSperrenResponse_QNAME = new QName("http://Webservice/", "passwortSperrenResponse");
    private final static QName _GibtEsOrgaEinheitSchon_QNAME = new QName("http://Webservice/", "gibtEsOrgaEinheitSchon");
    private final static QName _OrgaEinheitErstellenResponse_QNAME = new QName("http://Webservice/", "OrgaEinheitErstellenResponse");
    private final static QName _BenutzerLoeschenResponse_QNAME = new QName("http://Webservice/", "benutzerLoeschenResponse");
    private final static QName _GetBenutzerResponse_QNAME = new QName("http://Webservice/", "getBenutzerResponse");
    private final static QName _GetStrichelArten_QNAME = new QName("http://Webservice/", "getStrichelArten");
    private final static QName _GetAlleBerechtigungen_QNAME = new QName("http://Webservice/", "getAlleBerechtigungen");
    private final static QName _GibtEsOrgaEinheitSchonResponse_QNAME = new QName("http://Webservice/", "gibtEsOrgaEinheitSchonResponse");
    private final static QName _NeueStrichelart_QNAME = new QName("http://Webservice/", "neueStrichelart");
    private final static QName _Login_QNAME = new QName("http://Webservice/", "login");
    private final static QName _AnzeigeResponse_QNAME = new QName("http://Webservice/", "anzeigeResponse");
    private final static QName _GetBenutzer_QNAME = new QName("http://Webservice/", "getBenutzer");
    private final static QName _GetAlleBerechtigungenResponse_QNAME = new QName("http://Webservice/", "getAlleBerechtigungenResponse");
    private final static QName _BenutzerErstellen_QNAME = new QName("http://Webservice/", "benutzerErstellen");
    private final static QName _BenutzerLoeschen_QNAME = new QName("http://Webservice/", "benutzerLoeschen");
    private final static QName _NeuesPasswortSetzen_QNAME = new QName("http://Webservice/", "neuesPasswortSetzen");
    private final static QName _GibtesBenutzerschonResponse_QNAME = new QName("http://Webservice/", "gibtesBenutzerschonResponse");
    private final static QName _Anzeige_QNAME = new QName("http://Webservice/", "anzeige");
    private final static QName _GibtEsStrichelBezeichnungSchonResponse_QNAME = new QName("http://Webservice/", "gibtEsStrichelBezeichnungSchonResponse");
    private final static QName _GibtesBenutzerschon_QNAME = new QName("http://Webservice/", "gibtesBenutzerschon");
    private final static QName _Stricheln_QNAME = new QName("http://Webservice/", "stricheln");
    private final static QName _BenutzernameAendern_QNAME = new QName("http://Webservice/", "benutzernameAendern");
    private final static QName _BenutzerErstellenResponse_QNAME = new QName("http://Webservice/", "benutzerErstellenResponse");
    private final static QName _GetStatistik_QNAME = new QName("http://Webservice/", "getStatistik");
    private final static QName _BenutzernameAendernResponse_QNAME = new QName("http://Webservice/", "benutzernameAendernResponse");
    private final static QName _OrgaEinheitErstellen_QNAME = new QName("http://Webservice/", "OrgaEinheitErstellen");
    private final static QName _StrichelArtBezeichnungAendernResponse_QNAME = new QName("http://Webservice/", "StrichelArtBezeichnungAendernResponse");
    private final static QName _StrichelArtBezeichnungAendern_QNAME = new QName("http://Webservice/", "StrichelArtBezeichnungAendern");
    private final static QName _GetOrgaEinheitenResponse_QNAME = new QName("http://Webservice/", "getOrgaEinheitenResponse");
    private final static QName _GetStatistikResponse_QNAME = new QName("http://Webservice/", "getStatistikResponse");
    private final static QName _GetStrichelArtenResponse_QNAME = new QName("http://Webservice/", "getStrichelArtenResponse");
    private final static QName _GibtEsStrichelBezeichnungSchon_QNAME = new QName("http://Webservice/", "gibtEsStrichelBezeichnungSchon");
    private final static QName _LoginResponse_QNAME = new QName("http://Webservice/", "loginResponse");
    private final static QName _StrichelnResponse_QNAME = new QName("http://Webservice/", "strichelnResponse");
    private final static QName _NeueStrichelartResponse_QNAME = new QName("http://Webservice/", "neueStrichelartResponse");
    private final static QName _PasswortSperren_QNAME = new QName("http://Webservice/", "passwortSperren");
    private final static QName _BenutzerOrgaEinheitAendernResponse_QNAME = new QName("http://Webservice/", "benutzerOrgaEinheitAendernResponse");
    private final static QName _GetOrgaEinheiten_QNAME = new QName("http://Webservice/", "getOrgaEinheiten");
    private final static QName _BenutzerOrgaEinheitAendern_QNAME = new QName("http://Webservice/", "benutzerOrgaEinheitAendern");
    private final static QName _NeuesPasswortSetzenResponse_QNAME = new QName("http://Webservice/", "neuesPasswortSetzenResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BenutzerLoeschen }
     * 
     */
    public BenutzerLoeschen createBenutzerLoeschen() {
        return new BenutzerLoeschen();
    }

    /**
     * Create an instance of {@link BenutzerErstellen }
     * 
     */
    public BenutzerErstellen createBenutzerErstellen() {
        return new BenutzerErstellen();
    }

    /**
     * Create an instance of {@link GetAlleBerechtigungenResponse }
     * 
     */
    public GetAlleBerechtigungenResponse createGetAlleBerechtigungenResponse() {
        return new GetAlleBerechtigungenResponse();
    }

    /**
     * Create an instance of {@link NeuesPasswortSetzen }
     * 
     */
    public NeuesPasswortSetzen createNeuesPasswortSetzen() {
        return new NeuesPasswortSetzen();
    }

    /**
     * Create an instance of {@link BenutzernameAendern }
     * 
     */
    public BenutzernameAendern createBenutzernameAendern() {
        return new BenutzernameAendern();
    }

    /**
     * Create an instance of {@link GibtesBenutzerschonResponse }
     * 
     */
    public GibtesBenutzerschonResponse createGibtesBenutzerschonResponse() {
        return new GibtesBenutzerschonResponse();
    }

    /**
     * Create an instance of {@link Stricheln }
     * 
     */
    public Stricheln createStricheln() {
        return new Stricheln();
    }

    /**
     * Create an instance of {@link GibtesBenutzerschon }
     * 
     */
    public GibtesBenutzerschon createGibtesBenutzerschon() {
        return new GibtesBenutzerschon();
    }

    /**
     * Create an instance of {@link GibtEsStrichelBezeichnungSchonResponse }
     * 
     */
    public GibtEsStrichelBezeichnungSchonResponse createGibtEsStrichelBezeichnungSchonResponse() {
        return new GibtEsStrichelBezeichnungSchonResponse();
    }

    /**
     * Create an instance of {@link Anzeige }
     * 
     */
    public Anzeige createAnzeige() {
        return new Anzeige();
    }

    /**
     * Create an instance of {@link OrgaEinheitErstellenResponse }
     * 
     */
    public OrgaEinheitErstellenResponse createOrgaEinheitErstellenResponse() {
        return new OrgaEinheitErstellenResponse();
    }

    /**
     * Create an instance of {@link BenutzerLoeschenResponse }
     * 
     */
    public BenutzerLoeschenResponse createBenutzerLoeschenResponse() {
        return new BenutzerLoeschenResponse();
    }

    /**
     * Create an instance of {@link GetBenutzerResponse }
     * 
     */
    public GetBenutzerResponse createGetBenutzerResponse() {
        return new GetBenutzerResponse();
    }

    /**
     * Create an instance of {@link GetStrichelArten }
     * 
     */
    public GetStrichelArten createGetStrichelArten() {
        return new GetStrichelArten();
    }

    /**
     * Create an instance of {@link PasswortSperrenResponse }
     * 
     */
    public PasswortSperrenResponse createPasswortSperrenResponse() {
        return new PasswortSperrenResponse();
    }

    /**
     * Create an instance of {@link GibtEsOrgaEinheitSchon }
     * 
     */
    public GibtEsOrgaEinheitSchon createGibtEsOrgaEinheitSchon() {
        return new GibtEsOrgaEinheitSchon();
    }

    /**
     * Create an instance of {@link NeueStrichelart }
     * 
     */
    public NeueStrichelart createNeueStrichelart() {
        return new NeueStrichelart();
    }

    /**
     * Create an instance of {@link GetAlleBerechtigungen }
     * 
     */
    public GetAlleBerechtigungen createGetAlleBerechtigungen() {
        return new GetAlleBerechtigungen();
    }

    /**
     * Create an instance of {@link GibtEsOrgaEinheitSchonResponse }
     * 
     */
    public GibtEsOrgaEinheitSchonResponse createGibtEsOrgaEinheitSchonResponse() {
        return new GibtEsOrgaEinheitSchonResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link AnzeigeResponse }
     * 
     */
    public AnzeigeResponse createAnzeigeResponse() {
        return new AnzeigeResponse();
    }

    /**
     * Create an instance of {@link GetBenutzer }
     * 
     */
    public GetBenutzer createGetBenutzer() {
        return new GetBenutzer();
    }

    /**
     * Create an instance of {@link GetOrgaEinheitenResponse }
     * 
     */
    public GetOrgaEinheitenResponse createGetOrgaEinheitenResponse() {
        return new GetOrgaEinheitenResponse();
    }

    /**
     * Create an instance of {@link StrichelnResponse }
     * 
     */
    public StrichelnResponse createStrichelnResponse() {
        return new StrichelnResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GibtEsStrichelBezeichnungSchon }
     * 
     */
    public GibtEsStrichelBezeichnungSchon createGibtEsStrichelBezeichnungSchon() {
        return new GibtEsStrichelBezeichnungSchon();
    }

    /**
     * Create an instance of {@link GetStrichelArtenResponse }
     * 
     */
    public GetStrichelArtenResponse createGetStrichelArtenResponse() {
        return new GetStrichelArtenResponse();
    }

    /**
     * Create an instance of {@link GetStatistikResponse }
     * 
     */
    public GetStatistikResponse createGetStatistikResponse() {
        return new GetStatistikResponse();
    }

    /**
     * Create an instance of {@link BenutzerOrgaEinheitAendernResponse }
     * 
     */
    public BenutzerOrgaEinheitAendernResponse createBenutzerOrgaEinheitAendernResponse() {
        return new BenutzerOrgaEinheitAendernResponse();
    }

    /**
     * Create an instance of {@link PasswortSperren }
     * 
     */
    public PasswortSperren createPasswortSperren() {
        return new PasswortSperren();
    }

    /**
     * Create an instance of {@link NeueStrichelartResponse }
     * 
     */
    public NeueStrichelartResponse createNeueStrichelartResponse() {
        return new NeueStrichelartResponse();
    }

    /**
     * Create an instance of {@link BenutzerOrgaEinheitAendern }
     * 
     */
    public BenutzerOrgaEinheitAendern createBenutzerOrgaEinheitAendern() {
        return new BenutzerOrgaEinheitAendern();
    }

    /**
     * Create an instance of {@link NeuesPasswortSetzenResponse }
     * 
     */
    public NeuesPasswortSetzenResponse createNeuesPasswortSetzenResponse() {
        return new NeuesPasswortSetzenResponse();
    }

    /**
     * Create an instance of {@link GetOrgaEinheiten }
     * 
     */
    public GetOrgaEinheiten createGetOrgaEinheiten() {
        return new GetOrgaEinheiten();
    }

    /**
     * Create an instance of {@link GetStatistik }
     * 
     */
    public GetStatistik createGetStatistik() {
        return new GetStatistik();
    }

    /**
     * Create an instance of {@link BenutzerErstellenResponse }
     * 
     */
    public BenutzerErstellenResponse createBenutzerErstellenResponse() {
        return new BenutzerErstellenResponse();
    }

    /**
     * Create an instance of {@link StrichelArtBezeichnungAendernResponse }
     * 
     */
    public StrichelArtBezeichnungAendernResponse createStrichelArtBezeichnungAendernResponse() {
        return new StrichelArtBezeichnungAendernResponse();
    }

    /**
     * Create an instance of {@link OrgaEinheitErstellen }
     * 
     */
    public OrgaEinheitErstellen createOrgaEinheitErstellen() {
        return new OrgaEinheitErstellen();
    }

    /**
     * Create an instance of {@link BenutzernameAendernResponse }
     * 
     */
    public BenutzernameAendernResponse createBenutzernameAendernResponse() {
        return new BenutzernameAendernResponse();
    }

    /**
     * Create an instance of {@link StrichelArtBezeichnungAendern }
     * 
     */
    public StrichelArtBezeichnungAendern createStrichelArtBezeichnungAendern() {
        return new StrichelArtBezeichnungAendern();
    }

    /**
     * Create an instance of {@link ComBerechtigung }
     * 
     */
    public ComBerechtigung createComBerechtigung() {
        return new ComBerechtigung();
    }

    /**
     * Create an instance of {@link ComStatistik }
     * 
     */
    public ComStatistik createComStatistik() {
        return new ComStatistik();
    }

    /**
     * Create an instance of {@link ComBenutzer }
     * 
     */
    public ComBenutzer createComBenutzer() {
        return new ComBenutzer();
    }

    /**
     * Create an instance of {@link ComStrichart }
     * 
     */
    public ComStrichart createComStrichart() {
        return new ComStrichart();
    }

    /**
     * Create an instance of {@link ComOrgaEinheit }
     * 
     */
    public ComOrgaEinheit createComOrgaEinheit() {
        return new ComOrgaEinheit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswortSperrenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "passwortSperrenResponse")
    public JAXBElement<PasswortSperrenResponse> createPasswortSperrenResponse(PasswortSperrenResponse value) {
        return new JAXBElement<PasswortSperrenResponse>(_PasswortSperrenResponse_QNAME, PasswortSperrenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GibtEsOrgaEinheitSchon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "gibtEsOrgaEinheitSchon")
    public JAXBElement<GibtEsOrgaEinheitSchon> createGibtEsOrgaEinheitSchon(GibtEsOrgaEinheitSchon value) {
        return new JAXBElement<GibtEsOrgaEinheitSchon>(_GibtEsOrgaEinheitSchon_QNAME, GibtEsOrgaEinheitSchon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrgaEinheitErstellenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "OrgaEinheitErstellenResponse")
    public JAXBElement<OrgaEinheitErstellenResponse> createOrgaEinheitErstellenResponse(OrgaEinheitErstellenResponse value) {
        return new JAXBElement<OrgaEinheitErstellenResponse>(_OrgaEinheitErstellenResponse_QNAME, OrgaEinheitErstellenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerLoeschenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzerLoeschenResponse")
    public JAXBElement<BenutzerLoeschenResponse> createBenutzerLoeschenResponse(BenutzerLoeschenResponse value) {
        return new JAXBElement<BenutzerLoeschenResponse>(_BenutzerLoeschenResponse_QNAME, BenutzerLoeschenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getBenutzerResponse")
    public JAXBElement<GetBenutzerResponse> createGetBenutzerResponse(GetBenutzerResponse value) {
        return new JAXBElement<GetBenutzerResponse>(_GetBenutzerResponse_QNAME, GetBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStrichelArten }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStrichelArten")
    public JAXBElement<GetStrichelArten> createGetStrichelArten(GetStrichelArten value) {
        return new JAXBElement<GetStrichelArten>(_GetStrichelArten_QNAME, GetStrichelArten.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlleBerechtigungen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getAlleBerechtigungen")
    public JAXBElement<GetAlleBerechtigungen> createGetAlleBerechtigungen(GetAlleBerechtigungen value) {
        return new JAXBElement<GetAlleBerechtigungen>(_GetAlleBerechtigungen_QNAME, GetAlleBerechtigungen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GibtEsOrgaEinheitSchonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "gibtEsOrgaEinheitSchonResponse")
    public JAXBElement<GibtEsOrgaEinheitSchonResponse> createGibtEsOrgaEinheitSchonResponse(GibtEsOrgaEinheitSchonResponse value) {
        return new JAXBElement<GibtEsOrgaEinheitSchonResponse>(_GibtEsOrgaEinheitSchonResponse_QNAME, GibtEsOrgaEinheitSchonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NeueStrichelart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "neueStrichelart")
    public JAXBElement<NeueStrichelart> createNeueStrichelart(NeueStrichelart value) {
        return new JAXBElement<NeueStrichelart>(_NeueStrichelart_QNAME, NeueStrichelart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnzeigeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "anzeigeResponse")
    public JAXBElement<AnzeigeResponse> createAnzeigeResponse(AnzeigeResponse value) {
        return new JAXBElement<AnzeigeResponse>(_AnzeigeResponse_QNAME, AnzeigeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getBenutzer")
    public JAXBElement<GetBenutzer> createGetBenutzer(GetBenutzer value) {
        return new JAXBElement<GetBenutzer>(_GetBenutzer_QNAME, GetBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlleBerechtigungenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getAlleBerechtigungenResponse")
    public JAXBElement<GetAlleBerechtigungenResponse> createGetAlleBerechtigungenResponse(GetAlleBerechtigungenResponse value) {
        return new JAXBElement<GetAlleBerechtigungenResponse>(_GetAlleBerechtigungenResponse_QNAME, GetAlleBerechtigungenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerErstellen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzerErstellen")
    public JAXBElement<BenutzerErstellen> createBenutzerErstellen(BenutzerErstellen value) {
        return new JAXBElement<BenutzerErstellen>(_BenutzerErstellen_QNAME, BenutzerErstellen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerLoeschen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzerLoeschen")
    public JAXBElement<BenutzerLoeschen> createBenutzerLoeschen(BenutzerLoeschen value) {
        return new JAXBElement<BenutzerLoeschen>(_BenutzerLoeschen_QNAME, BenutzerLoeschen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NeuesPasswortSetzen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "neuesPasswortSetzen")
    public JAXBElement<NeuesPasswortSetzen> createNeuesPasswortSetzen(NeuesPasswortSetzen value) {
        return new JAXBElement<NeuesPasswortSetzen>(_NeuesPasswortSetzen_QNAME, NeuesPasswortSetzen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GibtesBenutzerschonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "gibtesBenutzerschonResponse")
    public JAXBElement<GibtesBenutzerschonResponse> createGibtesBenutzerschonResponse(GibtesBenutzerschonResponse value) {
        return new JAXBElement<GibtesBenutzerschonResponse>(_GibtesBenutzerschonResponse_QNAME, GibtesBenutzerschonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Anzeige }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "anzeige")
    public JAXBElement<Anzeige> createAnzeige(Anzeige value) {
        return new JAXBElement<Anzeige>(_Anzeige_QNAME, Anzeige.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GibtEsStrichelBezeichnungSchonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "gibtEsStrichelBezeichnungSchonResponse")
    public JAXBElement<GibtEsStrichelBezeichnungSchonResponse> createGibtEsStrichelBezeichnungSchonResponse(GibtEsStrichelBezeichnungSchonResponse value) {
        return new JAXBElement<GibtEsStrichelBezeichnungSchonResponse>(_GibtEsStrichelBezeichnungSchonResponse_QNAME, GibtEsStrichelBezeichnungSchonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GibtesBenutzerschon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "gibtesBenutzerschon")
    public JAXBElement<GibtesBenutzerschon> createGibtesBenutzerschon(GibtesBenutzerschon value) {
        return new JAXBElement<GibtesBenutzerschon>(_GibtesBenutzerschon_QNAME, GibtesBenutzerschon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stricheln }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "stricheln")
    public JAXBElement<Stricheln> createStricheln(Stricheln value) {
        return new JAXBElement<Stricheln>(_Stricheln_QNAME, Stricheln.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzernameAendern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzernameAendern")
    public JAXBElement<BenutzernameAendern> createBenutzernameAendern(BenutzernameAendern value) {
        return new JAXBElement<BenutzernameAendern>(_BenutzernameAendern_QNAME, BenutzernameAendern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerErstellenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzerErstellenResponse")
    public JAXBElement<BenutzerErstellenResponse> createBenutzerErstellenResponse(BenutzerErstellenResponse value) {
        return new JAXBElement<BenutzerErstellenResponse>(_BenutzerErstellenResponse_QNAME, BenutzerErstellenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatistik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStatistik")
    public JAXBElement<GetStatistik> createGetStatistik(GetStatistik value) {
        return new JAXBElement<GetStatistik>(_GetStatistik_QNAME, GetStatistik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzernameAendernResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzernameAendernResponse")
    public JAXBElement<BenutzernameAendernResponse> createBenutzernameAendernResponse(BenutzernameAendernResponse value) {
        return new JAXBElement<BenutzernameAendernResponse>(_BenutzernameAendernResponse_QNAME, BenutzernameAendernResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrgaEinheitErstellen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "OrgaEinheitErstellen")
    public JAXBElement<OrgaEinheitErstellen> createOrgaEinheitErstellen(OrgaEinheitErstellen value) {
        return new JAXBElement<OrgaEinheitErstellen>(_OrgaEinheitErstellen_QNAME, OrgaEinheitErstellen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StrichelArtBezeichnungAendernResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "StrichelArtBezeichnungAendernResponse")
    public JAXBElement<StrichelArtBezeichnungAendernResponse> createStrichelArtBezeichnungAendernResponse(StrichelArtBezeichnungAendernResponse value) {
        return new JAXBElement<StrichelArtBezeichnungAendernResponse>(_StrichelArtBezeichnungAendernResponse_QNAME, StrichelArtBezeichnungAendernResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StrichelArtBezeichnungAendern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "StrichelArtBezeichnungAendern")
    public JAXBElement<StrichelArtBezeichnungAendern> createStrichelArtBezeichnungAendern(StrichelArtBezeichnungAendern value) {
        return new JAXBElement<StrichelArtBezeichnungAendern>(_StrichelArtBezeichnungAendern_QNAME, StrichelArtBezeichnungAendern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrgaEinheitenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getOrgaEinheitenResponse")
    public JAXBElement<GetOrgaEinheitenResponse> createGetOrgaEinheitenResponse(GetOrgaEinheitenResponse value) {
        return new JAXBElement<GetOrgaEinheitenResponse>(_GetOrgaEinheitenResponse_QNAME, GetOrgaEinheitenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatistikResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStatistikResponse")
    public JAXBElement<GetStatistikResponse> createGetStatistikResponse(GetStatistikResponse value) {
        return new JAXBElement<GetStatistikResponse>(_GetStatistikResponse_QNAME, GetStatistikResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStrichelArtenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStrichelArtenResponse")
    public JAXBElement<GetStrichelArtenResponse> createGetStrichelArtenResponse(GetStrichelArtenResponse value) {
        return new JAXBElement<GetStrichelArtenResponse>(_GetStrichelArtenResponse_QNAME, GetStrichelArtenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GibtEsStrichelBezeichnungSchon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "gibtEsStrichelBezeichnungSchon")
    public JAXBElement<GibtEsStrichelBezeichnungSchon> createGibtEsStrichelBezeichnungSchon(GibtEsStrichelBezeichnungSchon value) {
        return new JAXBElement<GibtEsStrichelBezeichnungSchon>(_GibtEsStrichelBezeichnungSchon_QNAME, GibtEsStrichelBezeichnungSchon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StrichelnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "strichelnResponse")
    public JAXBElement<StrichelnResponse> createStrichelnResponse(StrichelnResponse value) {
        return new JAXBElement<StrichelnResponse>(_StrichelnResponse_QNAME, StrichelnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NeueStrichelartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "neueStrichelartResponse")
    public JAXBElement<NeueStrichelartResponse> createNeueStrichelartResponse(NeueStrichelartResponse value) {
        return new JAXBElement<NeueStrichelartResponse>(_NeueStrichelartResponse_QNAME, NeueStrichelartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswortSperren }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "passwortSperren")
    public JAXBElement<PasswortSperren> createPasswortSperren(PasswortSperren value) {
        return new JAXBElement<PasswortSperren>(_PasswortSperren_QNAME, PasswortSperren.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerOrgaEinheitAendernResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzerOrgaEinheitAendernResponse")
    public JAXBElement<BenutzerOrgaEinheitAendernResponse> createBenutzerOrgaEinheitAendernResponse(BenutzerOrgaEinheitAendernResponse value) {
        return new JAXBElement<BenutzerOrgaEinheitAendernResponse>(_BenutzerOrgaEinheitAendernResponse_QNAME, BenutzerOrgaEinheitAendernResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrgaEinheiten }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getOrgaEinheiten")
    public JAXBElement<GetOrgaEinheiten> createGetOrgaEinheiten(GetOrgaEinheiten value) {
        return new JAXBElement<GetOrgaEinheiten>(_GetOrgaEinheiten_QNAME, GetOrgaEinheiten.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerOrgaEinheitAendern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "benutzerOrgaEinheitAendern")
    public JAXBElement<BenutzerOrgaEinheitAendern> createBenutzerOrgaEinheitAendern(BenutzerOrgaEinheitAendern value) {
        return new JAXBElement<BenutzerOrgaEinheitAendern>(_BenutzerOrgaEinheitAendern_QNAME, BenutzerOrgaEinheitAendern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NeuesPasswortSetzenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "neuesPasswortSetzenResponse")
    public JAXBElement<NeuesPasswortSetzenResponse> createNeuesPasswortSetzenResponse(NeuesPasswortSetzenResponse value) {
        return new JAXBElement<NeuesPasswortSetzenResponse>(_NeuesPasswortSetzenResponse_QNAME, NeuesPasswortSetzenResponse.class, null, value);
    }

}
