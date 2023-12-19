package xml.ubl.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xml.ubl.attributes.PatternLanguage;
import xml.ubl.axioms.ElementT;
import xml.ubl.data.ElementsName;
import xml.ubl.elements.AddressAndStreet;
import xml.ubl.elements.CityName;
import xml.ubl.elements.CountryZone;
import xml.ubl.elements.InvoicedQuantity;
import xml.ubl.elements.LineExtensionAmount;
import xml.ubl.elements.Name;
import xml.ubl.elements.ZipCode;
import xml.ubl.modules.CustomerAddress.CustomerAddressBuilder;



public class CurrencyCode {
	private Document doc;
	private Element element;
	private Name currencyName;
	
	
	private CurrencyCode(CurrencyCodeBuilder builder) {
	        this.doc = builder.doc;
	        this.element = builder.element;
	   
	        this.currencyName=builder.currencyName;
	       
	    }

	    /**
	     * Builder InvoiceLine
	     */
	public static class CurrencyCodeBuilder {

	        private Document doc;
	        private Element element;
	    	private Name currencyName;
	   
	       
	     

	        public CurrencyCodeBuilder() {}

	        public CurrencyCodeBuilder documentLinked(Document doc){
	            this.doc = doc;
	            return this;
	        }
	        public CurrencyCodeBuilder elementFather(Element element){
	            this.element = element;
	            return this;
	        }
	        public CurrencyCodeBuilder currencyName(Name currencyName){
	            this.currencyName = currencyName;
	            return this;
	        }
	       
	        
	        public CurrencyCode build(){
	        	CurrencyCode currencyCode = new CurrencyCode(this);
	            return currencyCode;
	        } 

	    }

	  
	    public Name currencyName() {
	        return currencyName;
	    }
	   

	    /**
	     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
	     * @return the generated element
	     */
	    public Element load() {
	        Element elementInvoiceLine = new ElementT(doc, element, ElementsName.CURRENCY_CODE.label).load();
	       
//	        if(!invoicedQuantity.isNull()){
//	            Element elementInvoicedQuantity = new InvoicedQuantity.InvoicedQuantityBuilder()
//	                    .documentLinked(doc)
//	                    .elementFather(elementInvoiceLine)
//	                    .value(invoicedQuantity.getValue())
//	                    .attributes(new PatternCode.PatternCodeBuilder()
//	                            .unitCode(invoicedQuantity.getPatternCode().getUnitCode())
//	                            .build())
//	                    .build().load();
//	        }
//	        if(!lineExtensionAmount.isNull()){
//	            Element elementLineExtensionAmount = new LineExtensionAmount.LineExtensionAmountBuilder()
//	                    .documentLinked(doc)
//	                    .elementFather(elementInvoiceLine)
//	                    .value(lineExtensionAmount.getValue())
//	                    .attributes(new PatternCurrency.PatternCurrencyBuilder()
//	                            .currencyID(lineExtensionAmount.getPatternCurrency().getCurrencyID())
//	                            .build())
//	                    .build().load();
//	        }
	        
	       
	        
	        if(!(currencyName == null)){
	            if(!(currencyName.getPatternLanguage() == null)){
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("EUR")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(currencyName.getPatternLanguage().getLanguageID())
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("EUR")
	                        .build().load();
	            }
	        }
	        
	        if(!(currencyName == null)){
	            if(!(currencyName.getPatternLanguage() == null)){
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("RON")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(currencyName.getPatternLanguage().getLanguageID())
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("RON")
	                        .build().load();
	            }
	        }
	        if(!(currencyName == null)){
	            if(!(currencyName.getPatternLanguage() == null)){
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("USD")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(currencyName.getPatternLanguage().getLanguageID())
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("USD")
	                        .build().load();
	            }
	        }
	        
	        if(!(currencyName == null)){
	            if(!(currencyName.getPatternLanguage() == null)){
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("INR")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(currencyName.getPatternLanguage().getLanguageID())
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new Name.NameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("INR")
	                        .build().load();
	            }
	        }
	       
	        return elementInvoiceLine;
	    }

}
