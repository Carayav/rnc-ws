package cl.minsal.api.types;

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.26 at 02:43:12 PM CLST 
//




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://uv.com/types/rnc}HeaderDoc"/&gt;
 *         &lt;element name="BodyDoc"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element ref="{http://uv.com/types/rnc}ResolucionTratamientoDoc"/&gt;
 *                   &lt;element ref="{http://uv.com/types/rnc}DiagnosticoDoc"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "headerDoc",
    "bodyDoc"
})
@XmlRootElement(name = "Documento")
public class Documento {

    @XmlElement(name = "HeaderDoc", required = true)
    protected HeaderDoc headerDoc;
    @XmlElement(name = "BodyDoc", required = true)
    protected Documento.BodyDoc bodyDoc;

    /**
     * Gets the value of the headerDoc property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderDoc }
     *     
     */
    public HeaderDoc getHeaderDoc() {
        return headerDoc;
    }

    /**
     * Sets the value of the headerDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderDoc }
     *     
     */
    public void setHeaderDoc(HeaderDoc value) {
        this.headerDoc = value;
    }

    /**
     * Gets the value of the bodyDoc property.
     * 
     * @return
     *     possible object is
     *     {@link Documento.BodyDoc }
     *     
     */
    public Documento.BodyDoc getBodyDoc() {
        return bodyDoc;
    }

    /**
     * Sets the value of the bodyDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Documento.BodyDoc }
     *     
     */
    public void setBodyDoc(Documento.BodyDoc value) {
        this.bodyDoc = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element ref="{http://uv.com/types/rnc}ResolucionTratamientoDoc"/&gt;
     *         &lt;element ref="{http://uv.com/types/rnc}DiagnosticoDoc"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "resolucionTratamientoDoc",
        "diagnosticoDoc"
    })
    public static class BodyDoc {

        @XmlElement(name = "ResolucionTratamientoDoc")
        protected ResolucionTratamientoDoc resolucionTratamientoDoc;
        @XmlElement(name = "DiagnosticoDoc")
        protected DiagnosticoDoc diagnosticoDoc;

        /**
         * Gets the value of the resolucionTratamientoDoc property.
         * 
         * @return
         *     possible object is
         *     {@link ResolucionTratamientoDoc }
         *     
         */
        public ResolucionTratamientoDoc getResolucionTratamientoDoc() {
            return resolucionTratamientoDoc;
        }

        /**
         * Sets the value of the resolucionTratamientoDoc property.
         * 
         * @param value
         *     allowed object is
         *     {@link ResolucionTratamientoDoc }
         *     
         */
        public void setResolucionTratamientoDoc(ResolucionTratamientoDoc value) {
            this.resolucionTratamientoDoc = value;
        }

        /**
         * Gets the value of the diagnosticoDoc property.
         * 
         * @return
         *     possible object is
         *     {@link DiagnosticoDoc }
         *     
         */
        public DiagnosticoDoc getDiagnosticoDoc() {
            return diagnosticoDoc;
        }

        /**
         * Sets the value of the diagnosticoDoc property.
         * 
         * @param value
         *     allowed object is
         *     {@link DiagnosticoDoc }
         *     
         */
        public void setDiagnosticoDoc(DiagnosticoDoc value) {
            this.diagnosticoDoc = value;
        }

    }

}