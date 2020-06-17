package com.masoud.hr.model;
public class Employee {
    private String name;
    private Integer personalCode;

    public Employee() {
    }

    public Employee(Integer personalCode) {
        this.personalCode = personalCode;
    }

    public Employee(String name, Integer personalCode) {
        this.name = name;
        this.personalCode = personalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(Integer personalCode) {
        this.personalCode = personalCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", personalCode=" + personalCode +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null) return false;
        if(!(obj instanceof Test.EMP)) return false;
        if(personalCode==null || ((Employee)obj).personalCode==null)
            return false;
        return personalCode.equals(((Test.EMP)obj).code);
    }

    @Override
    public int hashCode() {
        if(personalCode==null) {
            return super.hashCode();
        }
        return 7 * personalCode.hashCode();
    }
}
