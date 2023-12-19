package xml.ubl.templates;

import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xml.ubl.attributes.PatternLanguage;
import xml.ubl.attributes.PatternScheme;
import xml.ubl.axioms.AttributeT;
import xml.ubl.axioms.ElementT;
import xml.ubl.data.ElementsName;
import xml.ubl.data.NamespacesName;
import xml.ubl.elements.AddressAndStreet;
import xml.ubl.elements.CityName;
import xml.ubl.elements.CountryCode;
import xml.ubl.elements.CountryZone;
import xml.ubl.elements.CustomizationID;
import xml.ubl.elements.DeliveryDate;
import xml.ubl.elements.DocumentCurrencyCode;
import xml.ubl.elements.DueDate;
import xml.ubl.elements.FirstName;
import xml.ubl.elements.ID;
import xml.ubl.elements.InvoiceNumber;
import xml.ubl.elements.InvoiceTypeCode;
import xml.ubl.elements.IssueDate;
import xml.ubl.elements.ZipCode;
import xml.ubl.modules.AccountingCustomerParty;
import xml.ubl.modules.AccountingSupplierParty;
import xml.ubl.modules.CustomerAddress;
import xml.ubl.modules.InvoiceLine;
import xml.ubl.modules.LegalMonetaryTotal;
import xml.ubl.modules.TaxTotal;


public class UBLTest {
//	General information
	private Document doc;
	private InvoiceNumber invoiceNumber;	
	private DeliveryDate deliveryDate;	
//	Vendor information
	private FirstName firstName;
	private CityName cityName;
	private AddressAndStreet address;
	private ZipCode zipCode;
	private CountryCode countryCode;
	private CountryZone countryZone;
//	private List<InvoiceLine> invoiceLineList;
	
//	Customer information
	private List<CustomerAddress> customerAddress;

// Generating the Test XML file
	private CustomizationID customizationID;
	private ID id;
	private DueDate dueDate;
	private IssueDate issueDate;
	
	private InvoiceTypeCode invoiceTypeCode;
	private DocumentCurrencyCode documentCurrencyCode;
	private AccountingSupplierParty accountingSupplierParty;
	private AccountingCustomerParty accountingCustomerParty;
	private TaxTotal taxTotalList;
	private LegalMonetaryTotal legalMonetaryTotal;
    private List<InvoiceLine> invoiceLineList;
    private List<InvoiceLine> invoiceLineList1;
	
	
	private UBLTest(UBLTestBuilder builder) {
		this.doc = builder.doc;
        this.cityName = builder.cityName;
        this.firstName = builder.firstName;
        this.invoiceNumber = builder.invoiceNumber;
     
        this.deliveryDate=builder.deliveryDate;        
        this.address = builder.address;
        this.zipCode = builder.zipCode;
        this.countryCode = builder.countryCode;  
        this.countryZone = builder.countryZone;
        
        
//        this.invoiceLineList = builder.invoiceLineList; 
        this.customerAddress = builder.customerAddress;
      
        
//        Test XMl generating.
        this.customizationID =builder.customizationID;
        this.id = builder.id;
        this.dueDate=builder.dueDate;
        this.issueDate=builder.issueDate;
        
        this.invoiceTypeCode =builder.invoiceTypeCode;
        this.documentCurrencyCode= builder.documentCurrencyCode;
        this.accountingSupplierParty=builder.accountingSupplierParty;
        this.accountingCustomerParty = builder.accountingCustomerParty;
        this.taxTotalList = builder.taxTotalList;
        this.legalMonetaryTotal = builder.legalMonetaryTotal;
        this.invoiceLineList = builder.invoiceLineList;
        this.invoiceLineList1 = builder.invoiceLineList1;
 
       
    }
	
	public static class UBLTestBuilder{
		private Document doc;
		private InvoiceNumber invoiceNumber;
	
		private FirstName firstName;
		private DeliveryDate deliveryDate;
		private AddressAndStreet address;
		private CityName cityName;
		private ZipCode zipCode;
		private CountryCode countryCode;
		private CountryZone countryZone;
		private List<CustomerAddress> customerAddress;
		
		
//		Test XMl 
		private CustomizationID customizationID;
		private ID id;
		private DueDate dueDate;
		private IssueDate issueDate;
	
		private InvoiceTypeCode invoiceTypeCode;
		private DocumentCurrencyCode documentCurrencyCode;
		private AccountingSupplierParty accountingSupplierParty;
		private AccountingCustomerParty accountingCustomerParty;
		private TaxTotal taxTotalList;
		private LegalMonetaryTotal legalMonetaryTotal;
		private List<InvoiceLine> invoiceLineList;
		private List<InvoiceLine> invoiceLineList1;
		
		
		

		public UBLTestBuilder() {}
		
		public UBLTestBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
		
		 public UBLTestBuilder invoiceNumber(InvoiceNumber invoiceNumber){
	            this.invoiceNumber = invoiceNumber;
	            return this;
	        }
		 
		
		 
	    public UBLTestBuilder cityName(CityName cityName){
	            this.cityName = cityName;
	            return this;
	        }
	    public UBLTestBuilder firstName(FirstName firstName){
	            this.firstName = firstName;
	            return this;
	        }
	    public UBLTestBuilder address(AddressAndStreet address){
            this.address= address;
            return this;
        }
	
	    public UBLTestBuilder deliveryDate(DeliveryDate deliveryDate){
            this.deliveryDate = deliveryDate;
            return this;
        }
	    
	    public UBLTestBuilder zipCode(ZipCode zipCode){
            this.zipCode = zipCode;
            return this;
        }
	    
	    public UBLTestBuilder countryCode(CountryCode countryCode){
            this.countryCode = countryCode;
            return this;
        }
	    
	    public UBLTestBuilder countryZone(CountryZone countryZone){
            this.countryZone = countryZone;
            return this;
        }
	    
//	    public UBLTestBuilder invoiceLineList(List<InvoiceLine> invoiceLineList){
//            this.invoiceLineList = invoiceLineList;
//            return this;
//        }
	    public UBLTestBuilder customerAddress(List<CustomerAddress> customerAddress){
            this.customerAddress = customerAddress;
            return this;
        }
	    
	    
//	    Test xml Generating
	    
	    public UBLTestBuilder customizationID(CustomizationID customizationID){
            this.customizationID = customizationID;
            return this;
        }
	    public UBLTestBuilder id(ID id){
            this.id = id;
            return this;
        }
	    public UBLTestBuilder dueDate(DueDate dueDate){
            this.dueDate = dueDate;
            return this;
        }
	    
	    public UBLTestBuilder issueDate(IssueDate issueDate){
            this.issueDate = issueDate;
            return this;
        }
	    
	    public UBLTestBuilder invoiceTypeCode(InvoiceTypeCode invoiceTypeCode){
            this.invoiceTypeCode = invoiceTypeCode;
            return this;
        }
	    public UBLTestBuilder documentCurrencyCode(DocumentCurrencyCode documentCurrencyCode){
            this.documentCurrencyCode = documentCurrencyCode;
            return this;
        }
	    
	    public UBLTestBuilder accountingSupplierParty(AccountingSupplierParty accountingSupplierParty){
            this.accountingSupplierParty = accountingSupplierParty;
            return this;
        }
	    
	    public UBLTestBuilder accountingCustomerParty(AccountingCustomerParty accountingCustomerParty){
            this.accountingCustomerParty = accountingCustomerParty;
            return this;
        }
	    
	    public UBLTestBuilder taxTotalList(TaxTotal taxTotalList){
            this.taxTotalList = taxTotalList;
            return this;
        }
	    public UBLTestBuilder legalMonetaryTotal(LegalMonetaryTotal legalMonetaryTotal){
            this.legalMonetaryTotal = legalMonetaryTotal;
            return this;
        }
        public UBLTestBuilder invoiceLineList(List<InvoiceLine> invoiceLineList){
            this.invoiceLineList = invoiceLineList;
            return this;
        }
        public UBLTestBuilder invoiceLineList1(List<InvoiceLine> invoiceLineList1){
            this.invoiceLineList1 = invoiceLineList1;
            return this;
        }
	  
	    public UBLTest build(){
	    	UBLTest ublTest = new UBLTest(this);
            return ublTest;
        }
	    
	}
	
	public Element load() {
        Element elementInvoice = new ElementT(doc, ElementsName.INVOICE.label).loadDoc();
        Attr elementInvoice_Attr1 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS.label, NamespacesName.XMLNS_IMPORT.label).load();
        Attr elementInvoice_Attr2 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_CAC_ATTR.label, NamespacesName.XMLNS_CAC_IMPORT.label).load();
        Attr elementInvoice_Attr3 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_CBC_ATTR.label, NamespacesName.XMLNS_CBC_IMPORT.label).load();
//        Attr elementInvoice_Attr4 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_CCTS_ATTR.label, NamespacesName.XMLNS_CCTS_IMPORT.label).load();
//        Attr elementInvoice_Attr5 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_EXT_ATTR.label, NamespacesName.XMLNS_EXT_IMPORT.label).load();
//        Attr elementInvoice_Attr6 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_NS7_ATTR.label, NamespacesName.XMLNS_NS7_IMPORT.label).load();
//        Attr elementInvoice_Attr7 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_SDT_ATTR.label, NamespacesName.XMLNS_SDT_IMPORT.label).load();
//        Attr elementInvoice_Attr8 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_UDT_ATTR.label, NamespacesName.XMLNS_UDT_IMPORT.label).load();

        
//        Inovice number
        if(!(invoiceNumber == null)){
            if(!(invoiceNumber.getPatternLanguage() == null)){
                Element elementcityName = new InvoiceNumber.InvoiceNumberBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(invoiceNumber.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(invoiceNumber.getPatternLanguage().getLanguageID())                    
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new InvoiceNumber.InvoiceNumberBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(invoiceNumber.getValue())
                        .build().load();
            }
        }
        
       
//        delivery date
        
        if(!(deliveryDate == null)){
            if(!(deliveryDate.getPatternLanguage() == null)){
                Element elementcityName = new DeliveryDate.DeliveryDateBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(deliveryDate.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(deliveryDate.getPatternLanguage().getLanguageID())                    
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new DeliveryDate.DeliveryDateBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(deliveryDate.getValue())
                        .build().load();
            }
        }
        
//        city name
        if(!(cityName == null)){
            if(!(cityName.getPatternLanguage() == null)){
                Element elementcityName = new CityName.CityNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(cityName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(cityName.getPatternLanguage().getLanguageID())
                         
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new CityName.CityNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(cityName.getValue())
                        .build().load();
            }
        }
//        id
       
//        Name of vendor
        if(!(firstName == null)){
            if(!(firstName.getPatternLanguage() == null)){
                Element elementcityName = new FirstName.FirstNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(firstName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(firstName.getPatternLanguage().getLanguageID())
                         
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new FirstName.FirstNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(firstName.getValue())
                        .build().load();
            }
        }
//        address of vendor
        if(!(address == null)){
            if(!(address.getPatternLanguage() == null)){
                Element elementcityName = new AddressAndStreet.AddressAndStreetBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(address.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(address.getPatternLanguage().getLanguageID())
                         
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new AddressAndStreet.AddressAndStreetBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(address.getValue())
                        .build().load();
            }
        }
        
//        Zip code of vendor
        
        if(!(zipCode == null)){
            if(!(zipCode.getPatternLanguage() == null)){
                Element elementcityName = new ZipCode.ZipCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(zipCode.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(zipCode.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new ZipCode.ZipCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(zipCode.getValue())
                        .build().load();
            }
        }
        
//        Country Code
        if(!(countryCode == null)){
            if(!(countryCode.getPatternLanguage() == null)){
                Element elementcityName = new CountryCode.CountryCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(countryCode.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(countryCode.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new CountryCode.CountryCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(countryCode.getValue())
                        .build().load();
            }
        }
        
        if(!(countryZone == null)){
            if(!(countryZone.getPatternLanguage() == null)){
                Element elementcityName = new CountryZone.CountryZoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(countryZone.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(countryZone.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new CountryZone.CountryZoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(countryZone.getValue())
                        .build().load();
            }
        }
//        if(!(invoiceLineList == null)){
//            for (InvoiceLine invoiceLine : invoiceLineList) {
//                Element invoiceLine1 = new InvoiceLine.InvoiceLineBuilder()
//                        .documentLinked(doc)
//                        .elementFather(elementInvoice)
//                        .id(invoiceLine.getId())
//                        .invoicedQuantity(invoiceLine.getInvoicedQuantity())
//                        .lineExtensionAmount(invoiceLine.getLineExtensionAmount())
//                        .taxTotal(invoiceLine.getTaxTotal())
//                        .item(invoiceLine.getItem())
//                        .price(invoiceLine.getPrice())
//                        .build().load();
//            }
//        }
        
        if(!(customerAddress == null)){
            for (CustomerAddress customerAddress : customerAddress) {
                Element invoiceLine1 = new CustomerAddress.CustomerAddressBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                   
//                        .invoicedQuantity(customerAddress.getInvoicedQuantity())
                        .address(customerAddress.address())
                        .zipCode(customerAddress.zipCode())
                        .cityName(customerAddress.cityName())
                        .countryZone(customerAddress.countryZone())
                        .build().load();
            }
        }
        
        
//        Generating the TEST XMl
        
//        Customization ID
        if(!(customizationID == null)){
            if(!(customizationID.getPatternLanguage() == null)){
                Element elementcityName = new CustomizationID.CustomizationIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(customizationID.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(customizationID.getPatternLanguage().getLanguageID())                    
                                .build())
                        .build().load();
            } else {
                Element elementcityName = new CustomizationID.CustomizationIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(customizationID.getValue())
                        .build().load();
            }
        }
        
//id 
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementID = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
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
                Element elementID = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(id.getValue())
                        .build().load();
            }
        }
        
        
//      date of invoice
      if(!(issueDate == null)){
          if(!(issueDate.getPatternLanguage() == null)){
              Element elementcityName = new IssueDate.IssueDateBuilder()
                      .documentLinked(doc)
                      .elementFather(elementInvoice)
                      .value(issueDate.getValue())
                      .attributes(new PatternLanguage.PatternLanguageBuilder()
                              .languageID(issueDate.getPatternLanguage().getLanguageID())                    
                              .build())
                      .build().load();
          } else {
              Element elementcityName = new IssueDate.IssueDateBuilder()
                      .documentLinked(doc)
                      .elementFather(elementInvoice)
                      .value(issueDate.getValue())
                      .build().load();
          }
      }
      
      
//    due date
    if(!(dueDate == null)){
        if(!(dueDate.getPatternLanguage() == null)){
            Element elementcityName = new DueDate.DueDateBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(dueDate.getValue())
                    .attributes(new PatternLanguage.PatternLanguageBuilder()
                            .languageID(dueDate.getPatternLanguage().getLanguageID())                    
                            .build())
                    .build().load();
        } else {
            Element elementcityName = new DueDate.DueDateBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(dueDate.getValue())
                    .build().load();
        }
    }
    
//    invoice type code
    if(!(invoiceTypeCode == null)){
        if(!(invoiceTypeCode.getPatternLanguage() == null)){
            Element elementcityName = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(invoiceTypeCode.getValue())
                    .attributes(new PatternLanguage.PatternLanguageBuilder()
                            .languageID(invoiceTypeCode.getPatternLanguage().getLanguageID())                    
                            .build())
                    .build().load();
        } else {
            Element elementcityName = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(invoiceTypeCode.getValue())
                    .build().load();
        }
    }
    
    
    if(!(documentCurrencyCode == null)){
        if(!(documentCurrencyCode.getPatternLanguage() == null)){
            Element elementcityName = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(documentCurrencyCode.getValue())
                    .attributes(new PatternLanguage.PatternLanguageBuilder()
                            .languageID(documentCurrencyCode.getPatternLanguage().getLanguageID())                    
                            .build())
                    .build().load();
        } else {
            Element elementcityName = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(documentCurrencyCode.getValue())
                    .build().load();
        }
    }
    
//    account supplier party
    if(!(accountingSupplierParty == null)){
        Element elementAccountingSupplierParty = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                .documentLinked(doc)
                .elementFather(elementInvoice)
                .party(accountingSupplierParty.getParty())
                .build().load();
    }
    
//    account customer party
    if(!(accountingCustomerParty == null)){
        Element elementAccountingCustomerParty = new AccountingCustomerParty.AccountingCustomerPartyBuilder()
                .documentLinked(doc)
                .elementFather(elementInvoice)
                .party(accountingCustomerParty.getParty())
                .build().load();
    }
    
    if(!(taxTotalList == null)){
        Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                .documentLinked(doc)
                .elementFather(elementInvoice)
                .taxAmount(taxTotalList.getTaxAmount())
                .taxSubTotalList(taxTotalList.getTaxSubTotalList())
                .build().load();
    } 
    
    if(!(legalMonetaryTotal == null)){
        Element elementTaxTotal = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                .documentLinked(doc)
                .elementFather(elementInvoice)
                .lineExtensionAmount(legalMonetaryTotal.getLineExtensionAmount())
                .taxExclusiveAmount(legalMonetaryTotal.getTaxExclusiveAmount())
                .taxInclusiveAmount(legalMonetaryTotal.getTaxInclusiveAmount())
                .payableAmount(legalMonetaryTotal.getPayableAmount())
                .build().load();
    }
    
//    
    if(!(invoiceLineList == null)){
        for (InvoiceLine invoiceLine : invoiceLineList) {
            Element invoiceLine1 = new InvoiceLine.InvoiceLineBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .id(invoiceLine.getId())
                    .invoicedQuantity(invoiceLine.getInvoicedQuantity())
                    .lineExtensionAmount(invoiceLine.getLineExtensionAmount())
//                    .taxTotal(invoiceLine.getTaxTotal())
                    .item(invoiceLine.getItem())
                    .price(invoiceLine.getPrice())
                    .build().load();
        }
    }
    
    if(!(invoiceLineList1 == null)){
        for (InvoiceLine invoiceLine1 : invoiceLineList1) {
            Element invoiceLine = new InvoiceLine.InvoiceLineBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .id(invoiceLine1.getId())
                    .invoicedQuantity(invoiceLine1.getInvoicedQuantity())
                    .lineExtensionAmount(invoiceLine1.getLineExtensionAmount())
//                    .taxTotal(invoiceLine.getTaxTotal())
                    .item(invoiceLine1.getItem())
                    .price(invoiceLine1.getPrice())
                    .build().load();
        }
    }

      
        return elementInvoice;
    }
	

}
