package bai17_io_binary_file_serialization.bai_tap.manage_product;

import java.io.Serializable;

/*
Thông tin sản phẩm gồm:
- Mã sản phẩm
- Tên sản phẩm
- Hãn sản xuất
- Giá
- Các mô tả khác
 */
public class Product implements Serializable {
    private String productCode;
    private String productName;
    private String manufacturer;
    private double price;
    private String otherDescription;

    public Product(String productCode, String productName, String manufacturer, double price, String otherDescription) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.otherDescription = otherDescription;
    }

//    public void inputProduct(){
//        System.out.println("Please input pro");
//    }
    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", otherDescription='" + otherDescription + '\'' +
                '}';
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }
}
