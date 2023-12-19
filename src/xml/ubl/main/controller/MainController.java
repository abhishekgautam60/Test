/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml.ubl.main.controller;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.data.ObjectReference;
import com.bas.shared.domain.operation.IEntity;
import com.test.efaktura.MyProcessLibrary;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.openadaptor.dataobjects.InvalidParameterException;
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

/**
 *
 * @author Abhishek.Gautam
 */
public class MainController implements IProcess{

    @Override
    public Object execute(IExecutionEngine iee, Object[] os) throws SuspendProcessException, ExecutionException, AccessDeniedException 
   {    
        try 
        {
            // get the parameter
            IEntity invoice_entity = (IEntity) os [0];
            IEntity system_settings_entity = (IEntity) os [1]; 
            System.out.println("Main Controller Started");
            
//          HERE MENTION THE LOCATION WHERE YOU WANT TO UPLOAD THE UBL_XML FILE.

//          DocumentT docInvoice = new DocumentT("UBLTestInvoice.xml","C:\\UBL\\");
            DocumentT docInvoice = new DocumentT("UBLTestInvoice.xml", (String) system_settings_entity.getAttributeValue("DocumentPath"));
            docInvoice.initialize();

            //    Customization ID
            CustomizationID customizationID= new CustomizationID.CustomizationIDBuilder()
                    .value("urn:cen.eu:en16931:2017#compliant#urn:efactura.mfinante.ro:CIUS-RO:1.0.1")
                    .build();	  

            //    ID
            ID id= new ID.IDBuilder()
                    .value((String) invoice_entity.getAttributeValue("cbc_ID"))
                    .build();

            //Issue Date
            IssueDate issueDate = new IssueDate.IssueDateBuilder()
                    .value((String) invoice_entity.getAttributeValue("cbc_Date"))
                    .build();


            //Due Date
            DueDate dueDate = new DueDate.DueDateBuilder()
                    .value((String) invoice_entity.getAttributeValue("cbc_DueDate"))
                    .build();

            //	 Invoice Type Code
            InvoiceTypeCode invoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                    .value((String)invoice_entity.getAttributeValue("cbc_InvoiceTypeCode"))
                    .build();

            //	 Document Currency Code
            DocumentCurrencyCode documentCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                    .value((String) invoice_entity.getAttributeValue("cbc_DocumentCurrencyCode"))
                    .build();


    /**
     * Account supplier party
     */

           ObjectReference[] obj1 = invoice_entity.getReferences("cac_SupplierParty");
           IEntity supplier_entity = iee.getEntity(this, "AccountingSupplierParty", obj1[0].m_objectId);
           
           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
           List<PartyIdentification> partyIdentificationListInvoice = new ArrayList<>();
           PartyIdentification partyIdentification1Invoice = new PartyIdentification.PartyIdentificationBuilder()
                   .id(new ID.IDBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_ID"))
                           .build())
                   .build();

           partyIdentificationListInvoice.add(partyIdentification1Invoice);


           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
           List<PartyName> partyNameListInvoice = new ArrayList<>();
           PartyName partyNameInvoice1 = new PartyName.PartyNameBuilder()
                   .name(new Name.NameBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_Name"))
                           .build())
                   .build();
           partyNameListInvoice.add(partyNameInvoice1);

           //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
           Country countryInvoice1 = new Country.CountryBuilder()
                   .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_CountryIdentificationCode"))
                           .build())

                   .build();
           //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
           PostalAddress postalAddressInvoice1 = new PostalAddress.PostalAddressBuilder()
                   .streetName(new StreetName.StreetNameBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_StreetName"))
                           .attributes(new PatternLanguage.PatternLanguageBuilder()
                                   .build())
                           .build())
                   .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_AdditionalStreetName"))
                           .attributes(new PatternList.PatternListBuilder()
                                   .build())
                           .build())
                   .cityName(new CityName.CityNameBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_CityName"))
                           .attributes(new PatternLanguage.PatternLanguageBuilder()
                                   .build())
                           .build())
                   .countrySubentity(new PostalZone.PostalZoneBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_CountrySubentity"))
                           .build())

                   .country(countryInvoice1)
                   .build();

           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
           TaxScheme taxSchemeInvoice1 = new TaxScheme.TaxSchemeBuilder()
                   .id(new ID.IDBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_TaxSchemeID"))

                           .build())
                   .build();
           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
           List<PartyTaxScheme> partyTaxSchemeListInvoice = new ArrayList<>();
           PartyTaxScheme partyTaxSchemeInvoice1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                   .companyId(new CompanyID.CompanyIDBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_PartyTaxSchemeID"))
                           .build())
                   .taxScheme(taxSchemeInvoice1)
                   .build();
           partyTaxSchemeListInvoice.add(partyTaxSchemeInvoice1);


           //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
           List<PartyLegalEntity> partyLegalEntityListInvoice = new ArrayList<>();
           PartyLegalEntity partyLegalEntityInvoice1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                   .registrationName(new RegistrationName.RegistrationNameBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_RegistrationName"))
                           .build())
                   .companyId(new CompanyID.CompanyIDBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_CompanyID"))            
                           .build())

                   .companyLegalForm(new CompanyLegalForm.CompanyLegalFormBuilder()
                           .value((String) supplier_entity.getAttributeValue("cbc_CompanyLegalForm"))
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

           ObjectReference[] obj2 = invoice_entity.getReferences("cac_CustomerParty");
           IEntity customer_entity = iee.getEntity(this, "AccountingCustomerParty", obj2[0].m_objectId);
                       
           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY IDENTIFICATION
           List<PartyIdentification> partyIdentificationListCreditNote = new ArrayList<>();
           PartyIdentification partyIdentificationCreditNote1 = new PartyIdentification.PartyIdentificationBuilder()
                   .id(new ID.IDBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_ID"))
                           .build())
                   .build();

           partyIdentificationListCreditNote.add(partyIdentificationCreditNote1);

           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY NAME
           List<PartyName> partyNameListCreditNote = new ArrayList<>();
           PartyName partyNameCreditNote1 = new PartyName.PartyNameBuilder()
                   .name(new Name.NameBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_Name"))
                           .build())
                   .build();
           partyNameListCreditNote.add(partyNameCreditNote1);

           //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
           Country countryCreditNote1 = new Country.CountryBuilder()
                   .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_CountryCode"))
                           .build())
                   .build();


           //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS
           PostalAddress postalAddressCreditNote1 = new PostalAddress.PostalAddressBuilder()
                   .streetName(new StreetName.StreetNameBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_StreetName"))
                           .build())
                   .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_CustomerAddresFormateCode"))
                           .build())
                   .cityName(new CityName.CityNameBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_CityName"))
                           .build())

                   .countrySubentity(new PostalZone.PostalZoneBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_CountrySubentity"))
                           .build())

                   .country(countryCreditNote1)

                   .build();
           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
           TaxScheme taxSchemeCreditNote1 = new TaxScheme.TaxSchemeBuilder()

                   .id(new ID.IDBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_TaxSchemeID"))
                           .build())

                   .build();


           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME
           List<PartyTaxScheme> partyTaxSchemeListCreditNote = new ArrayList<>();
           PartyTaxScheme partyTaxSchemeCreditNote1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                   .companyId(new CompanyID.CompanyIDBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_PartTaxSchemeID"))

                           .build())
                   .taxScheme(taxSchemeCreditNote1)
                   .build();
           partyTaxSchemeListCreditNote.add(partyTaxSchemeCreditNote1);


           //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY
           List<PartyLegalEntity> partyLegalEntityListCreditNote = new ArrayList<>();
           PartyLegalEntity partyLegalEntityCreditNote1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                   .registrationName(new RegistrationName.RegistrationNameBuilder()
                           .value((String) customer_entity.getAttributeValue("cbc_RegistrationName"))
                           .build())
                   .companyId(new CompanyID.CompanyIDBuilder()
                           .value((String)customer_entity.getAttributeValue("cbc_CompanyID"))
                           .build())

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


    /**
     * Element TaxTotal [List]
     */

            ObjectReference[] obj3 = invoice_entity.getReferences("cac_TaxTotal");
                        IEntity taxTotal_entity = iee.getEntity(this, "TaxTotal", obj3[0].m_objectId);
            //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
            TaxScheme taxSchemeInvoice44 = new TaxScheme.TaxSchemeBuilder()
                    .id(new ID.IDBuilder()
                            .value((String) taxTotal_entity.getAttributeValue("cbc_TaxTotalTaxSchemeId"))
                            .build())

                    .build();

            //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
            TaxCategory taxCategoryInvoice44 = new TaxCategory.TaxCategoryBuilder()
                    .id(new ID.IDBuilder()
                            .value((String) taxTotal_entity.getAttributeValue("cbc_TaxCategoryID"))

                            .build())
                    .percent(new Percent.PercentBuilder().value((String) taxTotal_entity.getAttributeValue("cbc_Percent")).build())
                    .taxScheme(taxSchemeInvoice44)
                    .build();


    //TAX TOTAL > TAX SUB TOTAL
            List<TaxSubTotal> taxSubTotalList44 = new ArrayList<>();
            TaxSubTotal taxSubTotal44 = new TaxSubTotal.TaxSubTotalBuilder()
                    .taxableAmount(new TaxableAmount.TaxableAmountBuilder()
                            .value((String) taxTotal_entity.getAttributeValue("cbc_TaxableAmount"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) taxTotal_entity.getAttributeValue("cbc_TaxableAmountAttributes"))
                                    .build())
                            .build())
                    .taxAmount(new TaxAmount.TaxAmountBuilder()
                            .value((String) taxTotal_entity.getAttributeValue("cbc_TaxAmount"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) taxTotal_entity.getAttributeValue("cbc_TaxAmountAttributes"))
                                    .build())
                            .build())

                    .taxCategory(taxCategoryInvoice44)
                    .build();
            taxSubTotalList44.add(taxSubTotal44);


    //TAX TOTAL
            List<TaxTotal> taxTotalList44 = new ArrayList<>();
            TaxTotal taxTotal44 = new TaxTotal.TaxTotalBuilder()
                    .taxAmount(new TaxAmount.TaxAmountBuilder()
                            .value((String) taxTotal_entity.getAttributeValue("cbc_TaxTotalAmount"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) taxTotal_entity.getAttributeValue("cbc_TaxTotalAmountAttributes"))
                                    .build())
                            .build())
                    .taxSubTotalList(taxSubTotalList44)
                    .build();

            taxTotalList44.add(taxTotal44);


    /**
     * Element LegalMonetaryTotal
     */

            ObjectReference[] obj4 = invoice_entity.getReferences("cac_LegalMonetaryTotal");
            IEntity LegalMonetaryTotal_entity = iee.getEntity(this, "LegalMonetaryTotal", obj4[0].m_objectId);

            LegalMonetaryTotal legalMonetaryTotalInvoice1 = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                    .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                            .value((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAmount"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAttributes"))
                                    .build())
                            .build())
                    .taxExclusiveAmount(new TaxExclusiveAmount.TaxExclusiveAmountBuilder()
                            .value((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_TaxExclusiveAmount"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAttributes"))
                                    .build())
                            .build())
                    .taxInclusiveAmount(new TaxInclusiveAmount.TaxInclusiveAmountBuilder()
                            .value((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_TaxInclusiveAmount"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAttributes"))
                                    .build())
                            .build())
                    .payableAmount(new PayableAmount.PayableAmountBuilder()
                            .value((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_PayableAmount"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAttributes"))
                                    .build())
                            .build())
                    .build();

    /**
     * Element InvoiceLine [List]
     */

    //INVOICE LINE

            IEntity[] lines = iee.getAllReferences(this, invoice_entity, "cac_InvoiceLine");
            List<InvoiceLine> invoiceLineList44 = new ArrayList<>();
            for(int i=0; i<lines.length; i++)
            {
                ClassifiedTaxCategory classifiedTaxCategoryInvoice44 = new ClassifiedTaxCategory.ClassifiedTaxCategoryBuilder()
                    .id(new ID.IDBuilder()
                            .value((String) lines[i].getAttributeValue("cbc_ID"))
                            .build())
                    .percent(new Percent.PercentBuilder().value((String) lines[i].getAttributeValue("cbc_Percent")).build())
                    .taxScheme(taxSchemeInvoice44)
                    .build();


        //INVOICE LINE > ITEM
                Item item44 = new Item.ItemBuilder()       
                       .name(new Name.NameBuilder()
                            .value((String) lines[i].getAttributeValue("cbc_itemName1"))
                            .build())
                       .classifiedTaxCategory(classifiedTaxCategoryInvoice44)
                       .build();


        //INVOICE LINE > PRICE
                Price price44 = new Price.PriceBuilder()
                    .priceAmount(new PriceAmount.PriceAmountBuilder()
                            .value((String) lines[i].getAttributeValue("cbc_Price1"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) lines[i].getAttributeValue("cbc_priceAmountAttributes1"))
                                    .build())
                            .build())
                    .baseQuantity(new BaseQuantity.BaseQuantityBuilder()
                            .value((String) lines[i].getAttributeValue("cbc_Quantity1"))
                            .attributes(new PatternCode.PatternCodeBuilder()
                                    .unitCode((String) lines[i].getAttributeValue("cbc_QuantityAttribute1"))
                                    .build())
                            .build())

                    .build();

        //  INVOICE LINE
                InvoiceLine invoiceLine44 = new InvoiceLine.InvoiceLineBuilder()        
                    .id(new ID.IDBuilder()
                            .value((String) lines[i].getAttributeValue("cbc_invoiceLineId1"))
                            .attributes(new PatternScheme.PatternSchemeBuilder()
                                    .build())
                            .build())
                    .invoicedQuantity(new InvoicedQuantity.InvoicedQuantityBuilder()
                            .value((String) lines[i].getAttributeValue("cbc_invoiceLineQuantity1"))
                            .attributes(new PatternCode.PatternCodeBuilder()
                                    .unitCode((String) lines[i].getAttributeValue("cbc_invoiceQuantityAttributes1"))
                                    .build()).build())
                    .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                            .value((String) lines[i].getAttributeValue("cbc_ExtensionAmount1"))
                            .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                    .currencyID((String) lines[i].getAttributeValue("cbc_ExtensionAmountAttribute1"))
                                    .build())
                            .build())
                    .item(item44)
                    .price(price44)
                    .build();
                    invoiceLineList44.add(invoiceLine44);
            }

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
            .build().load();

            docInvoice.generate();            
                System.out.println("XML is successfully created on given path");            
            } 
            catch (ParserConfigurationException ex) {
                Logger.getLogger(MyProcessLibrary.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ParaserConfiguration Exception occur");
            } catch (TransformerException ex) {
                Logger.getLogger(MyProcessLibrary.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("TransformerException Exception occur");
            } catch (InvalidParameterException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("InvalidParameterException Exception occur");                
            }
        
            return null;           
    }
    

    @Override
    public Object resume(IExecutionEngine iee, Object o) throws SuspendProcessException, ExecutionException, AccessDeniedException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

   


    
}
