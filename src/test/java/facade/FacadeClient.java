package facade;

import facade.implementation.Item;
import facade.implementation.ShopFascade;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeClient {

    @Test
    void BuyFiveEggs() {
        ShopFascade shopFascade = new ShopFascade();
        List<Item> boughtItems = shopFascade.buyItems("Egg", 5);
        
        assertEquals(5, boughtItems.size());
        assertEquals("Egg", boughtItems.get(0).getName());
    }
    
    @Test
    void BuyMilk() {
        ShopFascade shopFascade = new ShopFascade();
        Item milk = shopFascade.buyMilk();
        
        assertEquals("Milk", milk.getName());
    }
}
