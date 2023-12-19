package xml.ubl.elements;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xml.ubl.attributes.PatternLanguage;
import xml.ubl.axioms.AttributeT;
import xml.ubl.axioms.ElementT;
import xml.ubl.data.AttributesName;
import xml.ubl.data.ElementsName;
import xml.ubl.elements.ZipCode.ZipCodeBuilder;

public class CountryCode {
	private Document doc;
    private Element element;
    private String name = ElementsName.COUNTRY_CODE.label;
    private String value;
    private PatternLanguage patternLanguage;

    /**
     * <h2>Element "IssueDate"</h2>
     * <p>The date assigned by the Creditor on which the Credit Note was issued. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>value</b> <b>[1..1]</b> : Value for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private CountryCode(CountryCodeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.patternLanguage = builder.patternLanguage;
        this.value = builder.value;

    }

    /**
     * Builder IssueDate
     */
    public static class CountryCodeBuilder {

        private Document doc;
        private Element element;
        private String name = ElementsName.COUNTRY_CODE.label;
        private String value;
        private PatternLanguage patternLanguage;

        public CountryCodeBuilder() {}

        public CountryCodeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CountryCodeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CountryCodeBuilder value(String value){
            this.value = value;
            return this;
        }
        public CountryCodeBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        
        public CountryCode build(){
        	CountryCode element = new CountryCode(this);
            return element;
        }

    }
    public PatternLanguage getPatternLanguage() {
        return patternLanguage;
    }

    public String getValue() {
        return value;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
    	Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!(patternLanguage == null)){
            if(!(patternLanguage.getLanguageID() == null)){
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.COUNTRY_CODE.label, patternLanguage.getLanguageID()).load();
            }
        }
		return elementRoot;
    }

}
