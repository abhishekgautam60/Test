package xml.ubl.elements;

import xml.ubl.attributes.PatternLanguage;
import xml.ubl.attributes.PatternList;
import xml.ubl.attributes.PatternScheme;
import xml.ubl.axioms.AttributeT;
import xml.ubl.axioms.ElementT;
import xml.ubl.axioms.Tips;
import xml.ubl.data.AttributesName;
import xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class DocumentCurrencyCode
 */
public class DocumentCurrencyCode {

    private Document doc;
    private Element element;
    private String name = ElementsName.DOCUMENTCURRENCY_CODE.label;
    private String value;
    private PatternLanguage patternLanguage;

    /**
     * <h2>Element "DocumentCurrencyCode"</h2>
     * <p>The default currency for the Credit Note. Contains :</p>
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
     *         <li>[PatternList] <b>patternList</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private DocumentCurrencyCode(DocumentCurrencyCodeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternLanguage = builder.patternLanguage;
    }

    /**
     * Builder DocumentCurrencyCode
     */
    public static class DocumentCurrencyCodeBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternLanguage patternLanguage;

        public DocumentCurrencyCodeBuilder() {}

        public DocumentCurrencyCodeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public DocumentCurrencyCodeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public DocumentCurrencyCodeBuilder value(String value){
            this.value = value;
            return this;
        }
        public DocumentCurrencyCodeBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        public DocumentCurrencyCode build(){
            DocumentCurrencyCode element = new DocumentCurrencyCode(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternLanguage getPatternLanguage() {
        return patternLanguage;
    }
    
    public boolean isNull() {
        if(Tips.stringIsNull(value)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!(patternLanguage == null)){
            if(!(patternLanguage.getLanguageID() == null)){
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.DOCUMENTCURRENCY_CODE.label, patternLanguage.getLanguageID()).load();
            }
        }
        return elementRoot;
    }

}
