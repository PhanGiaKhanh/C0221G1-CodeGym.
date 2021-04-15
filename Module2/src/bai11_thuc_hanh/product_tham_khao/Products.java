package bai11_thuc_hanh.product_tham_khao;

public class Products {
    private int id;
    private String nameProducts;
    private double priceProduct;

    public Products() {
    }

    public Products(int id, String nameProducts, double priceProduct) {
        this.id = id;
        this.nameProducts = nameProducts;
        this.priceProduct = priceProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", nameProducts='" + nameProducts + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
