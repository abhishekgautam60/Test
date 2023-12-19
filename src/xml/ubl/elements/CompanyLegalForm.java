package xml.ubl.elements;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xml.ubl.attributes.PatternLanguage;
import xml.ubl.axioms.AttributeT;
import xml.ubl.axioms.ElementT;
import xml.ubl.axioms.Tips;
import xml.ubl.data.AttributesName;
import xml.ubl.data.ElementsName;


public class CompanyLegalForm {

	 private Document doc;
	    private Element element;
	    private String name = ElementsName.COMPANYLEGAL_FORM.label;
	    private String value;
	    private PatternLanguage patternLanguage;

	    /**
	     * <h2>Element "RegistrationName"</h2>
	     * <p>The name of a party as registered with the legal authority. Contains :</p>
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
	     *         <li>[PatternLanguage] <b>patternLanguage</b> <b>[0..1]</b> : Attributes available for this element.</li>
	     *     </ul>
	     *     </li>
	     * </ul>
	     */
	    private CompanyLegalForm(CompanyLegalFormBuilder builder) {
	        this.doc = builder.doc;
	        this.element = builder.element;
	        this.value = builder.value;
	        this.patternLanguage = builder.patternLanguage;
	    }

	    /**
	     * Builder RegistrationName
	     */
	    public static class CompanyLegalFormBuilder {

	        private Document doc;
	        private Element element;
	        private String value;
	        private PatternLanguage patternLanguage;

	        public CompanyLegalFormBuilder() {}

	        public CompanyLegalFormBuilder documentLinked(Document doc){
	            this.doc = doc;
	            return this;
	        }
	        public CompanyLegalFormBuilder elementFather(Element element){
	            this.element = element;
	            return this;
	        }
	        public CompanyLegalFormBuilder value(String value){
	            this.value = value;
	            return this;
	        }
	        public CompanyLegalFormBuilder attributes(PatternLanguage patternLanguage){
	            this.patternLanguage = patternLanguage;
	            return this;
	        }
	        public CompanyLegalForm build(){
	        	CompanyLegalForm companyLegalForm = new CompanyLegalForm(this);
	            return companyLegalForm;
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
	                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.LANGUAGE_ID.label, patternLanguage.getLanguageID()).load();
	            }
	        }
	        return elementRoot;
	    }

}
