package com.stage.backend.domain;

public class ValuesByCodeTypeAndValClmAndcodeTypeClm {
    String codeTypeRef;
    String valeurClm;
    String valTypeClm;

    public ValuesByCodeTypeAndValClmAndcodeTypeClm() {
        super();
        // TODO Auto-generated constructor stub
    }
    public ValuesByCodeTypeAndValClmAndcodeTypeClm(String codeTypeRef, String valeurClm, String valTypeClm) {
        super();
        this.codeTypeRef = codeTypeRef;
        this.valeurClm = valeurClm;
        this.valTypeClm = valTypeClm;
    }
    public String getCodeTypeRef() {
        return codeTypeRef;
    }
    public void setCodeTypeRef(String codeTypeRef) {
        this.codeTypeRef = codeTypeRef;
    }
    public String getValeurClm() {
        return valeurClm;
    }
    public void setValeurClm(String valeurClm) {
        this.valeurClm = valeurClm;
    }
    public String getValTypeClm() {
        return valTypeClm;
    }
    public void setValTypeClm(String valTypeClm) {
        this.valTypeClm = valTypeClm;
    }
    @Override
    public String toString() {
        return "ValuesByCodeTypeAndValClmAndcodeTypeClm [codeTypeRef=" + codeTypeRef + ", valeurClm=" + valeurClm
                + ", valTypeClm=" + valTypeClm + "]";
    }

}
