package model.bean.contract;

public class ContractDetail {
    private int detailId;
    private int contractId;
    private int attachServiceID;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractId, int attachServiceID, int quantity) {
        this.contractId = contractId;
        this.attachServiceID = attachServiceID;
        this.quantity = quantity;
    }

    public ContractDetail(int detailId, int contractId, int attachServiceID, int quantity) {
        this.detailId = detailId;
        this.contractId = contractId;
        this.attachServiceID = attachServiceID;
        this.quantity = quantity;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAttachServiceID() {
        return attachServiceID;
    }

    public void setAttachServiceID(int attachServiceID) {
        this.attachServiceID = attachServiceID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
