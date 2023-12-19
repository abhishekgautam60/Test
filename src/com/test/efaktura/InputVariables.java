package com.test.efaktura;



public class InputVariables {
	public String customizationId;
	public String id;
	public String dueDate;
	public String issueDate;
	public String invoiceTypeCode;
	public String documentCurrencyCode;
	public String partyIdentification1Invoice;	
	public String partyNameListInvoice;

//	postal address
	public String streetName;
	public String addressFormatCode;
	public String cityName;
	public String countrySubentity;
	
//	Country
	public String identificationCode;
	
//	Party Tax scheme
	public String PartyTaxSchemeID;
	public String TaxSchemeID;
        
//       party legal entity
        public String registrationName;
        public String partyLegalEntityId;
        public String partyLegalForm;

        
//        Acounting Customer party
        
//        party Identification
        public String customerPartyIdentificationId;
        public String customerPartyName;
        public String customerCountryCode;
        public String customerStreetName;
        public String customerAddresFormateCode;
        public String customerCityName;
        public String customerCountySubentity;
        
        
        public String customerTaxSchemeID;
        public String customerPartyTaxSchemeId;
        public String CustomerPartyLegalRegistrationName;
        public String customerPartylegalRegistrationId;
        
        
        
//        Tax total
        public String taxTotalTaxSchemeId;
        public String taxTotalTaxCategory;        
        public String taxSubTotalPercent;
        public String taxSubTotalTaxableAmount;
        public String taxSubTotalTaxableAmountAttribute;   
        public String taxSubTotalTaxAmount;
        public String taxSubTotalTaxAmountAttributes;
        public String taxTotalAmount;
        public String taxTotalAmountAttributes;
        
        
        
//        Legal Monetary Total
        public String lineExtensionAmount;
        public String lineExtensionAmountAttributes;
        public String taxExclusiveAmount;
        public String taxInclusiveAmount;
        public String payableAmount;
        
        
//        Invoice Line
//        seller itemidenetification
        public String classifiedTaxCategoryId;
        public String classifiedTaxCategoryPercent;
        
        public String description;
        
//        Item 1
        public String item1Name;
        public String invoiceLineId1;
        public String invoiceLineInvoicedQuantity1;
        public String invoiceLineInvoicedQuantityAttributes1;
        public String invoiceLineExtensionAmount1;
        public String invoiceLineExtensionAmountAttributes1;
        public String priceAmount1;
        public String priceAmountAttributes1;
        public String baseQuantity1;
        public String baseQuantityAttributes1;
        
        
//      Item 2               
        public String item2Name;               
        public String priceAmount2;
        public String priceAmountAttributes2;
        public String baseQuantity2;
        public String baseQuantityAttributes2;        
        public String invoiceLineId2;
        public String invoiceLineInvoicedQuantity2;
        public String invoiceLineInvoicedQuantityAttributes2;
        public String invoiceLineExtensionAmount2;
        public String invoiceLineExtensionAmountAttributes2;
        


 
        
        
        
        
        
        
        
    public InputVariables() {
        
    }

    public String getCustomizationId() {
        return customizationId;
    }

    public void setCustomizationId(String customizationId) {
        this.customizationId = customizationId;
    }

    public String getId() {
        return id;
    }

  

    public void setId(String id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public String getPartyIdentification1Invoice() {
        return partyIdentification1Invoice;
    }

    public void setPartyIdentification1Invoice(String partyIdentification1Invoice) {
        this.partyIdentification1Invoice = partyIdentification1Invoice;
    }

    public String getPartyNameListInvoice() {
        return partyNameListInvoice;
    }

    public void setPartyNameListInvoice(String partyNameListInvoice) {
        this.partyNameListInvoice = partyNameListInvoice;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAddressFormatCode() {
        return addressFormatCode;
    }

    public void setAddressFormatCode(String addressFormatCode) {
        this.addressFormatCode = addressFormatCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountrySubentity() {
        return countrySubentity;
    }

    public void setCountrySubentity(String countrySubentity) {
        this.countrySubentity = countrySubentity;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getPartyTaxSchemeID() {
        return PartyTaxSchemeID;
    }

    public void setPartyTaxSchemeID(String PartyTaxSchemeID) {
        this.PartyTaxSchemeID = PartyTaxSchemeID;
    }

    public String getTaxSchemeID() {
        return TaxSchemeID;
    }

    public void setTaxSchemeID(String TaxSchemeID) {
        this.TaxSchemeID = TaxSchemeID;
    }

    public InputVariables(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getPartyLegalEntityId() {
        return partyLegalEntityId;
    }

    public void setPartyLegalEntityId(String partyLegalEntityId) {
        this.partyLegalEntityId = partyLegalEntityId;
    }

    public String getPartyLegalForm() {
        return partyLegalForm;
    }

    public void setPartyLegalForm(String partyLegalForm) {
        this.partyLegalForm = partyLegalForm;
    }

    public String getCustomerPartyIdentificationId() {
        return customerPartyIdentificationId;
    }

    public void setCustomerPartyIdentificationId(String customerPartyIdentificationId) {
        this.customerPartyIdentificationId = customerPartyIdentificationId;
    }

    public String getCustomerPartyName() {
        return customerPartyName;
    }

    public void setCustomerPartyName(String customerPartyName) {
        this.customerPartyName = customerPartyName;
    }

    public String getCustomerCountryCode() {
        return customerCountryCode;
    }

    public void setCustomerCountryCode(String customerCountryCode) {
        this.customerCountryCode = customerCountryCode;
    }

    public String getCustomerStreetName() {
        return customerStreetName;
    }

    public void setCustomerStreetName(String customerStreetName) {
        this.customerStreetName = customerStreetName;
    }

    public String getCustomerAddresFormateCode() {
        return customerAddresFormateCode;
    }

    public void setCustomerAddresFormateCode(String customerAddresFormateCode) {
        this.customerAddresFormateCode = customerAddresFormateCode;
    }

    public String getCustomerCityName() {
        return customerCityName;
    }

    public void setCustomerCityName(String customerCityName) {
        this.customerCityName = customerCityName;
    }

    public String getCustomerCountySubentity() {
        return customerCountySubentity;
    }

    public void setCustomerCountySubentity(String customerCountySubentity) {
        this.customerCountySubentity = customerCountySubentity;
    }

    public String getCustomerTaxSchemeID() {
        return customerTaxSchemeID;
    }

    public void setCustomerTaxSchemeID(String customerTaxSchemeID) {
        this.customerTaxSchemeID = customerTaxSchemeID;
    }

    public String getCustomerPartyTaxSchemeId() {
        return customerPartyTaxSchemeId;
    }

    public void setCustomerPartyTaxSchemeId(String customerPartyTaxSchemeId) {
        this.customerPartyTaxSchemeId = customerPartyTaxSchemeId;
    }

    public String getCustomerPartyLegalRegistrationName() {
        return CustomerPartyLegalRegistrationName;
    }

    public void setCustomerPartyLegalRegistrationName(String CustomerPartyLegalRegistrationName) {
        this.CustomerPartyLegalRegistrationName = CustomerPartyLegalRegistrationName;
    }

    public String getCustomerPartylegalRegistrationId() {
        return customerPartylegalRegistrationId;
    }

    public void setCustomerPartylegalRegistrationId(String customerPartylegalRegistrationId) {
        this.customerPartylegalRegistrationId = customerPartylegalRegistrationId;
    }

    public String getTaxTotalTaxSchemeId() {
        return taxTotalTaxSchemeId;
    }

    public void setTaxTotalTaxSchemeId(String taxTotalTaxSchemeId) {
        this.taxTotalTaxSchemeId = taxTotalTaxSchemeId;
    }

    public String getTaxTotalTaxCategory() {
        return taxTotalTaxCategory;
    }

    public void setTaxTotalTaxCategory(String taxTotalTaxCategory) {
        this.taxTotalTaxCategory = taxTotalTaxCategory;
    }

    public String getTaxSubTotalPercent() {
        return taxSubTotalPercent;
    }

    public void setTaxSubTotalPercent(String taxSubTotalPercent) {
        this.taxSubTotalPercent = taxSubTotalPercent;
    }

    public String getTaxSubTotalTaxableAmount() {
        return taxSubTotalTaxableAmount;
    }

    public void setTaxSubTotalTaxableAmount(String taxSubTotalTaxableAmount) {
        this.taxSubTotalTaxableAmount = taxSubTotalTaxableAmount;
    }

    public String getTaxSubTotalTaxableAmountAttribute() {
        return taxSubTotalTaxableAmountAttribute;
    }

    public void setTaxSubTotalTaxableAmountAttribute(String taxSubTotalTaxableAmountAttribute) {
        this.taxSubTotalTaxableAmountAttribute = taxSubTotalTaxableAmountAttribute;
    }

    public String getTaxSubTotalTaxAmount() {
        return taxSubTotalTaxAmount;
    }

    public void setTaxSubTotalTaxAmount(String taxSubTotalTaxAmount) {
        this.taxSubTotalTaxAmount = taxSubTotalTaxAmount;
    }

    public String getTaxSubTotalTaxAmountAttributes() {
        return taxSubTotalTaxAmountAttributes;
    }

    public void setTaxSubTotalTaxAmountAttributes(String taxSubTotalTaxAmountAttributes) {
        this.taxSubTotalTaxAmountAttributes = taxSubTotalTaxAmountAttributes;
    }

    public String getTaxTotalAmount() {
        return taxTotalAmount;
    }

    public void setTaxTotalAmount(String taxTotalAmount) {
        this.taxTotalAmount = taxTotalAmount;
    }

    public String getTaxTotalAmountAttributes() {
        return taxTotalAmountAttributes;
    }

    public void setTaxTotalAmountAttributes(String taxTotalAmountAttributes) {
        this.taxTotalAmountAttributes = taxTotalAmountAttributes;
    }

    public String getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(String lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public String getLineExtensionAmountAttributes() {
        return lineExtensionAmountAttributes;
    }

    public void setLineExtensionAmountAttributes(String lineExtensionAmountAttributes) {
        this.lineExtensionAmountAttributes = lineExtensionAmountAttributes;
    }

    public String getTaxExclusiveAmount() {
        return taxExclusiveAmount;
    }

    public void setTaxExclusiveAmount(String taxExclusiveAmount) {
        this.taxExclusiveAmount = taxExclusiveAmount;
    }

    public String getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }

    public void setTaxInclusiveAmount(String taxInclusiveAmount) {
        this.taxInclusiveAmount = taxInclusiveAmount;
    }

    public String getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getClassifiedTaxCategoryId() {
        return classifiedTaxCategoryId;
    }

    public void setClassifiedTaxCategoryId(String classifiedTaxCategoryId) {
        this.classifiedTaxCategoryId = classifiedTaxCategoryId;
    }

    public String getClassifiedTaxCategoryPercent() {
        return classifiedTaxCategoryPercent;
    }

    public void setClassifiedTaxCategoryPercent(String classifiedTaxCategoryPercent) {
        this.classifiedTaxCategoryPercent = classifiedTaxCategoryPercent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem1Name() {
        return item1Name;
    }

    public void setItem1Name(String item1Name) {
        this.item1Name = item1Name;
    }

    public String getItem2Name() {
        return item2Name;
    }

    public void setItem2Name(String item2Name) {
        this.item2Name = item2Name;
    }

    public String getPriceAmount1() {
        return priceAmount1;
    }

    public void setPriceAmount1(String priceAmount1) {
        this.priceAmount1 = priceAmount1;
    }

    public String getPriceAmountAttributes1() {
        return priceAmountAttributes1;
    }

    public void setPriceAmountAttributes1(String priceAmountAttributes1) {
        this.priceAmountAttributes1 = priceAmountAttributes1;
    }

    public String getBaseQuantity1() {
        return baseQuantity1;
    }

    public void setBaseQuantity1(String baseQuantity1) {
        this.baseQuantity1 = baseQuantity1;
    }

    public String getBaseQuantityAttributes1() {
        return baseQuantityAttributes1;
    }

    public void setBaseQuantityAttributes1(String baseQuantityAttributes1) {
        this.baseQuantityAttributes1 = baseQuantityAttributes1;
    }

    public String getPriceAmount2() {
        return priceAmount2;
    }

    public void setPriceAmount2(String priceAmount2) {
        this.priceAmount2 = priceAmount2;
    }

    public String getPriceAmountAttributes2() {
        return priceAmountAttributes2;
    }

    public void setPriceAmountAttributes2(String priceAmountAttributes2) {
        this.priceAmountAttributes2 = priceAmountAttributes2;
    }

    public String getBaseQuantity2() {
        return baseQuantity2;
    }

    public void setBaseQuantity2(String baseQuantity2) {
        this.baseQuantity2 = baseQuantity2;
    }

    public String getBaseQuantityAttributes2() {
        return baseQuantityAttributes2;
    }

    public void setBaseQuantityAttributes2(String baseQuantityAttributes2) {
        this.baseQuantityAttributes2 = baseQuantityAttributes2;
    }

    public String getInvoiceLineId1() {
        return invoiceLineId1;
    }

    public void setInvoiceLineId1(String invoiceLineId1) {
        this.invoiceLineId1 = invoiceLineId1;
    }

    public String getInvoiceLineInvoicedQuantity1() {
        return invoiceLineInvoicedQuantity1;
    }

    public void setInvoiceLineInvoicedQuantity1(String invoiceLineInvoicedQuantity1) {
        this.invoiceLineInvoicedQuantity1 = invoiceLineInvoicedQuantity1;
    }

    public String getInvoiceLineInvoicedQuantityAttributes1() {
        return invoiceLineInvoicedQuantityAttributes1;
    }

    public void setInvoiceLineInvoicedQuantityAttributes1(String invoiceLineInvoicedQuantityAttributes1) {
        this.invoiceLineInvoicedQuantityAttributes1 = invoiceLineInvoicedQuantityAttributes1;
    }

    public String getInvoiceLineExtensionAmount1() {
        return invoiceLineExtensionAmount1;
    }

    public void setInvoiceLineExtensionAmount1(String invoiceLineExtensionAmount1) {
        this.invoiceLineExtensionAmount1 = invoiceLineExtensionAmount1;
    }

    public String getInvoiceLineExtensionAmountAttributes1() {
        return invoiceLineExtensionAmountAttributes1;
    }

    public void setInvoiceLineExtensionAmountAttributes1(String invoiceLineExtensionAmountAttributes1) {
        this.invoiceLineExtensionAmountAttributes1 = invoiceLineExtensionAmountAttributes1;
    }

    public String getInvoiceLineId2() {
        return invoiceLineId2;
    }

    public void setInvoiceLineId2(String invoiceLineId2) {
        this.invoiceLineId2 = invoiceLineId2;
    }

    public String getInvoiceLineInvoicedQuantity2() {
        return invoiceLineInvoicedQuantity2;
    }

    public void setInvoiceLineInvoicedQuantity2(String invoiceLineInvoicedQuantity2) {
        this.invoiceLineInvoicedQuantity2 = invoiceLineInvoicedQuantity2;
    }

    public String getInvoiceLineInvoicedQuantityAttributes2() {
        return invoiceLineInvoicedQuantityAttributes2;
    }

    public void setInvoiceLineInvoicedQuantityAttributes2(String invoiceLineInvoicedQuantityAttributes2) {
        this.invoiceLineInvoicedQuantityAttributes2 = invoiceLineInvoicedQuantityAttributes2;
    }

    public String getInvoiceLineExtensionAmount2() {
        return invoiceLineExtensionAmount2;
    }

    public void setInvoiceLineExtensionAmount2(String invoiceLineExtensionAmount2) {
        this.invoiceLineExtensionAmount2 = invoiceLineExtensionAmount2;
    }

    public String getInvoiceLineExtensionAmountAttributes2() {
        return invoiceLineExtensionAmountAttributes2;
    }

    public void setInvoiceLineExtensionAmountAttributes2(String invoiceLineExtensionAmountAttributes2) {
        this.invoiceLineExtensionAmountAttributes2 = invoiceLineExtensionAmountAttributes2;
    }


    
       
    
    

  
        
    
}
