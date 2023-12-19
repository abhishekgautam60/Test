/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.efaktura;

import com.bas.basserver.executionengine.ExecutionException;
import com.bas.basserver.executionengine.IExecutionEngine;
import com.bas.basserver.executionengine.IProcess;
import com.bas.basserver.executionengine.ServerTimeOutException;
import com.bas.basserver.executionengine.SuspendProcessException;
import com.bas.connectionserver.server.AccessDeniedException;
import com.bas.shared.data.EntityIdAndName;
import com.bas.shared.data.ObjectReference;
import com.bas.shared.domain.operation.IEntity;
import com.test.efaktura.Customers;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.openadaptor.dataobjects.InvalidParameterException;
import xml.ubl.modules.InvoiceLine;
/**
 *
 * @author Abhishek.Gautam
 */
public class MyProcessLibrary implements IProcess {

    public String t;
	@Override
	public boolean cancel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object execute(IExecutionEngine engine, Object[] processParameters)
			throws SuspendProcessException, ExecutionException, AccessDeniedException
	{
            

        try {
            // get the parameter
            IEntity invoice_entity = (IEntity) processParameters [0];
            IEntity system_settings_entity = (IEntity) processParameters [1];
            
            System.out.println(invoice_entity.getAttributeValue("cbc_DocumentCurrencyCode"));
            System.out.println(system_settings_entity.getAttributeValue("DocumentPath"));
            System.out.println(invoice_entity.getAttributeValue("cbc_ID"));

            
            InputVariables inputVariables=new InputVariables();
            inputVariables.setDocumentCurrencyCode((String) invoice_entity.getAttributeValue("cbc_DocumentCurrencyCode"));
            inputVariables.setId((String) invoice_entity.getAttributeValue("cbc_ID"));
            inputVariables.setInvoiceTypeCode((String)invoice_entity.getAttributeValue("cbc_InvoiceTypeCode"));
            inputVariables.setIssueDate((String) invoice_entity.getAttributeValue("cbc_Date"));
            inputVariables.setDueDate((String) invoice_entity.getAttributeValue("cbc_DueDate"));
            
//            Accounting Supplier party

            ObjectReference[] obj1 = invoice_entity.getReferences("cac_SupplierParty");
            IEntity supplier_entity = engine.getEntity(this, "AccountingSupplierParty", obj1[0].m_objectId);
            System.out.println("supplier name " + supplier_entity.getName());
            
            System.out.println("supplier name " + (String) supplier_entity.getAttributeValue("cbc_CityName"));
              
           inputVariables.setPartyIdentification1Invoice((String) supplier_entity.getAttributeValue("cbc_ID"));
           inputVariables.setPartyNameListInvoice((String) supplier_entity.getAttributeValue("cbc_Name"));
//           Country
           inputVariables.setIdentificationCode((String) supplier_entity.getAttributeValue("cbc_CountryIdentificationCode"));           
//           Postal Address
           inputVariables.setStreetName((String) supplier_entity.getAttributeValue("cbc_StreetName"));                                         
           inputVariables.setAddressFormatCode((String) supplier_entity.getAttributeValue("cbc_AdditionalStreetName"));
           inputVariables.setCityName((String) supplier_entity.getAttributeValue("cbc_CityName"));
           inputVariables.setCountrySubentity((String) supplier_entity.getAttributeValue("cbc_CountrySubentity"));
//           party Tax Scheme
            inputVariables.setTaxSchemeID((String) supplier_entity.getAttributeValue("cbc_TaxSchemeID"));
            inputVariables.setPartyTaxSchemeID((String) supplier_entity.getAttributeValue("cbc_PartyTaxSchemeID"));
//           party legal Entity           
            inputVariables.setRegistrationName((String) supplier_entity.getAttributeValue("cbc_RegistrationName"));  
            inputVariables.setPartyLegalEntityId((String) supplier_entity.getAttributeValue("cbc_CompanyID"));  
            inputVariables.setPartyLegalForm((String) supplier_entity.getAttributeValue("cbc_CompanyLegalForm"));
           
            
            
//        Accounting Customer Party
            ObjectReference[] obj2 = invoice_entity.getReferences("cac_CustomerParty");
            IEntity customer_entity = engine.getEntity(this, "AccountingCustomerParty", obj2[0].m_objectId);
            System.out.println(customer_entity.getAttributeValue("cbc_Name"));

            inputVariables.setCustomerPartyIdentificationId((String) customer_entity.getAttributeValue("cbc_ID"));
            inputVariables.setCustomerPartyName((String) customer_entity.getAttributeValue("cbc_Name"));
            
//            Country
            inputVariables.setCustomerCountryCode((String) customer_entity.getAttributeValue("cbc_CountryCode"));
            
//           postal addres
            inputVariables.setCustomerStreetName((String) customer_entity.getAttributeValue("cbc_StreetName"));
            inputVariables.setCustomerAddresFormateCode((String) customer_entity.getAttributeValue("cbc_CustomerAddresFormateCode"));            
            inputVariables.setCustomerCityName((String) customer_entity.getAttributeValue("cbc_CityName"));
            inputVariables.setCustomerCountySubentity((String) customer_entity.getAttributeValue("cbc_CountrySubentity"));
            
//             TaxScheme
            inputVariables.setCustomerTaxSchemeID((String) customer_entity.getAttributeValue("cbc_TaxSchemeID"));
//            party tax sccheme
            inputVariables.setCustomerPartyTaxSchemeId((String) customer_entity.getAttributeValue("cbc_PartTaxSchemeID"));
           
//            party legal entity
            inputVariables.setCustomerPartyLegalRegistrationName((String) customer_entity.getAttributeValue("cbc_RegistrationName"));
            inputVariables.setCustomerPartylegalRegistrationId((String)customer_entity.getAttributeValue("cbc_CompanyID"));
            
            
                        
//            TAX Total

            ObjectReference[] obj3 = invoice_entity.getReferences("cac_TaxTotal");
            IEntity taxTotal_entity = engine.getEntity(this, "TaxTotal", obj3[0].m_objectId);
            System.out.println(taxTotal_entity.getAttributeValue("cbc_TaxTotalTaxSchemeId"));
//Tax Scheme
            inputVariables.setTaxTotalAmount((String) taxTotal_entity.getAttributeValue("cbc_TaxTotalAmount"));
            inputVariables.setTaxTotalAmountAttributes((String) taxTotal_entity.getAttributeValue("cbc_TaxTotalAmountAttributes"));
            

            inputVariables.setTaxTotalTaxSchemeId((String) taxTotal_entity.getAttributeValue("cbc_TaxTotalTaxSchemeId"));
//            Tax Category
            inputVariables.setTaxTotalTaxCategory((String) taxTotal_entity.getAttributeValue("cbc_TaxCategoryID"));
            inputVariables.setTaxSubTotalPercent((String) taxTotal_entity.getAttributeValue("cbc_Percent"));
            
//            Tax sub total
            inputVariables.setTaxSubTotalTaxableAmount((String) taxTotal_entity.getAttributeValue("cbc_TaxableAmount"));
            inputVariables.setTaxSubTotalTaxableAmountAttribute((String) taxTotal_entity.getAttributeValue("cbc_TaxableAmountAttributes"));
            inputVariables.setTaxSubTotalTaxAmount((String) taxTotal_entity.getAttributeValue("cbc_TaxAmount"));
            inputVariables.setTaxSubTotalTaxAmountAttributes((String) taxTotal_entity.getAttributeValue("cbc_TaxAmountAttributes"));
            
            
             ObjectReference[] obj4 = invoice_entity.getReferences("cac_LegalMonetaryTotal");
            IEntity LegalMonetaryTotal_entity = engine.getEntity(this, "LegalMonetaryTotal", obj4[0].m_objectId);
            System.out.println(LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAmount"));
            
//            Legal Monetary Total
            inputVariables.setLineExtensionAmount((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAmount"));
            inputVariables.setLineExtensionAmountAttributes((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_LineExtensionAttributes"));
            inputVariables.setTaxExclusiveAmount((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_TaxExclusiveAmount"));
            inputVariables.setTaxInclusiveAmount((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_TaxInclusiveAmount"));
            inputVariables.setPayableAmount((String) LegalMonetaryTotal_entity.getAttributeValue("cbc_PayableAmount"));
            
            
            IEntity[] lines = engine.getAllReferences(this, invoice_entity, "cac_InvoiceLine");
            
            System.out.println(lines[0].getAttributeValue("cbc_ID"));
          
            System.out.println("obj5 count " + lines.length);
          
            for(int i=0; i<lines.length; i++)
            {
                inputVariables.setClassifiedTaxCategoryId((String) lines[i].getAttributeValue("cbc_ID"));            
                inputVariables.setClassifiedTaxCategoryPercent((String) lines[i].getAttributeValue("cbc_Percent"));
                inputVariables.setDescription((String) lines[i].getAttributeValue("cbc_Description")); 
                if(i<1){                         
                inputVariables.setItem1Name((String) lines[i].getAttributeValue("cbc_itemName1"));    
                inputVariables.setPriceAmount1((String) lines[i].getAttributeValue("cbc_Price1"));                        
                inputVariables.setPriceAmountAttributes1((String) lines[i].getAttributeValue("cbc_priceAmountAttributes1"));                        
                inputVariables.setBaseQuantity1((String) lines[i].getAttributeValue("cbc_Quantity1"));                      
                inputVariables.setBaseQuantityAttributes1((String) lines[i].getAttributeValue("cbc_QuantityAttribute1")); 
                inputVariables.setInvoiceLineId1((String) lines[i].getAttributeValue("cbc_invoiceLineId1"));
                inputVariables.setInvoiceLineInvoicedQuantity1((String) lines[i].getAttributeValue("cbc_invoiceLineQuantity1"));
                inputVariables.setInvoiceLineInvoicedQuantityAttributes1((String) lines[i].getAttributeValue("cbc_invoiceQuantityAttributes1"));
                inputVariables.setInvoiceLineExtensionAmount1((String) lines[i].getAttributeValue("cbc_ExtensionAmount1"));
                inputVariables.setInvoiceLineExtensionAmountAttributes1((String) lines[i].getAttributeValue("cbc_ExtensionAmountAttribute1"));
            }                
                else
                {                         
                inputVariables.setItem2Name((String) lines[i].getAttributeValue("cbc_itemName2"));    
                inputVariables.setPriceAmount2((String) lines[i].getAttributeValue("cbc_price2"));                        
                inputVariables.setPriceAmountAttributes2((String) lines[i].getAttributeValue("cbc_priceAmountAttributes2"));                        
                inputVariables.setBaseQuantity2((String) lines[i].getAttributeValue("cbc_Quantity2"));                      
                inputVariables.setBaseQuantityAttributes2((String) lines[i].getAttributeValue("cbc_QuantityAttribute2")); 
                inputVariables.setInvoiceLineId2((String) lines[i].getAttributeValue("cbc_invoiceLineId2"));
                inputVariables.setInvoiceLineInvoicedQuantity2((String) lines[i].getAttributeValue("cbc_invoiceLineQuantity2"));
                inputVariables.setInvoiceLineInvoicedQuantityAttributes2((String) lines[i].getAttributeValue("cbc_invoiceQuantityAttributes2"));
                inputVariables.setInvoiceLineExtensionAmount2((String) lines[i].getAttributeValue("cbc_ExtensionAmount2"));
                inputVariables.setInvoiceLineExtensionAmountAttributes2((String) lines[i].getAttributeValue("cbc_ExtensionAmountAttribute2"));
                }
         
            
            }


            
            
            
            
            System.out.println(inputVariables.getDocumentCurrencyCode());
            TestController mainController=new TestController();
            mainController.newXmlStart(inputVariables);

            
            
            System.out.println("Process started..");
            
        } catch (InvalidParameterException ex) {
            Logger.getLogger(MyProcessLibrary.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception ocur");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MyProcessLibrary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(MyProcessLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
                
  
        }
      

	@Override
	public Object resume(IExecutionEngine arg0, Object arg1)
			throws SuspendProcessException, ExecutionException{
		// TODO Auto-generated method stub
		return null;
	}
        
        
       
        
}