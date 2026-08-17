import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 

public class ContactTest {
    @Test 
  void constructor_setsNameCorrectly() { 
    Contact c = new Contact("Alice", "123-456-7890"); 
    assertEquals("Alice", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    Contact c = new Contact("Bob", "987-654-3210"); 
    assertEquals("987-654-3210", c.getPhoneNumber()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Charlie", "555-555-5555"); 
    assertEquals("Charlie", c.getName());
  } 
} 

