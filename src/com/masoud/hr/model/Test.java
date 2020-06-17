package com.masoud.hr.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    static class EMP{
        String name;
        String code;

        public EMP(String code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj) return true;
            if(obj==null) return false;
            if(!(obj instanceof EMP)) return false;
            if(code==null || ((EMP)obj).code==null)
                return false;
            return code.equals(((EMP)obj).code);
        }

        @Override
        public int hashCode() {
            if(code==null) {
                return super.hashCode();
            }
            return 7 * code.hashCode();
        }
    }

    public static void main(String[] args) {
        EMP emp=new EMP("123");

        Set<EMP> empList=new HashSet<>();
        empList.add(emp);
        System.out.println(emp.hashCode());
        System.out.println( "123".hashCode());;
        System.out.println(empList.contains(new EMP("123")));
    }
}
