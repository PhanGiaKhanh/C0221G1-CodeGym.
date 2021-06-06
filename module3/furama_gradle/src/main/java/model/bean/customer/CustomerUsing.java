package model.bean.customer;

public class CustomerUsing {
    private int contractId;
    private int customerId;
    private int serviceId;
    private String startDate;
    private String endDate;
    private String name;
    private String phone;
    private String serviceName;
    private double cost;

    public CustomerUsing(int contractId, int customerId, int serviceId, String startDate, String endDate, String name, String phone, String serviceName, double cost) {
        this.contractId = contractId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.phone = phone;
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
