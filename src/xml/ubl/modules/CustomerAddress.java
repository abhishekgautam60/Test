package xml.ubl.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xml.ubl.attributes.PatternCode;
import xml.ubl.attributes.PatternCurrency;
import xml.ubl.attributes.PatternLanguage;
import xml.ubl.attributes.PatternScheme;
import xml.ubl.axioms.ElementT;
import xml.ubl.data.ElementsName;
import xml.ubl.elements.AddressAndStreet;
import xml.ubl.elements.CityName;
import xml.ubl.elements.CountryCode;
import xml.ubl.elements.CountryZone;
import xml.ubl.elements.ID;
import xml.ubl.elements.InvoicedQuantity;
import xml.ubl.elements.LineExtensionAmount;
import xml.ubl.elements.ZipCode;
import xml.ubl.modules.InvoiceLine.InvoiceLineBuilder;

public class CustomerAddress {

	 private Document doc;
	    private Element element;
	
	    private AddressAndStreet address;
	    private ZipCode zipCode;
	    private CityName cityName;
	    private CountryZone countryZone;
	    private InvoicedQuantity invoicedQuantity;
	    private LineExtensionAmount lineExtensionAmount;
	   

	   
	    private CustomerAddress(CustomerAddressBuilder builder) {
	        this.doc = builder.doc;
	        this.element = builder.element;
	   
	        this.invoicedQuantity = builder.invoicedQuantity;
	        this.lineExtensionAmount = builder.lineExtensionAmount;
	        this.address = builder.address;
	        this.zipCode = builder.zipCode;
	        this.cityName = builder.cityName;
	        this.countryZone = builder.countryZone;
	       
	    }

	    /**
	     * Builder InvoiceLine
	     */
	    public static class CustomerAddressBuilder {

	        private Document doc;
	        private Element element;
	   
	        private AddressAndStreet address;
		    private ZipCode zipCode;
		    private CityName cityName;
		    private CountryZone countryZone;
	        private InvoicedQuantity invoicedQuantity;
	        private LineExtensionAmount lineExtensionAmount;
	     

	        public CustomerAddressBuilder() {}

	        public CustomerAddressBuilder documentLinked(Document doc){
	            this.doc = doc;
	            return this;
	        }
	        public CustomerAddressBuilder elementFather(Element element){
	            this.element = element;
	            return this;
	        }
	       
	        public CustomerAddressBuilder invoicedQuantity(InvoicedQuantity invoicedQuantity){
	            this.invoicedQuantity = invoicedQuantity;
	            return this;
	        }
	        public CustomerAddressBuilder lineExtensionAmount(LineExtensionAmount lineExtensionAmount){
	            this.lineExtensionAmount = lineExtensionAmount;
	            return this;
	        }
	        public CustomerAddressBuilder address(AddressAndStreet address){
	            this.address = address;
	            return this;
	        }
	        
	        public CustomerAddressBuilder zipCode(ZipCode zipCode){
	            this.zipCode = zipCode;
	            return this;
	        }
	        public CustomerAddressBuilder cityName(CityName cityName){
	            this.cityName = cityName;
	            return this;
	        }
	        public CustomerAddressBuilder countryZone(CountryZone countryZone){
	            this.countryZone = countryZone;
	            return this;
	        }
	        public CustomerAddress build(){
	        	CustomerAddress customerAddress = new CustomerAddress(this);
	            return customerAddress;
	        }
	       
	       

	    }

	   

	    public InvoicedQuantity getInvoicedQuantity() {
	        return invoicedQuantity;
	    }

	    public LineExtensionAmount getLineExtensionAmount() {
	        return lineExtensionAmount;
	    }
	    
	    public AddressAndStreet address() {
	        return address;
	    }
	    public ZipCode zipCode() {
	        return zipCode;
	    }
	    public CityName cityName() {
	        return cityName;
	    }
	    public CountryZone countryZone() {
	        return countryZone;
	    }
	   

	  

	    /**
	     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
	     * @return the generated element
	     */
	    public Element load() {
	        Element elementInvoiceLine = new ElementT(doc, element, ElementsName.CUSTOMER_ADDRESSS.label).load();
	       
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
	        
	        if(!(address == null)){
	            if(!(address.getPatternLanguage() == null)){
	                Element elementcityName = new AddressAndStreet.AddressAndStreetBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("Delhi-Jaipur Highway, Gandhinagar")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(address.getPatternLanguage().getLanguageID())
	                         
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new AddressAndStreet.AddressAndStreetBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("Delhi-Jaipur Highway, Gandhinagar")
	                        .build().load();
	            }
	        }
	        
	        if(!(zipCode == null)){
	            if(!(zipCode.getPatternLanguage() == null)){
	                Element elementcityName = new ZipCode.ZipCodeBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("112235")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(zipCode.getPatternLanguage().getLanguageID())
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new ZipCode.ZipCodeBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("112235")
	                        .build().load();
	            }
	        }
	        
	        if(!(cityName == null)){
	            if(!(cityName.getPatternLanguage() == null)){
	                Element elementcityName = new CityName.CityNameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("Delhi")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(cityName.getPatternLanguage().getLanguageID())
	                         
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new CityName.CityNameBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("Delhi")
	                        .build().load();
	            }
	        }
	        
	        if(!(countryZone == null)){
	            if(!(countryZone.getPatternLanguage() == null)){
	                Element elementcityName = new CountryZone.CountryZoneBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("Asia/Kolkata UTC +05:30")
	                        .attributes(new PatternLanguage.PatternLanguageBuilder()
	                                .languageID(countryZone.getPatternLanguage().getLanguageID())
	                                .build())
	                        .build().load();
	            } else {
	                Element elementcityName = new CountryZone.CountryZoneBuilder()
	                        .documentLinked(doc)
	                        .elementFather(elementInvoiceLine)
	                        .value("Asia/Kolkata UTC +05:30")
	                        .build().load();
	            }
	        }
	       
	        return elementInvoiceLine;
	    }
}
