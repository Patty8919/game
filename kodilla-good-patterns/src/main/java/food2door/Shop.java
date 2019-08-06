package food2door;

public class Shop {
    public String shopName;
    public int quantityOfProduct;
    public String productName;

    public Shop(String shopName, int quantityOfProduct, String productName) {
        this.shopName = shopName;
        this.quantityOfProduct = quantityOfProduct;
        this.productName = productName;
    }

    public String getShopName() {
        return shopName;
    }

    public int getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public String getProductName() {
        return productName;
    }
}
