package com.bsu;

import java.util.Objects;
class Company {
    private String nameOfCompany;
    private String shortNameOfCompany;
    private int actualDate;
    private String address;
    private int dateOfFoundation;
    private int numOfEmployees;
    private String auditor;
    private long phoneNumber;
    private String email;
    private String industry;
    private String kindOfActivity;
    private String internetAddress;
    int numOfFields = 12;
    public Company(String[] args) throws Exception {
        if(args.length<numOfFields){ throw new Exception("Error data"); }
        this.nameOfCompany = args[0];
        this.shortNameOfCompany = args[1];
        this.actualDate = Integer.parseInt(args[2]);
        this.address = args[3];
        this.dateOfFoundation = Integer.parseInt(args[4]);
        this.numOfEmployees = Integer.parseInt(args[5]);
        this.auditor = args[6];
        this.phoneNumber = Long.parseLong(args[7]);
        this.email = args[8];
        this.industry = args[9];
        this.kindOfActivity = args[10];
        this.internetAddress = args[11];
    }

  @Override
    public int hashCode() {
        return Objects.hash(nameOfCompany, shortNameOfCompany, actualDate, address, dateOfFoundation, numOfEmployees,
                auditor, phoneNumber, email, industry, kindOfActivity, internetAddress);
    }

    @Override
    public boolean equals(Object t) {
        if (this == t) return true;
        if (t == null || getClass() != t.getClass()) return false;
        Company company = (Company) t;
        return Objects.equals(nameOfCompany, company.nameOfCompany) &&
                Objects.equals(shortNameOfCompany, company.shortNameOfCompany) &&
                Objects.equals(actualDate, company.actualDate) &&
                Objects.equals(address, company.address) &&
                Objects.equals(dateOfFoundation, company.dateOfFoundation) &&
                Objects.equals(numOfEmployees, company.numOfEmployees) &&
                Objects.equals(auditor, company.auditor) &&
                Objects.equals(phoneNumber, company.phoneNumber) &&
                Objects.equals(email, company.email) &&
                Objects.equals(industry, company.industry) &&
                Objects.equals(kindOfActivity, company.kindOfActivity) &&
                Objects.equals(internetAddress, company.internetAddress);
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public void setShortNameOfCompany(String shortNameOfCompany) {
        this.shortNameOfCompany= shortNameOfCompany;
    }

    public void setActualDate(int actualDate) {
        this.actualDate = actualDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfFoundation(int dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public void setNumOfEmployees(Integer numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setKindOfActivity(String kindOfActivity) {
        this.kindOfActivity = kindOfActivity;
    }

    public void setURLAddress(String URLAddress) {
        this.internetAddress = URLAddress;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public String getShortNameOfCompany() {
        return shortNameOfCompany;
    }

    public int getActualDate() {
        return actualDate;
    }

    public String getAddress() {
        return address;
    }

    public int getDateOfFoundation() {
        return dateOfFoundation;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public String getAuditor() {
        return auditor;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getIndustry() {
        return industry;
    }

    public String getKindOfActivity() {
        return kindOfActivity;
    }

    public String getInternetAddress() {
        return internetAddress;
    }

}