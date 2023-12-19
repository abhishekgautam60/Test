package com.test.efaktura;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.domain.operation.IEntity;
import com.test.efaktura.MyProcessLibrary;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;

import xml.ubl.attributes.PatternCode;
import xml.ubl.attributes.PatternCurrency;
import xml.ubl.attributes.PatternLanguage;
import xml.ubl.attributes.PatternList;
import xml.ubl.attributes.PatternScheme;
import xml.ubl.axioms.DocumentT;
import xml.ubl.elements.AddressFormatCode;
import xml.ubl.elements.BaseQuantity;
import xml.ubl.elements.CityName;
import xml.ubl.elements.CompanyID;
import xml.ubl.elements.CompanyLegalForm;
import xml.ubl.elements.CustomizationID;
import xml.ubl.elements.Description;
import xml.ubl.elements.DocumentCurrencyCode;
import xml.ubl.elements.DueDate;
import xml.ubl.elements.ID;
import xml.ubl.elements.IdentificationCode;
import xml.ubl.elements.InvoiceTypeCode;
import xml.ubl.elements.InvoicedQuantity;
import xml.ubl.elements.IssueDate;
import xml.ubl.elements.LineExtensionAmount;
import xml.ubl.elements.Name;
import xml.ubl.elements.PayableAmount;
import xml.ubl.elements.Percent;
import xml.ubl.elements.PostalZone;
import xml.ubl.elements.PriceAmount;
import xml.ubl.elements.RegistrationName;
import xml.ubl.elements.StreetName;
import xml.ubl.elements.TaxAmount;
import xml.ubl.elements.TaxExclusiveAmount;
import xml.ubl.elements.TaxInclusiveAmount;
import xml.ubl.elements.TaxableAmount;
import xml.ubl.inputVariables.InputParameter;
import xml.ubl.modules.AccountingCustomerParty;
import xml.ubl.modules.AccountingSupplierParty;
import xml.ubl.modules.ClassifiedTaxCategory;
import xml.ubl.modules.Country;
import xml.ubl.modules.InvoiceLine;
import xml.ubl.modules.Item;
import xml.ubl.modules.LegalMonetaryTotal;
import xml.ubl.modules.Party;
import xml.ubl.modules.PartyIdentification;
import xml.ubl.modules.PartyLegalEntity;
import xml.ubl.modules.PartyName;
import xml.ubl.modules.PartyTaxScheme;
import xml.ubl.modules.PostalAddress;
import xml.ubl.modules.Price;
import xml.ubl.modules.TaxCategory;
import xml.ubl.modules.TaxScheme;
import xml.ubl.modules.TaxSubTotal;
import xml.ubl.modules.TaxTotal;
import xml.ubl.templates.UBLTest;

//public class MainController {
public class TestController  {
    
    
    
	
	public void newXmlStart(InputVariables inputVariables) throws ParserConfigurationException, TransformerException {
	
          
      
                System.out.println("Main Controller Started");
                InputParameter inputParameter= new InputParameter();
                DocumentT docInvoice = new DocumentT("UBLTestInvoice.xml","C:\\UBL\\");
                docInvoice.initialize();
         

//    Customization ID
CustomizationID customizationID= new CustomizationID.CustomizationIDBuilder()
        .value("urn:cen.eu:en16931:2017#compliant#urn:efactura.mfinante.ro:CIUS-RO:1.0.1")
        .build();	  

    
//    ID
ID id= new ID.IDBuilder()
        .value(inputVariables.id)
        .build();

//Issue Date
IssueDate issueDate = new IssueDate.IssueDateBuilder()
        .value(inputVariables.issueDate)
        .build();


//Due Date
DueDate dueDate = new DueDate.DueDateBuilder()
        .value(inputVariables.dueDate)
        .build();

//	 Invoice Type Code
InvoiceTypeCode invoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
        .value(inputVariables.invoiceTypeCode)
        .build();

//	 Document Currency Code
DocumentCurrencyCode documentCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
        .value(inputVariables.documentCurrencyCode)
        .build();
System.out.println(inputVariables.documentCurrencyCode);

System.out.println(inputVariables.getDocumentCurrencyCode());


/**
 * Account supplier party
 */

//ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
List<PartyIdentification> partyIdentificationListInvoice = new ArrayList<>();
PartyIdentification partyIdentification1Invoice = new PartyIdentification.PartyIdentificationBuilder()
        .id(new ID.IDBuilder()
                .value(inputVariables.partyIdentification1Invoice)
                .build())
        .build();

partyIdentificationListInvoice.add(partyIdentification1Invoice);


//ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
List<PartyName> partyNameListInvoice = new ArrayList<>();
PartyName partyNameInvoice1 = new PartyName.PartyNameBuilder()
        .name(new Name.NameBuilder()
                .value(inputVariables.partyNameListInvoice)
                .build())
        .build();
partyNameListInvoice.add(partyNameInvoice1);

//ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
Country countryInvoice1 = new Country.CountryBuilder()
        .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                .value(inputVariables.identificationCode)
                .build())
        
        .build();
//ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
PostalAddress postalAddressInvoice1 = new PostalAddress.PostalAddressBuilder()
        .streetName(new StreetName.StreetNameBuilder()
                .value(inputVariables.streetName)
                .attributes(new PatternLanguage.PatternLanguageBuilder()
                        .build())
                .build())
        .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                .value(inputVariables.addressFormatCode)
                .attributes(new PatternList.PatternListBuilder()
                        .build())
                .build())
        .cityName(new CityName.CityNameBuilder()
                .value(inputVariables.cityName)
                .attributes(new PatternLanguage.PatternLanguageBuilder()
                        .build())
                .build())
        .countrySubentity(new PostalZone.PostalZoneBuilder()
                .value(inputVariables.countrySubentity)
                .build())
        
        .country(countryInvoice1)
        
        
        .build();

//ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
TaxScheme taxSchemeInvoice1 = new TaxScheme.TaxSchemeBuilder()
        .id(new ID.IDBuilder()
                .value(inputVariables.TaxSchemeID)
                
                .build())
        
        .build();
//ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
List<PartyTaxScheme> partyTaxSchemeListInvoice = new ArrayList<>();
PartyTaxScheme partyTaxSchemeInvoice1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
        .companyId(new CompanyID.CompanyIDBuilder()
                .value(inputVariables.PartyTaxSchemeID)
                .build())
        .taxScheme(taxSchemeInvoice1)
        .build();
partyTaxSchemeListInvoice.add(partyTaxSchemeInvoice1);



//ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
List<PartyLegalEntity> partyLegalEntityListInvoice = new ArrayList<>();
PartyLegalEntity partyLegalEntityInvoice1 = new PartyLegalEntity.PartyLegalEntityBuilder()
        .registrationName(new RegistrationName.RegistrationNameBuilder()
                .value(inputVariables.registrationName)
                .build())
        .companyId(new CompanyID.CompanyIDBuilder()
                .value(inputVariables.partyLegalEntityId)            
                .build())
        
        .companyLegalForm(new CompanyLegalForm.CompanyLegalFormBuilder()
                .value(inputVariables.partyLegalForm)
                .build())
        .build();
partyLegalEntityListInvoice.add(partyLegalEntityInvoice1);



//ACCOUNTING SUPPLIER PARTY > PARTY
Party elementPartyInvoice1 = new Party.PartyBuilder()
        .partyIdentificationList(partyIdentificationListInvoice)
        .partyNameList(partyNameListInvoice)
        .postalAddress(postalAddressInvoice1)
        .partyTaxSchemeList(partyTaxSchemeListInvoice)
        .partyLegalEntityList(partyLegalEntityListInvoice)
        .build();

//ACCOUNTING SUPPLIER PARTY
AccountingSupplierParty elementAccountingSupplierPartyInvoice = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
        .party(elementPartyInvoice1)
        .build();





/**
 * Element AccountingCustomerParty
 */


//ACCOUNTING CUSTOMER PARTY > PARTY > PARTY IDENTIFICATION
List<PartyIdentification> partyIdentificationListCreditNote = new ArrayList<>();
PartyIdentification partyIdentificationCreditNote1 = new PartyIdentification.PartyIdentificationBuilder()
        .id(new ID.IDBuilder()
                .value(inputVariables.customerPartyIdentificationId)
                .build())
        .build();

partyIdentificationListCreditNote.add(partyIdentificationCreditNote1);
//        partyIdentificationListCreditNote.add(partyIdentificationCreditNote2);

//ACCOUNTING CUSTOMER PARTY > PARTY > PARTY NAME
List<PartyName> partyNameListCreditNote = new ArrayList<>();
PartyName partyNameCreditNote1 = new PartyName.PartyNameBuilder()
        .name(new Name.NameBuilder()
                .value(inputVariables.customerPartyName)
                .build())
        .build();
partyNameListCreditNote.add(partyNameCreditNote1);

//ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
Country countryCreditNote1 = new Country.CountryBuilder()
        .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                .value(inputVariables.customerCountryCode)
                .build())
        .build();


//ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS
PostalAddress postalAddressCreditNote1 = new PostalAddress.PostalAddressBuilder()
        .streetName(new StreetName.StreetNameBuilder()
                .value(inputVariables.customerStreetName)
                .build())
        .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                .value(inputVariables.customerAddresFormateCode)
                .build())
        .cityName(new CityName.CityNameBuilder()
                .value(inputVariables.customerCityName)
                .build())
        
        .countrySubentity(new PostalZone.PostalZoneBuilder()
                .value(inputVariables.customerCountySubentity)
                .build())
        
        .country(countryCreditNote1)
        
        .build();
//ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
TaxScheme taxSchemeCreditNote1 = new TaxScheme.TaxSchemeBuilder()
        
        .id(new ID.IDBuilder()
                .value(inputVariables.customerTaxSchemeID)
                .build())
        
        .build();


//ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME
List<PartyTaxScheme> partyTaxSchemeListCreditNote = new ArrayList<>();
PartyTaxScheme partyTaxSchemeCreditNote1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
        .companyId(new CompanyID.CompanyIDBuilder()
                .value(inputVariables.customerPartyTaxSchemeId)
                
                .build())
        .taxScheme(taxSchemeCreditNote1)
        .build();
partyTaxSchemeListCreditNote.add(partyTaxSchemeCreditNote1);



//ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY
List<PartyLegalEntity> partyLegalEntityListCreditNote = new ArrayList<>();
PartyLegalEntity partyLegalEntityCreditNote1 = new PartyLegalEntity.PartyLegalEntityBuilder()
        .registrationName(new RegistrationName.RegistrationNameBuilder()
                .value(inputVariables.CustomerPartyLegalRegistrationName)
                .build())
        .companyId(new CompanyID.CompanyIDBuilder()
                .value(inputVariables.customerPartylegalRegistrationId)
                .build())
        
//
        .build();
partyLegalEntityListCreditNote.add(partyLegalEntityCreditNote1);



//ACCOUNTING CUSTOMER PARTY > PARTY
Party elementPartyCreditNote = new Party.PartyBuilder()
        .partyIdentificationList(partyIdentificationListCreditNote)
        .partyNameList(partyNameListCreditNote)
        .postalAddress(postalAddressCreditNote1)
        .partyTaxSchemeList(partyTaxSchemeListCreditNote)
        .partyLegalEntityList(partyLegalEntityListCreditNote)
        
        .build();

//ACCOUNTING CUSTOMER PARTY
AccountingCustomerParty elementAccountingCustomerPartyCreditNote = new AccountingCustomerParty.AccountingCustomerPartyBuilder()
        .party(elementPartyCreditNote)
        .build();



//TODO

/**
 * Element TaxTotal [List]
 */

//TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
TaxScheme taxSchemeInvoice44 = new TaxScheme.TaxSchemeBuilder()
        .id(new ID.IDBuilder()
                .value(inputVariables.taxTotalTaxSchemeId)
                .build())
        
        .build();

//TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
TaxCategory taxCategoryInvoice44 = new TaxCategory.TaxCategoryBuilder()
        .id(new ID.IDBuilder()
                .value(inputVariables.taxTotalTaxCategory)
                
                .build())
        .percent(new Percent.PercentBuilder().value(inputVariables.taxSubTotalPercent).build())
        .taxScheme(taxSchemeInvoice44)
        .build();

//TAX TOTAL > TAX SUB TOTAL
List<TaxSubTotal> taxSubTotalList44 = new ArrayList<>();
TaxSubTotal taxSubTotal44 = new TaxSubTotal.TaxSubTotalBuilder()
        .taxableAmount(new TaxableAmount.TaxableAmountBuilder()
                .value(inputVariables.taxSubTotalTaxableAmount)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.taxSubTotalTaxableAmountAttribute)
                        .build())
                .build())
        .taxAmount(new TaxAmount.TaxAmountBuilder()
                .value(inputVariables.taxSubTotalTaxAmount)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.taxSubTotalTaxAmountAttributes)
                        .build())
                .build())
        
        .taxCategory(taxCategoryInvoice44)
        .build();
taxSubTotalList44.add(taxSubTotal44);

//TAX TOTAL
List<TaxTotal> taxTotalList44 = new ArrayList<>();
TaxTotal taxTotal44 = new TaxTotal.TaxTotalBuilder()
        .taxAmount(new TaxAmount.TaxAmountBuilder()
                .value(inputVariables.taxTotalAmount)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.taxTotalAmountAttributes)
                        .build())
                .build())
        .taxSubTotalList(taxSubTotalList44)
        .build();

taxTotalList44.add(taxTotal44);

/**
 * Element LegalMonetaryTotal
 */

LegalMonetaryTotal legalMonetaryTotalInvoice1 = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
        .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                .value(inputVariables.lineExtensionAmount)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.lineExtensionAmountAttributes)
                        .build())
                .build())
        .taxExclusiveAmount(new TaxExclusiveAmount.TaxExclusiveAmountBuilder()
                .value(inputVariables.taxExclusiveAmount)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.lineExtensionAmountAttributes)
                        .build())
                .build())
        .taxInclusiveAmount(new TaxInclusiveAmount.TaxInclusiveAmountBuilder()
                .value(inputVariables.taxInclusiveAmount)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.lineExtensionAmountAttributes)
                        .build())
                .build())
        .payableAmount(new PayableAmount.PayableAmountBuilder()
                .value(inputVariables.payableAmount)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.lineExtensionAmountAttributes)
                        .build())
                .build())
        .build();
/**
 * Element InvoiceLine [List]
 */

//INVOICE LINE > ITEM > SELLERS ITEM IDENTIFICATION
ClassifiedTaxCategory classifiedTaxCategoryInvoice44 = new ClassifiedTaxCategory.ClassifiedTaxCategoryBuilder()
        .id(new ID.IDBuilder()
                .value(inputVariables.classifiedTaxCategoryId)
                .build())
        .percent(new Percent.PercentBuilder().value(inputVariables.classifiedTaxCategoryPercent).build())
        .taxScheme(taxSchemeInvoice44)
        .build();

//INVOICE LINE > ITEM > DESCRIPTION
List<Description> descriptionList44 = new ArrayList<>();
Description description44 = new Description.DescriptionBuilder()
        .value(inputVariables.description)
        .build();
descriptionList44.add(description44);

//INVOICE LINE > ITEM
Item item44 = new Item.ItemBuilder()       
           .name(new Name.NameBuilder()
                .value(inputVariables.item1Name)
                .build())
           .classifiedTaxCategory(classifiedTaxCategoryInvoice44)
           .build();
        
Item item2 = new Item.ItemBuilder()
        
        .name(new Name.NameBuilder()
                .value(inputVariables.item2Name)
                .build())
        .classifiedTaxCategory(classifiedTaxCategoryInvoice44)
        .build();

//INVOICE LINE > PRICE
Price price44 = new Price.PriceBuilder()
        .priceAmount(new PriceAmount.PriceAmountBuilder()
                .value(inputVariables.priceAmount1)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.priceAmountAttributes1)
                        .build())
                .build())
        .baseQuantity(new BaseQuantity.BaseQuantityBuilder()
                .value(inputVariables.baseQuantity1)
                .attributes(new PatternCode.PatternCodeBuilder()
                        .unitCode(inputVariables.baseQuantityAttributes1)
                        .build())
                .build())
        
        .build();

Price price2 = new Price.PriceBuilder()
        .priceAmount(new PriceAmount.PriceAmountBuilder()
                .value(inputVariables.priceAmount2)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.priceAmountAttributes2)
                        .build())
                .build())
        .baseQuantity(new BaseQuantity.BaseQuantityBuilder()
                .value(inputVariables.baseQuantity2)
                .attributes(new PatternCode.PatternCodeBuilder()
                        .unitCode(inputVariables.baseQuantityAttributes2)
                        .build())
                .build())
        
        .build();

//INVOICE LINE
List<InvoiceLine> invoiceLineList44 = new ArrayList<>();
InvoiceLine invoiceLine44 = new InvoiceLine.InvoiceLineBuilder()        
        .id(new ID.IDBuilder()
                .value(inputVariables.invoiceLineId1)
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .build())
                .build())
        .invoicedQuantity(new InvoicedQuantity.InvoicedQuantityBuilder()
                .value(inputVariables.invoiceLineInvoicedQuantity1)
                .attributes(new PatternCode.PatternCodeBuilder()
                        .unitCode(inputVariables.invoiceLineInvoicedQuantityAttributes1)
                        .build()).build())
        .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                .value(inputVariables.invoiceLineExtensionAmount1)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.invoiceLineExtensionAmountAttributes1)
                        .build())
                .build())
        .item(item44)
        .price(price44)
        .build();
invoiceLineList44.add(invoiceLine44);

List<InvoiceLine> invoiceLineList2 = new ArrayList<>();
InvoiceLine invoiceLine2 = new InvoiceLine.InvoiceLineBuilder()
        .id(new ID.IDBuilder()
                .value(inputVariables.invoiceLineId2)
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .build())
                .build())
        .invoicedQuantity(new InvoicedQuantity.InvoicedQuantityBuilder()
                .value(inputVariables.invoiceLineInvoicedQuantity2)
                .attributes(new PatternCode.PatternCodeBuilder()
                        .unitCode(inputVariables.invoiceLineInvoicedQuantityAttributes2)
                        .build()).build())
        .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                .value(inputVariables.invoiceLineExtensionAmount2)
                .attributes(new PatternCurrency.PatternCurrencyBuilder()
                        .currencyID(inputVariables.invoiceLineExtensionAmountAttributes2)
                        .build())
                .build())
//                .taxTotal(taxTotal44)
        .item(item2)
        .price(price2)
        .build();
invoiceLineList2.add(invoiceLine2);



/**
 * Element ROOT
 */


//Creating the XML with the values

Element elementInvoice = (Element) new UBLTest.UBLTestBuilder()
        
        .documentLinked(docInvoice.getDoc())
        .customizationID(customizationID)
        .id(id)
        .dueDate(dueDate)
        .issueDate(issueDate)
        .invoiceTypeCode(invoiceTypeCode)
        .documentCurrencyCode(documentCurrencyCode)
        .accountingSupplierParty(elementAccountingSupplierPartyInvoice)
        .accountingCustomerParty(elementAccountingCustomerPartyCreditNote)
        .taxTotalList(taxTotal44)
        .legalMonetaryTotal(legalMonetaryTotalInvoice1)
        .invoiceLineList(invoiceLineList44)
        .invoiceLineList1(invoiceLineList2)
        .build().load();


docInvoice.generate();
           
			 
	}
        

  
}
