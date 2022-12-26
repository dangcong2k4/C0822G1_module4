package com.codegym.casetudy.model.contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class ContractDetail implements Serializable {
    @Id
    @ManyToOne
    private AttachFacility attachFacility;
    @Id
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName ="id")
    private Contract contract;
    private int quantity;

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
