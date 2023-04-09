package Jupiter.toys.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import Jupiter.toys.Assertions.Assertion3;
import Jupiter.toys.Base.Base;
import Jupiter.toys.Pages.Cart;
import Jupiter.toys.Pages.Shop;
import Jupiter.toys.utilities.FloatConversion;


//To verify Product price, Subtotal and Total on Cart 
public class TC3_CartPage extends Base {

	@Test
	public void ValidateCartPage() throws InterruptedException {
		Shop sh = new Shop(driver, pr);
		sh.ShopLink();

		for (int i = 0; i < 2; i++) {
			sh.ProductSelectionBasedUponIndex(1);
		}

		for (int i = 0; i < 5; i++) {
			sh.ProductSelectionBasedUponIndex(3);
		}

		for (int i = 0; i < 3; i++) {
			sh.ProductSelectionBasedUponIndex(6);
		}

		String Expected_StuffedFrog = sh.ShopProductPrice(1);
		Float ExpectedPrice_StuffedFrog = FloatConversion.FloatConvert(Expected_StuffedFrog);

		String Expected_FluffyBunny = sh.ShopProductPrice(3);
		Float ExpectedPrice_FluffyBunny = FloatConversion.FloatConvert(Expected_FluffyBunny);

		String Expected_ValentineBear = sh.ShopProductPrice(6);
		Float ExpectedPrice_ValentineBear = FloatConversion.FloatConvert(Expected_ValentineBear);

		Float ExpectedST_StuffedFrog = 21.98f;
		Float ExpectedST_FluffyBunny = 49.95f;
		Float ExpectedST_ValentineBear = 44.97f;
		Float ExpectedTotal = ExpectedST_StuffedFrog + ExpectedST_FluffyBunny + ExpectedST_ValentineBear;

		Cart ca = new Cart(driver, pr);
		ca.CartLink();
		ca.VerifyCartItems("Stuffed Frog", ExpectedPrice_StuffedFrog, ExpectedST_StuffedFrog);
		ca.VerifyCartItems("Fluffy Bunny", ExpectedPrice_FluffyBunny, ExpectedST_FluffyBunny);
		ca.VerifyCartItems("Valentine Bear", ExpectedPrice_ValentineBear, ExpectedST_ValentineBear);

		Float ActualTotal = ca.ProductTotal();
		Assert.assertTrue(Assertion3.TotalAssertion(ActualTotal, ExpectedTotal, "TC3_CartPage"));

	}

}
