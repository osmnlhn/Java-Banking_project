import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
   Customer customer;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception {
     this.customer=new Customer("Osman");
    }

    @org.junit.jupiter.api.Test
    void setAddress() {

     assertNull(this.customer.getAddress());

     this.customer.setAddress("London");
     assertEquals("London",this.customer.getAddress());

     this.customer.setAddress("Batman");
     assertEquals("Batman",this.customer.getAddress());
    }
}