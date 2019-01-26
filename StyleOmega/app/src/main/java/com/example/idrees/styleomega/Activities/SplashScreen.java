package com.example.idrees.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.idrees.styleomega.Model.Product;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.List;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Product> products = Product.listAll(Product.class);
        if(products==null && products.isEmpty()){
            addProducts();
        }

        startActivity(new Intent(SplashScreen.this, SignIn.class));
        // close splash activity
        try {
            finish();
        }
        catch (RuntimeException rethrown) {
            throw rethrown;
        } catch (Exception ignored) {
        }



    }

    public void addProducts() {
        Product M1=new Product("M001","PGA TOUR Men's Polo","Perfect for transitioning from the office to the greens, this classic short-sleeve polo from PGA TOUR features a comfortable athletic fit and modern allover windowpane print.",2936.00,25,"https://slimages.macysassets.com/is/image/MCY/products/3/optimized/10531023_fpx.tif",true,true,"MEN","TSHIRT");
        Product M2=new Product("M002","Under Armour Textured-Stripe Polo","Tee up in top-notch golf style and comfort with the soft lightweight design and cool moisture-wicking properties of this textured-stripe Tech polo from Under Armour.",3589.00,25,"https://slimages.macysassets.com/is/image/MCY/products/4/optimized/8457954_fpx.tif",false,true,"MEN","TSHIRT");
        Product M3=new Product("M003","Stripe Performance Polo","Feel like a pro for your next day on the green with the stylish stripes and moisture-wicking performance of this golf polo from PGA TOUR.",2450.00,25,"https://slimages.macysassets.com/is/image/MCY/products/8/optimized/10147818_fpx.tif",false,true,"MEN","TSHIRT");
        Product M4=new Product("M004","Michael Kors Polo Shirt","Enhance your casual look with this polished contrast-trim logo polo from Michael Kors.",1990.00,25,"https://slimages.macysassets.com/is/image/MCY/products/1/optimized/10021691_fpx.tif",false,true,"MEN","TSHIRT");

        Product M5=new Product("M005","Vintage Men's Waffle-Knit Henley","Perfect for transitioning from the office to the greens, this classic short-sleeve polo from PGA TOUR features a comfortable athletic fit and modern allover windowpane print.",4520.00,25,"https://slimages.macysassets.com/is/image/MCY/products/4/optimized/10327014_fpx.tif",true,true,"MEN","SHIRT");
        Product M6=new Product("M006","Mens Plaid Flannel Shirt ","Perfect for transitioning from the office to the greens, this classic short-sleeve polo from PGA TOUR features a comfortable athletic fit and modern allover windowpane print.",3698.00,25,"https://slimages.macysassets.com/is/image/MCY/products/0/optimized/10056180_fpx.tif",false,true,"MEN","SHIRT");
        Product M7=new Product("M007","Men's Brushed Jersey Crew","Perfect for transitioning from the office to the greens, this classic short-sleeve polo from PGA TOUR features a comfortable athletic fit and modern allover windowpane print.",2936.00,25,"https://slimages.macysassets.com/is/image/MCY/products/4/optimized/10755774_fpx.tif",false,false,"MEN","SHIRT");
        Product M8=new Product("M008","Brushed Flannel Shirt","Perfect for transitioning from the office to the greens, this classic short-sleeve polo from PGA TOUR features a comfortable athletic fit and modern allover windowpane print.",4856.00,25,"https://slimages.macysassets.com/is/image/MCY/products/4/optimized/10327014_fpx.tif",true,true,"MEN","SHIRT");

        Product M9=new Product("M009","Puma Men's Retro Woven Pants", "A retro-inspired look in woven fabric, these Puma pants are detailed with an iconic stripe at the sides for authentic style.",6895.00,25,"https://slimages.macysassets.com/is/image/MCY/products/2/optimized/9966102_fpx.tif",false,true,"MEN","PANTS");
        Product M10=new Product("M010","Puma Men's Knit Track Pants","Keep your look classic with these track pants from Puma, in timeless tricot with a brushed back for added comfort.",5874.00,25,"https://slimages.macysassets.com/is/image/MCY/products/1/optimized/11180971_fpx.tif",false,true,"MEN","PANTS");
        Product M11=new Product("M011","Alfani Men's Regular-Fit Pants","Perfect for transitioning from the office to the greens, this classic short-sleeve polo from PGA TOUR features a comfortable athletic fit and modern allover windowpane print.",3698.00,25,"https://slimages.macysassets.com/is/image/MCY/products/4/optimized/8563544_fpx.tif",false,false,"MEN","PANTS");
        Product M12=new Product("M012","adidas Men's Tricot Track Pants","Workout in warmth or relax in comfort in these adidas sweatpants, with a soft brushed lining and an adjustable waist. Three stripes at the sides add a classic look.",4250.00,25,"https://slimages.macysassets.com/is/image/MCY/products/3/optimized/10531023_fpx.tif",true,true,"MEN","PANTS");

        Product W1=new Product("W001","Juicy Couture Top","A repeating logo tape runs the length of each sleeve on a cropped Juicy Couture puffer jacket ready for heavy wardrobe rotation.",1200.00,25,"https://slimages.macysassets.com/is/image/MCY/products/7/optimized/11229457_fpx.tif",true,true,"WOMEN","TSHIRT");
        Product W2=new Product("W002","Reason Faux-Fur Anorak","Juicy Couture's LA logo pullover updates your sweater collection, styled in a comfy cotton knit with the LA logo at the front.",999.00,25,"https://slimages.macysassets.com/is/image/MCY/products/5/optimized/11386995_fpx.tif",false,false,"WOMEN","TSHIRT");
        Product W3=new Product("W003","Superdry Pacific Coast Logo Tank Top","Superdry's super cool tank top has relaxed muscle style with oversized arm holes and a bold logo.",2136.00,25,"https://slimages.macysassets.com/is/image/MCY/products/3/optimized/11334673_fpx.tif",false,false,"WOMEN","TSHIRT");
        Product W4=new Product("W004","28 NYC Cold Shoulder Lace ","Show off your sultry side with this bodysuit from PROJECT 28 NYC featuring cold-shoulder cutouts and lace throughout the body and sleeves.",1236.00,25,"https://slimages.macysassets.com/is/image/MCY/products/5/optimized/11322505_fpx.tif",false,true,"WOMEN","TSHIRT");

        Product W5=new Product("W005","I.N.C. Twist-Front Button-Up Top","Contemporary and flattering with a twist-front hem, I.N.C. International Concepts' V-neck top features a chic button front.",3566.00,25,"https://slimages.macysassets.com/is/image/MCY/products/2/optimized/10755352_fpx.tif",true,true,"WOMEN","SHIRT");
        Product W6=new Product("W006","Alfani Printed High-Low Tunic","Creative inspiration is at the heart of Alfani's artistically designed top.",4566.00,25,"https://slimages.macysassets.com/is/image/MCY/products/4/optimized/11134484_fpx.tif",false,true,"WOMEN","SHIRT");
        Product W7=new Product("W007","32 Degrees Cozy Heat Long-Sleeve Top","Get a sleek look in cozy comfort with this top from 32 Degrees, with heat retention and moisture wicking for improved performance. Stretch fabric creates a great fit.",5626.00,25,"https://slimages.macysassets.com/is/image/MCY/products/4/optimized/10408964_fpx.tif",false,false,"WOMEN","SHIRT");
        Product W8=new Product("W008","Alfani Ruffled-Sleeve Zip-Back Top","Pretty ruffles swirl around each sleeve, lending stand-out detail to this Alfani top. It zips neatly up the upper back.",3256.00,25,"https://slimages.macysassets.com/is/image/MCY/products/9/optimized/9437739_fpx.tif",true,true,"WOMEN","SHIRT");

        Product W9=new Product ("W009","Alfani Tummy-Control Pull","Alfani's essential tummy-control pants feature a stretchy fit and a sleek silhouette, giving you comfort throughout the day without sacrificing style.",4936.00,25,"https://slimages.macysassets.com/is/image/MCY/products/1/optimized/8083151_fpx.tif",false,true,"WOMEN","PANTS");
        Product W10=new Product("W010","Charter Club Lexington Corduroy Straight-Leg Pants","Corduroy and tummy-control come together in these Charter Club pants for a timeless and reliable look.",3928.00,25,"https://slimages.macysassets.com/is/image/MCY/products/6/optimized/10315366_fpx.tif",false,false,"WOMEN","PANTS");
        Product W11=new Product("W011","Lee Platinum Madelyn Straight-Leg Trousers","Lee Platinum's straight-leg pants are business-ready, so you can get a chic professional look.",2698.00,25,"https://slimages.macysassets.com/is/image/MCY/products/9/optimized/3971089_fpx.tif",false,true,"WOMEN","PANTS");
        Product W12=new Product("W012","Alfani Tummy-Control Pull-On Capri Pants","For work, weekend and everything in between, Alfani's pull-on capris deliver a sleek silhouette with endless styling potential. Our customers rave about the built-in tummy control panel that flattens your middle and adds instant polish to any ensemble.",3652.00,25,"https://slimages.macysassets.com/is/image/MCY/products/7/optimized/11233507_fpx.tif",true,true,"WOMEN","PANTS");

        Product MA1=new Product("MA01","Leather Amigo Dress Belt","Perry Ellis gives you two handsome looks in one with this Amigo belt. A stitched feature edge is the perfect complement to the sleek polished finish of the buckle.\n" +
                "\n" +
                "Nickel-finish swivel buckle\n" +
                "32mm\n" +
                "Metal buckle with cowhide strap",3200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/9/optimized/3511629_fpx.tif",true,true,"MENACC","BELT");
        Product MA2=new Product("MA02","Oxford Solid Tie","Tailored-made for the dapper gentleman. Highlight sleek suiting with this solid silk tie from Perry Ellis.\n" +
                "\n" +
                "Perry Ellis solid silk tie\n" +
                "3 1/4'' wide\n" +
                "56 1/4\" length",900.00,10,"https://slimages.macysassets.com/is/image/MCY/products/2/optimized/2342552_fpx.tif",true,false,"MENACC","TIE");
        Product MA3=new Product("MA03","Brown Shoe","The burnished toe of these classic Oxfords add an updated look to your office style.\n" +
                "\n" +
                "Cap toe\n" +
                "Lace-up closure\n" +
                "Leather lining for comfort and durability\n" +
                "Manmade upper; rubber sole\n" +
                "Imported",4500.00,10,"https://slimages.macysassets.com/is/image/MCY/products/7/optimized/8093757_fpx.tif",true,true,"MENACC","SHOE");
        Product MA4=new Product("MA04","Leather Black shoe","Embossed leather forms the classic driver silhouette and exceptional relaxed style of these fashionable slip-on shoes from Alfani.\n" +
                "\n" +
                "Moc toe\n" +
                "Slip-on style with bit",6200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/1/optimized/9987341_fpx.tif",true,true,"MENACC","SHOE");
        Product MA5=new Product("MA05","Michael Kors\n" +
                "Men's Leather Briefcase","Polish your professional look with this sophisticated and practical Michael Kors briefcase, in rich leather for enduring style. Interior pockets keep a tablet, phone and more at your fingertips.",12300.00,10,"https://slimages.macysassets.com/is/image/MCY/products/3/optimized/9358043_fpx.tif",false,true,"MENACC","BAG");
        Product MA6=new Product("MA06","Tasso Elba\n" +
                "Parma Paisley Tie","Create signature style for day to date-night with this classic paisley silk tie from Tasso Elba.\n" +
                "\n" +
                "Tasso Elba paisley silk tie\n" +
                "3 1/4'' wide\n" +
                "Silk",1000.00,10,"https://slimages.macysassets.com/is/image/MCY/products/1/optimized/2687511_fpx.tif",false,true,"MENACC","TIE");

        Product WA1=new Product("WA01","Sporto Dana Boots","Eastman Sporto's Dana boots feature modern lines with a hint of retro inspiration and plush faux fur for a cozy warm addition cold-weather fashion.\n" +
                "\n" +
                "1\" heel\n" +
                "Shaft height: 8\"; circumference: 2\"\n" +
                "Round-toe pull-on boots\n" +
                "Faux-fur lining\n" +
                "Water-resistant; insulated for added warmth",9200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/6/optimized/10426886_fpx.tif",false,true,"WOMENACC","SHOE");
        Product WA2=new Product("WA02","Naturalizer\n" +
                "Michelle Pumps","Naturalizer's Michelle pumps combine a sophisticated silhouette with ultra-comfortable style for a look to love from day to night.\n" +
                "\n" +
                "Round-toe slip-on platform pumps",11200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/9/optimized/8515069_fpx.tif",true,true,"WOMENACC","SHOE");
        Product WA3=new Product("WA03","Michael Kors Raven Pebble Leather Tote","A sleek and spacious organizer, MICHAEL Michael Kors' triple-compartment tote in rich pebble leather brings elegance and ease to your daytime look.\n" +
                "\n" +
                "Large sized bag; 13-1/2\"W x 10\"H x 5-1/2\"D; (width is measured across bottom of handbag)\n" +
                "Interior features 1 zip pocket, 4 slip pockets and 1 key finder; triple compartment design with center zip compartment and 2 magnetic-snap compartments",8200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/1/optimized/9198291_fpx.tif",false,false,"WOMENACC","BAG");
        Product WA4=new Product("WA04","Crossgrain Leather Continental Wallet","On-the-go yet ever glamorous, the Jet Set travel wallet from MICHAEL Michael Kors keeps your financials and phone right at your fingertips.\n" +
                "\n" +
                "Textured leather\n" +
                "Wrist strap with 7\" drop\n" +
                "Top zip closure",3200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/0/optimized/8382770_fpx.tif",false,true,"WOMENACC","BAG");
        Product WA5=new Product("WA05","Tartan Plaid Scarf","A timeless plaid adds charm and style to any look. Snuggle up in the beautiful Patricia Nash Tartan Plaid Scarf.\n" +
                "\n" +
                "27\"W x 79\"L\n" +
                "Viscose\n" +
                "Hand wash",3200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/7/optimized/10524627_fpx.tif",false,true,"WOMENACC","SCARF");
        Product WA6=new Product("WA06","Braided Catullo Belt","Strips of leather curve around the braided band of this unique Patricia Nash belt finished with a lightly distressed buckle.\n" +
                "\n" +
                "Approx. width: 2\"\n" +
                "Braided band\n" +
                "Gold-tone or silver-tone single-prong buckle, varies by color",3200.00,10,"https://slimages.macysassets.com/is/image/MCY/products/8/optimized/10782828_fpx.tif",true,false,"WOMENACC","BELT");

        M1.save();M2.save();M3.save();M4.save();M5.save();M6.save();M7.save();M8.save();M9.save();M10.save();M11.save();M12.save();
        W1.save();W2.save();W3.save();W4.save();W5.save();W6.save();W7.save();W8.save();W9.save();W10.save();W11.save();W12.save();
        MA1.save();MA2.save();MA3.save();MA4.save();MA5.save();MA6.save();WA1.save();WA2.save();WA3.save();WA4.save();WA5.save();WA6.save();

    }


}
