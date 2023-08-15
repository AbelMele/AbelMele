package Excel;

public class products {
    private static int id;
    private static String title;
    private static String description;
    private static Double price;
    private static Double discountPercentage;
    private static Double rate;
    private static int stock;
    private static String brand;
    private static String category;
    private static String thumbnail;
    private static String image;
   // private List<String> image;

   // private List<Product> products;
   public static int getId() {
      return id;
    }




    public void setId() {
       this.id = id;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = title;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public static Double getPrice() {
        return price;
    }
    public void setPrice(){
        this.price =price;
    }

    public static Double getDiscountPercentage() {
            return discountPercentage;
        }


    public void setDiscountPercentage() {
        this.discountPercentage = discountPercentage;
    }

    public static Double getRate() {
        return rate;
    }

    public void setRate() {
        this.rate = rate;
    }
    public static int getStock() {
        return stock;
    }

    public void setStock() {
        this.stock = stock;
    }

    public static String getBrand() {
        return brand;
    }

    public void setBrand() {
        this.brand = brand;
    }

    public static String getCategory() {
        return category;
    }

    public void setCategory() {
        this.category = category;
    }

    public static String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail() {
        this.thumbnail = thumbnail;
    }

    public static String getImage() {
        return image;
    }

    public void setImage() {
        this.image = image;
    }

 public String toString() {
       return "products{"+
               "id=" + id +
               ", title= '" + title + '\'' +
               ",description='" + description + '\''+
               ",price=" + price +
               ",discountPercentage=" + discountPercentage +
               ",rate=" + rate +
               ",stock=" + stock +
               ", brand= '" + brand + '\'' +
               ", category= '" + category + '\'' +
               ", thumbnail= '" + thumbnail + '\'' +
               ",image=" + image +
               '}';
 }

}

