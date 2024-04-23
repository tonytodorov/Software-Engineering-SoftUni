import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class InstockTest {

    public static final String PRODUCT_LABEL = "test_label";
    public static final double PRODUCT_PRICE = 15.00;
    public static final int PRODUCT_QUANTITY = 10;
    public static final double DUPLICATED_PRICE = 11.99;
    public static final double BEGIN = 32.99;
    public static final double END = 70.99;

    Instock instock;
    Product product;

    @Before
    public void setUp() {
        this.instock = new Instock();
        this.product = new Product(PRODUCT_LABEL, PRODUCT_PRICE, PRODUCT_QUANTITY);
    }

    @Test
    public void test_Contains_Return_Correct_Result() {
        instock.add(product);
        assertTrue(instock.contains(product));
        assertFalse(instock.contains(new Product("not_added", PRODUCT_PRICE, PRODUCT_QUANTITY)));
    }

    @Test
    public void test_Count_Return_Correct_Result() {
        assertEquals(0, instock.getCount());
        instock.add(product);
        assertEquals(1, instock.getCount());

    }

    @Test
    public void test_ChangeQuantity_Applies_NewQuantity_WhenProductPresent() {
        instock.add(product);

        int expectedQuantity = PRODUCT_QUANTITY * 7;
        instock.changeQuantity(product.getLabel(), expectedQuantity);

        assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeQuantity_ThrowsException_WhenProductNotPresent() {
        instock.changeQuantity(product.getLabel(), PRODUCT_QUANTITY);
    }

    @Test
    public void test_FindByIndex_ShouldReturnProduct_InInsertionOrder() {
        List<Product> products = addProducts();

        int index = 3;

        String expectedLabel = products.get(index).getLabel();

        Product p = instock.find(index);
        assertNotNull(p);
        String actualLabel = p.getLabel();

        assertEquals(expectedLabel, actualLabel);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_FindByIndex_ShouldThrow_When_IndexOutOfBounds() {
        instock.find(instock.getCount() + 1);
    }

    @Test
    public void test_FindByLabel_ShouldReturn_ProductWithMatchingLabel() {
        instock.add(product);
        Product foundProduct = instock.findByLabel(product.getLabel());
        assertNotNull(foundProduct);
        assertEquals(product.getLabel(), foundProduct.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FindByLabel_ShouldThrow_When_LabelIsMissing() {
        instock.findByLabel(product.getLabel());
    }

    @Test
    public void test_FindFirstByAlphabeticalOrder_ShouldReturn_CorrectCountOfProducts() {
        int count = addProducts().size() - 2;
        List<Product> products = toList(instock.findFirstByAlphabeticalOrder(count));
        assertEquals(count, products.size());

    }

    @Test
    public void test_FindFirstByAlphabeticalOrder_ShouldReturn_ProductsOrderedByLabel() {
        List<Product> expectedProducts = addProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());

        List<Product> actualProducts = toList(instock.findFirstByAlphabeticalOrder(expectedProducts.size()));
        assertProductListsEquals(expectedProducts, actualProducts);
    }

    @Test
    public void test_FindFirstByAlphabeticalOrder_ShouldReturn_EmptySet_When_CountIsTooLarge() {
        List<Product> products = toList(instock.findFirstByAlphabeticalOrder(1));
        assertTrue(products.isEmpty());
    }

    @Test
    public void test_FindAllInRange_ShouldReturn_CorrectRange() {
        addProducts();

        List<Product> products = toList(instock.findAllInRange(BEGIN, END));

        products.stream()
                .mapToDouble(Product::getPrice)
                .forEach(p -> assertTrue(p > BEGIN && p <= END));
    }

    @Test
    public void test_FindAllInRange_ShouldReturnIn_DescendingOrder() {
        List<Product> expectedProducts = addProducts().stream()
                .filter(p -> p.getPrice() > BEGIN && p.getPrice() <= END)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        List<Product> actualProducts = toList(instock.findAllInRange(BEGIN, END));

        assertProductListsEquals(expectedProducts, actualProducts);
    }

    @Test
    public void test_FindAllInRange_ShouldReturn_EmptySet_WhenNoneMatches() {
        double maxPrice = addProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .max()
                .orElse(0.00);

        List<Product> products = toList(instock.findAllInRange(maxPrice, maxPrice + 1));
        assertTrue(products.isEmpty());
    }

    @Test
    public void test_FindAllByPrice_ShouldReturn_MatchingPricesOnly() {
        addProducts();
        List<Product> products = toList(instock.findAllByPrice(DUPLICATED_PRICE));

        products.forEach(p -> assertEquals(DUPLICATED_PRICE, p.getPrice(), 0.00));
    }

    @Test
    public void test_FindAllByPrice_ShouldReturn_EmptySet_When_NoMatches() {
        addProducts();
        List<Product> products = toList(instock.findAllByPrice(100));

        assertTrue(products.isEmpty());
    }

    @Test
    public void test_FindAllByQuantity_ShouldReturn_MatchingQuantityOnly() {
        addProducts();
        List<Product> products = toList(instock.findAllByQuantity(PRODUCT_QUANTITY));

        products.forEach(p -> assertEquals(PRODUCT_QUANTITY, p.getQuantity(), 0.00));
    }

    @Test
    public void test_FindAllByQuantity_ShouldReturn_EmptySet_When_NoMatches() {
        addProducts();
        List<Product> products = toList(instock.findAllByQuantity(100));

        assertTrue(products.isEmpty());
    }


    @Test
    public void test_FindFirstMostExpensiveProducts_ShouldReturn_CorrectCountOfProducts() {
        addProducts();
        int count = 3;

        List<Product> products = toList(instock.findFirstMostExpensiveProducts(count));

        assertEquals(count, products.size());
    }

    @Test
    public void test_FindFirstMostExpensiveProducts_ShouldReturn_MostExpensiveProducts() {
        int count = 3;
        List<Product> expectedProducts = addProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());

        List<Product> actualProducts = toList(instock.findFirstMostExpensiveProducts(count));

        assertEquals(expectedProducts.size(), actualProducts.size());

        for (int i = 0; i < expectedProducts.size(); i++) {
            double expectedPrice = expectedProducts.get(i).getPrice();
            double actualPrice = actualProducts.get(i).getPrice();

            assertEquals(expectedPrice, actualPrice, 0.00);
        }
    }

    @Test
    public void test_FindFirstMostExpensiveProducts_ShouldReturn_EmptySet_IfCountIsLargerThanSize() {
        int size = addProducts().size();

        List<Product> products = toList(instock.findFirstMostExpensiveProducts(size + 1));

        assertTrue(products.isEmpty());
    }

    @Test
    public void test_Iterator_ReturnAllProducts() {
        List<Product> expectedProducts = addProducts();

        Iterator<Product> iterator = instock.iterator();

        assertNotNull(iterator);

        Iterable<Product> iterable = () -> iterator;

        List<Product> actualProducts = StreamSupport.stream(
                iterable.spliterator(), false)
                .collect(Collectors.toList());

        assertProductListsEquals(expectedProducts, actualProducts);
    }

    private List<Product> addProducts() {
        List<Product> products = List.of(
                new Product("test_label_2", 14.50, PRODUCT_QUANTITY),
                new Product("test_label_1", 42.99, 78),
                new Product("test_label_5", BEGIN, PRODUCT_QUANTITY),
                new Product("test_label_3", END, 24),
                new Product("test_label_4", DUPLICATED_PRICE, 35),
                new Product("test_label_7", 55.00, 2),
                new Product("test_label_6", DUPLICATED_PRICE, 99)
        );

        products.forEach(instock::add);
        return products;
    }

    private List<Product> toList(Iterable<Product> iterable) {
        assertNotNull(iterable);

        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    private static void assertProductListsEquals(List<Product> expectedProducts, List<Product> actualProducts) {
        assertEquals(expectedProducts.size(), actualProducts.size());

        for (int i = 0; i < expectedProducts.size(); i++) {
            String expectedProduct = expectedProducts.get(i).getLabel();
            String actualProduct = actualProducts.get(i).getLabel();

            assertEquals(expectedProduct, actualProduct);
        }
    }
}
