    package Database;

    public class Categories {

      private String productId;
      private String productName;

      public Categories() {

      }

      public Categories(String id, String name) {
          this.productId = id;
          this.productName = name;
      }

      public Categories(String name) {
        this.productName = name;
      }

      public void setName(String n) {
        this.productName = n;
      }

      public void setId(String id) {
        this.productId = id;
      }

      public String getName() {
        return this.productName;
      }

      public String getId() {
        return this.productId;
      }

    }
