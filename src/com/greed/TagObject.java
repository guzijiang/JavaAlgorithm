package src.com.greed;

public class TagObject {
    int weight;
    int price;
    int status;
    int tag;

    public TagObject(int weight, int price, int tag) {
        this.weight = weight;
        this.price = price;
        this.tag = tag;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
