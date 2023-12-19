package xml.ubl.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xml.ubl.attributes.PatternScheme;
import xml.ubl.axioms.ElementT;
import xml.ubl.data.ElementsName;
import xml.ubl.elements.ID;
import xml.ubl.elements.Percent;


public class ClassifiedTaxCategory {
	  private Document doc;
	    private Element element;
	    private ID id;
	    private Percent percent;
	    private TaxScheme taxScheme;

	    private ClassifiedTaxCategory(ClassifiedTaxCategoryBuilder builder) {
	        this.doc = builder.doc;
	        this.element = builder.element;
	        this.id = builder.id;
	        this.percent = builder.percent;
	        this.taxScheme = builder.taxScheme;
	    }

	    /**
	     * Builder Contact
	     */
	    public static class ClassifiedTaxCategoryBuilder {

	        private Document doc;
	        private Element element;
	        private ID id;
	        private Percent percent;
	        private TaxScheme taxScheme;

	        public ClassifiedTaxCategoryBuilder() {}

	        public ClassifiedTaxCategoryBuilder documentLinked(Document doc){
	            this.doc = doc;
	            return this;
	        }
	        public ClassifiedTaxCategoryBuilder elementFather(Element element){
	            this.element = element;
	            return this;
	        }
	        public ClassifiedTaxCategoryBuilder id(ID id){
	            this.id = id;
	            return this;
	        }
	        public ClassifiedTaxCategoryBuilder percent(Percent percent){
	            this.percent = percent;
	            return this;
	        }
	        public ClassifiedTaxCategoryBuilder taxScheme(TaxScheme taxScheme){
	            this.taxScheme = taxScheme;
	            return this;
	        }
	        public ClassifiedTaxCategory build(){
	        	ClassifiedTaxCategory classifiedTaxCategory = new ClassifiedTaxCategory(this);
	            return classifiedTaxCategory;
	        }

	    }

	    public ID getId() {
	        return id;
	    }

	    public Percent getPercent() {
	        return percent;
	    }

	    public TaxScheme getTaxScheme() {
	        return taxScheme;
	    }

	    /**
	     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
	     * @return the generated element
	     */
	    public Element load() {
	        Element elementTaxCategory = new ElementT(doc, element, ElementsName.CLASSIFIED_TAX_CATEGORY.label).load();
	        if(!(id == null)){
	            if(!(id.getPatternScheme() == null)){
	                Element elementId = new ID.IDBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementTaxCategory)
	                        .value(id.getValue())
	                        .attributes(new PatternScheme.PatternSchemeBuilder()
	                                .schemeID(id.getPatternScheme().getSchemeID())
	                                .schemeName(id.getPatternScheme().getSchemeName())
	                                .schemeAgencyID(id.getPatternScheme().getSchemeAgencyID())
	                                .schemeAgencyName(id.getPatternScheme().getSchemeAgencyName())
	                                .schemeVersionID(id.getPatternScheme().getSchemeVersionID())
	                                .schemeDataURI(id.getPatternScheme().getSchemeDataURI())
	                                .schemeURI(id.getPatternScheme().getSchemeURI())
	                                .build())
	                        .build().load();
	            } else {
	                Element elementId = new ID.IDBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementTaxCategory)
	                        .value(id.getValue())
	                        .build().load();
	            }
	        }
	        if(!(percent == null)){
	            Element elementPercent = new Percent.PercentBuilder()
	                    .documentLinked(doc)
	                    .elementFather(elementTaxCategory)
	                    .value(percent.getValue())
	                    .build().load();
	        }
	        if(!(taxScheme == null)){
	            Element elementTaxScheme = new TaxScheme.TaxSchemeBuilder()
	                    .documentLinked(doc)
	                    .elementFather(elementTaxCategory)
	                    .id(taxScheme.getId())
	                    .name(taxScheme.getName())
	                    .build().load();
	        }
	        return elementTaxCategory;
	    }

}
